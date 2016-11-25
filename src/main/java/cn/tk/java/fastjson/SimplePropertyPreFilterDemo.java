package cn.tk.java.fastjson;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

/**
 * @Company: 泰康在线财产保险股份有限公司
 * @Author: 李晋龙
 * @Title: SimplePropertyPreFilterDemo.java
 * @Package: cn.tk.java.fastjson
 * @Time: 2016年7月7日上午11:53:57
 *
 * @description:SimplePropertyPreFilter 要过滤必须要有 javaBean， 不能直接在 json 的基础上进行过滤，希望写一个功能可以
 * 实现更加智能化的过滤， 任意一个 json 直接可以进行过滤。
 */
public class SimplePropertyPreFilterDemo {
	@Test
	public void testSimpleFilter()
	{
		List<Person> personList = prepareData();
		JSONObject inputJson = new JSONObject();
		JsonUtil.setValue(inputJson, "data.person", personList);
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Person.class,  "name");
		System.out.println(JSONObject.toJSONString(inputJson, filter));
	}

	private List<Person> prepareData() {
		List<Person> persons = new LinkedList<Person>();
		Person person = new Person();
		person.setName("xiaowang");
		person.setCidNo("141112191305020012");
		person.setMobile("13800000000");
		person.setSex("famale");
		Person person1 = new Person();
		person1.setName("xiaozhang");
		person1.setCidNo("141112191305020023");
		person1.setMobile("13811111111");
		person1.setSex("male");
		persons.add(person);
		persons.add(person1);
		return persons;
	}
}
