package cn.tk.java.algorithm.leetcode.array;

import org.junit.Test;

public class ThirdMax {
	/**
	 * @description:返回数组中第三大的值，如果没有返回最大的
	 */
	public int thirdMax(int[] nums) {
	    return 0;
	}
	
	@Test
	public void testThirdmax()
	{
		int array1[] = {3, 2, 1};
		int array2[] = {1, 2};
		int array3[] = {2, 2, 3, 1};
		System.out.println(thirdMax(array1));
		System.out.println(thirdMax(array2));
		System.out.println(thirdMax(array3));
	}
	
}
