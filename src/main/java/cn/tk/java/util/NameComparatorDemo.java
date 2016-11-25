package cn.tk.java.util;

import java.util.Comparator;

import org.junit.Test;

public class NameComparatorDemo implements Comparator<String> {

	/**
	 * @Author: lijl85
	 * @Time: 2016年10月21日下午4:21:41 
	 * @description：
	 * 1. 都变成大写
	 * 2. 依次比较每个字符差值
	 * 3. 比较长度差值
	 * 字符不同以字符为准，字符相同比较长度。
	 */
	@Override
	public int compare(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		int min = Math.min(n1, n2);
		for (int i = 0; i < min; i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			if (c1 != c2) {
				c1 = Character.toUpperCase(c1);
				c2 = Character.toUpperCase(c2);
				if (c1 != c2)
					// No overflow because of numeric promotion
					return c1 - c2;
			}
		}
		return n1 - n2;
	}
	
	/**
	 * @description:字符串比较器默认实现， 内部类
	 */
	@Test
	public void testNameComparator()
	{
		System.out.println(compare("li", "wang"));
		System.out.println(compare("wang", "WANG"));//忽略大小写
	}
}
