package newProperty;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.google.common.collect.Lists;

public class StreamDemo {
	/**
	 * @description:过滤掉空元素
	 */
	@Test
	public void testFilterNull()
	{
		List<Integer> nums = Lists.newArrayList(1, 2, 3, null, null, 4, 10, null);
		long count = nums.stream().filter(num -> num != null).count();
		Stream<Integer> filter = nums.stream().filter(num -> num != null);
		System.out.println(count);
		Iterator<Integer> iterator = filter.iterator();
		while(iterator.hasNext())
		{
			System.out.print(iterator.next() + ",");
		}
	}

	@Test
	public void testOf()
	{
		String[] names = {"wenchao", "liujia", "lijinlong", "shanling"};
		Stream<String> stream = Stream.of(names);//转成 Stream
		stream.forEach(System.out::println);
	}

	/**
	 * Description：Stream 的中间操作
	 */
	@Test
	public void testMiddleOperate()
	{
		List<Integer> list = Arrays.asList(1, 2, 3, 8, 4, 5, 6, 7, 8, 9, 10);
		list.stream()
				.filter(a -> a % 2 == 0)
				.distinct()
				.sorted((a, b) -> b - a)
				.skip(2)
				.limit(3)
				.forEach(System.out::println);
	}

	/**
	 * Description：返回一个 Map
	 */
	@Test
	public void testMap()
	{
		List<Integer> list = Arrays.asList(1, 2, 3, 8, 4, 5, 6, 7, 8, 9, 10);
		Map<Integer, Integer> map = list.stream()
				.map(a -> a * 2)
				.distinct()
				.collect(Collectors.toMap(i1 -> i1, i1 -> i1));
		System.out.println(map);
	}
}
