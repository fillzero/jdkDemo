package cn.tk.java.lang.string;

import org.junit.Test;

public class StringEquals {
	@Test
	public void testIfEquals()
	{
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		String str4 = str1;
		System.out.println("is str1 = str2? " + (str1 == str2));
		System.out.println("is str1 = str3? " + (str1 == str3));
		System.out.println("is str1 refer to str3? " + (str1.length() == str3.length()));
		System.out.println("is str1 = str4? " + (str1 == str4));
		System.out.println("is str2 = str4? " + (str2 == str4));
		System.out.println("is str4 refer to str3? " +(str4.intern()==str3.intern()));
	}
}
