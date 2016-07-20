package cn.tk.java.lang.object;

import org.junit.Test;


public class ObjectDemo {
	/**
	 * @Description:https://www.ibm.com/developerworks/cn/java/j-jtp05273/
	 */
	@Test
	public void testHashCode()
	{
		Object object = new Object();
		System.out.println(object.hashCode());
	}
}
