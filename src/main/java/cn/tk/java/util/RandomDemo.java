package cn.tk.java.util;

import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

public class RandomDemo {
	@Test
	public void testCreate()
	{
		Random random = new Random(100);
		for(int i=0; i<100; i++)
		{
			System.out.print(random.nextInt(100) + " ");
		}
	}

	@Test
	public void testApacheRandom()
	{
		for(int i=0; i<10; i++)
		{
			System.out.print(RandomUtils.nextInt(10) + " ");
			System.out.println(RandomUtils.nextBoolean(new Random(100)));
		}
	}
}
