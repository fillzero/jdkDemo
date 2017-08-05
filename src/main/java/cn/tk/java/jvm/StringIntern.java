package cn.tk.java.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/8/4
 * Description:
 */
public class StringIntern {
    /**
     * Description:
     * jdk 1.7 之前 HotSpot 的方法区被设置为永久代，intern 方法会把对应的字符串实例复制到永久代一份儿，作为运行时常量
     * jdk 1.7 开始，方法区被拿出来，并且 intern 方法只会把一个引用放到常量池里面
     * new StringBuffer() 返回来的变量存放在堆上
     * 至于字符串 "java" 是原生放在永久代上的，所以返回 false.
     *
     * jdk 1.7 之前，不停的执行 str.intern 会导致方法区内存溢出。
     */
    @Test
    public void testStrIntern() {
        String str1 = new StringBuffer("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

    /**
     * Description：方法区主要存放 Class 的相关信息：类名、访问修饰符、常量池、字段描述、方法描述
     *
     * 所以很多字节码技术比如 Cglib 会不断的产生代理类，可能会导致方法区的溢出
     *
     * 实验方案：使用 Cglib 不断创建新的类
     *
     * 结果：最后永久代设置成 100k，仍然没有出现方法区内存溢出，怀疑 jdk1.8 做了这方面的优化
     *
     * -XX:PermSize=10M -XX:MaxPermSize=10M
     */
    @Test
    public void testMethodAreaOOM(){
        while (true){
            // 增强对象
            Enhancer enhancer = new Enhancer();

            // 设置继承类
            enhancer.setSuperclass(OOMObject.class);

            // 是否设置缓存
            enhancer.setUseCache(false);

            // 引入增强
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(object, args);
                }
            });

            // 创建增强类
            enhancer.create();
        }
    }

    static class OOMObject{

    }
}
