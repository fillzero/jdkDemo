package cn.tk.java.algorithm;

/**
 * <p>
 * Title: TestMaxArray.java
 * </p>
 * <p>
 * Description: 分治法求解连续和最大
 * </p>
 * 
 * @date 2014-3-05
 *
 */
public class MaxSub {
//	static int arr[] = { 4, -3, 5, -2, -1, 2, 6, -2 }; // 也可以随机生成
	static int arr[] = {3, -4, 5, -10, -4, 27, 2, -12};

	public static void main(String args[]) {
		System.out.println(max(arr));
	}

	// 包装函数
	public static int max(final int[] arr) {
		return max(arr, 0, arr.length - 1);
	}

	// 核心代码：递归调用max()
	public static int max(final int[] arr, int leftIndex, int rightIndex) {
		System.out.println("leftIndex:  " + leftIndex + ",   rightIndex: " + rightIndex);
		int sum = 0, leftHalfMax = 0, rightHalfMax = 0;
		if (rightIndex - leftIndex == 0) {
			return arr[rightIndex];
		} else {
			int center = (leftIndex + rightIndex) / 2;// 2分查找中间节点
			int maxLeft = max(arr, leftIndex, center);// 左边最大的
			int maxRight = max(arr, center + 1, rightIndex);// 右边最大的
			
			for (int i = center; i >= leftIndex; --i) {
				sum += arr[i];
				if (sum > leftHalfMax) {
					leftHalfMax = sum;
				}
			}
			sum = 0;
			for (int i = center + 1; i <= rightIndex; ++i) {
				sum += arr[i];
				if (sum > rightHalfMax) {
					rightHalfMax = sum;
				}
			}
			return max(maxLeft, maxRight, leftHalfMax + rightHalfMax);
		}
	}

	// 三者取最大值
	public static int max(int a, int b, int c) {
		return a > b ? (a > c ? a : c) : (b > c ? b : c);
	}
}