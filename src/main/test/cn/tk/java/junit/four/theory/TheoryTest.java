package cn.tk.java.junit.four.theory;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * @Description:理论机制加入了参数传入, 可以通过 @DataPoint 将参数传入理论测试方法
 * 带参数的测试函数, 参数来自 @DataPoint
 */
@RunWith(Theories.class)
public class TheoryTest {

	//数据集合
	@DataPoint public static String YEAR_2007 = "2007";
	@DataPoint public static String YEAR_2008 = "2008";
	@DataPoint public static String NAME1 = "developer";
	@DataPoint public static String NAME2 = "Works";
	@DataPoint public static String NAME3 = "developerWorks";

	@Theory
	public void testNames1(String year, String name) {
		assumeThat(year, is("2007"));//过滤数据, year 必须是 2007 或者 2008
		System.out.println(year + "-" + name);
		assertThat(year, is("2007"));//将假设过滤后的数据交给断言判断
	}
	
	@Theory
	public void testName2(String year, String name)
	{
		assumeThat(year, is("2007"));
		assumeThat(name, allOf(not(is("2007")), not(is("2008"))));//name 不能是 2007, 2008
		System.out.println(year + "-" + name);
		assertThat(year, is("2007"));
	}
}
