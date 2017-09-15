package cn.tk.java.algorithm.leetcode.array.reverseInteger;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/9/15
 * Description:
 */
public class reverseInteger {
    public int reverse(Integer x)
    {
        if (x > Integer.MAX_VALUE)
            return 0;

        boolean flag = true;
        if (x < 0) {
            x = -x;
            flag = !flag;
        }
        List<Character> charList = strToCharList(String.valueOf(x));
        Collections.reverse(charList);
        String reverseStr = charListToStr(charList);
        try {
            Integer reverseInteger = Integer.valueOf(reverseStr);
            return flag ? reverseInteger : -reverseInteger;
        } catch (Exception e) {
            return 0;
        }
    }

    private List<Character> strToCharList(String xStr) {
        List<Character> charList = new ArrayList<>();
        char[] chars = xStr.toCharArray();
        for (char aChar : chars) {
            charList.add(aChar);
        }
        return charList;
    }


    private String charListToStr(List<Character> charList) {
        StringBuilder sb = new StringBuilder();
        charList.forEach(sb::append);
        return sb.toString();
    }

    @Test
    public void testReverse()
    {
        assertEquals(reverse(0), 0);
        assertEquals(reverse(123), 321);
        assertEquals(reverse(-123), -321);
        assertEquals(reverse(1534236469), 0);
    }
}
