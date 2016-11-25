package cn.tk.java.io.commonsIo;

import java.io.File;

import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: lijl85
 * @Title: FileFilterTest.java
 * @Package: cn.tk.java.io.commonsIo
 * @Time: 2016年10月13日下午1:39:19
 *
 * @description:文件过滤器
 */
public class FileFilterTest {
	private String basePath = null;
	
	@Before
	public void setUp()
	{
		basePath = "src/main/java/cn/tk/java/io/commonsIo/file/";
	}
	
	/**
	 * @description:过滤出所有非空文件
	 */
	@Test
	public void testEmptyFileFilter()
	{
		File dir = new File(basePath);
		String[] files = dir.list(EmptyFileFilter.NOT_EMPTY);
		for(String file : files)
		{
			System.out.println(file);
		}
	}
	
	/**
	 * @description:文件是否为空靠 length() 方法判断，返回文件所占字节数， 空文件为 0
	 */
	@Test
	public void testFileLength()
	{
		File aFile = new File(basePath + "src.txt");
		System.out.println(aFile.length());
		File bFile = new File(basePath + "dest.txt");
		System.out.println(bFile.length());
	}
}
