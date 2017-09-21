package cn.tk.java.algorithm.leetcode.array.stringToInteger;

import org.junit.Test;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/9/19
 * Description:
 */
public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() < 1)
            return 0;

        // trim white spaces
        str = str.trim();

        char flag = '+';

        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;

        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-')
            result = -result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }

    @Test
    public void testMyAtoi()
    {
        System.out.println(myAtoi(null));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("13B"));//13
        System.out.println(myAtoi("13-"));//13
        System.out.println(myAtoi("13"));//13
        System.out.println(myAtoi("1390123898123123"));//超过最大整型，返回最大整型
        System.out.println(myAtoi("-100"));
        System.out.println(myAtoi("-1390123898123123"));
        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("  -0012a42"));// a 前面如果是数字也可以转换，把后面的部分截取掉就可以了
    }
}
