package cn.tk.java.fastjson.jsonSchema;

import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.Charset;

/**
 * Created by lijl85 on 2017/1/23.
 */
public class JsonSchemaGeneratorTest {
    private static String jsonDemo = "";
    private static String schemaDemo = "";

    private JSONObject targetSchema = new JSONObject();

    @BeforeAll
    @SneakyThrows
    public static void init()
    {
        String jsonPath = "./src/main/test/cn/tk/java/fastjson/jsonSchema/resource/demo.json";
        jsonDemo = FileUtils.readFileToString(new File(jsonPath), Charset.forName("UTF-8"));
    }

    @Test
    public void generateSchema() throws Exception {

    }
}