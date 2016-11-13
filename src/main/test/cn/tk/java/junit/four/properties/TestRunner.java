package cn.tk.java.junit.four.properties;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @Description:junit特性: 测试运行器
 */
public class TestRunner {
	public static void main(String[] args)
	{
		Result result = JUnitCore.runClasses(TestJunit.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
	
	@Test
	public void getAssertRunner()
	{
		Result result = JUnitCore.runClasses(AssertDemo.class, TestJunit.class);//通过运行器运行单元测试类, 获取单元测试结果
		System.out.println("单元测试总个数:　" + result.getRunCount());
		System.out.println("失败类个数: " + result.getFailureCount());
		for(Failure failure : result.getFailures())
		{
			System.out.println("失败详情: " + failure.toString());//打印失败的
		}
		System.out.println(result.wasSuccessful());//没有失败的就成功了
	}
}
