package cn.tk.java.jvm.classStructure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lijinlong3 on 2017/9/21.
 */
public class TestClassTest {

    @Test
    public void testInc() throws Exception {
        TestClass testClass = new TestClass();
        System.out.println(testClass.inc());
    }
}