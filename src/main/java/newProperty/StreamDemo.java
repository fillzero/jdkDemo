package newProperty;

import java.util.Iterator;
import java.util.List;
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
}
