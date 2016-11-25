package cn.tk.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @description:原子更新， 使用原子变量 ＝＝> 不用锁就可以安全的更新变量
 * 读， 写， 更新作为一个原子操作
 */
public class AtomicIntegerFieldUpdaterDemo {
	class DemoData {
		public volatile int value1 = 1;
		volatile int value2 = 2;
		protected volatile int value3 = 3;//3, 4的值对 AtomicIntegerFieldUpdaterDemo 是不可见的， 不可以修改
		private volatile int value4 = 4;
	}

	AtomicIntegerFieldUpdater<DemoData> getUpdater(String fieldName) {
		return AtomicIntegerFieldUpdater.newUpdater(DemoData.class, fieldName);
	}

	void doit() {
		DemoData data = new DemoData();
		System.out.println("1 ==> " + getUpdater("value1").getAndSet(data, 10));
		System.out.println("2 ==> "	+ getUpdater("value2").decrementAndGet(data));
		System.out.println("3 ==> "	+ getUpdater("value3").incrementAndGet(data));
		System.out.println("true ==> " + getUpdater("value4").compareAndSet(data, 4, 5));
	}
	
	public static void main(String[] args)
	{
		AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();
		demo.doit();
	}
}
