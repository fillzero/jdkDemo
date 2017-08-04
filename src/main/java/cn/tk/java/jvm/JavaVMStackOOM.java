package cn.tk.java.jvm;

import org.junit.Test;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/8/4
 * Description:
 */
public class JavaVMStackOOM {

    private void dontStop()
    {
        while (true)
        {

        }
    }

    /**
     * Description：不停的创建线程但是不释放: 每个线程都要分配栈空间，不断的创建新线程会榨干内存，导致 OutOfMemoryError
     * -Xss2M
     */
    public void stackLeakByThread()
    {
        while (true)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            }).start();
    }

    @Test
    public void testOOM()
    {
        stackLeakByThread();
    }
}
