package cn.tk.java.algorithm;

import org.junit.Test;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/9/6
 * Description: 简单递归算法
 */
public class Recurse {
    /**
     * Description：高斯求和公式，计算 1...100 的和
     *
     * 结束条件：num == 0
     * 转移条件：--num
     * 递归：sum += num
     */
    public int gauss(int sum, int num)
    {
        if (num == 0)
            return sum;

        sum += num;
        return gauss(sum, --num);
    }

    @Test
    public void testGauss()
    {
        int sum = gauss(0, 100);
        System.out.println(sum);
    }
}
