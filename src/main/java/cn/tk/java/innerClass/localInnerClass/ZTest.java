package cn.tk.java.innerClass.localInnerClass;

import org.junit.Test;

public class ZTest {
	
	private static LocalInnerClass local = new LocalInnerClass();
	
	@Test
	public void testDemo()
	{
		Counter localCounter = local.getCounter("LocalCounter");
		Counter anonyCounter = local.getCounterAno("AnonymousCounter");
		
		for(int i=0; i<5; i++)
			System.out.println(localCounter.next());
		for(int i=0; i<5; i++)
			System.out.println(anonyCounter.next());
	}
}
