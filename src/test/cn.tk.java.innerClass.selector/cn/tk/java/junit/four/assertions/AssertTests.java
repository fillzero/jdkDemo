package cn.tk.java.junit.four.assertions;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

/**
 * @Description:
 * Equals: 对比两个对象的值是否相等
 * Same: 对比两个对象是否是同一个对象
 */
public class AssertTests {
	
	/**
	 * @Description:比较两个 byte 数组值是否相等
	 */
	@Test
	public void testAssertArrayEquals()
	{
		byte[] expected = "trial".getBytes();
		byte[] actual = "trial".getBytes();
		assertArrayEquals("failure - byte arrays not same", expected, actual);
	}
	
	/**
	 * @Description: 比较两个 null 值是否相等
	 */
	@Test
	public void testAssertNullEquals() {
		String aString = null;
		String bString = null;
		assertEquals("failure - null is not equal to null", aString, bString);
	}

	/**
	 * @Description: 比较两个字符串值是否相等
	 */
	@Test
	public void testAssertEquals()
	{
		assertEquals("failure - strings are not equal", "text", "text");
	}
	
	/**
	 * @Description:比较两个 Object 是否是同一个对象, 证明两个新 new 的 Object 不是同一个对象, 占用内存空间不一样
	 */
	@Test
	public void testAssertNotSame() throws ClassNotFoundException
	{
		assertNotSame("should not be same Object", new Object(), new Object());
	}
	
	/**
	 * @Description: aNumber 与 aNumber 是同一个对象
	 */
	@Test
	public void testAssertSame()
	{
		Integer aNumber = Integer.valueOf(768);
		assertSame("should be same", aNumber, aNumber);
	}
	
	/**
	 * @Description:区别 Equals 和 Same
	 * 自动装箱池 IntegerCache
	 */
	@Test
	public void diffEqualsAndSame()
	{
		//Integer 里面有一个内部类 IntegerCache, -128-127之间的数会缓存, 所以 aNumber, bNumber 是同一个对象
		Integer aNumber = Integer.valueOf(123);
		Integer bNumber = Integer.valueOf(123);
		Integer cNumber = new Integer(123);
		assertSame("failure - should be the same object", aNumber, bNumber);
		assertSame("failure - should be the same object", aNumber, cNumber);
		assertEquals("should be the same value", aNumber, bNumber) ;
	}
	
	/**
	 * @Description:断言对象是否为空
	 */
	@Test
	public void testAssertNull()
	{
		assertNull("should be null", null);
	}
	
	@Test
	public void testAssertThatBothContainsString()
	{
		assertThat("albumen", both(containsString("a")).and(containsString("b")));
	}
	
	@Test
	public void testAssertThatHasItems()
	{
		assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "two"));
	}
	
	@Test
	public void testAssertThatEveryItemContainsString()
	{
		assertThat(Arrays.asList(new String[]{"fun", "ban", "net"}), everyItem(containsString("n")));
	}
	
	@Test
	public void testAssertThatHamcrestCoreMatchers()
	{
		assertThat("good", allOf(equalTo("good"), startsWith("good")));
		assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
		assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
		assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
		assertThat(new Object(), not(sameInstance(new Object())));
	}
	
	@Test
	public void testAssertTrue()
	{
		assertTrue("failure - should be true", true);
	}
}
