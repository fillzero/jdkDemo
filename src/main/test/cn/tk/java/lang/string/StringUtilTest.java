package cn.tk.java.lang.string;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lijl85 on 2017/1/5.
 * normal,                     //原值
 * camelhump,                  //驼峰转下划线
 * uppercase,                  //转换为大写
 * lowercase,                  //转换为小写
 * camelhumpAndUppercase,      //驼峰转下划线大写形式
 * camelhumpAndLowercase,      //驼峰转下划线小写形式
 */
public class StringUtilTest {
    /*
    * @description: productCatalog -->  product_catalog
    *
    */
    @Test
    public void camelhumpToUnderline() throws Exception {
        String word = "productCatalog";
        assertEquals("product_catalog", StringUtil.camelhumpToUnderline(word));
    }

    /*
    * @description:  product_catalog --> productCatalog
    *
    */
    @Test
    public void underlineToCamelhump() throws Exception {
        String word = "product_catalog";
        assertEquals("productCatalog", StringUtil.underlineToCamelhump(word));
    }

    @Test
    public void convertByStyle() throws Exception {
        String word = "productCatalog";
        String camelhump = StringUtil.convertByStyle(word, Style.camelhump);
        String uppercase = StringUtil.convertByStyle(word, Style.uppercase);
        String lowercase = StringUtil.convertByStyle(word, Style.lowercase);
        String camelhumpAndUppercase = StringUtil.convertByStyle(word, Style.camelhumpAndUppercase);
        String camelhumpAndLowercase = StringUtil.convertByStyle(word, Style.camelhumpAndLowercase);
        System.out.println(camelhump);
        System.out.println(uppercase);
        System.out.println(lowercase);
        System.out.println(camelhumpAndUppercase);
        System.out.println(camelhumpAndLowercase);
    }
}