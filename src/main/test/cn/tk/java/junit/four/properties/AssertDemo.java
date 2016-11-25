package cn.tk.java.junit.four.properties;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @description:断言类
 */
public class AssertDemo {
	@Test
	public void testAdd()
	{
		int num = 5;
		String temp = null;
		String str = "Hello World";
		
		assertEquals("Hello World", str);
		assertNull(temp);
		assertTrue(num < 6);
	}
	
	/**
	 * @description:该单元测试可以被忽略, 不会被单元测试运行器扫描到
	 */
	@Ignore
	public void testSub()
	{
		int num1 = 12;
		int num2 = 3;
		assertTrue((num1-num2) < 15);
	}
}
