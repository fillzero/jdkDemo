package cn.tk.java.algorithm.leetcode.bit;

import org.junit.Test;

/**
 * @Author: lijl85
 * @Title: BasicManipulation.java
 * @Package: cn.tk.java.algorithm.leetcode.bit
 * @Time: 2016年11月1日下午1:27:46
 *
 * @Description:常见位运算计算技巧： 
 * "&": 按位与
 * "|": 按位或
 * "~": 按位非
 */
public class BasicManipulation {
	/**
	 * @Description: 获取最大整型: 移位运算符优先级低于减号，必须加括号
	 */
	@Test
	public void getMaxInt()
	{
		int maxInt = (1 << 31) - 1;
		System.out.println(maxInt);
		maxInt = ~(1 << 31);
		System.out.println(maxInt);
		maxInt = (1 << -1) - 1;
		System.out.println(maxInt);
	}
	
	/**
	 * @Description: 获取最小整数
	 */
	@Test
	public void getMinInt()
	{
		int minInt = (1 << 31);
		System.out.println(minInt);
		minInt = 1 << -1;
		System.out.println(minInt);
	}
	
	/**
	 * @Description: 获取最大 long 值
	 */
	@Test
	public void getMaxLong()
	{
		long maxLong = ((long)1 << 127) - 1;
		System.out.println(maxLong);
		maxLong = ((long)1 << -1) - 1;
		System.out.println(maxLong);
		maxLong = ~((long)1 << 127);
		System.out.println(maxLong);
	}
	
	/**
	 * @Description: 获取最小 long 值
	 */
	@Test
	public void getMinLong()
	{
		long minLong = ((long)1 << 127);
		System.out.println(minLong);
		minLong = (long)1 << -1;
		System.out.println(minLong);
	}
	
	/**
	 * @Description: 乘 2 运算
	 */
	@Test
	public void mulTwo()
	{
		System.out.println("10 * 2 = " + (10 << 1));
	}
	
	/**
	 * @Description: 除 2 运算: 向下取整
	 */
	@Test
	public void divTwo()
	{
		System.out.println("10 / 2 = " + (10 >> 1));
		System.out.println("9 / 2 = " + (9 >> 1));
		System.out.println("-9 / 2 = " + (-9 >> 1));
	}
	
	/**
	 * @Description: 除以 2 的 m 次方: 向下取整
	 */
	@Test
	public void divTwoPower()
	{
		System.out.println("100 / 2^5 = " + (100 >> 5));
		System.out.println("-100 / 2^5 = " + (-100 >> 5));
	}
	
	/**
	 * @Description: 判断奇偶性
	 */
	@Test
	public void oddNumber()
	{
		System.out.println((11 & 1) == 1);
		System.out.println((10 & 1) == 1);
	}
	
	/**
	 * @Description: 不用临时变量交换两个数
	 */
	@Test
	public void swap()
	{
		int a = 3;
		int b = 4;
		System.out.println("Before: a = " + a + ", b = " + b);
		a ^= b;
		b ^= a;
		a ^= b;
		System.out.println("After:  a = " + a + ", b = " + b);
	}
	
	/**
	 * @Description:求绝对值
	 * <br>
	 * <p> 
	 * 	   n >> 31 取的 n 的符号，若 n 为正数， n >> 31 等于 0， 若 n 为负数， n >> 31 等于	<br>
	 * -1 若 n 为正数 n ^ 0 = 0， 数不变， 若 n 为负数， 有 n ^ -1， 需要计算 n 和 -1 的补码，	 <br>
	 *  然后进行异或运算， 结果 n 变号并且为 n 的绝对值减 1， 再减去 -1 就是绝对值。
	 * </p>
	 */
	@Test
	public void abs()
	{
		int a = 10;
		int b = -10;
		int absA = (a ^ (a >> 31)) - (a >> 31);
		int absB = (b ^ (b >> 31)) - (b >> 31);
		System.out.println("absA: " + absA);
		System.out.println("absB: " + absB);
	}
	
	/**
	 * @Description: 取最大值
	 * 如果 a >= b， （a - b）>> 31 为 0， 否则为 -1
	 */
	@Test
	public void max()
	{
		int a = 12;
		int b = 11;
		int max = b & ((a-b) >> 31) | a & (~(a-b) >> 31);
		System.out.println(max);
	}
	
	/**
	 * @Description: 取最小值
	 */
	@Test
	public void min()
	{
		int a = 12;
		int b = 11;
		int min = a & ((a-b) >> 31) | b & (~(a-b) >> 31);
		System.out.println(min);
	}
	
	/**
	 * @Description: 判断符号是否相同: true 表示相同， false 表示不相同
	 */
	@Test
	public void isSameSign()
	{
		int a = 10;
		int b = 11;
		int c = -9;
		System.out.println((a ^ b) >= 0);
		System.out.println((b ^ c) >= 0);
	}
	
	/**
	 * @Description: 计算 2 的 n 次方
	 */
	@Test
	public void getFactorialOfTwo()
	{
		int pow = 10;
		System.out.println(2 << (pow-1));
	}
	
	/**
	 * @Description: 判断是否是 2 的幂
	 * 如果是 2 的幂， 一定是 1111....， 所以做与运算结果为 0
	 */
	@Test
	public void isFactorialOfTwo()
	{
		int a = 100;
		int b = 128;
		System.out.println(a>0 ? (a&(a-1)) == 0 : false);
		System.out.println(b>0 ? (b&(b-1)) == 0 : false);
	}
	
	/**
	 * @Description: 取两个整数的平均值
	 * (a ^ b) >> 1: 得到 a, b 其中一个为 1 的位并除以 2 <br>
	 * (a & b)： 得到 a, b 都为 1 的部分， 加一起就是平均数了
	 */
	@Test
	public void getAverage()
	{
		int a = 100;
		int b = 70;
		System.out.println((a + b) >> 1);
		System.out.println(((a ^ b) >> 1) + (a & b));
	}
	
	/**
	 * @Description: 取 a 的 第 b 位（从低位到高位）
	 */
	@Test
	public void getBit()
	{
		int a = 15;
		int b = 3;
		System.out.println((a >> (b-1)) & 1);
	}
	
	/**
	 * @Description: 将 a 的第 b 位置为 1（从低位到高位）
	 * 14: 1110 --> 15: 1111
	 */
	@Test
	public void setBitToOne()
	{
		int a = 14;
		int b = 1;
		System.out.println(a | (1 << (b-1)));
	}
	
	/**
	 * @Description: 将 a 的第 b 位置为 0（从低位到高位）
	 * 15: 1111 --> 14: 1110
	 */
	@Test
	public void setBitToZero()
	{
		int a = 15;
		int b = 1;
		System.out.println(a & ~(1 << (b - 1)));
	}
	
	/**
	 * @Description: 位运算常识
	 */
	@Test
	public void commonSense()
	{
		// 加 1 操作
		System.out.println("加 1 操作: " + -~10);
		
		// 减 1 操作
		System.out.println("减 1 操作: " + ~-10);
		
		// 取相反数
		System.out.println("取相反数: " + (~10 + 1));
		System.out.println("取相反数: " + ((10 ^ -1) + 1));
	}
}
