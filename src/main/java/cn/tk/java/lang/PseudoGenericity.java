package cn.tk.java.lang;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
* @date: 2017/2/14
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description: java 伪泛型
* 
*/
public class PseudoGenericity<T>{
    @Test
    public void testGenericity()
    {
        Object[] a = new Object[4];
        String[] b = (String[]) a;
    }

    public boolean add(Collection<T> values) {
        T[] vals = (T[])values.toArray();
        return add(vals);
    }

    public boolean add(T[] val) {
        return add(val);
    }
}
