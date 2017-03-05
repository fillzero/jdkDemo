package cn.tk.java.util.concurrent.liftoff;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/3/4 0004.
 */
public class SimpleDaemonsTest {
    /*
    * @description: 主线程的休眠的时间设置的大于守护线程的休眠时间，可以看到守护线程的执行
    * 显式创建多个守护线程去主笔性守护线程任务
    */
    @Test
    public void testSimpleDaemon() throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.SECONDS.sleep(3);
    }
}