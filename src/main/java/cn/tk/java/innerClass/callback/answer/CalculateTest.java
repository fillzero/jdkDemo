package cn.tk.java.innerClass.callback.answer;

import org.junit.Test;

public class CalculateTest {
	/**
	 * @Description:
	 * 主调者 Ask 调用被调者  Answer， 并且传入自己的 "指针"（接口对象）和 参数
	 * 被调者 Answer 回调主调者 Ask 解决问题， 并且返回客户端
	 * 至此完成整个回调过程。 
	 */
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
