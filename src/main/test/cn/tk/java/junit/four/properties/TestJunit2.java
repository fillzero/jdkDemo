package cn.tk.java.junit.four.properties;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class TestJunit2 {
	String message = "Robert";
	MessageUtil messageUtil = new MessageUtil(message);
	@Test
	public void testPrintMessage()
	{
		System.out.println("Inside testSalutationMessage()");
		message = "Hi!" + "Robert";
		assertEquals(message, messageUtil.salutationMessage());
	}
}
