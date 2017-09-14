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
        List<Integer> xIndexList = createIndex_X(length, nums);
        List<Integer> yIndexList = createIndex_Y(length, nums);
        int xLength = nums;
        int yLength = length % nums * nums + 1;
        char[][] resultCh = new char[xLength][yLength];

        for (int i=0; i<length; i++)
        {
            int xIndex = xIndexList.get(i);
            int yIndex = yIndexList.get(i);
            resultCh[xIndex][yIndex] = s.charAt(i);
        }

        // 注意 \u0000 与 空字符串是不相等的，需要特殊处理，替换的时候一定要注意
        String resultStr = getArray(xLength, yLength, resultCh).replaceAll("\\u0000", "");
        return resultStr;
    }

    /**
     * Description：创建二维数组的 x 下标
     */
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

    /**
     * Description：创建二维数组的 y 下标
     *
     * 0 （0,0,0,0,0,0）（1,2,3,4,5,6）（6,6,6,6,6,6）（7,8,9,10,11,12）
     */
    public List<Integer> createIndex_Y(int length, int bound)
    {
        boolean stay = true;//stay 为 true 的时候数字不变，为 false 的时候每次递增
        int yIndex = 0;
        int counter = 1;
        List<Integer> yIndexList = new ArrayList<>();
        yIndexList.add(yIndex);
        while (yIndexList.size() <= length) {
            // 换位器
            if (counter >= bound-1) {
                stay = !stay;
                counter = 0;
            }

            if (stay) {
                counter++;
                // 保持不变
                yIndexList.add(yIndex);
            } else {
                // 主键递增
                counter++;
                yIndexList.add(yIndex++);
            }
        }
        return yIndexList;
    }

    /**
     * Description：返回二维数组逐行遍历的字符串
     */
    public String getArray(int xLength, int yLength, char[][] chars)
    {
        StringBuilder resultStr = new StringBuilder();
        for (int i=0; i<xLength; i++)
        {
            for (int j=0; j<yLength; j++)
            {
                String charStr = String.valueOf(chars[i][j]);
                if (charStr != null || charStr != "");
                    resultStr.append(charStr);
                System.out.print(charStr);
            }
            System.out.println();
        }
        return resultStr.toString();
    }

    @Test
    public void testConvert()
    {
        String realStr = convert("PAYPALISHIRING", 3);
        String expectedStr = "PAHNAPLSIIGYIR";
        Assert.assertEquals(expectedStr, realStr);

        String realStr1 = convert("abcdefghijklmnopqrstuvwxyz", 7);
        System.out.println(realStr1);
    }
}
