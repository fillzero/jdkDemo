package cn.tk.java.algorithm.leetcode.array;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		int[] index = {0, 0};
		for (int i=0; i<nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				if (sum == target) {
					index[0] = i;
					index[1] = j;
					return index;
				}
			}
		}
		return index;
    }
	
	public static void main(String[] args) {
		int[] nums =  {2, 7, 11, 15};
		int[] twoSum = twoSum(nums, 9);
		for(int i : twoSum)
		{
			System.out.println(i);
		}
	}
}
