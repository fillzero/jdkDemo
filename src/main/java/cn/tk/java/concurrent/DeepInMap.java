package cn.tk.java.concurrent;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/8/23
 * Description:
 * 1. HashMap 扩容机制
 * 2. 为什么 HashMap 不是线性安全的
 */
public class DeepInMap {
    @Test
    public void testDisorder()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "lijinlong");
        map.put("age", 18);
        map.put("sex", "male");
        System.out.println(map);
    }

    static int hash(int h)
    {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public static void main(String[] args) {
        int hash = hash("Aa".hashCode());
        int hash1 = hash("Bb".hashCode());
        System.out.println(hash);
        System.out.println(hash1);
    }
}
