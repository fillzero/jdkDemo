package cn.tk.java.lang;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class AtomicIntegerDemo {
	private AtomicInteger atomicInteger = new AtomicInteger(1);
	
	@Test
	public void testGetAndIncrement()
	{
		System.out.println(atomicInteger);
		System.out.println(atomicInteger.getAndIncrement());
		System.out.println(atomicInteger);
	}
}
