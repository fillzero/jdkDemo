package cn.tk.java.innerClass.selector;

import org.junit.Test;

public class ZTest {
	private static Sequence sequence;
	
	static{
		sequence = new Sequence(10);
		for(int i=0; i<10; i++) {
			sequence.add(i);
		}
	}
	
	/**
	 * @description:测试迭代器
	 */
	@Test
	public void testCommonSelecter()
	{
		Selecter selecter = sequence.getCommonSelecter();
		while (selecter.hasNext()) {
			System.out.println(selecter.value());
			selecter.next();
		}
	}
	
	/**
	 * @description:测试迭代器
	 */
	@Test
	public void testReverseSelecter()
	{
		Selecter selecter = sequence.getReverseSelecter();
		while (selecter.hasNext()) {
			System.out.println(selecter.value());
			selecter.next();
		}
	}
}
