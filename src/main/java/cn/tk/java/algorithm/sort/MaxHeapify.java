package cn.tk.java.algorithm.sort;

import org.junit.Test;

/**
 * @Author: lijl85
 * @Title: MaxHeapify.java
 * @Package: cn.tk.java.algorithm.sort
 * @Time: 2016年8月23日下午1:26:33
 *
 * @description: 大顶堆
 */
public class MaxHeapify {
	private static int[] input = new int[] {16, 4, 10, 14, 7, 9, 3, 2, 8, 1 };
	private static int heapSize = input.length;//堆大小
	
	/**
	 * @description: 递归维护大顶堆方法
	 * @param: array: 数组（用来描述堆）
	 * @param: parent: 根节点下标
	 */
	public static void maxHeapifyRecursion(int[] heap, int parent) {
		int lchild = parent * 2;//左孩子下标
		int rchild = lchild + 1;//右孩子下标
		int largest;
		if (lchild <= heapSize && heap[lchild-1] > heap[parent-1]) {//左孩子与父节点比较大小
			largest = lchild;
		}else {
			largest = parent;
		}
		
		if (rchild < heapSize && heap[rchild-1] > heap[largest-1]) {//右孩子与父节点左孩子比较大小
			largest = rchild;
		}
		
		if (largest != parent) {
			exchange(heap, parent, largest);
			maxHeapifyRecursion(heap, largest);
		}
	}
	
	public static void maxHeapifyRecursion(int[] heap, int parent, int length) {
		int lchild = parent * 2;//左孩子下标
		int rchild = lchild + 1;//右孩子下标
		int largest;
		if (lchild <= length && heap[lchild-1] > heap[parent-1]) {//左孩子与父节点比较大小
			largest = lchild;
		}else {
			largest = parent;
		}
		
		if (rchild <= length && heap[rchild-1] > heap[largest-1]) {//右孩子与父节点左孩子比较大小
			largest = rchild;
		}
		
		if (largest != parent) {
			exchange(heap, parent, largest);
			maxHeapifyRecursion(heap, largest, length);
		}
	}
	
	/**
	 * @description:非递归方式维护大顶堆
	 */
	public static void maxHeapify(int[] heap, int parent)
	{
		int lchild = parent * 2;//左孩子下标
		int rchild = lchild + 1;//右孩子下标 
		int largest = parent;
		while (true) {
			if (lchild < heapSize && heap[lchild] > heap[parent]) {
				largest = lchild;
			}
			if (rchild < heapSize && heap[rchild] > heap[largest]) {
				largest = rchild;
			}
			if (parent != largest) {
				exchange(heap, parent, largest);
			}
			else {
				break;
			}
			parent = largest;
			lchild = parent * 2;
			rchild = lchild + 1;
		}
	}

	/**
	 * @description: 交换数组中两个元素的值
	 * @param heap： 数组
	 * @param parent： 父节点下标
	 * @param largest： 最大值节点下标
	 */
	public static void exchange(int[] heap, int parent, int largest) {
		int temp = heap[parent-1];
		heap[parent-1] = heap[largest-1];
		heap[largest-1] = temp;
	}
	
	/**
	 * @description: 打印整个数组
	 */
	public static void printArray() {
		for (int i : input) {
			System.out.println(i + " ");
		}
	}
	
	@Test
	public void testMaxHeapifyRecursion() {
		maxHeapifyRecursion(input, 2);
		printArray();
	}
	
	@Test
	public void testMaxHeapify(){
		maxHeapify(input, 2);
		printArray();
	}
}
