package cn.tk.java.math;

import org.junit.Test;

public class AbsDemo {
	@Test
	public void testAbs()
	{
		String aString = "lijinlong";
		System.out.println(aString.hashCode());
		System.out.println(aString.hashCode() % 4);
		int abs = Math.abs(aString.hashCode() % 4); //绝对值函数
		System.out.println(abs);
	}
}
