package cn.tk.java.jvm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/8/4
 * Description: 通过程序模拟内存溢出场景
 */
public class OutOfMemory {
    static class OOMObject {

    }

    /**
     * Description：不断创建对象导致内存溢出
     * 设置最大对内存 20M，并且不能扩展
     *
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    @Test
    public void triggerByCreateObject(){
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true)
            list.add(new OOMObject());
    }
}
