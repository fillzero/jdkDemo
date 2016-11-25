package cn.tk.java.util.concurrent.atomic;

import org.junit.Test;

/**
 * @description:经过实验该非阻塞计数器是线程安全的
 */
public class NonblockingCounterTest {
	private static volatile int value = 0;
	@Test
	public void testIncrement() {
		for (int i = 0; i < 50; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("Value: " + ++value);
				}
			});
			thread.start();
		}
	}
}
