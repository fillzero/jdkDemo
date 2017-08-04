package cn.tk.java.jvm;

import org.junit.Test;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/8/4
 * Description: 通过程序模拟栈溢出场景
 *
 * HotSpot 虚拟机不区分 虚拟机栈和本地方法栈
 */
public class StackOverFlow {
    private int stackLength = 1; //堆栈深度

    public void recursive(){
        stackLength ++;
        recursive();
    }

    /**
     * Description：-Xss128k
     * 通过不断递归实现栈溢出，抛出 StackOverflowError
     *
     * 单个线程下，无论栈帧太大，还是虚拟机栈容量太小，当内存无法分配的时候都会抛出 StackOverflowError 异常。
     * 注意 StackOverflowError 不是 Exception 的子类
     */
    @Test
    public void testRecursive(){
        StackOverFlow stack = new StackOverFlow();
        try{
            stack.recursive();
        }catch (Throwable e){
            System.out.println("Stack Depth: " + stack.stackLength);
            throw e;
        }
    }
}
