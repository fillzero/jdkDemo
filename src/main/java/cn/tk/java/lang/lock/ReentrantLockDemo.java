package cn.tk.java.lang.lock;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* @date: 2017/2/14
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description: 可重入锁, Lock 接口的唯一实现类
* Lock 类: 四种获取锁方式
*   lock()
*   tryLock()
*   tryLock(long time, TimeUnit unit)
*   lockInterruptibly
*
*   unlock
*/
@SuppressWarnings("Duplicates")
public class ReentrantLockDemo {
    private List<Integer> resource = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock();

    /*
    * @description: 插入操作, 使用 lock()
    */
    public void insertWithLock(Thread thread)
    {
        lock.lock();//获取锁
        try{
            //获取使用共享资源
            System.out.println(thread.getName() + " acquire the lock!");
            for (int i = 0; i < 5; i++) {
                resource.add(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println(thread.getName() + " release the lock!");
            lock.unlock();//释放锁
        }
    }

    /*
   * @description: 插入操作, 使用 tryLock
   */
    public void insertWithTryLock(Thread thread)
    {
        if (lock.tryLock()) //尝试获取锁
        {
            try{
                //获取使用共享资源
                System.out.println(thread.getName() + " acquire the lock!");
                for (int i = 0; i < 5; i++) {
                    resource.add(i);
                }
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                System.out.println(thread.getName() + " release the lock!");
                lock.unlock();//释放锁
            }
        }else{
            System.out.println(thread.getName() + " failed to get lock!");
        }
    }

    /*
    * @description: 插入操作, 使用 tryLock + timeout, 不立即返回尝试获取锁结果, 导致很多线程获取不到锁, 无法使用资源
    */
    @SneakyThrows
    public void insertWithTryLockAndTimeout(Thread thread)
    {
        if (lock.tryLock(10, TimeUnit.SECONDS)) //尝试获取锁
        {
            try{
                //获取使用共享资源
                System.out.println(thread.getName() + " acquire the lock!");
                for (int i = 0; i < 5; i++) {
                    resource.add(i);
                }
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                System.out.println(thread.getName() + " release the lock!");
                lock.unlock();//释放锁
            }
        }else{
            System.out.println(thread.getName() + " failed to get lock!");
        }
    }

    /*
    * @description: 插入操作, 使用 lockInterruptibly 获取锁, 阻塞进程可以适时中断
    */
    @SneakyThrows
    public void insertWithInterruptibly(Thread thread)
    {
        lock.lockInterruptibly();
        try {
            System.out.println(thread.getName() + " acquire the lock!");
            long startTime = System.currentTimeMillis();
            // 一个线程获取锁, 长时间不释放
            for(    ;     ;) {
                if(System.currentTimeMillis() - startTime >= Integer.MAX_VALUE)
                    break;
                //插入数据
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName()+"执行finally");
            lock.unlock();
            System.out.println(thread.getName() + " release the lock!");
        }
    }
}