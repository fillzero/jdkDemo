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

    @BeforeAll
    @SneakyThrows
    public static void readJsonAndSchema()
    {
        String jsonPath = "./src/main/test/cn/tk/java/fastjson/jsonSchema/resource/demo.json";
        String schemaPath = "./src/main/test/cn/tk/java/fastjson/jsonSchema/resource/schema.txt";
        candidateStr = FileUtils.readFileToString(new File(jsonPath), Charset.forName("UTF-8"));
        jsonSchema = FileUtils.readFileToString(new File(schemaPath), Charset.forName("UTF-8"));
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
}
