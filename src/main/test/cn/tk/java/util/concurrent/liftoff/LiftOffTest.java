package cn.tk.java.util.concurrent.liftoff;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/2/25 0025.
 * 注：Executor 执行器，用于在客户端和任务之间建立一个中间层，帮助客户端更好的完成任务。
 */
public class LiftOffTest {
    /*
    * @description: 一个线程
    */
    @Test
    public void testLiftOff() throws Exception {
        LiftOff launch = new LiftOff();
        launch.run();
    }

    /*
    * @description: 多个线程
    */
    @Test
    public void testLiftOffThreads()
    {
        for (int i=0; i<5; i++)
        {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff!");
    }

    /*
    * @description: 线程池
    */
    @Test
    public void testCachedThreadPool()
    {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i<5; i++)
            executorService.execute(new LiftOff());
        executorService.shutdown();
    }

    /*
    * @description: 固定大小的线程池
    */
    @Test
    public void testFixedThreadPool()
    {
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }

    /*
    * @description: 类似于单线程执行，一个任务执行完之后执行另一个任务，序列化任务
    */
    @Test
    public void testSingleThreadExecutor()
    {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}