package cn.tk.java.innerClass.callback.caller;

public class IndirectIncrementer extends MyIncrement{
	
	private int i;
	
	/**
	 * 重写父类方法, 先调用父类的, 再调用自己的
	 */
	public void increment()
	{
		super.increment();
		i ++;
		System.out.println(i);
	}
	
	/**
	 * @description: 内部类间接实现接口, 增加功能
	 */
	private class Closure implements Incrementable{
		/** 
		 * 实现接口的方法与覆盖类的方法名都一样, 这时候可以使用内部类, 外部类覆盖父类方法, 内部类实现接口编写实现方法
		 */
		@Override
		public void increment() {
			IndirectIncrementer.this.increment();
		}
	}
	
	public Incrementable getCallbackReference()
	{
		return new Closure();
	}
}
