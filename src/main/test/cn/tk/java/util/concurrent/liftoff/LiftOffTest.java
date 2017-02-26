package cn.tk.java.util.concurrent.liftoff;

import org.junit.Test;

/**
 * Created by Administrator on 2017/2/25 0025.
 */
public class LiftOffTest {
    /*
    * @description: 一个线程
    */
    @Test
    public void testLiftOff() throws Exception {
        LiftOff launch = new LiftOff();
        launch.run();
    }

    /*
    * @description: 多个线程
    */
    @Test
    public void testLiftOffThreads()
    {
        for (int i=0; i<5; i++)
        {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff!");
    }
}