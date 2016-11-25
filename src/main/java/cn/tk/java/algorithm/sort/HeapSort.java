package cn.tk.java.algorithm.sort;

import org.junit.Test;

/**
 * @Author: lijl85
 * @Title: HeapSort.java
 * @Package: cn.tk.java.algorithm.sort
 * @Time: 2016年8月23日下午4:43:25
 *
 * @description: 堆排序
 */
public class HeapSort {
	private static int[] input = new int[] {16, 4, 10, 14, 7, 9, 3, 2, 8, 1 };
	
	public void heapSort(int[] heap)
	{
		if (heap == null || heap.length <=1) {
			return;
		}
		BuildMaxHeap.buildMaxHeap(heap);//构建大顶堆
		int length = heap.length;
		for (int i = heap.length; i >=2 ; i--) {
			MaxHeapify.exchange(heap, 1, i);
			length --;
			MaxHeapify.maxHeapifyRecursion(heap, 1, length);
		}
	}
	
	@Test
	public void testHeapSort()
	{
		heapSort(input);
		for (int i : input) {
			System.out.println(i + " ");
		}
	}
}
