package cn.tk.java.concurrent.atomic;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/9/25
 * Description: 使用 atomic 包测试线程安全
 */
public class ThreadSafety {
    AtomicInteger counter = new AtomicInteger();

    private final int EXECUTE_COUNT = 10000;

    //core， max，keepAliveTime（任务少了以后大于 core 的要释放）, unit, workQueue（超过core之后排队）
    ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 10, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

    public void incr()
    {
        counter.getAndIncrement();
    }

    @Test
    @SneakyThrows
    public void testAtomicIncr()
    {
        for (int i=0; i<EXECUTE_COUNT; i++)
        {
            executor.execute(() -> incr());
        }
        TimeUnit.SECONDS.sleep(10);
        System.out.println(counter);
    }
}
