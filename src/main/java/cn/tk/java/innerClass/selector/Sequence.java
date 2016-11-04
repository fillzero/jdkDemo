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
	 * @Description: 内部类实现 Selecter 接口， 提供默认实现
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
	public Selecter getSelecter()
	{
		return new DefaultSelecter();
	}
	
	/**
	 * @Description:测试迭代器
	 */
	public static void main(String[] args)
	{
		Sequence sequence = new Sequence(10);
		for(int i=0; i<10; i++) {
			sequence.add(i);
		}
		
		Selecter selecter = sequence.getSelecter();
		while (selecter.hasNext()) {
			System.out.println(selecter.value());
			selecter.next();
		}
	}
}
