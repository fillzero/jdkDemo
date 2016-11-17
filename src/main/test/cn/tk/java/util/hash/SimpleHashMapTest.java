package cn.tk.java.util.hash;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/11/17.
 */
public class SimpleHashMapTest {

    static SimpleHashMap<String, String> map = new SimpleHashMap<String, String>();

    @BeforeAll
    public static void initial()
    {
        map.put("name", "lijinlong");
    }

    @Test
    @DisplayName("HashMap: get()")
    public void get() throws Exception {
        assertEquals("lijinlong", map.get("name"));
    }

    @Test
    @DisplayName("HashMap: set()")
    public void put() throws Exception {
        assertEquals("18", map.put("age", "18"));
    }

    @Test
    @DisplayName("HashMap: entrySet()")
    public void entrySet() throws Exception {
        assertEquals("name=lijinlong", map.entrySet());
    }
}