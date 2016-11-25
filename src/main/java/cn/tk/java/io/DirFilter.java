package cn.tk.java.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @description:目录名称过滤器
 */
public class DirFilter implements FilenameFilter {
	
	private Pattern pattern;
	
	/**
	 * @Author: 李晋龙
	 * @Time: 2016年7月27日下午2:31:20
	 * @param regex: 正则表达式
	 * @description: 初始化的时候，传入正则表达式， 创建正则表达式匹配器
	 */
	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}

	/**
	 * @Author: 李晋龙
	 * @Time: 2016年7月27日下午2:31:54
	 * 
	 * @description:重载方法: accept 方法用于正则表达式的匹配， 选出满足条件的项， 返回布尔值
	 */
	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
}
