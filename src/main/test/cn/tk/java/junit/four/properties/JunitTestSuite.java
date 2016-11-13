package cn.tk.java.junit.four.properties;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import cn.tk.java.junit.four.wordDealUtil.WordDealUtilTest;

/**
 * @Description:junit特性: 测试套件
 * 1. public修饰的空类作为测试套件的入口
 * 2. @RunWith: 指定按套件运行, @Suite.SuiteClass: 指定套件包含类
 */
@RunWith(Suite.class)//按测试套件运行
@Suite.SuiteClasses({//指定套件包含的类
	TestJunit1.class, TestJunit2.class, WordDealUtilTest.class
})
public class JunitTestSuite {

}
