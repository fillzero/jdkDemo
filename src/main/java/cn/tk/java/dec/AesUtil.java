package cn.tk.java.dec;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/** 
 * 高级加密标准
 */
public class AesUtil
{
	/**
	 * 加密
	 */
	public static String encrypt(String str, String key) throws Exception
	{
		if (str == null || key == null)
			return null;
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"));
		byte[] bytes = cipher.doFinal(str.getBytes("utf-8"));
		return new String(new Base64().encode(bytes));
	}

	/**
	 * 解密
	 */
	public static String decrypt(String str, String key) throws Exception
	{
		if (str == null || key == null)
			return null;
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"));
		byte[] bytes = new Base64().decode(str);
		bytes = cipher.doFinal(bytes);
		return new String(bytes, "utf-8");
	}
}
