package cn.tk.java.algorithm.leetcode.bit;

/**
 * @Author: lijl85
 * @Title: ConvertToHex.java
 * @Package: cn.tk.java.algorithm.leetcode.bit
 * @Time: 2016年11月3日上午10:00:28
 *
 * @description: 整数转换成 16进制， 负数使用补码
 * Given an integer, write an algorithm to convert it to hexadecimal. 
 * For negative integer, two’s complement method is used.
 * 
 * 1、 转换后的十六进制字符串字母必须转成小写（a-f）
 * 2、  如果是数字 0，用一个字符 '0' 来替代，否则，十六进制字符串的第一个字符不能是 '0'
 * 3、 入参整数必须是 32位以内的带符号整数。
 * 4、 不能直接使用第三方工具包内方法进行转换
 */
public class ConvertToHex {
	public String toHex(int num) {
        return "0";
    }
}
