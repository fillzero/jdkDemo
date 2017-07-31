package cn.tk.java.designPattern.singleton;

/*
*@date: 2017/2/16
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 懒汉模式, synchronized 同步代码块, 只锁住一个代码块, 不像 SingletonLazy 锁住整个方法
* 懒汉模式双重同步锁, 锁的粒度变小
*/
public class SingletonSynchronized {
    private static volatile SingletonSynchronized INSTANCE;

    private SingletonSynchronized(){

    }

    /*
    * @description: 双重锁, 两个线程同时进入 第一个 INSTANCE == null, A 拿到锁, 创建一个实例, B 没有拿到锁, 如果没有第二个
    * INSTANCE == null, B 等 A 走后拿到锁也可以创建一个实例, 相当于可以创建两个实例
    */
    public static SingletonSynchronized getInstance()
    {
        if (INSTANCE == null){
            synchronized (SingletonSynchronized.class){
                if (INSTANCE == null)
                    INSTANCE = new SingletonSynchronized();
            }
        }
        return INSTANCE;
    }
}
