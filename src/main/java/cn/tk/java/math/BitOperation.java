package cn.tk.java.math;

import org.junit.Test;

public class BitOperation {
	@Test
	public void testBitOperation()
	{
		//1、左移
		// 0000 0101 --> 0001 0100， 左移两位，低位补 0，相当于乘 2^2 = 4
		System.out.println("***************************** 左移两位 ***************************");
		System.out.println(5 << 2);
		System.out.println(5 * 4);
		
		//2、右移（高位补符号位）
		// 0000 0101 --> 0000 0001， 右移两位，高位补 0，相当于除 4
		System.out.println("\n***************************** 右移两位 ***************************");
		System.out.println(5 >> 2);
		System.out.println(5 / 4);
		// 1000 0101 --> 1000 0111
		System.out.println(-5 >> 2);
		
		
		//3、无符号右移（高位补 0）
		System.out.println("\n***************************** 无符号右移 ***************************");
		System.out.println(5 >> 3);
		System.out.println(-5 >> 3);
		System.out.println(-5 >>> 3);
		
		//4、位与（&）
		// 5 & 3: 0000 0101 & 0000 0011 = 0000 0001 --> 1
		// 4 & 1: 0000 0100 & 0000 0001 = 0000 0000 --> 0
		System.out.println("\n***************************** 位与 ***************************");
		System.out.println(5 & 3);
		System.out.println(4 & 1);
		
		//5、位或（|）
		// 5 | 3: 0000 0101 | 0000 0011 = 0000 0111 --> 7
		System.out.println("\n***************************** 位或 ***************************");
		System.out.println(5 | 3);
		
		//6、位异或
		// 5 ^ 3: 0000 0101 ^ 0000 0011 = 0000 0110 --> 6
		System.out.println("\n***************************** 位异或 ***************************");
		System.out.println(5 ^ 3);
		
		//7、位非
		//~5 0000 0101 --> 1111 1010
		System.out.println("\n***************************** 位非 ***************************");
		System.out.println(~5);
		
	}
}