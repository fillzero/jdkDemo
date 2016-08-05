package cn.tk.java.dec;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class InputUtilTest {
	@Test
	public void testChangeTokenWeChat()
	{
		String input = "{\r\n" + 
				"    \"requestId\": \"1234111\",\r\n" + 
				"    \"customerId\": \"8999614\",\r\n" + 
				"    \"applicantList\": [\r\n" + 
				"        {\r\n" + 
				"            \"identifyNumber\": \"420583199201240738\",\r\n" + 
				"            \"identifyType\": \"01\",\r\n" + 
				"            \"name\": \"小明\",\r\n" + 
				"            \"mobile\": \"18346660318\",\r\n" + 
				"            \"mail\": \"751240877@qq.com\"\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"insuresubjectList\": [\r\n" + 
				"        {\r\n" + 
				"            \"fieldAk\": \"01\",\r\n" + 
				"            \"fieldAl\": \"房主\",\r\n" + 
				"		}\r\n" + 
				"    ],\r\n" + 
				"    \"insuredList\": [\r\n" + 
				"        {\r\n" + 
				"            \"identifyNumber\": \"420583199201240738\",\r\n" + 
				"            \"identifyType\": \"01\",\r\n" + 
				"            \"name\": \"小明\",\r\n" + 
				"            \"mobile\": \"18346660318\",\r\n" + 
				"            \"mail\": \"751240877@qq.com\",\r\n" + 
				"            \"relatedperson\": \"0\"\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"issueDate\": \"1460613041513\",\r\n" + 
				"    \"insuredAddress\": \"北京 北京市 东城区\",\r\n" + 
				"    \"detailedAddress\": \"详细地址11111\",\r\n" + 
				"    \"businessChannel\": \"05\",\r\n" + 
				"    \"comboid\": \"1702T104\",\r\n" + 
				"    \"itemPropertyList\": [\r\n" + 
				"        {\r\n" + 
				"            \"itemprovincecode\": \"999\",\r\n" + 
				"            \"itemcitycode\": \"888\",\r\n" + 
				"            \"itemdistrictcode\": \"777\",\r\n" + 
				"            \"itempostalcode\": \"6666\"\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"intermediarycode\": \"xxxx\",\r\n" + 
				"    \"payWayId\": 71,\r\n" + 
				"    \"payCallBackUrl\": \"http://weit.taikang.com/wechat/rest/v4/insure/policy\",\r\n" + 
				"    \"failUrl\": \"http://weit.taikang.com/WHO/page/payFail.html\",\r\n" + 
				"    \"payAccount\": \"wang\",\r\n" + 
				"    \"successUrl\": \"http://weit.taikang.com/WHO/page/paySuccess.html\"\r\n" + 
				"}\r\n" + 
				"";
		JSONObject json = new JSONObject();
		String token = "123456";
		json.put("req", JSONObject.parse(input));
		json.put("token", token);
		System.out.println(InputUtil.changeTokenWeChat(json.toJSONString(), "alitkang"));
	}
}
