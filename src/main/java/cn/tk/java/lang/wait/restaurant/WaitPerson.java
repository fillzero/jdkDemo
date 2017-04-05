package cn.tk.java.lang.wait.restaurant;

import java.util.concurrent.TimeUnit;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/4
* @description: 服务员
* 如果没有肉 --> wait()
* 如果有肉 --> 使用肉 --> notify() 通知厨师继续生产
**/
public class WaitPerson implements Runnable {

    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                synchronized (this){
                    while (restaurant.meal == null)
                        wait();
                }

                System.out.println("WaitPerson get: " + restaurant.meal);

                synchronized (restaurant.chef)
                {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
            } catch (InterruptedException e) {
                System.out.println("服务员下班了！");
            }
        }

    }
}
