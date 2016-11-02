package cn.tk.java.algorithm.leetcode.bit;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @description:找数组中任意两个数异或的最大值
 * 时间复杂度控制在 O(n)
 */
public class FindMaximumXOR {
	
	/**
	 * @description:位运算与 HashMap
	 * example: Given [14, 11, 7, 2], which in binary are [1110, 1011, 0111, 0010].
		Since the MSB is 3, I'll start from i = 3 to make it simplify.
		
		i = 3, set = {1000, 0000}, max = 1000
		i = 2, set = {1100, 1000, 0100, 0000}, max = 1100
		i = 1, set = {1110, 1010, 0110, 0010}, max = 1100
		i = 0, set = {1110, 1011, 0111, 0010}, max = 1100
	 */
	/**
	 * @description:第一种方式, 还可以用字典数实现
	 */
	public int findMaximumXOR(int[] nums) {
		int max = 0, mask = 0;
		for(int i = 31; i >= 0; i--){
		    mask = mask | (1 << i);
		    Set<Integer> set = new HashSet<>();
		    for(int num : nums){
		        set.add(num & mask);
		    }
		    //与 0 异或不变, 与 1 异或变成相反数, 0与1异或就会变大
		    int tmp = max | (1 << i); // in each iteration, there are pair(s) whoes Left bits can XOR to max
		    for(int prefix : set){
		        if(set.contains(tmp ^ prefix)) {
		            max = tmp;
		            break;
		        }
		    }
		}
		return max;
    }
	
	@Test
	public void test()
	{
		 int nums[] = {3, 10, 5, 25, 2, 8};
		 int maxNum = findMaximumXOR(nums);
		 System.out.println(maxNum);
	}
	
	/**
	 * @description: 异或运算: 不同为 1, 相同为 0
	 * 与 1 异或变成相反数
	 * 与 0 异或变成本身 
	 */
	@Test
	public void basicXOR()
	{
		System.out.println("0 ^ 1 = " + (0 ^ 1));
		System.out.println("1 ^ 1 = " + (1 ^ 1));
		System.out.println("0 ^ 0 = " + (0 ^ 0));
		System.out.println("1 ^ 0 = " + (1 ^ 0));
	}
}
