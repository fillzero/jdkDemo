package cn.tk.java.nio;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import org.junit.Test;

import cn.tk.java.fastjson.JsonUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @description:Charset 使用事例
 */
public class CharsetDemo {
	@Test
	public void testCharset() throws CharacterCodingException
	{
		//Get Charset
		Charset charset = Charset.forName("UTF-8");
		
		//Encoder
		ByteBuffer inputData = charset.encode("李晋龙");
		
		//Decoder
		CharBuffer outputData = charset.decode(inputData);
		
		System.out.println(outputData);
	}
	
	@Test
	public void testCharsetEncoder() throws CharacterCodingException {
		//Get Charset
		Charset charset = Charset.forName("UTF-8");
		
		//编码器， 解码器
		CharsetEncoder encoder = charset.newEncoder();
		CharsetDecoder decoder = charset.newDecoder();
		
		//编码， 解码
		ByteBuffer inputData = encoder.encode(CharBuffer.wrap("李晋龙"));
		CharBuffer outputData = decoder.decode(inputData);
		
		//print
		System.out.println(outputData);
	}
	
	@Test
	public void testFastjsonCharset() throws UnsupportedEncodingException
	{
		JSONObject inputJson = new JSONObject(); 
		JsonUtil.setStringValue(inputJson, "name", "枫");
		System.out.println(inputJson.toJSONString());
		System.out.println(JSON.parse(inputJson.toJSONString().getBytes("UTF-8")));
	}
	
	@Test
	public void testWrongDemo()
	{
		Charset utf8 = Charset.forName("UTF-8");
		Charset iso8859 = Charset.forName("ISO-8859-1");
		Charset utf16 = Charset.forName("UTF-16");
		Charset gbk = Charset.forName("GBK");
		Charset gb2312 = Charset.forName("GB2312");
		
		ByteBuffer inputData0 = utf8.encode("邢振枫");
		ByteBuffer inputData = utf8.encode("邢振枫");
		ByteBuffer inputData1 = utf8.encode("邢振枫");
		ByteBuffer inputData2 = utf8.encode("邢振枫");
		ByteBuffer inputData3 = utf8.encode("邢振枫");
		CharBuffer outputData0 = utf8.decode(inputData0);
		CharBuffer outputData = iso8859.decode(inputData);
		CharBuffer outputData1 = utf16.decode(inputData1);
		CharBuffer outputData2 = gbk.decode(inputData2);
		CharBuffer outputData3 = gb2312.decode(inputData3);
		
		System.out.println("utf-8: " + outputData0);
		System.out.println("ios-8859-1: " + outputData);
		System.out.println("utf16: " + outputData1);
		System.out.println("gbk: " + outputData2);
		System.out.println("gb2312: " + outputData3);
	}
	
	@Test
	public void testUrlEncoder() throws UnsupportedEncodingException
	{
		String inputData = URLEncoder.encode("邢振枫", "utf-8");
		assertThat("邢振枫".getBytes("utf-8"), equalTo(inputData));
	}
	
	@Test
	public void testURLDecoder() throws UnsupportedEncodingException
	{
		String inputData = URLEncoder.encode("邢振枫", "utf-8");
		System.out.println("URLDncoder: " + inputData);
		assertThat(URLDecoder.decode(inputData, "utf-8"), equalTo("邢振枫"));
	}
	
	@Test
	public void testDecoder() throws UnsupportedEncodingException
	{
		//本地拼装 json
		JSONObject inputJson = new JSONObject();
		JsonUtil.setStringValue(inputJson, "name", "邢振枫");
		String utf8Data = JSON.parse(JSON.toJSONString(inputJson).getBytes("utf-8")).toString();
		System.out.println("本地入参: " + utf8Data);
		
		//网络传输
		Charset charset = Charset.forName("utf-8");
		ByteBuffer encode = charset.encode(utf8Data);
		CharBuffer outputData = charset.decode(encode);
		System.out.println("网络解析: " + outputData);
		
		System.out.println("URLDecoder 解析： " + URLDecoder.decode(outputData.toString(), "utf-8"));
	}
}
