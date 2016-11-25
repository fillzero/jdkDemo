package cn.tk.java.guava.collections;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @Company: 泰康在线财产保险股份有限公司
 * @Author: 李晋龙
 * @Title: BiMapDemo.java
 * @Package: cn.tk.java.guava.collections
 * @Time: 2016年7月5日下午5:50:23
 *
 * @description:双向 Map， key， value 都不可以重复
 */
public class BiMapDemo {
	/**
	 * @description:传统 map， key 不可以重复， 但是 value 可以重复， 是一种多对多的关系， 无法实现直接自动反转
	 */
	@Test
	public void testinverseMap()
	{
		Map<String, String> originalData = prepareMapData();
		for(Map.Entry<String, String> entry : originalData.entrySet())
		{
			if("3".equals(entry.getValue()))
			{
				System.out.println(entry.getKey());
			}
		}
	}
	
	/**
	 * @description:BiMap 两次反转， 因为是双向 Map, key/value 都不可以重复， 所以可以实现直接反转，
	 * key/value 一一对应
	 */
	@Test
	public void testBiMap()
	{
		BiMap<String, String> biMap = prepareBiMapData();
		BiMap<String, String> inverseMap = biMap.inverse();
		System.out.println(inverseMap.get("3"));
		System.out.println(inverseMap.inverse().get("c"));
	}
	
	public Map<String, String> prepareMapData()
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "1");
		map.put("b", "2");
		map.put("c", "3");
		map.put("d", "3");
		return map;
	}
	
	/**
	 * @description:放重复的 value 就会出现 IllegalArgumentException
	 */
	public BiMap<String, String> prepareBiMapData()
	{
		BiMap<String, String> biMap = HashBiMap.create();
		biMap.put("a", "1");
		biMap.put("b", "2");
		biMap.put("c", "3");
		return biMap;
	}
}
