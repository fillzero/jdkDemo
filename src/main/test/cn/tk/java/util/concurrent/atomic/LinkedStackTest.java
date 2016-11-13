package cn.tk.java.util.concurrent.atomic;

import org.junit.Test;

public class LinkedStackTest{
	@Test
	public void testPushAndPop()
	{
		String aString = "wang";
		String bString = "li";
		String cString = "zhang";
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.push(aString);
		stack.push(bString);
		stack.push(cString);
		System.out.println(stack.pop());
		System.out.println(stack);
	}
}
