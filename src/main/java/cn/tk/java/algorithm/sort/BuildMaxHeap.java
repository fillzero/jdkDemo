package cn.tk.java.algorithm.sort;

import org.junit.Test;

/**
 * @Author: lijl85
 * @Title: BuildMaxHeap.java
 * @Package: cn.tk.java.algorithm.sort
 * @Time: 2016年8月23日下午3:57:21
 *
 * @Description:构建大顶堆， 这一步是堆排序的基础
 */
public class BuildMaxHeap {
	
	private static int[] input = new int[] {16, 4, 10, 14, 7, 9, 3, 2, 8, 1 };
	
	/**
	 * @Description:对整棵树进行堆调整不需要将所有的节点都进行调整， 叶节点不需要调整（没有左右孩子）， 
	 * 所以从第一个叶节点之前的元素开始顺序调整。
	 * @param heap: 进行对调整的堆结构（一个简单的数组）
	 */
	public static void buildMaxHeap(int[] heap)
	{
		for (int i = heap.length/2; i >= 1; i--) {
			MaxHeapify.maxHeapifyRecursion(heap, i);
		}
	}
	
	@Test
	public void testBuildMaxHeap()
	{
		buildMaxHeap(input);
		for (int i : input) {
			System.out.println(i + " ");
		}
	}
}
