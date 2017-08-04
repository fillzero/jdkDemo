package cn.tk.java.concurrent;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/8/4
 * Description: 添加两个锁存器控制多线程执行任务，开始锁存器让出现并发的可能性变大。
 */
public class CountDownLatchDemo {
    private static int counter = 0;

    public static final int THREAD_COUNT = 100000;

    public static CountDownLatch startSignal = new CountDownLatch(1);

    public static CountDownLatch doneSignal = new CountDownLatch(THREAD_COUNT);

    private ReentrantLock lock = new ReentrantLock();

    @Test
    @SneakyThrows
    public void multiThreadTest()
    {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 10, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        for (int i=0; i<THREAD_COUNT; i++) {
            threadPoolExecutor.execute(new Worker(startSignal, doneSignal));
        }

        doSomeThingBeforeStart();
        startSignal.countDown();
        doneSignal.await();
        doSomeThingAfterDone();
    }

    @SneakyThrows
    private void doSomeThingBeforeStart() {
        System.out.println("所有线程准备就绪！GO!");
        TimeUnit.SECONDS.sleep(1);
    }

    private void doSomeThingAfterDone() {
        System.out.println("所有线程都执行完毕了！DONE!");
        System.out.println("最后的 counter 值：" + counter);
    }

    private class Worker implements Runnable {

        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        private Worker(CountDownLatch startSignal, CountDownLatch doneSignal){
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        @Override
        @SneakyThrows
        public void run() {
            startSignal.await();
            lock.lock();
            try{
                counter ++;
            }finally {
                lock.unlock();
            }
            doneSignal.countDown();
        }
    }
}
