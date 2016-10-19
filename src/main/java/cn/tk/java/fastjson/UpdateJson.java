package cn.tk.java.fastjson;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class UpdateJson {
	
	public void updateJson(String name, JSONObject inputJson)
	{
		JsonUtil.setStringValue(inputJson, "name", name);
	}
	
	@Test
	public void testUpdate()
	{
		JSONObject inputJson = new JSONObject();
		JsonUtil.setStringValue(inputJson, "name", "lijinlong");
		System.out.println(inputJson.toJSONString());
		updateJson("wangwenchao", inputJson);
		System.out.println(inputJson.toJSONString());
	}
}
