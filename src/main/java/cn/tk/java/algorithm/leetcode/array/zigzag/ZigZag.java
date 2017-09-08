package cn.tk.java.algorithm.leetcode.array.zigzag;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/9/8
 * Description: The string "PAYPALISHIRING" is written in a zigzag pattern on a
 * given number of rows like this: (you may want to display this pattern in a fixed
 * font for better legibility)
 *
 * 根据输入数据打印一个倒立的 "之" 形
 */
public class ZigZag {
    public String convert(String s, int nums)
    {
        return "";
    }

    @Test
    public void test()
    {
        String realStr = convert("PAYPALISHIRING", 3);
        String expectedStr = "PAHNAPLSIIGYIR";
        Assert.assertEquals(expectedStr, realStr);
    }
}
