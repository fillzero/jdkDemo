package cn.tk.java.util.concurrent.liftoff;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/3/4 0004.
 */
public class ADaemonTest {

    /*
    * @description: 主线程迅速执行完毕，守护线程也立即中断，不再去执行 finally 块
    */
    @Test
    public void testDaemonThread() throws Exception {
        Thread thread = new Thread(new ADaemon());
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(2);
    }

}