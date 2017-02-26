package cn.tk.java.designPattern.singleton;

/*
*@date: 2017/2/16
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 内部类实现单实例
*/
public class SingletonInnerClass {
    private static boolean flag = false;

    private SingletonInnerClass(){
        synchronized (SingletonInnerClass.class)
        {
            if (!flag)
                flag = !flag;
            else
                throw new RuntimeException("单实例被侵犯!");
        }
    }

    private static class SingletonHolder
    {
        private static final SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    public void doSomething()
    {
        System.out.println("Do SomeThing!");
    }
}
