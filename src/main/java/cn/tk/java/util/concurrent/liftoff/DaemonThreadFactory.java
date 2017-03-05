package cn.tk.java.util.concurrent.liftoff;

import java.util.concurrent.ThreadFactory;

/*
*@date: 2017/3/4 0004
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 守护线程工厂，传入任务生成相应的守护线程
*/
public class DaemonThreadFactory implements ThreadFactory {

    /*
    * @description: 根据任务创建可执行线程，生成一个守护线程工厂
    */
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
