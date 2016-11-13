package cn.tk.java.io;

import java.io.File;

import org.junit.Test;

public class DirectoryTest {
	
	/**
	 * @Description: local 方法根据正则表达式过滤指定目录下的文件和文件夹
	 */
	@Test
	public void testLocal() {
		File[] localFiles = Directory.local(".", ".*");
		for(File item : localFiles)
		{
			System.out.println(item.getName());
		}
	}
		
	@Test
	public void testWalk()
	{
		System.out.println(Directory.walk(".git"));
	}
}
