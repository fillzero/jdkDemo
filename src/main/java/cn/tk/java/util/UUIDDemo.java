package cn.tk.java.util;

import java.util.UUID;

import org.junit.Test;

public class UUIDDemo {
	@Test
	public void testGenerateUUID()
	{
		for(int i=0; i<100; i++)
		{
			UUID randomUUID = UUID.randomUUID();
			System.out.println(randomUUID + "," + randomUUID.toString().length());
		}
	}
	
	/**
	 * @description:位运算简单测试
	 */
	@Test
	public void testBitOperation()
	{
		System.out.println(0x0f);//00001111 = 2^4 - 1 = 15
        System.out.println(0x40);//01000000 = 2^6 = 64
        System.out.println(0x3f);//00111111 = 2^6 - 1 = 63
        System.out.println(0x80);//10000000 = 2^7 = 128
        
        /**
         * 按位与 &：
    	 * 1： 不变
    	 * 0： 变成 0
    	 * 按位或 |:
    	 * 1： 变成 1
    	 * 0： 不变
    	 * 
    	 * &： 0变1不变， |: 1变0不变
    	 */
        System.out.println(0x2 & 0xf); //0010 & 1111 = 0010 = 2
        System.out.println(0x2 & 0x0); //0010 & 0000 = 0000 = 0
        System.out.println(0x2 | 0xf); //0010 | 1111 = 1111 = 15 
        System.out.println(0x2 | 0x0); //0010 | 0000 = 0010 = 2
	}
}
