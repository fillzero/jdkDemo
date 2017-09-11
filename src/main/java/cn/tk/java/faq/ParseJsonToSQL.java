package cn.tk.java.faq;

import cn.tk.java.util.commonUtils.DateUtil;
import cn.tk.java.util.date.DateUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/9/11
 * Description: 由于测试数据库被删除，想要从生产库获取数据导入测试库，但是没有生产库导出 SQL 权限，只能查询。
 * 可以查询到 JSON 格式的 SQL 语句，所以想要根据该 JSON 数据生成对应的 insert 插入语句
 *
 * 目标：JSON数据 --> Insert 建表语句
 *
 * INSERT INTO sequence_value (name, id) VALUES ('lijinlong', '1'),('liujia', '2');
 *
 * SQL_HEADER TABLE_NAME SQL_COLUMNS CONJUNCTION SQL_VALUES
 */
public class ParseJsonToSQL {

    private final String JSON_DIRECTORY = "E:\\WorkSpace\\jdkDemo\\src\\main\\resources\\parseJsonToSql";

    private final String STATEMENT_DIRECTORY = "E:\\WorkSpace\\jdkDemo\\src\\main\\resources\\parseJsonToSql\\statement";

    private String SQL_HEADER = "insert into ";

    private String SQL_SPACE = " ";

    private String TABLE_NAME;

    private String SQL_COLUMNS;

    private String SQL_VALUES;

    private final String CONJUNCTION = " values ";

    private final String LEFT_BRACKET = "(";

    private final String RIGHT_BRACKET = ")";

    private final String SINGLE_QUOTES = "'";

    private final String COMMA = ", ";

    private final String SEMICOLON = ";";


    /**
     * Description：读文件夹获取所有文件，放到一个 Map
     * key：文件名
     * value: 文件内容 Json String
     */
    @SneakyThrows
    public Map<String, String> readFromFile()
    {
        Map<String, String> fileJsonMap = new LinkedHashMap<>();
        File directory = new File(JSON_DIRECTORY);
        if (directory.isDirectory())
        {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile())
                {
                    String fileName = file.getName();
                    String fileJson = FileUtils.readFileToString(file, Charset.defaultCharset());
                    fileJsonMap.put(fileName, fileJson);
                }
            }
        }
        return fileJsonMap;
    }

    /**
     * Description：解析方法
     */
    public String parseJsonToSQL(String tableName, String dbDataStr)
    {
        StringBuilder insertStatement = new StringBuilder();
        JSONObject dbData = JSON.parseObject(dbDataStr, Feature.OrderedField);
        JSONArray rows = dbData.getJSONArray("rows");
        JSONObject row = rows.getJSONObject(0);
        Set<Map.Entry<String, Object>> entries = row.entrySet();
        this.TABLE_NAME = tableName;
        this.SQL_COLUMNS = getSqlColumns(entries);
        this.SQL_VALUES = getSqlValues(rows);
        insertStatement.append(SQL_HEADER);
        insertStatement.append(TABLE_NAME + SQL_SPACE);
        insertStatement.append(SQL_COLUMNS);
        insertStatement.append(CONJUNCTION);
        insertStatement.append(SQL_VALUES);
        return insertStatement.toString();
    }

    /**
     * Description：解析生成 values
     * {
     *   "name":"ADIMAGE_ID",
     *   "id":"300"
     * },
     * {
     *   "name":"AUTHORITY_ID",
     *   "id":"800"
     * },
     */
    private String getSqlValues(JSONArray rows) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<rows.size(); i++)
        {
            sb.append(LEFT_BRACKET);
            JSONObject dataLine = rows.getJSONObject(i);
            Set<Map.Entry<String, Object>> entries = dataLine.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                String value = (String) entry.getValue();
                if ("null".equals(value))
                    value = DateUtils.date2Str(new Date(), DateUtils.standard);
                sb.append(SINGLE_QUOTES + value + SINGLE_QUOTES + COMMA);
            }
            sb.deleteCharAt(sb.lastIndexOf(COMMA));
            sb.append(RIGHT_BRACKET + COMMA);
        }
        sb.deleteCharAt(sb.lastIndexOf(COMMA));
        sb.append(SEMICOLON);
        return sb.toString();
    }

    /**
     * Description：解析生成 Column，如何保证数据顺序？
     * {
     *     "name":"ADIMAGE_ID",
     *     "id":"300"
     * }
     *
     * (name, id)
     */
    private String getSqlColumns(Set<Map.Entry<String, Object>> entries) {
        StringBuilder sb = new StringBuilder();
        sb.append(LEFT_BRACKET);
        for (Map.Entry<String, Object> entry : entries) {
            String column = entry.getKey();
            sb.append(column + COMMA);
        }
        sb.deleteCharAt(sb.lastIndexOf(COMMA));
        sb.append(RIGHT_BRACKET);
        return sb.toString();
    }

    @Test
    @SneakyThrows
    public void testParseJsonToSQL()
    {
        Map<String, String> fileJsonMap = readFromFile();
        Set<Map.Entry<String, String>> entries = fileJsonMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String tableName = entry.getKey();
            String dbDataStr = entry.getValue();
            String insertStatement = parseJsonToSQL(tableName, dbDataStr);
            File targetFile = new File(STATEMENT_DIRECTORY + "/" + tableName);
            if (!targetFile.exists())
                FileUtils.writeStringToFile(targetFile, insertStatement, Charset.defaultCharset());
        }
    }
}

