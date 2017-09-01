package cn.tk.java.algorithm.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/9/1
 * Description: 寻找最长回文
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * 客上天然居，居然天上客 ^。^
 */
public class LongestPalindromic {

    /**
     * Description：使用堆栈处理回文问题
     */
    public String longestPalindrome(String s)
    {
        String longestPalindrome = "";

        // 是否重新开始计算表示：一个回文串没有继续下去就需要重新开始，false 表示需要重新开始，true 表示继续计算
        boolean flag = false;

        // 临时堆栈
        Stack<Character> stack = new Stack<>();

        // 存放最大回文串
        List<Character> longest = new ArrayList<>();

        // 存放当前回文串
        List<Character> current = new ArrayList<>();
        char[] elements = s.toCharArray();
        for (char element : elements) {

            // 堆栈为空，直接放入
            if (stack.size() == 0)
            {
                stack.push(element);
                continue;
            }

            // 堆栈不为空，与栈顶元素比较
            char peek = stack.peek();
            if (peek != element)
            {
                // 从头再来
                if (flag) {
                    flag = false;
                    stack.removeAllElements();
                    if (current.size() > longest.size()) {
                        longest.clear();
                        longest = current;
                    }
                }
                stack.push(element);
                continue;
            }

            current.add(stack.pop());
            flag = true; // 表示本次回文开始计算了
        }

        if (current.size() == 0) {
            return "没有回文！";
        } else if (current.size()!=0 && longest.size()==0) {
            longestPalindrome = current.toString();
            Collections.reverse(current);
            longestPalindrome = current.toString() + longestPalindrome;
        } else {
            longestPalindrome = longest.toString();
            Collections.reverse(longest);
            longestPalindrome = longest.toString() + longestPalindrome;
        }

        return longestPalindrome;
    }

    @Test
    public void testPalindrome()
    {
        // 无回文
        System.out.println(longestPalindrome("abcd"));

        // 1个回文
        System.out.println(longestPalindrome("baab"));

        // 2个回文
        System.out.println(longestPalindrome("baab"));

        // 中文回文
        System.out.println(longestPalindrome("客上天然居居然天上客"));
    }

    @Test
    public void test()
    {
        Stack stack = new Stack();
        stack.push('a');
        stack.push('b');
        System.out.println(stack.toArray().toString());
        System.out.println(stack.lastElement());
        System.out.println(stack.size());

        System.out.println('a' == 'b');
        System.out.println('a' == 'a');
        System.out.println(' ' == 'a');

        System.out.println(stack.pop());
        System.out.println(stack.lastElement());
        System.out.println(stack.size());
    }
}
