package cn.tk.java.innerClass.dotThis;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lijl85
 * @date：2016年11月3日下午11:06:58
 * @description: .new
 * 创建内部类对象(非静态内部类和静态内部类)
 */
public class DotNew {
	/**
	 * @description: 静态内部类
	 */
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	private static class StaticInner{
		private String name;
	}
	
	/**
	 * @description: 非静态内部类
	 */
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	private class NoStaticInner{
		private int age;
	}
	
	/**
	 * @description: 创建内部类对象
	 * new OuterClass.InnerClass()  等效于 outerObject.new InnerClass()
	 * 先创建外部类对象， 内部类引用指向内部类引用，所以内部类对象可以访问外部类中所有元素
	 * 
	 * outObject.new 相当于 OuterClass
	 */
	@Test
	public void testDemo()
	{
		DotNew outer = new DotNew();
		DotNew.NoStaticInner noStaticInner = outer.new NoStaticInner(18);
		System.out.println(noStaticInner.getAge());
		
		DotNew.NoStaticInner nInner = new DotNew.NoStaticInner(19);
		System.out.println(nInner.getAge());
		
		DotNew.StaticInner staticInner = new StaticInner("lijinlong");
		System.out.println(staticInner.getName());
		
		DotNew.StaticInner sInner = new DotNew.StaticInner("wangxiaoming");
		System.out.println(sInner.getName());
	}
}
