package cn.tk.java.algorithm.leetcode;

import java.text.DecimalFormat;

import org.junit.Test;

/**
 * @Author: lijl85
 * @Title: MedianOfTwoSortedArrays.java
 * @Package: cn.tk.java.algorithm.leetcode
 * @Time: 2016年10月25日上午9:52:34
 *
 * @Description:
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int temp[] = new int[100];
		int i = 0, j = 0, k = 0;
		int sum = 0;
		int len1 = nums1.length;
		int len2 = nums2.length;
		while(i < len1)
		{
			while(j < len2)
			{
				if (nums1[i] > nums2[j]) {
					temp[k] = nums2[j];
					k++; j++;		
				}else {
					temp[k] = nums1[i];
					k++; i++;
				}
			}
			if (i == nums1.length || j == nums2.length) {
				break;
			}
		}
		
		if (i < len1) {
			while(i < len1)
			{
				temp[k] = nums1[i];
				k ++; i++;
			}
		}
		
		if (j < len2) {
			while(j < len2)
			{
				temp[k] = nums2[j];
				k ++; j++;
			}
		}
		
		for (int l = 0; l < k; l++) {
			sum += temp[l];
		}
		
		return Double.valueOf(new DecimalFormat("###.00").format(sum / 2));
    }
	
	@Test
	public void testMedian() {
		int nums1[] = {1, 3};
		int nums2[] = {2};
		System.out.println(findMedianSortedArrays(nums1, nums2));
		int nums3[] = {1, 2};
		int nums4[] = {3, 4};
		System.out.println(findMedianSortedArrays(nums3, nums4));
	}
}
