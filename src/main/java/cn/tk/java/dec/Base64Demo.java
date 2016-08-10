package cn.tk.java.dec;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class Base64Demo {
	public String encode(String url)
	{
		url = Base64.encodeBase64URLSafeString(url.getBytes());
		return url;
	}
	
	public String decode(String encode)
	{
		byte[] url = Base64.decodeBase64(encode);
		return String.valueOf(url);
	}
	
	@Test
	public void testBase64()
	{
		String encode = encode("weit.taikang.com?openid=1234&timestamp=123412341&sign=QD1231KLSJDF");
		System.out.println(encode);
	}
	
	
}
