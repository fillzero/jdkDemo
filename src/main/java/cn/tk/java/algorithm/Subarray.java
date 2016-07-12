package cn.tk.java.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:最大子数组的基本属性
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subarray {
	private int left;
	private int right;
	private int sum;
}
