package cn.tk.java.fastjson.jsonSchema;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by lijl85 on 2016/11/30.
 *
 * @description: jsonSchema: 两种返回结果: accepted, refused: 接收/拒绝
 */

public class JsonSchemaUtilTest {

    private static final String candidateStr = "{\n" +
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

    private static final String jsonSchema = "{\"$schema\":\"http://json-schema.org/draft-04/schema#\",\"type\":\"object\",\"properties\":{\"address\":{\"type\":\"object\",\"properties\":{\"streetAddress\":{\"type\":\"string\"},\"city\":{\"type\":\"string\"}},\"required\":[\"streetAddress\",\"city\"]},\"phoneNumber\":{\"type\":\"array\",\"items\":{\"type\":\"object\",\"properties\":{\"location\":{\"type\":\"string\"},\"code\":{\"type\":\"integer\"}},\"required\":[\"location\",\"code\"]}}},\"required\":[\"address\",\"phoneNumber\"]}";

    @Test
    public void validate() throws Exception {
        assertTrue(JsonSchemaUtil.validate(jsonSchema, candidateStr));
    }

    /*
    * @description: 空 jsonSchema 因为没有校验规则, 所以可以接收任何形式的 JSON 数据
    *
    */
    @Test
    public void validateAnything()
    {
        assertTrue(JsonSchemaUtil.validate("{}", candidateStr));
    }
    /*
    * @description: String 类型
    */
    @Test
    public void validateString()
    {
        String jsonSchema = "{\n" +
                "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
                "  \"type\": \"object\",\n" +
                "  \"properties\": {\n" +
                "    \"str\": {\n" +
                "      \"type\": \"string\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"required\": [\n" +
                "    \"str\"\n" +
                "  ]\n" +
                "}";
        String candidateStr = "{\"str\":\"I'm a string\"}";
        assertTrue(JsonSchemaUtil.validate(jsonSchema, candidateStr));
    }

    @Test
    public void validate1() throws Exception {

    }
}
