package cn.tk.java.lang.wait.restaurant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/4
* @description: 餐馆
*
**/
public class Restaurant {
    Meal meal;
    ExecutorService executorService = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);

    public Restaurant() {
        executorService.execute(waitPerson);
        executorService.execute(chef);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
