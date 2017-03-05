package cn.tk.java.util.concurrent.liftoff;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/3/4 0004.
 */
public class TaskWithResultTest {

    /*
    * @description: 获取多线程返回结果，结果存在 Future 中，结果类型是 String（泛型）
    * 结果返回之后才可以调用 get()，会一直阻塞，使用 isDone() 方法可以判断任务是否执行完毕
    */
    @Test
    public void testCallable() throws Exception {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : results)
        {
            try{
                System.out.println(fs.get());
            }catch (InterruptedException e){
                System.out.println(e);
                return;
            }catch (ExecutionException e){
                System.out.println(e);
                return;
            }finally {
                executorService.shutdown();
            }
        }
    }

}