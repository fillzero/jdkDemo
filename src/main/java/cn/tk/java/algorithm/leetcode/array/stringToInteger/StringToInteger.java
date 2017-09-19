package cn.tk.java.algorithm.leetcode.array.stringToInteger;

import org.junit.Test;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/9/19
 * Description:
 */
public class StringToInteger {
    /**
     * Description：实现一个 C 语言的 atoi 函数，将字符串转换成整型
     * Hint:
     *      Carefully consider all possible input cases. If you want a challenge, please do not see
     * below and ask yourself what are the possible input cases.
     *
     * （1）空字符串 --> 0
     * （2）非整数字符串 --> 0
     * （3）整型 --> 转换
     * （4）整型超出最大整型位数 --> 0
     * （5）负数单独处理
     *
     * "  -0012a42" --> -12 没有办法通过？？？
     */
    public int myAtoi(String str) {
        boolean negative = false;
        str = str.trim();

        if (str == null || str.length() == 0 || str.trim().length() == 0)
            return 0;

        if (str.startsWith("-") || str.startsWith("+"))
        {
            if (str.startsWith("-"))
                negative = !negative;
            str = str.substring(1);
        }

        if (!isAllNumbers(str.toCharArray()))
            return 0;

        if (negative)
            str = "-" + str;

        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Description：判断是否每个字符都是数字
     */
    private boolean isAllNumbers(char[] chars) {
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9')
            {
                continue;
            }
            return false;
        }
        return true;
    }

    @Test
    public void testMyAtoi()
    {
        System.out.println(myAtoi(null));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("13B"));
        System.out.println(myAtoi("13-"));
        System.out.println(myAtoi("13"));
        System.out.println(myAtoi("1390123898123123"));
        System.out.println(myAtoi("-100"));
        System.out.println(myAtoi("-1390123898123123"));
        System.out.println(myAtoi("+1"));
    }
}
