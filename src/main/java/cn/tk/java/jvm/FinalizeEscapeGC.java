package cn.tk.java.jvm;

import java.util.concurrent.TimeUnit;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/8/8
 * Description:
 * 1. 对象在被 GC 的时候可以自我拯救
 * 2. 自我拯救机会只有 1 次，一个对象的 finalize 方法最多被系统自动调用 1 次
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = new FinalizeEscapeGC();

    public void isAlive()
    {
        System.out.println("It's alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Execute finalize method!");

        FinalizeEscapeGC.SAVE_HOOK = this;//重新调用，自我拯救 1 次，不建议使用
    }

    public static void main(String[] args) throws InterruptedException {
        forceGC();
        forceGC();
    }

    private static void forceGC() throws InterruptedException {
        SAVE_HOOK = null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);

        if (SAVE_HOOK != null)
            SAVE_HOOK.isAlive();
        else
            System.out.println("It's not alive!");
    }
}
