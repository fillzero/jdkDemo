package cn.tk.java.fastjson.jsonSchema;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by lijl85 on 2016/11/30.
 *
 * @description: jsonSchema: 两种返回结果: accepted, refused: 接收/拒绝
 */

public class JsonSchemaUtilTest {
    private static String candidateStr = "";
    private static String jsonSchema = "";
    private static String items = "";
    private static String itemsSchema = "";

    @BeforeAll
    @SneakyThrows
    public static void readJsonAndSchema()
    {
        String jsonPath = "./src/main/test/cn/tk/java/fastjson/jsonSchema/resource/options.json";
        String schemaPath = "./src/main/test/cn/tk/java/fastjson/jsonSchema/resource/schema.txt";
        candidateStr = FileUtils.readFileToString(new File(jsonPath), Charset.forName("UTF-8"));
        jsonSchema = FileUtils.readFileToString(new File(schemaPath), Charset.forName("UTF-8"));

        String itemsPath = "./src/main/test/cn/tk/java/fastjson/jsonSchema/resource/items.json";
        String itemsSchemaPath = "./src/main/test/cn/tk/java/fastjson/jsonSchema/resource/schema_items.txt";
        items = FileUtils.readFileToString(new File(itemsPath), Charset.forName("UTF-8"));
        itemsSchema = FileUtils.readFileToString(new File(itemsSchemaPath), Charset.forName("UTF-8"));
    }

    @Test
    public void validate() throws Exception {
        JSONObject candidateObject = JSON.parseObject(candidateStr);
        JSONObject schemaObject = JSON.parseObject(jsonSchema);
        candidateStr = candidateObject.getJSONObject("additional").toJSONString();
        jsonSchema = schemaObject.getJSONObject("additional").toJSONString();
        System.out.println(candidateStr);
        System.out.println(jsonSchema);
        assertTrue(JsonSchemaUtil.validate(jsonSchema, candidateStr));
    }

    /*
    * @description: 整体 type 是 array, 其中每个元素都有自己的校验规则, 由 items 设定
    * list: 数组里面多个元素共享一个 Schema
    * tuple: 数组里面每个元素都有自己的 Schema
    * length: 对数组中元素的个数作出校验
    * unique: 对数组是否允许重复元素作出校验, true: 不允许有重复元素, false: 元素有重复元素
    */
    @Test
    public void validateItemList()
    {
        JSONObject itemsObject = JSON.parseObject(items);
        JSONObject itemsSchemaObject = JSON.parseObject(itemsSchema);
        String listSchema = itemsSchemaObject.getJSONObject("list").toJSONString();//
        String tupleSchema = itemsSchemaObject.getJSONObject("tuple").toJSONString();
        String lengthSchema = itemsSchemaObject.getJSONObject("length").toJSONString();
        String uniqueSchema = itemsSchemaObject.getJSONObject("unique").toJSONString();

        assertTrue(JsonSchemaUtil.validate(listSchema, itemsObject.getJSONArray("pass1").toJSONString()));
        assertTrue(JsonSchemaUtil.validate(listSchema, itemsObject.getJSONArray("pass2").toJSONString()));
        assertFalse(JsonSchemaUtil.validate(listSchema, itemsObject.getJSONArray("fail1").toJSONString()));

        assertTrue(JsonSchemaUtil.validate(tupleSchema, itemsObject.getJSONArray("pass3").toJSONString()));
        assertTrue(JsonSchemaUtil.validate(tupleSchema, itemsObject.getJSONArray("pass4").toJSONString()));
        assertFalse(JsonSchemaUtil.validate(tupleSchema, itemsObject.getJSONArray("fail2").toJSONString()));

        assertTrue(JsonSchemaUtil.validate(lengthSchema, itemsObject.getJSONArray("pass5").toJSONString()));
        assertTrue(JsonSchemaUtil.validate(lengthSchema, itemsObject.getJSONArray("pass6").toJSONString()));
        assertFalse(JsonSchemaUtil.validate(lengthSchema, itemsObject.getJSONArray("fail3").toJSONString()));

        assertTrue(JsonSchemaUtil.validate(uniqueSchema, itemsObject.getJSONArray("pass7").toJSONString()));
        assertFalse(JsonSchemaUtil.validate(uniqueSchema, itemsObject.getJSONArray("fail4").toJSONString()));
    }
}
