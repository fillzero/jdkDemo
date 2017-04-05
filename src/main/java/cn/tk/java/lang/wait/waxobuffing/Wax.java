package cn.tk.java.lang.wait.waxobuffing;

import java.util.concurrent.TimeUnit;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/4
* @description: 
*
**/
public class Wax implements Runnable {

    private Car car;

    public Wax(Car car) {
        this.car = car;
    }

    /*
    * @description: 打蜡操作 --> 唤醒抛光
    */
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForBuffing();
                System.out.println("ThreadId: " + Thread.currentThread().getId() + ": Waxing!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt!");
        }
        System.out.println("Ending Waxing! Begin Buffing!");
    }
}
