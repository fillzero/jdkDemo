package cn.tk.java.designPattern.template;

import org.junit.Test;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/10/24
 * Description:
 */
public class Main {
    @Test
    public void testRead()
    {
        ReadCsv readCsv = new ReadCsv();
        readCsv.read();

        ReadExcel readExcel = new ReadExcel();
        readExcel.read();
    }
}
