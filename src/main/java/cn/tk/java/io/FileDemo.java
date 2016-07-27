package cn.tk.java.io;

import java.io.File;

import org.junit.Test;

public class FileDemo {
	/**
	 * @Description:找根路径方法
	 */
	@Test
	public void testCreateFile()
	{
		File file = new File("");
		System.out.println(file.getAbsolutePath());
	}
}
