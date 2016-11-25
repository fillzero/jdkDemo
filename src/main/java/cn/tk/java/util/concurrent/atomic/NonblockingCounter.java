package cn.tk.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:使用 CAS 的非阻塞算法
 */
public class NonblockingCounter {
	private AtomicInteger value;
	public int getValue()
	{
		return value.get();
	}
	
	/**
	 * @description: compareAndSet(expected, update): 只有当前值 value 与 预期的 v 相等的情况下， 才进行更新，间接保证了不会丢失数据
	 * 如果不相等， 说明有些线程的操作还没有结束， 继续循环获取当前值， 保证同一时刻只有一个线程在操作变量
	 * 
	 * compareAndSet 保证了对变量的更新是原子性的
	 */
	public int increment()
	{
		int v;
		do {
			v = value.get();
		} while (!value.compareAndSet(v, v+1));
		return v + 1;
	}
}
