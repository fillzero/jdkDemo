package cn.tk.java.jvm;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/8/5
 * Description:
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    /**
     * Description：测试直接内存区 OutOfMemoryError
     *
     * -XX:+PrintGCDetails
     *
     * 打印堆栈信息，发现堆栈信息一切正常
     */
    @Test
    public void testDirectMemoryOOM() throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true)
        {
            unsafe.allocateMemory(_1MB);
        }
    }
}
