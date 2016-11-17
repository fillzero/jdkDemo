package cn.tk.java.util.hash;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/*
* @date: 2016/11/17
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description:链表实现 Map 测试类
*
*/
public class SimpleHashMapTest {

    static SimpleHashMap<String, String> map = new SimpleHashMap<String, String>();

    /*
    * @description: 初始化map
    */
    @BeforeAll
    public static void initial()
    {
        map.put("name", "lijinlong");
    }

    /*
    * @description: 获取 map 中内容进行验证
    */
    @Test
    @DisplayName("HashMap: get()")
    public void get() throws Exception {
        assertEquals("lijinlong", map.get("name"));
    }

    /*
    * @description: 重新 set map 内容, 并且返回旧值
    */
    @Test
    @DisplayName("HashMap: set()")
    public void put() throws Exception {
        assertEquals("lijinlong", map.put("name", "wangwenchao"));
    }

    /*
    * @description: 打印 map 中所有数据
    */
    @Test
    @DisplayName("HashMap: entrySet()")
    public void entrySet() throws Exception {
        System.out.println(map.entrySet());
    }
}