package cn.tk.java.designPattern.singleton;

import org.junit.Test;
import org.junit.internal.Classes;

import java.lang.reflect.Constructor;

/**
 * Created by Administrator on 2017/2/16.
 */
public class SingletonInnerClassTest {
    @Test
    public void getInstance() throws Exception {
        final SingletonInnerClass instance = SingletonInnerClass.getInstance();
        instance.doSomething();

        final Class<SingletonInnerClass> singletonInnerClassClass = SingletonInnerClass.class;
        final Constructor<SingletonInnerClass> constructor = singletonInnerClassClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        final SingletonInnerClass instance1 = singletonInnerClassClass.newInstance();
        instance1.doSomething();
    }

}