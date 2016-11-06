package cn.tk.java.innerClass.localInnerClass;

/**
 * @author: lijl85
 * @date：2016年11月6日下午5:14:44
 * @description: 局部内部类对比匿名内部类
 */
public class LocalInnerClass {
	private int count = 0;
	
	public Counter getCounter(final String name)
	{
		class LocalCounter implements Counter{
			
			public LocalCounter() {
				System.out.println("Constructor LocalCounter!");
			}
			
			@Override
			public int next() {
				System.out.print(name + ": ");
				return count ++;
			}
			
		}
		return new LocalCounter();
	}
	
	public Counter getCounterAno(final String name)
	{
		/**
		 * @description: 匿名类没有带名字的构造器, 只有一个实例初始化
		 */
		return new Counter(){
			{
				System.out.println("Constructor AnonymousCounter!");
			}
			
			@Override
			public int next() {
				System.out.print(name + ": ");
				return count ++;
			}
			
		};
	}
}
