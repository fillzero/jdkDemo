package cn.tk.java.jvm;

import org.junit.Test;

/*
*@date: 2017/8/13 0013
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 内存分配策略测试
*
* -XX:+PrintGCDetails （打印 GC 详细信息）
* -XX:SurvivorRatio=8 （eden:survivor = 8:1）
* -Xms20M JVM 初始内存
* -Xmx20M JVM 最大可用内存：新生代 + 老年代
* -Xmn10M 新生代内存
*/
public class AllocationTest {

    private static final int _1M = 1025 * 1024;

    @Test
    public void testAllocation()
    {
        byte[] obj1, obj2, obj3, obj4;
        obj1 = new byte[2 * _1M];
        obj2 = new byte[2 * _1M];
        obj3 = new byte[2 * _1M];
        obj4 = new byte[4 * _1M]; // 出现一次 Minor GC
    }
}
