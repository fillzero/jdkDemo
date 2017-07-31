package cn.tk.java.designPattern.singleton;

/*
*@date: 2017/2/16
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 懒汉模式, 需要的时候才去创建实例: 延时加载
*/
public class SingletonLazy {
    private static volatile SingletonLazy INSTANCE;

    private SingletonLazy(){

    }

    /*
    * @description: synchronized 同步锁保证线程安全
    */
    public static synchronized SingletonLazy getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new SingletonLazy();
        return INSTANCE;
    }
}
