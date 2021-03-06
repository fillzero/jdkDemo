package cn.tk.java.algorithm.leetcode.array;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author: lijl85
 * @Title: LengthOfLongestSubstring.java
 * @Package: cn.tk.java.algorithm.leetcode
 * @Time: 2016年10月21日上午11:23:01
 *
 * @description:最长不重复字串问题
 * 
 * 题目： Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 *	Given "abcabcbb", the answer is "abc", which the length is 3.
 *	Given "bbbbb", the answer is "b", with the length of 1.
 *	Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LengthOfLongestSubstring {
	 /**
	 * @description:查找没有重复字符的最长子串长度
	 */
	public int lengthOfLongestSubstring(String s) {
		int max_count = 0;
		int count = 0;
		String current_max = "";
		for(int i=0; i<s.length(); i++)
		{
			if (!current_max.contains(String.valueOf(s.charAt(i)))) {
				count ++;
				current_max += String.valueOf(s.charAt(i));
			}else {
				max_count = max_count > count ? max_count : count;
				char repChar = s.charAt(i);
				current_max += String.valueOf(repChar);
				
				for (int j = 0; j < current_max.length(); j++) {
					if (repChar == current_max.charAt(j)) {
						current_max = current_max.substring(j+1);
						break;
					}
				}
				count = current_max.length();
			}
		}
		max_count = max_count > count ? max_count : count;
		return max_count;
	}

	public int lengthOfLongestSubstring2(String s) {
		if (s.length()==0) return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max=0;
		for (int i=0, j=0; i<s.length(); ++i){
			if (map.containsKey(s.charAt(i))){
				j = Math.max(j,map.get(s.charAt(i))+1);
			}
			map.put(s.charAt(i),i);
			max = Math.max(max,i-j+1);
		}
		return max;
	}


	@Test
	public void testGetLongestLength()
	{
		System.out.println(lengthOfLongestSubstring("a"));
		System.out.println(lengthOfLongestSubstring("au"));
		System.out.println(lengthOfLongestSubstring("dvdf"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
	@Test
	public void testGetLongestLength2()
	{
		System.out.println(lengthOfLongestSubstring2("a"));
		System.out.println(lengthOfLongestSubstring2("au"));
		System.out.println(lengthOfLongestSubstring2("dvdf"));
		System.out.println(lengthOfLongestSubstring2("pwwkew"));
	}
}
