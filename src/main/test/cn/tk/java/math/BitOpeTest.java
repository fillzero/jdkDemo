package cn.tk.java.math;

/*
*@date: 2017/8/27 0027
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 位运算性能超过基本运算 3 ~ 5 倍，不同机器会有所不同
*/
public class BitOpeTest {
    public static void main(String[] args) {
        int j = 10;
        final long start = System.currentTimeMillis();
        for (int i=0; i<100000000; i++)
        {
            if (i % 2 == 0)
            {
                for (int k=0; k<10; k++)
                {
                    j *= 2;
                }
            } else {
                for (int k=0; k<10; k++)
                {
                    j /= 2;
                }
            }
        }
        final long end = System.currentTimeMillis();
        System.out.println("Basic Operate: " + (end - start) + "ms");


        final long start1 = System.currentTimeMillis();
        for (int i=0; i<100000000; i++)
        {
            if (i % 2 == 0)
            {
                for (int k=0; k<10; k++)
                {
                    j = j >> 1;
                }
            } else {
                for (int k=0; k<10; k++)
                {
                    j = j << 1;
                }
            }
        }
        final long end2 = System.currentTimeMillis();
        System.out.println("Bit Operate: " + (end2 - start1) + "ms");

    }
}
