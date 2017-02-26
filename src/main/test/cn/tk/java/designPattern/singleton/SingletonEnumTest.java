package cn.tk.java.designPattern.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * Created by Administrator on 2017/2/16.
 */
public class SingletonEnumTest {
    @Test
    public void read() throws Exception {
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        singletonEnum.read();
    }

    @Test
    public void write() throws Exception {
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        singletonEnum.write();
    }

    /*
    * @description: 通过反射攻击单实例
    * 目标: 获取私有构造器, 执行 newInstance()
    */
    @Test
    public void testSecurity() throws NoSuchMethodException, IllegalAccessException, InstantiationException {
        final SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        singletonEnum1.read();

        final Class<SingletonEnum> singletonClass = SingletonEnum.class;
        final Constructor<SingletonEnum> constructor = singletonClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        singletonClass.newInstance();
    }
}