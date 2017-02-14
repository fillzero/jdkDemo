package cn.tk.java.lang.lock;

import org.junit.Test;

/*
* @date: 2017/2/14
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description:
* 
*/
public class ReentrantLockDemoTest {
    /*
  * @description: lock() 方式获取锁单元测试
  */
    @Test
    public void testLock()
    {
        ReentrantLockDemo threadDemo = new ReentrantLockDemo();

        for (int i=0; i<10; i++)
        {
            // Thread 本身也是 Runnable, 可以重写 Runnable 方法
            new Thread(){
                @Override
                public void run()
                {
                    threadDemo.insertWithLock(Thread.currentThread());
                }
            }.start();
        }
    }

    /*
    * @description: tryLock() 方式获取锁单元测试
    */
    @Test
    public void testTryLock()
    {
        ReentrantLockDemo threadDemo = new ReentrantLockDemo();

        for (int i=0; i<10; i++)
        {
            // 可以不用 Runnable, 也可以使用 Runnable 装载需要线程执行的任务
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadDemo.insertWithTryLock(Thread.currentThread());
                }
            }).start();
        }
    }

    /*
   * @description: tryLock(long time, TimeUnit unit) 方式获取锁单元测试
   */
    @Test
    public void testTryLockAndTimeout()
    {
        ReentrantLockDemo threadDemo = new ReentrantLockDemo();

        for (int i=0; i<10; i++)
        {
            // 可以不用 Runnable, 也可以使用 Runnable 装载需要线程执行的任务
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadDemo.insertWithTryLockAndTimeout(Thread.currentThread());
                }
            }).start();
        }
    }

    /*
    * @description: 测试
    */
    @Test
    public void testLockInterruptibly()
    {
        ReentrantLockDemo threadDemo = new ReentrantLockDemo();

        //aThread 获取锁后长期占用, bThread 等待两秒之后自行中断, bThread 是可中断的, 因为使用 lockInterruptibly 方式获取锁
        Thread aThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    threadDemo.insertWithInterruptibly(Thread.currentThread());
                }catch (Exception e)
                {
                    System.out.println(Thread.currentThread().getName() + " is interrupted!");
                }
            }
        });

        Thread bThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    threadDemo.insertWithInterruptibly(Thread.currentThread());
                }catch (Exception e)
                {
                    System.out.println(Thread.currentThread().getName() + " is interrupted!");
                }
            }
        });
        aThread.start();
        bThread.start();

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        bThread.interrupt();//bThread 阻塞两秒后直接中断, 不再进行等待
    }
}
