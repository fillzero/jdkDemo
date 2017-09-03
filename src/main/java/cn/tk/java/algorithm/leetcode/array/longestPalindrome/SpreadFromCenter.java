package cn.tk.java.algorithm.leetcode.array.longestPalindrome;

import org.junit.Test;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/9/3
 * Description: 中心扩散算法
 */
public class SpreadFromCenter {

    private String longest = "";

    public String longestPalindrome(String s)
    {
        for (int i=0; i<s.length(); i++)
        {
            // 奇数回文串
            calculate(s, i, 0);

            // 偶数回文串
            calculate(s, i, 1);
        }
        return longest;
    }

    public void calculate(String s, int idx, int offset)
    {
        int left = idx;
        int right = idx + offset;
        int length = s.length();

        while (left>=0 && right<length && s.charAt(left) == s.charAt(right))
        {
            left --;
            right ++;
        }

        String currentLongest = s.substring(left + 1, right);

        if (currentLongest.length() > longest.length())
        {
            longest = currentLongest;
        }
    }

    @Test
    public void testLongestPalindrome()
    {
        // 无回文："a"
        System.out.println(longestPalindrome("abc"));
        longest = "";

        // 1 个回文："abcba"
        System.out.println(longestPalindrome("defabcba"));
        longest = "";

        // 2个回文：abcba defg abcdcba："abcdcba"
        System.out.println(longestPalindrome("abcbadefgabcdcba"));
        longest = "";

        // 偶数回文串
        System.out.println(longestPalindrome("bccb"));
        longest = "";

        System.out.println(longestPalindrome("12212321"));
    }
}
