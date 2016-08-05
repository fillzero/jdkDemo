package cn.tk.java.dec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@SuppressWarnings("unchecked")
public class InputUtil {
	/**
	 * 根据key值计算token并且将input中的toke替换成正确内容
	 * @param input
	 * @param key
	 * @return
	 */
	public static String changeToken(String input,String key){
		Map<String,Object> map = (Map<String, Object>) JSON.parse(input);
		String req = String.valueOf(map.get("req"));

		Map<String, Object> map1 = JSON.parseObject(req);
		Set<String> keySet = map1.keySet();
		List<String> li = new ArrayList<>();
		for (String string : keySet) {
			li.add(string);
		}
		Collections.sort(li);
		String req1 = "";
		for (int i = 0; i < li.size(); i++) {
			if(li.get(i).equals("applicantList")){
				Object Object1 = map1.get("applicantList");
				JSONArray parseArray = JSON.parseArray(Object1.toString());
				Map<String,Object> app = (Map<String,Object>)parseArray.get(0);
				Set<String> keySet2 = app.keySet();
				List<String> list = new ArrayList<>();
				for (String string : keySet2) {
					list.add(string);
				}
				Collections.sort(list);
				for (int j = 0; j < list.size(); j++) {
					req1 += list.get(j)+app.get(list.get(j));
				}
			}else if (li.get(i).equals("insuredList")) {
				Object Object1 = map1.get("insuredList");
				JSONArray parseArray = JSON.parseArray(Object1.toString());
				Map<String, Object> app = (Map<String, Object>) parseArray.get(0);
				Set<String> keySet2 = app.keySet();
				List<String> list = new ArrayList<>();
				for (String string : keySet2) {
					list.add(string);
				}
				Collections.sort(list);
				for (int j = 0; j < list.size(); j++) {
					req1 += list.get(j) + app.get(list.get(j));
				}
			} 
			else if (li.get(i).equals("parameterMap")) {
				String parameterMap = String.valueOf(map1.get("parameterMap"));
				Map<String, Object> app = JSON.parseObject(parameterMap);
				Set<String> keySet2 = app.keySet();
				List<String> list = new ArrayList<>();
				for (String string : keySet2) {
					list.add(string);
				}
				Collections.sort(list);
				for (int j = 0; j < list.size(); j++) {
					req1 += list.get(j) + app.get(list.get(j));
				}
			} 
			else{
				req1 += li.get(i)+map1.get(li.get(i)); 
			}
		}

		String token = Md5Encrypt.getMD5Mac(req1+key, "utf-8");
		map.put("token", token);
		String result = JSON.toJSONString(map);
		return result;
	}
	/**
	 * 使用proposal 中生成的参数替换掉policy中的参数，
	 * @param proposalResult
	 * @param policyParam
	 * @return 返回替换掉投保单号，流水号的报文
	 */
	public static String changePolicyParams(String proposalResult,String policyParam){
		Map<String,Object> proposalMap = JSON.parseObject(proposalResult);
		Map<String,Object> resultMap = (Map<String, Object>) proposalMap.get("result");
		String proposalNo = (String) resultMap.get("proposalId");
		String billNo = (String) resultMap.get("tradeId");
		
		Map<String,Object> policyMap = JSON.parseObject(policyParam);
		Map<String,Object> reqMap = (Map<String, Object>) policyMap.get("req");
		reqMap.put("proposalNo", proposalNo);
		reqMap.put("billNo", billNo);
		String policyResult = JSONObject.toJSONString(policyMap);
		
		return policyResult;
	}
	
