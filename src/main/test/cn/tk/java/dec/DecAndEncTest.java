package cn.tk.java.dec;

import org.junit.Test;

public class DecAndEncTest {
	
	/**
	 * @description:测试解密
	 */
	@Test
	public void testDec()
	{
		String password = "110A8A102C55BE60DF87BE38BF44DE91C4C70A58AF128BF118C90D88";
		System.out.println(DecAndEnc.dec(password));
	}
}
