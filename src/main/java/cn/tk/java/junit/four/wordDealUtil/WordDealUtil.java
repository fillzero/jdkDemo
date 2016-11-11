package cn.tk.java.junit.four.wordDealUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordDealUtil {
	/**
	 * @Description:掌握正则表达式非终端添加和替换
	 * 1. 读字符串, 将读到的部分暂时放入字符缓冲区, 直到读到匹配的位置
	 * 2. 将匹配的部分与 replacement 进行替换
	 * 3. 从缓冲区读出暂时存入的字符串与替换后的部分合并, 生成新的字符串
	 * 
	 * 最后可以用  matcher.appendTail(sb) 用来复制剩余输入序列
	 * 
	 * appendReplacement(StringBuffer sb, String replacement)
	 * sb: 字符串缓冲区
	 * replacement: 替换字符串
	 */
	public static String wordFormat4DB(String name)
	{
		if(name == null)//处理 null 异常
		{
			return null;
		}
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher matcher = pattern.matcher(name);
		StringBuffer sb = new StringBuffer();
		while(matcher.find())
		{
			if(matcher.start()!=0)//处理首字母大写问题
				matcher.appendReplacement(sb, "_"+matcher.group());//替换添加
		}
		return matcher.appendTail(sb).toString().toLowerCase();
	}
}
