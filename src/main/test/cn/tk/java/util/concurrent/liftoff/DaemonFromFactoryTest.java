package cn.tk.java.util.concurrent.liftoff;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/3/4 0004.
 */
public class DaemonFromFactoryTest {
    /*
    * @description: 主线程，并且启动多个守护线程
    * 使用线程池创建多个守护线程去执行守护线程任务
    *
    * 普通线程的创建
    * Thread thread = new Thread(Runnable r)
    *
    * 守护线程的创建
    * Thread daemon = new Thread(Runnable r);
    * daemon.setDaemon(true);
    */
    @Test
    public void testDaemonThreadFactory() throws Exception {
        //1. 生成守护线程线程池（使用工厂指定守护线程生成规则）
        final ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());

        //2. 执行守护线程对应的任务
        for (int i = 0; i < 10; i++) {
            executorService.execute(new DaemonFromFactory());
        }

        System.out.println("All daemon thread start!");
        TimeUnit.SECONDS.sleep(2);
    }
}