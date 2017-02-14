package cn.tk.java.lang.lock;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lijl85 on 2017/2/14.
 */
public class ReentrantReadWriteLockDemoTest {
    /*
    * @description: 建立多个线程执行读操作, synchronized 实现读锁, 阻塞型同步, 多个进程无法同时获取读锁
    */
    @Test
    public void readWithSynchronized() throws Exception {
        ReentrantReadWriteLockDemo threadDemo = new ReentrantReadWriteLockDemo();
        for (int i=0; i<2; i++)
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadDemo.readWithSynchronized(Thread.currentThread());
                }
            }).start();
        }
    }

    /*
    * @description: 使用读写锁, 多个线程可以同时执行读操作, 交替获取读锁
    */
    @Test
    public void readWithReadAndWriteLock() throws Exception {
        ReentrantReadWriteLockDemo threadDemo = new ReentrantReadWriteLockDemo();
        for (int i=0; i<2; i++)
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadDemo.readWithReadAndWriteLock(Thread.currentThread());
                }
            }).start();
        }
    }
}