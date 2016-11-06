package cn.tk.java.innerClass.selector;

/**
 * @author: lijl85
 * @date：2016年11月3日下午10:50:39
 * @description:内部类拥有外部类所有元素的访问权
 * 常用技巧: 外部类的方法返回内部类的引用, 内部类向上转型, 返回值类型是内部类实现的的接口
 * 
 * 目的: 用内部类机制实现简单迭代器 
 * 如果当前 Sequence 还有元素, 就继续迭代并且打印, Sequence 内部是 Object 数组
 * 
 * 总结: 用到了 "迭代器" 设计模式
 * 
 * 内部类实现多重继承典型应用, 多个内部类实现同一个接口, 但是提供不同的实现
 * 当然多个内部类也可以实现不同的接口 ,然后返回一个内部类的引用供外部类使用.
 */
public class Sequence {
	
	public Object[] items;//被迭代集合
	public int next = 0;//迭代器下标
	
	public Sequence() {

	}
	
	public Sequence(int size) {
		items = new Object[size];
	}
	
	public void add(Object item)
	{
		if (next < items.length) {
			items[next ++] = item;
		}
	}
	
	/**
	 * @Description: 内部类实现 Selecter 接口， 提供正向迭代器
	 */
	private class DefaultSelecter implements Selecter{
		private int i = 0;
		@Override
		public boolean hasNext() {
			return i != items.length;
		}

		@Override
		public Object value() {
			return items[i];
		}

		@Override
		public void next() {
			if (i < items.length) {
				i ++;
			}
		}
	}
	
	/**
	 * @Description: 内部类实现 Selecter 接口， 提供方向迭代器
	 */
	private class ReverseSelecter implements Selecter{
		private int i = items.length;
		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Object value() {
			return items[i-1];
		}

		@Override
		public void next() {
			if (i > 0) {
				i --;
			}
		}
	}
	
	public Selecter getCommonSelecter()
	{
		return new DefaultSelecter();
	}
	public Selecter getReverseSelecter()
	{
		return new ReverseSelecter();
	}
}
