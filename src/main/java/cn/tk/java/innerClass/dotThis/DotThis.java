package cn.tk.java.innerClass.dotThis;

import org.junit.Test;

/**
 * @author: lijl85
 * @date：2016年11月3日下午11:03:29
 * @description:内部类中引用外部类(OutClassName.this), 外部类中引用内部类
 * 
 * 目的:
 * func(): 外部类方法
 * public Inner inner(): 返回内部类引用
 * public DotThis outer(): 返回外部类引用
 * 
 * inner()内部类引用 --> outer()外部类引用 --> func() 打印
 */
public class DotThis {
	
	/**
	 * @Description: 外部类方法
	 */
	public String func(String param)
	{
		System.out.println("调用流程: " + param);
		return param;
	}
	
	/**
	 * @Description: 外部类 inner() 返回内部类的引用
	 */
	public Inner inner()
	{
		return new Inner();
	}
	
	/**
	 * @Description: 内部类 outer() 方法返回外部类的引用
	 */
	private class Inner{
		public DotThis outer()
		{
			return DotThis.this;
		}
	}
	
	@Test
	public void testDemo()
	{
		DotThis outer = new DotThis().inner().outer();
		outer.func("inner() --> outer() --> func()");
	}
}
