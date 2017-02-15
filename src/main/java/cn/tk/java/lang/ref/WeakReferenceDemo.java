package cn.tk.java.lang.ref;

import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/*
* @date: 2017/2/15
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description:
* 
*/
public class WeakReferenceDemo {
    private ReferenceQueue<CommonObject> refQueue = new ReferenceQueue<CommonObject>();

    public static class CommonObject{
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("CommonObject's finalize called!");
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public class ClearQueue implements Runnable{
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
    * @description: 虚引用 GC 一次就会被回收
    */
    @Test
    public void testWeakReference()
    {
        CommonObject commonObject = new CommonObject();
        WeakReference<CommonObject> weakReferent = new WeakReference<CommonObject>(commonObject, refQueue);
        new Thread(new SoftReferenceDemo.ClearRefQueue()).start();

        commonObject = null;

        System.gc();
        System.out.println(weakReferent.get());
    }
}
