package cn.tk.java.guava.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.google.common.collect.HashMultimap;

public class CandidateAndVoters {
	/**
	 * @Description:一个 key 对应多个 value, 场景： 一个候选人对应多张选票， 将数据反转， 一个 key 对应多个 value
	 * key: String
	 * value： HashSet<String>
	 */
	@Test
	public void testMap()
	{
		Map<String, HashSet<String>> hMap = new HashMap<String, HashSet<String>>();
		Map<String, String> originalData = prepareData();
		Iterator<Entry<String, String>> iterator = originalData.entrySet().iterator();
		while (iterator.hasNext()) {
			HashSet<String> set = new HashSet<String>();
			Entry<String, String> entry = iterator.next(); 
		    String candidate = entry.getValue();//候选人： 1， 2， 3
		    String voters = entry.getKey();//选票： a ~ i
			if(hMap.containsKey(candidate))
			{
				set = hMap.get(candidate);
			}
			set.add(voters);
			hMap.put(candidate, set);
		}
		System.out.println(hMap.toString());
	}
	
	/**
	 * @Description:使用 HashMultimap， 一个 key 可以对应多个 value, 不需要考虑覆盖的问题， 并没有实现 Map
	 * 内部本质也是 value 为 Collection
	 */
	@Test
	public void testMultimap()
	{
		Map<String, String> originalData = prepareData();
		HashMultimap<String, String> multimap = HashMultimap.create();
		Iterator<Entry<String, String>> iterator = originalData.entrySet().iterator();
		while(iterator.hasNext())
		{
			Entry<String, String> entry = iterator.next();
			String candidate = entry.getValue();
			String voters = entry.getKey();
			multimap.put(candidate, voters);
		}
		System.out.println(multimap.toString());
	}
	
	/**
	 * @Description:
	 * key: voter
	 * value: candidate 
	 */
	public Map<String, String> prepareData()
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "1");
		map.put("b", "1");
		map.put("c", "1");
		map.put("d", "2");
		map.put("e", "2");
		map.put("f", "2");
		map.put("g", "2");
		map.put("h", "2");
		map.put("i", "3");
		System.out.println("originalData：" + map.toString());
		return map;
	}
}
