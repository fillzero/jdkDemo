package newProperty;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import org.junit.Test;

/**
 * @description:Lambda 表达式， 简化代码编写，java8 新特性
 */
public class LambdaExpression {
	/**
	 * @description:老版java排序字符串， 传一个 List 和一个比较器 Comparator
	 */
	@Test
	public void sortMethodOld()
	{
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, new Comparator<String>() {
			public int compare(String a, String b)
			{
				return b.compareTo(a);
			}
		});
		System.out.println(names);
	}
	
	/**
	 * @description:新版java 使用 lambda 表达式
	 */
	@Test
	public void sortMethodNew()
	{
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, (String a, String b) -> {
			return b.compareTo(a);
		});
		System.out.println(names);
	}
	
	/**
	 * @description:用 lambda 表达式排序， 还可以写的更简单一点
	 */
	@Test
	public void sortMethodNew2()
	{
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, (a,b) -> b.compareTo(a));
		System.out.println(names);
	}
}
