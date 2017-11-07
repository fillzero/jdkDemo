package cn.tk.java.concurrent;

import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/11/7
 * Description:
 */
public class FutureCallable {

    ThreadPoolExecutor taskExecutor = new ThreadPoolExecutor(2, 3, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));

    @Test
    public void testFuture() throws ExecutionException, InterruptedException {
        for (int i=0; i<3; i++) {
            Future<Boolean> future = taskExecutor.submit(new DemoCallable());
            Boolean result = future.get();
            System.out.println(result);
        }
    }

    public class DemoCallable implements Callable {
        @Override
        public Boolean call() throws Exception {
            long threadId = Thread.currentThread().getId();
            System.out.println("CurrentThreadID: " + threadId);
            Thread.sleep(5000);
            return threadId % 2 == 0 ? true : false;
        }
    }
}
