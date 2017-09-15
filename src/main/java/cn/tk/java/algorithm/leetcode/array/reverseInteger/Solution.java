package cn.tk.java.algorithm.leetcode.array.reverseInteger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/9/15
 * Description: 官方解决方法
 */
public class Solution {
    /**
     * Description:
     * 1 2 3
     *
     * res = 0 * 10 + 123 % 10 = 3
     * res = 3 * 10 + 12 % 10 = 32
     * res = 32 * 10 + 1 % 10 = 321
     */
    public int reverse(int x)
    {
        int res = 0;
        while (x != 0)
        {
            if (Math.abs(res) > Integer.MAX_VALUE / 10) return 0;
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
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
