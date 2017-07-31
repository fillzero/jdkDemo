package cn.tk.java.concurrent;

import cn.tk.java.designPattern.singleton.SingletonEnum;
import lombok.SneakyThrows;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/7/31
 * Description:
 */
public class SingletonInstanceTest extends Thread {

//    private static volatile int a = 0;
    public static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();


    public static void main(String args[]) throws InterruptedException {
        execute();
        System.out.println(map.size());
//        System.out.println(a);
    }

    /**
     * Description：依次启动 10000 个线程
     */
    public static void execute() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(new SingletonInstanceTest()).start();
        }
        TimeUnit.SECONDS.sleep(2);
    }

    /**
     * Description：每个线程尝试去获取单实例
     */
    @Override
    @SneakyThrows
    public void run() {
        for (int i = 0; i < 1000; i++) {
//            a ++;
        }
        SingletonEnum instance = SingletonEnum.INSTANCE;
        map.put(getInstance(instance), "1");
    }

    /**
     * Description：获取 16 进制对象
     */
    public String getInstance(Object instance) {
        String address = instance.toString();
        String substring = address.substring(address.indexOf("@") + 1);
        return substring;
    }
}
