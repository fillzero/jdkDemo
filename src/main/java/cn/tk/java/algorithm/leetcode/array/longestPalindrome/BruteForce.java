package cn.tk.java.algorithm.leetcode.array.longestPalindrome;

import org.junit.Test;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/9/2
 * Description: 穷举法
 */
public class BruteForce {

    /**
     * Description：遍历所有子字符串，找出最大的回文
     */
    public String longestPalindrome(String s)
    {
        // 空字符串没有回文
        if (s == null || s.length() == 0)
            return "没有回文！";

        // 单字符字符串其本身就是最长回文串
        if (s.length() == 1)
            return s;

        // 最长回文串起始下标
        int maxStart = 0;

        // 最长回文串长度
        int maxLength = 0;

        int length = s.length();

        // i 是子字符串的左端下标，j 是子字符串右端下标
        for (int i=0; i<length; i++)
        {
            for (int j=i+1; j<length+1; j++)
            {
                if ((j-i)>maxLength && isPalindrome(s, i, j))
                {
                    maxStart = i;
                    maxLength = j - i;
                }
            }
        }

        return s.substring(maxStart, maxStart + maxLength);
    }

    /**
     * Description：判断当前子字符串是否为回文
     */
    private boolean isPalindrome(String s, int i, int j)
    {
        String substring = s.substring(i, j);
        StringBuffer sb = new StringBuffer(substring);
        sb = sb.reverse();
        return substring.equals(sb.toString());
    }

    @Test
    public void testLongestPalindrome()
    {
        // 无回文："a"
        System.out.println(longestPalindrome("abc"));

        // 1 个回文："abcba"
        System.out.println(longestPalindrome("defabcba"));

        // 2个回文：abcba defg abcdcba："abcdcba"
        System.out.println(longestPalindrome("abcbadefgabcdcba"));

        // 偶数回文串
        System.out.println(longestPalindrome("bccb"));

        System.out.println(longestPalindrome("12212321"));
    }
}
