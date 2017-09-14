package cn.tk.java.algorithm.leetcode.array.zigzag;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/9/14
 * Description:
 */
public class ZigZag {

    /**
     * Description：字符串折叠成躺着的 Z 字形
     * @param s 需要折叠的字符串
     * @param nums 要折叠的层数
     */
    public String convert(String s, int nums)
    {
        if (s == null || s.isEmpty()) {
            return s;
        }

        int length = s.length();
        if (length <= nums || nums == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int step = 2 * (nums - 1);
        int count = 0;

        for (int i = 0; i < nums; i++){
            int interval = step - 2 * i;

            for (int j = i; j < length; j += step){
                sb.append(s.charAt(j));
                count++;
                if (interval > 0 && interval < step
                        && j + interval < length
                        && count <  length) {
                    sb.append(s.charAt(j + interval));
                    count++;
                }
            }
        }
        return sb.toString();
    }
}
