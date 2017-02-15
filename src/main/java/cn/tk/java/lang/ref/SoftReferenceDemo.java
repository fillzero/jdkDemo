package cn.tk.java.lang.ref;

import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/*
* @date: 2017/2/15
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description:
* 1. 测试 GC 后 SoftReference 中取值变化
* 2. 写一个内存敏感的缓存存放图片数据
*/
public class SoftReferenceDemo {
    private static ReferenceQueue<CommonObject> refQueue = new ReferenceQueue<CommonObject>();

    /*
    * @description: 软引用指向的软可及对象, 普通对象
    * finalize(): 收尾方法, 对象被 GC 回收的时候就会调用该方法进行收尾工作.
    */
    public static class CommonObject{
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("CommonObject's finalize called!");
        }

        @Override
        public String toString() {
            return "This is CommonObject!";
        }
    }

    /*
    * @description: 获取软引用队列中的软引用
    */
    public static class ClearRefQueue implements Runnable{
        Reference<CommonObject> commonObject = null;
        @Override
        public void run() {
            try {
                commonObject = (Reference<CommonObject>) refQueue.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (commonObject!=null)
                System.out.println("commonObject: " + commonObject.get());
        }
    }

    /*
    * @description:
     * 1. 内存空间充足, 软引用不会被回收
     * 2. 内存不够的时候为了避免内存泄露会回收软引用
    */
    @Test
    public void testSoftReference()
    {
        CommonObject commonObject = new CommonObject();
        SoftReference<CommonObject> softReferent = new SoftReference<CommonObject>(commonObject, refQueue);
        new Thread(new ClearRefQueue()).start();

        commonObject = null;
        System.gc();
        System.out.println(softReferent.get());//内存空间充足, 软引用不会被回收
    }
}
