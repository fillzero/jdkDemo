package cn.tk.java.util.concurrent.liftoff;

import lombok.SneakyThrows;

/*
*@date: 2017/2/25 0025
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 显式的管理线程
*/
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int threadId = taskCount++;

    public LiftOff(){

    }

    public String status()
    {
        return "#" + Thread.currentThread().getId() + "(" + (countDown > 0 ? countDown : "LiftOff!" ) + ")";
    }

    @Override
    @SneakyThrows
    public void run() {
        while (countDown-- > 0){
            System.out.println(status());
            Thread.yield();
        }
    }
}
