package cn.tk.java.designPattern.singleton;

/*
*@date: 2017/2/16
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 枚举实现单例模式
* 1. 线程安全
* 2. 防序列化: 不会因为序列化而产生新实例
* 3. 防止反射攻击
*/
public enum SingletonEnum {
    INSTANCE{
        @Override
        protected void read()
        {
            System.out.println("read");
        }

        @Override
        protected void write()
        {
            System.out.println("write");
        }
    };

    protected abstract void read();
    protected abstract void write();
}
