package cn.tk.java.util.hash;

import java.util.LinkedHashMap;

import org.junit.Test;

public class LinkedHashMapDemo {
	
	/**
	 * @Description: jdk 实现 LRU 算法， 可以用作缓存
	 */
	@Test
	public void test() throws InterruptedException
	{
		LRUCache cache = new LRUCache(2, 0.75f, true);
		cache.put("name1", "lijl1");
		cache.put("name2", "lijl2");
		System.out.println(cache.get("name1"));
		cache.put("name3", "lijl3");
		
		System.out.println(cache.toString());
	}
	
	/**
	 * @Description: Cache 使用 LRU 算法， 重写 removeEldestEntry 方法， 定时删除 map 中长时间或者很少使用的元素。
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
}