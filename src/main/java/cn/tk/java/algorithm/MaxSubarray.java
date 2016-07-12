package cn.tk.java.algorithm;

import java.util.Arrays;

/**
 * @Description: 求解最大非空连续子数组的和
 * 1. 暴力求解
 * 2. 递归求解
 * 3. 动态规划
 */
public class MaxSubarray {
	
	/**
	 * @Description:1. 暴力求解, O(n^3) 的时间复杂度
	 */
	public Subarray findMaxSubArray(int[] data, int left, int right)
	{
		Subarray maxSubarray = new Subarray();
		int maxSum = Integer.MIN_VALUE;
		for (int i=0; i<data.length; i++) {
			for(int j=i+1; j<data.length; j++)
			{
				int[] currentArray = Arrays.copyOfRange(data, i, j);
				if (getArraySum(currentArray) > maxSum) {
					maxSum = getArraySum(currentArray);
					maxSubarray.setLeft(i);
					maxSubarray.setRight(j);
				}
			}
		}
		maxSubarray.setSum(maxSum);
		return maxSubarray;
	}
	
	/**
	 * @Description:求子数组的和
	 */
	public int getArraySum(int[] array) {
		if(array==null || array.length==0)
			throw new IllegalArgumentException();
		int sum = 0;
		for(int i : array)
		{
			sum += i;
		}
		return sum;
	}
	
	/**
	 * @Description:2. 递归算法：  O(n*logn) 的时间复杂度
	 */
	public Subarray maxSubArray_recursion(int[] data, int left, int right, Subarray currentSubarray)
	{
		if (left == right) {
			return currentSubarray;//记录当前最大非空连续子数组的下标
		}else {
			int mid = (left + right) / 2;
			Subarray maxCross = maxCross(data, left, mid, right);
			Subarray maxLeft = maxSubArray_recursion(data, left, mid, currentSubarray);
			Subarray maxRight = maxSubArray_recursion(data, mid+1, right, currentSubarray);
			currentSubarray = getMax3(maxCross, maxLeft, maxRight); 
			return currentSubarray;
		}
	}
	
	/**
	 * @Description: 找三个数中最大的
	 */
	public Subarray getMax3(Subarray maxCrossSubarray,
			Subarray maxLeftSubarray, Subarray maxRightSubarray) {
		int a = maxCrossSubarray.getSum();
		int b = maxLeftSubarray.getSum();
		int c = maxRightSubarray.getSum();
		if(b<a && c<a)
			return maxCrossSubarray;
		if(a<b && c<b)
			return maxLeftSubarray;
		else 
			return maxRightSubarray;
	}

	/**
	 * @Description:含中间部分最大和
	 * max 值开始一定要用负无穷， 不能用 0 代替， 否则负数中的最大值就不会被计算进来（注意最大值与正负无关）
	 * 当所有值都是负数的时候， 负数也可能成为最大值
	 */
	public Subarray maxCross(int[] data, int left, int mid, int right)
	{
		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MIN_VALUE;
		int curSum = 0;
		int posLeft = mid;
		int posRight = mid+1;
		for(int i=mid; i>=left; i--)
		{
			curSum += data[i];
			if (curSum > leftMax) 
			{
				leftMax = curSum;
				posLeft = i;
			}
		}
		curSum = 0;
		for(int i=mid+1; i<=right; i++)
		{
			curSum += data[i];
			if (curSum > rightMax)
			{
				rightMax = curSum; 
				posRight = i;
			}
		}
		return new Subarray(posLeft, posRight, leftMax+rightMax);
	}
	
	/**
	 * @Description:3. 线性时间求解最大非空连续子数组的和
	 * curSum <= 0： 从当前值重新开始计算，如果负数为最大值， 只可能是单一一个负数， 所以只需要记住一个最大的
	 * O(n) 的时间复杂度
	 */
	public Integer findMaxSum(int[] nums)
	{	// 参数校验
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }
        int max = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i : nums) {
            // 当前和小于0，就将当前值赋给curSum
            if (curSum <= 0){
                curSum = i;
            }
            // 否则进行累加
            else {
                curSum += i;
            }
            // 保存较大的值
            if (max < curSum) {
                max = curSum;
            }
        }
        return max;
    }
}
