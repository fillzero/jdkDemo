package cn.tk.java.util.concurrent.liftoff;

import java.util.concurrent.TimeUnit;

/*
*@date: 2017/3/4 0004
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 主线程突然结束，守护线程也会立即结束，不会执行内部 finally 块
*/
public class ADaemon implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("starting daemon thread!");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }finally {
            System.out.println("This should always run?");
        }
    }
}
