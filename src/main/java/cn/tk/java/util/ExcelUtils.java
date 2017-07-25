package cn.tk.java.util;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/7/25
 * Description: Excel 读取编辑工具类
 * references：https://wizardforcel.gitbooks.io/tutorialspoint-java/apache-poi/2.html
 */
public class ExcelUtils {
    public static InputStream excelContent;
    static {
        try {
            excelContent = FileUtils.openInputStream(new File("demo.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getContentFromExcel()
    {

    }
}
