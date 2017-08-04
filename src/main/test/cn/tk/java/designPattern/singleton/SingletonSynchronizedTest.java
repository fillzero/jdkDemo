package cn.tk.java.designPattern.singleton;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by lijinlong3 on 2017/8/4.
 */
public class SingletonSynchronizedTest {
    @SneakyThrows
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (int i=0; i<10; i++){
            new Thread(new Worker()).start();
        }

        TimeUnit.SECONDS.sleep(100);
    }

    public static class Worker implements Runnable {
        @Override
        @SneakyThrows
        public void run() {
            printInstance();
        }
    }

    private static void printInstance() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = Class.forName("cn.tk.java.designPattern.singleton.SingletonSynchronized");
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonSynchronized instance = (SingletonSynchronized) constructor.newInstance();
        System.out.println(instance);
    }
}