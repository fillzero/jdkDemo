package cn.tk.java.junit.four.extention;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DemoTest {
	@Test
	@Feature("Test Add Feature")
	@Release("9.9")
	public void testAdd()
	{
		Demo demo = new Demo();
		assertEquals(4,  demo.add(1,  2));
	}
	
	@Release("9.9")
	public void testMinux()
	{
		Demo demo = new Demo();
		assertEquals(2, demo.minus(2, 1));
	}
}