	public static boolean processStatus(String str){
		boolean result = false;
		try {
			Map<String,Object> map = JSON.parseObject(str); 
			String status = String.valueOf(map.get("code"));
			if("200".equals(status)){
				result =true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * token校验1.1.2 fastjson
	 * @param input
	 * @param key
	 * @return
	 */
	public static String changeTokenWeChat(String input, String key) {
		Map<String, Object> map = (Map<String, Object>) JSON.parse(input);
		String req = String.valueOf(map.get("req"));

		Map<String, Object> map1 = JSON.parseObject(req);
		Set<String> keySet = map1.keySet();
		List<String> li = new ArrayList<>();
		for (String string : keySet) {
			li.add(string);
		}
		Collections.sort(li);
		String req1 = "";
		for (int i = 0; i < li.size(); i++) {
			if (li.get(i).equals("applicantList")) {
				Object Object1 = map1.get("applicantList");
				JSONArray parseArray = JSON.parseArray(Object1.toString());
				for (int k = 0; k < parseArray.size(); k++) {
					Map<String, Object> app = (Map<String, Object>) parseArray.get(k);
					Set<String> keySet2 = app.keySet();
					List<String> list = new ArrayList<>();
					for (String string : keySet2) {
						list.add(string);
					}
					Collections.sort(list);
					for (int j = 0; j < list.size(); j++) {
						req1 += list.get(j) + app.get(list.get(j));
					}
				}
			} else if (li.get(i).equals("insuredList")) {
				Object Object1 = map1.get("insuredList");
				JSONArray parseArray = JSON.parseArray(Object1.toString());
				for (int k = 0; k < parseArray.size(); k++) {
					Map<String, Object> app = (Map<String, Object>) parseArray.get(k);
					Set<String> keySet2 = app.keySet();
					List<String> list = new ArrayList<>();
					for (String string : keySet2) {
						list.add(string);
					}
					Collections.sort(list);
					for (int j = 0; j < list.size(); j++) {
						req1 += list.get(j) + app.get(list.get(j));
					}
				}
			} else if (li.get(i).equals("profitpersonList")) {
				Object Object1 = map1.get("profitpersonList");
				JSONArray parseArray = JSON.parseArray(Object1.toString());
				for (int k = 0; k < parseArray.size(); k++) {
					Map<String, Object> app = (Map<String, Object>) parseArray.get(k);
					Set<String> keySet2 = app.keySet();
					List<String> list = new ArrayList<>();
					for (String string : keySet2) {
						list.add(string);
					}
					Collections.sort(list);
					for (int j = 0; j < list.size(); j++) {
						req1 += list.get(j) + app.get(list.get(j));
					}
				}
			} else if (li.get(i).equals("insureSubjectList")) {
				Object Object1 = map1.get("insureSubjectList");
				JSONArray parseArray = JSON.parseArray(Object1.toString());
				for (int k = 0; k < parseArray.size(); k++) {
					Map<String, Object> app = (Map<String, Object>) parseArray.get(k);
					Set<String> keySet2 = app.keySet();
					List<String> list = new ArrayList<>();
					for (String string : keySet2) {
						list.add(string);
					}
					Collections.sort(list);
					for (int j = 0; j < list.size(); j++) {
						req1 += list.get(j) + app.get(list.get(j));
					}
				}
			} else if (li.get(i).equals("itemPropertyList")) {
				Object Object1 = map1.get("itemPropertyList");
				JSONArray parseArray = JSON.parseArray(Object1.toString());
				for (int k = 0; k < parseArray.size(); k++) {
					Map<String, Object> app = (Map<String, Object>) parseArray.get(k);
					Set<String> keySet2 = app.keySet();
					List<String> list = new ArrayList<>();
					for (String string : keySet2) {
						list.add(string);
					}
					Collections.sort(list);
					for (int j = 0; j < list.size(); j++) {
						req1 += list.get(j) + app.get(list.get(j));
					}
				}
			} else if (li.get(i).equals("parameterMap")) {
				Map<String, Object> app = (Map<String, Object>) map1.get("parameterMap");
				Set<String> keySet2 = app.keySet();
				List<String> list = new ArrayList<>();
				for (String string : keySet2) {
					list.add(string);
			}
				Collections.sort(list);
				for (int j = 0; j < list.size(); j++) {
					req1 += list.get(j) + app.get(list.get(j));
				}
			} else {
				req1 += li.get(i) + map1.get(li.get(i));
			}
		}
		String token = Md5Encrypt.getMD5Mac(req1 + key, "utf-8");
		map.put("token", token);
		String result = JSON.toJSONString(map);
		return result;
	}
	
	/**
	 * 保单状态查询的加密报文
	 * @param input
	 * @param key
	 * @return
	 */
	public static String changeTokenToSmoke(String input, String key) {
		Map<String, Object> map = (Map<String, Object>) JSON.parse(input);
		String req = String.valueOf(map.get("req"));
		String token = Md5Encrypt.getMD5Mac(req + key, "utf-8");
		map.put("token", token);
		String result = JSON.toJSONString(map);
		return result;
	}
}
