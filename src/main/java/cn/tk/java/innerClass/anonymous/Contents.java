package cn.tk.java.innerClass.anonymous;

import org.junit.Test;

/**
 * @author: lijl85
 * @date：2016年11月4日上午7:37:43
 * @description:创建匿名类和实现类两种方式对比
 * contents() 方法, 返回对接口的引用, 默认使用无参构造器, 构造器还可以有参数
 */
public class Contents {
	/**
	 * @description:显式实现类，通过方法返回指向接口的引用
	 */
	private class ExplicitImpl implements IContents{
		@Override
		public void contents() {
			System.out.println("通过  private 内部类显式实现接口返回引用！");
		}
	}
	public IContents exclicitContents()
	{
		return new ExplicitImpl();
	}
	
	/**
	 * @description:通过匿名类实现， 返回指向接口的引用
	 */
	public IContents anonymousContents()
	{
		return new IContents() {
			@Override
			public void contents() {
				System.out.println("通过匿名内部类隐式实现接口返回引用！");
			}
		};
	}
	
	@Test
	public void testDemo()
	{
		IContents exclicitContents = exclicitContents();
		exclicitContents.contents();
		
		IContents anonymousContents = anonymousContents();
		anonymousContents.contents();
	}
}
