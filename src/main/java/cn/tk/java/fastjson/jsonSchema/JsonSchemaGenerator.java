package cn.tk.java.fastjson.jsonSchema;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

/*
* @date: 2017/1/16
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description: 根据 JSON 生成对应的 JSONSchema
* 
*/
public class JsonSchemaGenerator {



    public void generateSchema(JSONObject inputJson)
    {
        System.out.println("hha");
    }

    public static void main(String[] args) {
        String inputJsonStr = "{\n" +
                "  \"address\": {\n" +
                "    \"streetAddress\": \"21 2nd Street\",\n" +
                "    \"city\": \"New York\"\n" +
                "  },\n" +
                "  \"phoneNumber\": [\n" +
                "    {\n" +
                "      \"location\": \"home\",\n" +
                "      \"code\": 44\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        JSONObject.parseObject(inputJsonStr);
    }
}
