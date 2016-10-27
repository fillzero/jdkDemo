package cn.tk.java.fastjson;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author: lijl85
 * @Title: JSONArray.java
 * @Package: cn.tk.java.fastjson
 * @Time: 2016年10月27日上午11:30:21
 *
 * @Description: 测试 Array
 * Object 对象是 : key - value 对
 * Array 对象是 : key - array(values) 对
 * 
 * 1. 获取 Object 中的 Array
 * Object 里面可以有多个 Array， 获取对应的 Array 需要使用 key 来做索引
 * 	JSONArray pascalArray = book.getJSONArray("Pascal");
 * 
 * 2. 获取 Array 中的 Object
 * 获取 Array 中的元素需要使用对应的下标获取
 * 	JSONObject impatient = scalaArray.getJSONObject(i); 
 * 获取 impatient 对象中的 price 需要使用 key 来做索引
 *  String price = impatient.getString("price")
 *  
 * 总结: 获取 Object 元素需要使用 key-value， 获取 Array 元素需要使用下标索引
 * JSONObject 内置  LinkedHashMap/HashMap， JSONArray 内置 ArrayList
 */
public class JSONArrayDemo {
 
	private static JSONObject book = new JSONObject();
	private static JSONArray pascal = new JSONArray();
	private static JSONArray scala = new JSONArray();
	private static JSONObject simple = new JSONObject();
	private static JSONObject guide = new JSONObject();
	private static JSONObject impatient = new JSONObject();
	private static JSONObject depth = new JSONObject();

	//	{
//		  "Pascal": [
//		    {
//		      "Name": "Pascal Made Simple",
//		      "price": 700
//		    },
//		    {
//		      "Name": "Guide to Pascal",
//		      "price": 400
//		    }
//		  ],
//		  "Scala": [
//		    {
//		      "Name": "Scala for the Impatient",
//		      "price": 1000
//		    },
//		    {
//		      "Name": "Scala in Depth",
//		      "price": 1300
//		    }
//		  ]
//		}

	/**
	 * 从里到外的准备数据， 放入对应的 key
	 * Object 对象是 : key - value 对
	 * Array 对象是 : key - array(values) 对
	 */
	static{
		simple.put("Name", "Pascal Made Simple");
		simple.put("price", 700);
		guide.put("Name", "Guide to Pascal");
		guide.put("price", 400);
		impatient.put("Name", "Scala for the Impatient");
		impatient.put("price", 1000);
		depth.put("Name", "Scala in Depth");
		depth.put("price", 1300);
		
		pascal.add(simple);
		pascal.add(guide);
		scala.add(impatient);
		scala.add(depth);
		
		book.put("Pascal", pascal);
		book.put("Scala", scala);
	}
	
	/**
	 * @Description: 利用数据拼成一个 jsonArray 字符串
	 * 从里到外拼接 JSON 数据
	 */
	@Test
	public void testCreateArray()
	{
		System.out.println(book.toJSONString());
	}
	
	/**
	 * @Description:将一个字符串转换成 JSONArray，遍历 Array 中数据
	 */
	@Test
	public void testParse()
	{
		JSONArray pascalArray = book.getJSONArray("Pascal");
		JSONArray scalaArray = book.getJSONArray("Scala");
		
		for(int i=0; i<pascalArray.size(); i++)
		{
			System.out.println(pascalArray.getJSONObject(i).getString("Name"));
		}
		
		System.out.println("****************** 我是分界线 *********************");
		
		for(int i=0; i<scalaArray.size(); i++)
		{
			System.out.println(scalaArray.getJSONObject(i).getString("price"));
		}
	}
}