package cn.tk.java.util.properties;

import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Test;
import static org.junit.Assert.assertThat;

public class PropertiesUtilTest {
	@Test
	public void testGetValue()
	{
		assertThat("name 属性获取失败！", PropertiesUtil.getValue("name"), equalTo("lijinlong"));
		assertThat("url 属性获取失败！", PropertiesUtil.getValue("url"), equalTo("http://aiit.tk.cn/fuckeveryday?id=12345"));
	}
}
