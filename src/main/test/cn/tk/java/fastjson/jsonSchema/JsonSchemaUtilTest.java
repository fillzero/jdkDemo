package cn.tk.java.fastjson.jsonSchema;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by lijl85 on 2016/11/30.
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

    @Test
    public void validate1() throws Exception {

    }
}