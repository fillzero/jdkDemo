package cn.tk.java.util.concurrent.liftoff;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/*
*@date: 2017/3/4 0004
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 守护线程要执行的任务
*/
public class DaemonFromFactory implements Runnable {

    @Override
    @SneakyThrows
    public void run() {
        while (true){
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getId());
        }
    }
}
