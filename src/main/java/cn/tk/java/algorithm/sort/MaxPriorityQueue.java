package cn.tk.java.algorithm.sort;

import org.junit.Test;

/**
 * @Author: lijl85
 * @Title: MaxPriorityQueue.java
 * @Package: cn.tk.java.algorithm.sort
 * @Time: 2016年8月24日下午6:05:15
 *
 * @Description:最大优先队列： 由一组元素构成的集合， 拥有以下基本操作。
 * 1. 插入新的作业
 * 2. 查看高优先级作业
 * 3. 取出高优先级作业执行完删除
 * 4. 提升优先级
 */
public class MaxPriorityQueue {
	
	private static int[] input = new int[] {16, 4, 10, 14, 7, 9, 3, 2, 8, 1 };
	
	/**
	 * @Description:取出优先级高的作业（关键字大）
	 */
	public int heapMaxMum(int[] heap)
	{
		BuildMaxHeap.buildMaxHeap(heap);
		return heap[0];
	}
	
	/**
	 * @Description:取出优先级高的作业， 执行完删除
	 */
	public int heapExtractMax(int[] heap)
	{
		int length = heap.length;
		if (length < 1) {
			throw new RuntimeException("heap underflow");
		}
		BuildMaxHeap.buildMaxHeap(heap);
		int max = heap[0];
		heap[0] = heap[length-1];
		length --;
		MaxHeapify.maxHeapifyRecursion(heap, 1, length);
		return max;
	}
	
	/**
	 * @Description:提升关键字优先级（i 位置元素， 提升到 key）
	 */
	public void heapIncreaseKey(int[] heap, int i, int key)
	{
		if (key < heap[i]) {
			throw new RuntimeException("new key is smaller than current key!");
		}
		heap[i] = key;
		while (i>1 && heap[parent(i)]<heap[i]) {
			MaxHeapify.exchange(heap, parent(i), i);
			i = parent(i);
		}
		BuildMaxHeap.buildMaxHeap(heap);
	}
	
	/**
	 * @Description:将 key 插入 heap 中，
	 */
	public void heapInsert(int[] heap, int key)
	{
		
	}
	
	public int parent(int child)
	{
		return child/2;
	}
	
	public void print()
	{
		for (int i : input) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	public void testHeapMaxMum()
	{
		System.out.println("max mum: " + heapMaxMum(input));
		print();
	}
	
	@Test
	public void testHeapExtractMax()
	{
		System.out.println("extract max: " + heapExtractMax(input));
		print();
	}
	
	@Test
	public void testHeapIncreaseKey()
	{
		print();
		heapIncreaseKey(input, 2, 18);
		print();
	}
}
