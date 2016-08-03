package cn.tk.java.util;

import java.util.HashMap;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;

public class OauthGenerater
{
	private static final String oauthUrl = "https://open.weixin.qq.com/connect/oauth2/authorize"
			+ "?appid=wxcd7143c00e5bb6f7&redirect_uri=http://wxpt.taikang.com/tkmap/wechat/oauth2/safeRedirect/wxcd7143c00e5bb6f7"
			+ "?other=###&response_type=code&scope=snsapi_base&state=tkonline#wechat_redirect";
	
    /**
     * @Description:获取 oauth 链接
     */
    public String makeOauthUrl(String url)
    {
		try
		{
			url = Base64.encodeBase64URLSafeString(url.getBytes());
			url = oauthUrl.replace("###", url);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return url;
    }
    
    /**
     * @Description:获取 oauth 链接
     */
    public JSONObject getShareUrl(HashMap<String, String> map)
	{
		JSONObject jsonResult=null;
		String url = map.get("url");
		//判断url是否为空 
    	if(Strings.isNullOrEmpty(url))
    	{
    		System.out.println("url 不能为空");
    	}
    	//调用微信接口
		try{
			url = Base64.encodeBase64URLSafeString(url.getBytes());//url编码
			url = oauthUrl.replace("###", url);
			jsonResult= new JSONObject();
			jsonResult.put("oauthUrl", url);
		}catch(Exception e){
			System.out.println("调用微信接口异常");
		}
		return jsonResult;
	}
    
    /**
     * @Description:替换一下就好了
     */
    @Test
    public void testOauth()
    {
    	System.out.println(makeOauthUrl("www.baidu.com"));
    }
}
