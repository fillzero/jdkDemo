package cn.tk.java.designPattern.singleton;

/*
*@date: 2017/2/16
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 饿汉模式, 上来就创建
* 1. 私有构造器
* 2. public 方法返回内部 static 实例
*/
public class SingletonHungry {
    private static SingletonHungry INSTANCE = new SingletonHungry();

    private SingletonHungry(){

    }

    public SingletonHungry getInstance()
    {
        return SingletonHungry.INSTANCE;
    }
}
