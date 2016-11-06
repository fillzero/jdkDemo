package cn.tk.java.innerClass.callback.caller;

import org.junit.Test;

public class ZTest {
	/**
	 * @description: 测试直接实现接口
	 */
	@Test
	public void testDirect()
	{
		DirectIncrementer incrementer = new DirectIncrementer();
		Caller caller = new Caller(incrementer);
		caller.go();
		caller.go();
	}
	
	/**
	 * @escription: 测试内部类非直接实现接口
	 */
	@Test
	public void testIndirect()
	{
		IndirectIncrementer incrementer = new IndirectIncrementer();
		Incrementable incrementable = incrementer.getCallbackReference();
		Caller caller = new Caller(incrementable);
		
		System.out.println("通过覆盖父类实现 increment() 方法");
		IndirectIncrementer.funcIncre(incrementer);
		
		System.out.println("\n通过内部类实现接口实现 increment() 方法");
		caller.go();
		caller.go();
	}
}
