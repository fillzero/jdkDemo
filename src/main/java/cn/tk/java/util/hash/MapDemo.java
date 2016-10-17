package cn.tk.java.util.hash;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapDemo {
	/**
	 * @Description:map 的 key， value 最好不要用 null， 虽然不会报错， 但是会引起歧义
	 * map.get(key) 为 null， 可能是 value 为 null， 也有可能不存在相应的值
	 */
	@Test
	public void testMapNull()
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put(null, "xiaoshunzi");
		map.put(" ", "xiaoslizi");
		map.put("abc", null);
		System.out.println(map.get(null));
		System.out.println(map.get(" "));
		System.out.println(map.get("abc"));
		System.out.println(map.get("adf"));
	}
	
	 /**
	 * @Description: HashMap 中的 hash 实现
	 */
	static final int hash(Object key) {
		 int h;
		 return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	 }
	
	/**
	 * @Description:测试 HashMap 的 hash 特性， 与 hashCode 和 equals 方法建立关联
	 */
	@Test
	public void testHashMap()
	{
		System.out.println(hash(null));//null 的 hashCode 为 0
		System.out.println(8 >>> 16);//右移一位相当于处以 2
		System.out.println(1 << 64);
	}
	
	/**
	 * @Description:同一台机器 hashCode 不会变
	 */
	@Test
	public void testStringHashMap()
	{
		String aString = "lijinlong";
		String bString = "lijinlong";
		int count = 0;
		for (int i = 0; i < 10000; i++) {
			if (aString.hashCode() == bString.hashCode()) {
				count ++;
			}
		}
		System.out.println(count);
	}
}
