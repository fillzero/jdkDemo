package cn.tk.java.util.collections;

import java.util.List;

import org.junit.Test;

public class CollectionsDemoTest {
	/**
	 * @Description:测试生成随机数， 红包的概率取决于每一类红包所占的数量
	 */
	@Test
	public void testBonusGenerator()
	{
		List<Integer> bonus = CollectionsDemo.bonusGenerator(10, 50, 80000, 2400000);
		System.out.println(bonus.size());//生成 80000 个 10～50 之间的随机数， 总数不大于 2400000
	}
}
