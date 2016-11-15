package cn.tk.java.util.hash;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.StringHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/*
* @date: $DATE
* @author: Michael_Li
* @mail: ljldeepinit@163.com
* @description: SlowMap测试类
*
*/
public class SlowMapTest {

    private SlowMap<String, String> map;

    @BeforeAll
    public void setUp()
    {
        map = new SlowMap<>();
        map.put("age", "18");
        map.put("sex", "M");
        map.put("love", "flower");
    }

    @Test
    @DisplayName("put")
    public void put() throws Exception {
        map.put("name", "lijinlong");
    }

    @Test
    @DisplayName("get")
    public void get() throws Exception {
        assertSame("lijinlong", map.get("name"));
    }

    @Test
    @DisplayName("entrySet")
    public void entrySet() throws Exception {
        System.out.println(map.entrySet());
    }
}