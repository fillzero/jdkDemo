package cn.tk.java.algorithm.sort;

import org.junit.Test;

public class InsertSort {
	
	/**
	 * @description:按从小到大排序
	 */
	public void insertSort(int[] array)
	{
		if(array == null || array.length < 1)
		{
			System.out.println("请输入正确整数序列!");
			return;
		}
		
		/**
		 * @description: 1~(i-1) 均为有序数组, 插入 array[i], 变成 1~i 均为有序数组
		 */
		for(int i=0; i<array.length; i++)
		{
			int key = array[i];
			int position = i;
			for(int j =i-1; j>=0; j--)//从后向前遍历
			{
				if(array[j] > key)
				{
					array[j+1] = array[j];
					position --;
				}
			}
			array[position] = key;
		}
	}
	
	@Test
	public void testInsertSort()
	{
		int[] array = {5, 12, 12, 1, 23, 34, 5, 11};
		insertSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
