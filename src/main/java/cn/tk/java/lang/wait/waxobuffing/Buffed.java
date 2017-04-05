package cn.tk.java.lang.wait.waxobuffing;

import java.util.concurrent.TimeUnit;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/4
* @description: 抛光类：抛光完成，唤醒打蜡
**/
public class Buffed implements Runnable{
    private Car car;

    public Buffed(Car car) {
        this.car = car;
    }

    /*
    * @description: 抛光 --> 用时 200ms --> 唤醒打蜡
    */
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("ThreadId: " + Thread.currentThread().getId() + ": Buffing!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }catch (InterruptedException e) {
            System.out.println("Exiting via interrupted!");
        }
        System.out.println("Ending buffed! Begin Waxing!");//结束抛光，开始打蜡
    }
}
