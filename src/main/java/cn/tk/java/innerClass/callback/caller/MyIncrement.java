package cn.tk.java.innerClass.callback.caller;

/**
 * @author: lijl85
 * @date：2016年11月6日下午3:47:54
 * 自定义父类
 */
public class MyIncrement {
	public void increment()
	{
		System.out.println("MyIncrement: 交给子类实现, 空方法");
	}
	
	/**
	 * @description: 子类调用的时候, 先调用父类的, 再调用子类的
	 */
	public static void funcIncre(MyIncrement mIncrement)
	{
		mIncrement.increment();
	}
}
