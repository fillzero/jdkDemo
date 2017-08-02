package cn.tk.java.concurrent;

import cn.tk.java.designPattern.singleton.SingletonSynchronized;
import lombok.SneakyThrows;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/7/31
 * Description: 多线程执行的过程中使用 CountDownLatch 锁存器防止主线程提前执行结束
 */
public class SingletonInstanceTest extends Thread {

//    private static volatile int counter = 0;

    public static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();

    private static final int THREAD_COUNT = 1000;

    private static CountDownLatch doneSignal = null;

    private SingletonInstanceTest(CountDownLatch doneSignal)
    {
        this.doneSignal = doneSignal;
    }


    public static void main(String args[]) throws InterruptedException {
        execute();
//        System.out.println(counter);
        System.out.println(map.size());
        doneSignal.await();
    }

    /**
     * Description：依次启动 1000 个线程去获取单例
     */
    public static void execute() throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(new SingletonInstanceTest(doneSignal)).start();
        }
    }

    /**
     * Description：每个线程尝试去获取单实例
     */
    @Override
    @SneakyThrows
    public void run() {
//        counter ++;
        SingletonSynchronized instance = SingletonSynchronized.getInstance();
        map.put(getAddress(instance), "whatever");
        doneSignal.countDown();
    }

    /**
     * Description：获取 16 进制对象的存储位置，用于判断是否同一个对象
     */
    public String getAddress(Object instance) {
        String fullAddress = instance.toString();
        String address = fullAddress.substring(fullAddress.indexOf("@") + 1);
        return address;
    }
}
