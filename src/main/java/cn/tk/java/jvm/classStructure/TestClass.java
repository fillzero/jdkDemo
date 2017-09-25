package cn.tk.java.jvm.classStructure;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/9/21
 * Description: 分析 java 字节码
 */
public class TestClass implements ITest{
    private int m;

    public int inc()
    {
        return m + 1;
    }
}
