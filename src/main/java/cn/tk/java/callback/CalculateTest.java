package cn.tk.java.callback;

import org.junit.Test;

public class CalculateTest {
	@Test
	public void testCalculate() throws InstantiationException, IllegalAccessException
	{
		Answer answer = new Answer();
		Ask ask = new Ask(answer);
		System.out.println(ask.askQuestion('+', 10, 2));
		System.out.println(ask.askQuestion('-', 10, 2));
		System.out.println(ask.askQuestion('*', 10, 2));
		System.out.println(ask.askQuestion('/', 10, 2));
	}
}
