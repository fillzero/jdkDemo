package cn.tk.java.util.hash;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.StringHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/*
* @date: $DATE
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description: SlowMap测试类
*
*/
public class SlowMapTest {

    private static SlowMap<String, String> map;

    /*
    * @description: 初始化操作, 实例化对象
    */
    @BeforeAll
    public static void setUp()
    {
        map = new SlowMap<>();
        map.put("age", "18");
        map.put("sex", "M");
        map.put("love", "flower");
    }

    /*
    * @description: put 操作, 写入 Map
    */
    @Test
    @DisplayName("put")
    public void put() throws Exception {
        map.put("name", "lijinlong");
    }

    /*
    * @description: get操作, 获取 Map 值
    */
    @Test
    @DisplayName("get")
    public void get() throws Exception {
        assertSame("18", map.get("age"));
    }

    @Test
    @DisplayName("entrySet")
    public void entrySet() throws Exception {
        System.out.println(map.entrySet());
    }
}