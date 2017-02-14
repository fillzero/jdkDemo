package cn.tk.java.lang.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
* @date: 2017/2/14
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description: 读写锁
* 
*/
public class ReentrantReadWriteLockDemo {

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    /*
    * @description: 使用 synchronized 关键字实现读锁
    */
    public synchronized void readWithSynchronized(Thread thread)
    {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 1)
        {
            System.out.println(thread.getName() + " is reading!");
        }
        System.out.println(thread.getName() + " has read successfully!");
    }

    /*
    * @description: 使用读写锁实现
    * ReadLock, WriteLock 是 ReentrantReadWriteLock 内置两个内部类 ReadLock 和 WriteLock, 两个类分别实现 Lock 接口
    */
    public void readWithReadAndWriteLock(Thread thread)
    {
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();

            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + " is reading!");
            }
            System.out.println(thread.getName() + " has read successfully!");
        } finally {
            rwl.readLock().unlock();
        }
    }
}
