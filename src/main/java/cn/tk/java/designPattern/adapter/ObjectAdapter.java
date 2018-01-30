package cn.tk.java.designPattern.adapter;

import org.junit.Test;

/*
 *@date: 2018/1/28 0028
 *@author: lijl85
 *@mail: ljldeepinit@163.com
 *@description: 通过聚合对象的形式实现适配
 */
public class ObjectAdapter {
    public interface TargetInterface{
        void method1();
        void method2();
    }

    class BeAdapted
    {
        public void method1(){
            System.out.println("method1");
        }
    }

    class Adapter implements TargetInterface{

        private BeAdapted adapted;

        public Adapter(BeAdapted adapted)
        {
            this.adapted = adapted;
        }

        @Override
        public void method1() {
            this.adapted.method1();
        }

        @Override
        public void method2() {
            System.out.println("method2");
        }
    }

    @Test
    public void testObjectAdapter()
    {
        BeAdapted adapted = new BeAdapted();
        Adapter adapter = new Adapter(adapted);
        adapter.method1();
        adapter.method2();
    }
}
