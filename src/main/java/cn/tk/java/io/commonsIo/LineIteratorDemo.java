package cn.tk.java.io.commonsIo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: lijl85
 * @Title: LineIteratorDemo.java
 * @Package: cn.tk.java.io.commonsIo
 * @Time: 2016年10月13日下午1:39:37
 *
 * @description:文件行迭代器
 */
public class LineIteratorDemo {
	private String basePath = null;
	
	@Before
	public void setUp()
	{
		basePath = "src/main/java/cn/tk/java/io/commonsIo/file/";
	}
	
	/**
	 * @description: 文件行迭代器
	 */
	@Test
	public void testIterator() throws IOException
	{
		File file = new File(basePath + "src.txt");
		LineIterator lineIterator = FileUtils.lineIterator(file);
		while(lineIterator.hasNext())
		{
			System.out.println(lineIterator.nextLine());
		}
		LineIterator.closeQuietly(lineIterator);
	}
}
