package cn.tk.java.junit.four.parameterized;

/**
 * @Company: 泰康在线财产保险股份有限公司
 * @Author: 李晋龙
 * @Title: Fibonacci.java
 * @Package: cn.tk.junitDemo.parameterized
 * @Time: 2016年5月30日下午3:12:16
 *
 * @description: 斐波那契类
 */
public class Fibonacci {
	public static int compute(int n)
	{
		int result = 0;
		if(n <=1)
		{
			result = n;
		}else {
			result = compute(n-1) + compute(n-2);
		}
		return result;
	}
}
