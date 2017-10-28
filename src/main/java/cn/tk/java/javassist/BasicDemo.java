package cn.tk.java.javassist;

import javassist.*;
import lombok.SneakyThrows;
import org.junit.Test;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/10/28
 * Description:
 */
public class BasicDemo {
    /**
     * Description：读写字节码
     * 获取类：CtClass（compile-time class）
     * 一个 CtClass 对象，映射一个 class 文件
     */
    @Test
    @SneakyThrows
    public void testJavassist() {
        // 获取 CtClass 对象池
        ClassPool classPool = ClassPool.getDefault();
        new ClassPool();
        CtClass rectangleClass = classPool.get("cn.tk.java.javassist.Rectangle");
        CtClass pointClass = classPool.get("cn.tk.java.javassist.Point");

        // 改变类继承关系
        rectangleClass.setSuperclass(pointClass);

        // 将修改后的类写入 class 文件
        rectangleClass.writeFile();

        // 生成字节码
        byte[] bytecode = rectangleClass.toBytecode();

        // 获取反射 Class
        Class clazz = rectangleClass.toClass();
    }

    /**
     * Description：定义一个新的 CtClass
     */
    @Test
    @SneakyThrows
    public void testDefiningNewClass()
    {
        ClassPool classPool = ClassPool.getDefault();
        CtClass triangleClass = classPool.makeClass("cn.tk.java.javassist.Triangle");
        System.out.println(triangleClass.getSuperclass().getName());
    }

    /**
     * Description：class 文件封冻解冻
     * 当执行了 writeFile、toClass、toBytecode 以后，类文件就被封冻了，如果想要继续修改，需要调用 defrost() 方法
     * 因为 JVM 不允许程序员修改已经被加载了类
     */
    @Test
    @SneakyThrows
    public void testFrozenClass()
    {
        // 获取 CtClass 对象池
        ClassPool ctClassPool = ClassPool.getDefault();

        // 获取 Rectangle 类对象
        CtClass rectangleClass = ctClassPool.get("cn.tk.java.javassist.Rectangle");

        // CtClass 对象写入 class 文件，被封冻
        rectangleClass.writeFile();

        // 如果要修改，先解冻，然后继续修改
        rectangleClass.defrost();
    }

    /**
     * Description：指定 class 文件的搜索路径
     * 类路径（classpath）表示类存放的路径，可能在本地的文件夹中，可能在 jdk 中，可能在 lib 中，可能在某一个 url 下
     */
    @Test
    @SneakyThrows
    public void testSearch()
    {
        ClassPool ctClassPool = ClassPool.getDefault();
        // 当前类的类路径
        ctClassPool.insertClassPath(new ClassClassPath(this.getClass()));
        // 指定目录下
        ctClassPool.insertClassPath("/usr/local/lib");
        // 指定服务下
        ctClassPool.insertClassPath(new URLClassPath("www.javassist.org", 80, "/java/", "org.javassist."));
    }

    /**
     * Description：避免内存泄漏
     * javassist 中所有的 CtClass 都要存放到 ClassPool 中，那么 ClassPool（HashTable） 有可能非常大，耗费大量的内存空间。
     * 这时候可以调用 detach 方法暂时扔掉一些 CtClass，需要的时候调用 get 方法又可以重新拿到类文件对象。
     * ClassPool ctClassPool = new ClassPool(); 等效于使用 ClassPool.getDefault()
     */
    @Test
    @SneakyThrows
    public void testAvoidOOM()
    {
        ClassPool ctClassPool = ClassPool.getDefault();
        CtClass ctClass = ctClassPool.get("cn.tk.java.javassist.Rectangle");
        ctClass.detach();
        CtClass ctClassAgain = ctClassPool.get("cn.tk.java.javassist.Rectangle");
    }

    /**
     * Description：级联 ClassPool
     * 在 web server 中可能有多个类加载器，不同的类加载器需要使用不同的 ClassPool，而 ClassPool 对象是单例的，不能
     * 直接只调用 ClassPool.getDefault()
     */
    @Test
    @SneakyThrows
    public void testCascaded()
    {
        ClassPool parentPool = ClassPool.getDefault();
        // child 对象池
        ClassPool childPool = new ClassPool(parentPool);
        // 指定 child 对象池的类路径，调用 get 方法的时候先去 parent 对象池找，没找到再去子对象池找（级联关系）
        childPool.insertClassPath("./classes");

        // child 对象池的类路径和 parent 对象池的类路径一致
        childPool.appendSystemPath();

        // 解除级联关系，直接在 child 对象池中找
        childPool.childFirstLookup = true;
    }

    /**
     * Description：修改类对象名字
     */
    @Test
    @SneakyThrows
    public void testChangeName()
    {
        ClassPool ctClassPool = ClassPool.getDefault();
        CtClass ctClass = ctClassPool.get("cn.tk.java.javassist.Rectangle");
        ctClass.setName("Pair");
        ctClass.writeFile();
    }

    @Test
    @SneakyThrows
    public void testToClass()
    {
        String text = "{ System.out.println(\"Hello.say():\"); }";

        ClassPool ctClassPool = ClassPool.getDefault();
        CtClass rectangleClass = ctClassPool.get("cn.tk.java.javassist.Rectangle");
        CtMethod printMethod = rectangleClass.getDeclaredMethod("print");
        printMethod.insertBefore(text);
        Class clazz = rectangleClass.toClass();
        Rectangle rectangle = (Rectangle) clazz.newInstance();
        rectangle.print();
    }
}
