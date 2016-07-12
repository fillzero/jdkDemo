package cn.tk.java.algorithm.sort;

import org.junit.Test;

public class MergeSort {
	
	/**
	 * @description:分治法编写归并排序, 核心是 "合并" 方法
	 * 分解, 递归, 合并
	 */
	private void mergeSort(int[] data, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(data, left, middle);
			mergeSort(data, middle+1, right);
			merge(data, left, middle, right);
			print(data);
		}
	}
	
	/**
	 * @description: 合并两个有序序列
	 * left, middle, right: 数组边界点
	 */
	public void merge(int[] data, int left, int middle, int right)
	{
		int[] tempArray = new int[data.length];
		int leftPos = left;
		int tempPos = left;
		int midPos = middle + 1;
		while(leftPos<=middle && midPos<=right)
		{
			if (data[leftPos]<data[midPos]) {
				tempArray[tempPos++] = data[leftPos++];
			}
			else {
				tempArray[tempPos++] = data[midPos++];
			}
		}
		
		while(leftPos<=middle)
		{
			tempArray[tempPos++] = data[leftPos++];
		}
		while(midPos<=right)
		{
			tempArray[tempPos++] = data[midPos++];
		}
		
		while(left<=right)
		{
			data[left] = tempArray[left++];
		}
	}
	
	@Test
	public void testInsertSort()
	{
		int[] array = {5, 12, 12, 1, 23, 34, 5, 11};
		mergeSort(array, 0, array.length-1);
	}

	private void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}
}
