package cn.tk.java.lang;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @description:ThreadLocal, Thread类内置类
 */
public class ThreadLocalDemo {
	ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>()
	{
		/**
		 * @description:重写 initialValue() 方法, 初始化 get() 的时候可以获取到初始化值
		 */
		protected Integer initialValue()
		{
			return 10;
		}
	};
	
	@Test
	public void testInitialValue()
	{
		assertThat(threadLocal.get(), equalTo(10));
		threadLocal.set(100);
		assertThat(threadLocal.get(), equalTo(100));
	}
}
