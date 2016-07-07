package cn.tk.java.fastjson;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

public class SimplePropertyPreFilterDemo {
	@Test
	public void testSimpleFilter()
	{
		JSONObject inputJson = new JSONObject();
		prepareData(inputJson);
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(SimplePropertyPreFilterDemo.class,  "property");
		System.out.println(JSONObject.toJSONString(inputJson, filter));
	}

	private void prepareData(JSONObject inputJson) {
		JsonUtil.setStringValue(inputJson, "data.person.name", "xiaoli");
		JsonUtil.setStringValue(inputJson, "data.person.sex", "female");
		JsonUtil.setStringValue(inputJson, "data.person.cidNo", "150203456975435454");
		JsonUtil.setStringValue(inputJson, "data.person.mobile", "13800000000");
		JsonUtil.setStringValue(inputJson, "data.property.pants", "nike");
		JsonUtil.setStringValue(inputJson, "data.person.shoes", "adidas");
		JsonUtil.setStringValue(inputJson, "data.person.t-shirt", "lining");
	}
}
