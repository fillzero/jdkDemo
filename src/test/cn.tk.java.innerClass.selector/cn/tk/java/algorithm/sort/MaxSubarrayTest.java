package cn.tk.java.algorithm.sort;

import org.junit.Test;

import cn.tk.java.algorithm.MaxSubarray;
import cn.tk.java.algorithm.Subarray;

public class MaxSubarrayTest {
	private static int[] data = {3, -4, 5, 10, -10, 27, 2, -12};
//	private static int[] data = {3, -4, 5};
	Subarray currentSubarray = new Subarray(0, data.length, Integer.MIN_VALUE);
	private MaxSubarray maxSubarrayService = new MaxSubarray();
	
	@Test
	public void testMaxSubarray()
	{
		Subarray maxSubArray = maxSubarrayService.maxSubArray_recursion(data, 0, data.length-1, currentSubarray);
		System.out.println(maxSubArray.toString());
	}
	
	@Test
	public void testGetMaxFromThree()
	{
		Subarray maxCrossSubarray = new Subarray(0, 1, 100);
		Subarray maxLeftSubarray = new Subarray(2, 3, 200);
		Subarray maxRightSubarray = new Subarray(3, 7, 400);
		Subarray maxFromThree = maxSubarrayService.getMax3(maxCrossSubarray, maxLeftSubarray, maxRightSubarray);
		System.out.println(maxFromThree.toString());
	}
	
	@Test
	public void testMaxCrossSubarray()
	{
		int mid = data.length / 2;
		Subarray maxCrossSubarray = maxSubarrayService.maxCross(data, 0, mid, data.length-1);
		System.out.println(maxCrossSubarray.toString());
	}
	
	@Test
	public void testFindMaxSum()
	{
		System.out.println(maxSubarrayService.findMaxSum(data));
	}
	
	@Test
	public void testFindMaxSubArray()
	{
		System.out.println(maxSubarrayService.findMaxSubArray(data, 0, data.length));
	}
}
