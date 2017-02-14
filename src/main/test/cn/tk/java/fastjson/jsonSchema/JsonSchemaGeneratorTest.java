package cn.tk.java.fastjson.jsonSchema;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * Created by lijl85 on 2017/1/23.
 *
 * JSON 生成 JSONSchema 三步走:
 * 1.分割
 * 2.处理
 * 3.合并
 */
public class JsonSchemaGeneratorTest {
    private static String optionsDemo = "";
    private static String maximumDemo = "";
    private static String commonDemo = "";
    private static String schemaDemo = "";

    private JSONObject targetSchema = new JSONObject();

    @BeforeAll
    @SneakyThrows
    public static void init()
    {
        String optionsPath = "./src/main/test/cn/tk/java/fastjson/jsonSchema/resource/options.json";
        String maxPath = "./src/main/test/cn/tk/java/fastjson/jsonSchema/resource/maximum.json";
        String commonPath = "./src/main/test/cn/tk/java/fastjson/jsonSchema/resource/common.json";
        optionsDemo = FileUtils.readFileToString(new File(optionsPath), Charset.forName("UTF-8"));
        maximumDemo = FileUtils.readFileToString(new File(maxPath), Charset.forName("UTF-8"));
        commonDemo = FileUtils.readFileToString(new File(commonPath), Charset.forName("UTF-8"));
    }

    /*
    * @description: 获取 options
    * 1. 分割: 从整体 json 中获取到 id, type, returned, options
    *    id: jsonSchema 中的 key
    *    type: jsonSchema 中的数据类型
    *    returned: 是否需要转换成 jsonSchema
    *    options: jsonSchema 中的选项值
    *
    * 2. 处理: 拼接成一个 jsonSchema
    *
    * 3. 合并: 生成一个 key: value 对象
    */
    @Test
    public void generateOptions() throws Exception {
        JSONObject inputJson = JSON.parseObject(optionsDemo);

        //1. 分割
        String id = inputJson.getString("id");
        String type = inputJson.getString("type");
        JSONArray options = inputJson.getJSONArray("options");

        //2. 处理: 获取 options 中的 value
        JSONObject optionObject = new JSONObject();
        if (isReturned(inputJson))
        {
            JSONArray optionsArray = new JSONArray();
            for (int i=0; i<options.size(); i++)
            {
                optionsArray.add(options.getJSONObject(i).get("value"));
            }
            optionObject = generateObject(new String[] {"type", "enum"}, type, optionsArray);
        }
        JSONObject schemaObject = generateObject(id, optionObject);
        System.out.println(schemaObject);
    }

    /*
    * @description: 带 maximum 和 minimum 的转换, 放到一个 allOf 里面, 体现最大最小之间的逻辑关系
    *  {
          "insuredAgeRange": {
            "allOf": [
              {
                "maximum": 65,
                "type": "number"
              },
              {
                "type": "number",
                "minimum": 18
              }
            ]
          }
        }
    */
    @Test
    public void generateMaximum() throws Exception {
        JSONObject inputJson = JSON.parseObject(maximumDemo);

        //1. 分割: JSONObject --> 多个值
        String id = inputJson.getString("id");
        String type = inputJson.getString("type");
        Integer maximum = inputJson.getInteger("maximum");
        Integer minimum = inputJson.getInteger("minimum");

        //2. 处理: 判断是否 returned, 即是否生成 schema
        if (isReturned(inputJson))
        {
            //3. 合并: 合并生成 schema
            JSONObject maxObject = generateObject(new String[] {"type", "maximum"}, type, maximum);
            JSONObject minObject = generateObject(new String[] {"type", "minimum"}, type, minimum);
            JSONArray allOfArray = generateArray(maxObject, minObject);
            JSONObject ageObject = generateObject("allOf", allOfArray);
            JSONObject schemaObject = generateObject(id, ageObject);
            System.out.println(schemaObject);
        }
    }

    /*
    * @description: 一般情况下的 JSON 转换成 JSONSchema, 获取 id, type, id 变成 key, value 变成类型约束对象
    * {"type" : "string"}
    */
    @Test
    public void generateCommon()
    {
        JSONObject inputJson = JSON.parseObject(commonDemo);

        String id = inputJson.getString("id").replace("Widget", "Data");

        JSONArray components = inputJson.getJSONArray("components");
        JSONArray schemaArray = new JSONArray();

        for (int i=0; i<components.size(); i++)
        {
            String componentId = components.getJSONObject(i).getString("id");
            String componentType = components.getJSONObject(i).getString("type");

            if (isReturned(components.getJSONObject(i)))
            {
                schemaArray.add(generateObject(componentId, generateObject("type", componentType)));
            }
        }
        JSONObject schemaObject = generateObject(id, schemaArray);
        System.out.println(schemaObject);
    }
    
    @Test
    public void testAppendObject()
    {
        JSONObject person = generateObject("name", "lijinlong");
        appendObject(person, "age", 18);
        appendObject(person, new String[] {"birthday", "email"}, new Date(), "12345@qq.com");
        System.out.println(person);
    }

    /*
    * @description: 输入一个 key-value 对, 返回一个 JSONObject
    */
    public JSONObject generateObject(String key, Object value)
    {
        JSONObject targetObject = new JSONObject();
        targetObject.put(key, value);
        return targetObject;
    }
    /*
    * @description: 输入一组 key-value 对, 返回一个 JSONObject
    */
    public JSONObject generateObject(String[] keys, Object ...values)
    {
        JSONObject targetObject = new JSONObject();
        for(int i=0; i<keys.length; i++)
        {
            targetObject.put(keys[i], values[i]);
        }
        return targetObject;
    }

    /*
    * @description: 在原有的 JSONObject 基础上再添加一个 key-value 对
    */
    public JSONObject appendObject(JSONObject oldObject, String key, Object value)
    {
        oldObject.put(key, value);
        return oldObject;
    }

    /*
     * @description: 在原有的 JSONObject 基础上再添加一组 key-value 对
     */
    public JSONObject appendObject(JSONObject oldObject, String[] keys, Object ...values)
    {
        for(int i=0; i<keys.length; i++)
        {
            oldObject.put(keys[i], values[i]);
        }
        return oldObject;
    }

    /*
    * @description: 根据一组 value 生成一个 JSONArray
    */
    public JSONArray generateArray(Object ...options) {
        JSONArray targetArray = new JSONArray();
        for (int i = 0; i < options.length; i++)
        {
            targetArray.add(options[i]);
        }
        return targetArray;
    }

    /*
    * @description: 判断当前对象是否有返回值
    */
    public boolean isReturned(JSONObject targetObject)
    {
        Boolean returned = targetObject.getBoolean("returned");
        return returned!=null && returned ? true : false;
    }
}