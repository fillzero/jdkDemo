package cn.tk.java.util.map;

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
}
