package cn.tk.java.fastjson.putData;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class PutData {
	/**
	 * @description:String 类型数据多， 不会影响 parseObject, 只会把所需要的放进去
	 */
	@Test
	public void testPutDataToModel()
	{
		String personString = "{\r\n" + 
				"  \"identifyNo\": \"420583199201240738\",\r\n" + 
				"  \"identifyType\": \"01\",\r\n" + 
				"  \"name\": \"小明\",\r\n" + 
				"  \"mobile\": \"18346660318\",\r\n" + 
				"  \"mail\": \"751240877@qq.com\"\r\n" + 
				"}";
		Person person = JSON.parseObject(personString, Person.class);
		System.out.println(person.toString());
	}
	
	/**
	 * @description:String 类型数据少， 不会影响 parseObject, 只会把非空的数据放进去
	 */
	@Test
	public void testPutDataToModel2()
	{
		String personString = "{\r\n" + 
				"  \"identifyNo\": \"420583199201240738\",\r\n" + 
				"  \"identifyType\": \"01\",\r\n" + 
				"  \"name\": \"小明\"\r\n" + 
				"}";
		Person person = JSON.parseObject(personString, Person.class);
		System.out.println(person.toString());
	}
}
