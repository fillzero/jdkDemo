package cn.tk.java.lang.object;

import org.junit.Test;


public class ObjectDemo {
	@Test
	public void testHashCode()
	{
		Object object = new Object();
		System.out.println(object.hashCode());
	}
}
