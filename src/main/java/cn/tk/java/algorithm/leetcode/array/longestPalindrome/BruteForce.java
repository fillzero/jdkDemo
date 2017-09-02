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
        if (s == null || s.length() == 0)
            return "没有回文！";

        // 最长回文串起始下标
        int maxStart = 0;

        // 最长回文串长度
        int maxLength = 0;

        int length = s.length();

        for (int i=0; i<length; i++)
        {
            for (int j=i+1; j<length; j++)
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
        String substring = s.substring(i, i + j);
        StringBuffer sb = new StringBuffer(substring);
        sb = sb.reverse();
        return substring.equals(sb.toString());
    }

    @Test
    public void testLongestPalindrome()
    {
        // 无回文
        System.out.println(longestPalindrome("abc"));

        // 1 个回文
        System.out.println(longestPalindrome("defabcba"));

        // 2个回文：abcba defg abcdcba
        System.out.println(longestPalindrome("abcbadefgabcdcba"));
    }
}
