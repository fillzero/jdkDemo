package cn.tk.java.guava.cache;

import java.awt.GradientPaint;
import java.awt.RenderingHints.Key;
import java.awt.font.GraphicAttribute;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

/**
 * @Description: Cache 的创建和移除
 */
public class CacheDemo {
	/**
	 * @Description:cacheloader 方法
	 */
	@Test
	public void testCacheBuilder() throws ExecutionException
	{
		LoadingCache<String, String> graphs = CacheBuilder.newBuilder()
				.maximumSize(1000)//基于大小移除数据, 1000指数据条数， 不是内存大小
				.expireAfterAccess(1, TimeUnit.DAYS)//基于时间移除数据
				.build(new CacheLoader<String, String>(){

					@Override
					public String load(String key) throws Exception {
						//这里是 key 根据实际去取值的地方
						return "key";
					}
				});
		String resultVal = graphs.get("testKey");
		System.out.println(resultVal);
	}
	
	/**
	 * @Description: callable 方法
	 */
	@Test
	public void testCallable() throws ExecutionException
	{
		Cache<String, String> cache = CacheBuilder.newBuilder()
				.maximumSize(1000)
				.expireAfterWrite(1, TimeUnit.DAYS)
				.build();
		String resultVal = cache.get("testKey", new Callable<String>() 
		{
			@Override
			public String call(){
				return "value";
			}
		});
		System.out.println(resultVal);
	}
	
	/**
	 * @Description: callable 方法， 使用 lamda 表达式， 写法简洁
	 */
	@Test
	public void testCallableWithLamdaExpression() throws ExecutionException
	{
		Cache<String, String> cache = CacheBuilder.newBuilder()
				.maximumSize(1000)
				.build();
		String resultVal = cache.get("testKey", () -> "value");
		System.out.println(resultVal);
	}
	
	/**
	 * @Description:数据的移除
	 */
	@Test
	public void testCacheInvalidate()
	{
		Cache<String, String> cache = CacheBuilder.newBuilder()
				.maximumSize(1000)
				.expireAfterWrite(1, TimeUnit.DAYS)
				.build();
		cache.invalidate("testKey");
		
		cache.invalidateAll();
		
		List<String> keys = new LinkedList<String>(Arrays.asList("key1", "key2", "key3"));
		cache.invalidateAll(keys);
		
		cache.cleanUp();//清空缓存
	}
	
	/**
	 * @Description:定义自己的刷新行为， 重写 Cacheloader.load(K,V) 方法
	 * LoadingCache.refresh(K) 方法是异步的， 刷新不能即时生效
	 */
	@Test
	public void testCacheReload() throws ExecutionException
	{
		LoadingCache<String, String> graphs = CacheBuilder.newBuilder()
				.maximumSize(1000)
				.refreshAfterWrite(1, TimeUnit.MINUTES)
				.build(new CacheLoader<String, String>()
						{
							public String load(String key)
							{
								return getGraphFromDatabase(key);
							}

							private String getGraphFromDatabase(String key) {
								return "graph";
							}
							
							public ListenableFuture<String> reload(final String key, String prevGraph)
							{
								if(neverNeedsRefresh(key))
								{
									return Futures.immediateFuture(prevGraph);
								}
								else {
									//asynchronous
									return ListenableFutureTask.create(new Callable<String>()
											{

												@Override
												public String call()
														throws Exception {
													return getGraphFromDatabase(key);
												}
										
											});
								}
							}

							private boolean neverNeedsRefresh(String key) {
								return false;
							}
					
						});
		System.out.println(graphs.get("testKey"));
		graphs.put("testKey", "xiaoshunzi");
		graphs.refresh("testKey");
		System.out.println(graphs.get("testKey"));
	}
	
	@Test
	public void testCachestats()
	{
		Cache<String, String> cache = CacheBuilder.newBuilder()
				.maximumSize(1000)
				.expireAfterWrite(1, TimeUnit.DAYS)
				.concurrencyLevel(100)
				.build();
		for(int i=0; i<100; i++)
		{
			cache.put("key_"+i, ""+i);
		}
		CacheStats stats = cache.stats();
		System.out.println(stats.averageLoadPenalty());
	}
}
