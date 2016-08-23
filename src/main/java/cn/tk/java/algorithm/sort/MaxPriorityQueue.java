package cn.tk.java.algorithm.sort;

public class MaxPriorityQueue {
	public int heapMaxMum(int[] heap)
	{
		BuildMaxHeap.buildMaxHeap(heap);
		return heap[0];
	}
	
	public int heapExtractMax(int[] heap)
	{
		int length = heap.length;
		if (length < 1) {
			throw new RuntimeException("heap underflow");
		}
		BuildMaxHeap.buildMaxHeap(heap);
		int max = heap[0];
		heap[0] = heap[heap.length];
		length --;
		MaxHeapify.maxHeapifyRecursion(heap, 1, length);
		return max;
	}
	
	public void heapIncreaseKey(int[] heap, int i, int key)
	{
		if (key < heap[i]) {
			throw new RuntimeException();
		}
	}
}
