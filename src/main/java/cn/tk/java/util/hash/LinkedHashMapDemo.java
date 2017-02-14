package cn.tk.java.util.hash;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class LinkedHashMapDemo {
	
	/**
	 * @description: jdk 实现 LRU 算法， 可以用作缓存
	 */
	@Test
	public void test() throws InterruptedException
	{
		LRUCache cache = new LRUCache(2, 0.75f, true);
		cache.put("name1", "lijl1");
		cache.put("name2", "lijl2");
		System.out.println(cache.toString());
		System.out.println(cache.get("name1"));
		cache.put("name3", "lijl3");
		
		System.out.println(cache.toString());
	}
	
	/**
	 * @description: Cache 使用 LRU 算法， 重写 removeEldestEntry 方法， 定时删除 map 中长时间或者很少使用的元素。
	 */
	public class LRUCache extends LinkedHashMap<String, String>
	{
		private static final long serialVersionUID = 1L;
		protected int maxElements;

		public LRUCache(int maxSize, float loadFactor, boolean accessOrder) {
			super(maxSize, loadFactor, accessOrder);
			this.maxElements = maxSize;
		}
		
		@Override
		protected boolean removeEldestEntry(
				java.util.Map.Entry<String, String> eldest) {
			return size() > maxElements;
		}
	}

	/*
	* @description: 缓存回收策略只有在缓存空间有限的时候才会生效, 如果缓存空间无限大, 那么不需要存在缓存回收策略
	*/
	@Test
	public void testLinkedHashMap()
	{
		Map<String, Integer> cache = new LinkedHashMap<String, Integer>(3,  0.75f, true){
			/*
			* @description: LinkedHashMap 没有缺省实现, 并且默认返回 false, 就是永远不会删除缓存中元素, 所以要实现 LRU Cache
			* 必须手动编写 removeEldestEntry 实现方法并且覆盖默认方法.
			* 当元素大于 3 的时候执行删除
			*/
			@Override
			protected boolean removeEldestEntry(
					java.util.Map.Entry<String, Integer> eldest) {
				return size() > 3;
			}
		};
		cache.put("1", 1);
		cache.put("2", 2);
		cache.put("3", 3);
		cache.put("4", 4);
		System.out.println(cache.get("3"));
		cache.put("5", 5);
		cache.put("6", 6);
		System.out.println(cache.toString());
	}
}