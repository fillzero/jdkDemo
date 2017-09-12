package cn.tk.java.algorithm.leetcode.array.zigzag;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    /**
     * Description：输入字符串，转换成 ZigZag 模型，然后逐行读入数据
     * @param s 目标字符串
     * @param nums 目标长度
     *
     * 根据字符串长度计算出所有字符串在二维数组中的下标，依次存放到二维数组，然后打印二维数组所有
     * 不为空的字符。
     */
    public String convert(String s, int nums)
    {
        int length = s.length();
        List<Integer> index_x = createIndex_X(length, nums);
        List<Integer> index_y = createIndex_Y(length, nums);
        char[][] resultCh = new char[length%nums * nums][nums];
        for (int i=0; i<index_x.size(); i++)
        {
            for (int j=0; j<index_y.size(); j++)
            {
                resultCh[i][j] = s.charAt(i);
            }
        }
        String resultStr = new String();
        return resultStr;
    }

    public List<Integer> createIndex_X(int length, int bound)
    {
        boolean order = true;
        int xIndex = 0;
        List<Integer> xIndexList = new ArrayList<>();
        while (xIndexList.size() <= length) {
            if (order) {
                xIndexList.add(xIndex++);
                if (xIndex >= bound-1)
                    order = false;

            } else {
                xIndexList.add(xIndex--);
                if (xIndex <= 0)
                    order = true;
            }
        }
        return xIndexList;
    }

    @Test
    public void testXIndex()
    {
        List<Integer> index_x = createIndex_X(30, 7);
        System.out.println(index_x);
        List<Integer> index_y = createIndex_Y(30, 7);
        System.out.println(index_y);
    }

    public List<Integer> createIndex_Y(int length, int bound)
    {
        boolean order = true;
        int counter = 0;
        int yIndex = 0;
        List<Integer> yIndexList = new ArrayList<>();
        while (yIndexList.size() <= length) {
            // 换位器
            if (counter++ >= bound) {
                order = !order;
                counter = 0;
            }

            if (order) {
                // 保持不变
                yIndexList.add(yIndex);
            } else {
                // 主键递增
                yIndexList.add(yIndex++);
            }
        }
        return yIndexList;

    }

    @Test
    public void testConvert()
    {
        String realStr = convert("PAYPALISHIRING", 3);
        String expectedStr = "PAHNAPLSIIGYIR";
        Assert.assertEquals(expectedStr, realStr);
    }
}
