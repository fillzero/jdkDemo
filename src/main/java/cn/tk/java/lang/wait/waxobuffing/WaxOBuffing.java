package cn.tk.java.lang.wait.waxobuffing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/4
* @description: 汽车抛光涂蜡行为模拟
*
* 涂蜡 --> 抛光 --> 涂蜡（第二层）
* 抛光打蜡：互相等待（等待条件就是对方的唤醒条件），互相唤醒
**/
public class WaxOBuffing {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Wax(car));
        executorService.execute(new Buffed(car));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}
