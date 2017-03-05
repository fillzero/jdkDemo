package cn.tk.java.util.concurrent.liftoff;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/*
*@date: 2017/3/4 0004
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 守护线程（后台线程）
*/
public class SimpleDaemons implements Runnable {

    @Override
    @SneakyThrows
    public void run() {
        try {
            while (true){
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getId());
            }
        } catch (InterruptedException e){
            System.out.println("sleep() interrupted");
        }
    }
}
