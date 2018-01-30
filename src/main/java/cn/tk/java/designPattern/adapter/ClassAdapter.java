package cn.tk.java.designPattern.adapter;

import org.junit.Test;

/*
 *@date: 2018/1/28 0028
 *@author: lijl85
 *@mail: ljldeepinit@163.com
 *@description: 通过继承父类，实现接口的方式，将一个接口和一个实现类进行汇总，对外适配
 */
public class ClassAdapter {
    public interface TargetInterface {
        void method1();
        void method2();
    }

    class BeAdapted{
        public void method1(){
            System.out.println("method1");
        }
    }

    class Adapter extends BeAdapted implements TargetInterface {
        @Override
        public void method2() {
            System.out.println("method2");
        }
    }

    @Test
    public void testClassAdapter()
    {
        Adapter adapter = new Adapter();
        adapter.method1();
        adapter.method2();
    }
}
