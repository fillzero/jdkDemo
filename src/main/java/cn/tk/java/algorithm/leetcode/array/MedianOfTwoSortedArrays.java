package cn.tk.java.algorithm.leetcode.array;

import java.text.DecimalFormat;

import org.junit.Test;

/**
 * @Author: lijl85
 * @Title: MedianOfTwoSortedArrays.java
 * @Package: cn.tk.java.algorithm.leetcode
 * @Time: 2016年10月25日上午9:52:34
 *
 * @description: 题目 :There are two sorted arrays nums1 and nums2 of size m and n
 *               respectively. Find the median of the two sorted arrays. The
 *               overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {
	// 类似于 merge 算法, 自己实现, 时间复杂度为 O(m, n)
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		DecimalFormat formatter = new DecimalFormat("##.0");
		int len1 = nums1.length;
		int len2 = nums2.length;
		int temp[] = new int[len1 + len2];
		int i = 0, j = 0, k = 0;
		while (i < len1) {
			while (j < len2) {
				if (nums1[i] > nums2[j]) {
					temp[k] = nums2[j];
					k++;
					j++;
				} else {
					temp[k] = nums1[i];
					k++;
					i++;
				}
				if (i == nums1.length || j == nums2.length) {
					break;
				}
			}
			if (i == nums1.length || j == nums2.length) {
				break;
			}
		}
		if (i < len1) {
			while (i < len1) {
				temp[k] = nums1[i];
				k++;
				i++;
			}
		}
		if (j < len2) {
			while (j < len2) {
				temp[k] = nums2[j];
				k++;
				j++;
			}
		}
		if ((len1 + len2) % 2 == 0) {
			Double double1 = Double.valueOf(formatter
					.format(temp[(len1 + len2) / 2 - 1]));
			Double double2 = Double.valueOf(formatter
					.format(temp[(len1 + len2) / 2]));
			return (double1 + double2) / 2;
		} else {
			return temp[(len1 + len2) / 2];
		}
	}

	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int k = m + n;

		if ((k & 0x1) == 1) {
			return find_kth(nums1, 0, m, nums2, 0, n, k / 2 + 1);
		} else
			return (find_kth(nums1, 0, m, nums2, 0, n, k / 2) + find_kth(nums1, 0, m,
					nums2, 0, n, k / 2 + 1)) / 2;
	}

	// 递归算法，不断缩小两个数组的范围，同时k的值也相对两个搜索区间上限起始点而改变
	public double find_kth(int[] A, int aStart, int aEnd, int[] B, int bStart,
			int bEnd, int kth) {
		// 1. 统一将长度短的放置于find函数参数的前面项
		if (aEnd > bEnd)
			return find_kth(B, bStart, bEnd, A, aStart, aEnd, kth);

		// 2. 长度短的为空，则答案等同于求另外一个数组的中位数
		if (aEnd <= 0)
			return B[bStart + kth - 1];

		// 3. 递归到终点，两个数组的aStart和bStart已经到了中位数的位置
		if (kth == 1)
			return min(A[aStart], B[bStart]);

		int pa = min(kth / 2, aEnd), pb = kth - pa;

		if (A[aStart + pa - 1] < B[bStart + pb - 1])
			return find_kth(A, aStart + pa, aEnd - pa, B, bStart, bEnd, kth - pa);
		else
			return find_kth(A, aStart, aEnd, B, bStart + pb, bEnd - pb, kth - pb);

	}

	public int min(int a, int b) {
		return a > b ? b : a;
	}

	@Test
	public void testMedian() {
		int nums1[] = { 1, 3 };
		int nums2[] = { 2 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
		int nums3[] = { 1, 2 };
		int nums4[] = { 3, 4 };
		System.out.println(findMedianSortedArrays(nums3, nums4));
		
		System.out.println(findMedianSortedArrays2(nums1, nums2));
		System.out.println(findMedianSortedArrays2(nums3, nums4));
	}
}
