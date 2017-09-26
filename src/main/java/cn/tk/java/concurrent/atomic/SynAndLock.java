package cn.tk.java.concurrent.atomic;

import lombok.SneakyThrows;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/9/25
 * Description: 对比 Synchronized 和 ReentrantLock 相对吞吐率
 */
public class SynAndLock {
    private static int counter = 0;

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 10, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

    public synchronized void synIncr()
    {
        counter ++;
    }

    public void lockIncr()
    {
        Lock lock = new ReentrantLock();
        try{
            lock.lock();
            counter ++;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Description：测试同步吞吐率, 10s钟看能跑到多少
     */
    @Test
    @SneakyThrows
    public void testSynThroughout()
    {
        Date start = new Date();
        Date end = DateUtils.addSeconds(start, 10);

        // syn
        while (true) {
            Date now = new Date();
            if (now.after(end)) {
                break;
            }
            threadPoolExecutor.execute(() -> synIncr());
        }

        System.out.println("counter: "+ counter);
    }

    /**
     * Description：测试锁的吞吐率, 10s钟看能跑到多少
     */
    @Test
    @SneakyThrows
    public void testLockThroughout()
    {
        Date start = new Date();
        Date end = DateUtils.addSeconds(start, 10);

        // lock
        while (true) {
            Date now = new Date();
            if (now.after(end)) {
                break;
            }
            threadPoolExecutor.execute(() -> lockIncr());
        }

        System.out.println("counter: "+ counter);
    }
}
