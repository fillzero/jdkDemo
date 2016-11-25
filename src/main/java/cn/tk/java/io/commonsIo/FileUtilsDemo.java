package cn.tk.java.io.commonsIo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: lijl85
 * @Title: FileUtilsDemo.java
 * @Package: cn.tk.java.io.commonsIo
 * @Time: 2016年10月13日上午10:24:59
 *
 * @description: 工具类
 * FileUtils
 * IOUtils
 * FilenameUtils
 * FileSystemUtils
 * 
 * 文件操作： 拷贝(源文件不变), 移动(删除源文件，创建新文件), 删除(文件，目录)
 * 内容操作： 读文件， 写文件(重写、追加内容)， 比较文件
 */
public class FileUtilsDemo {
	private String basePath = null;
	
	@Before
	public void setUp()
	{
		basePath = "src/main/java/cn/tk/java/io/commonsIo/file/";
	}
	
	/**
	 * @description:拷贝文件
	 */
	@Test
	public void testCopy() throws IOException
	{
		File srcFile = new File(basePath + "src.txt");
		File destFile = new File(basePath + "dest.txt");
		FileUtils.copyFile(srcFile, destFile);
	}
	
	/**
	 * @description:删除文件
	 */
	@Test
	public void testDelete() throws IOException
	{
		File delFile = new File(basePath + "dest.txt");
		FileUtils.forceDelete(delFile);
//		FileUtils.forceMkdir(delFile);
	}
	@Test
	public void testDeleteDir() throws IOException
	{
		File delDir = new File(basePath + "file");
		FileUtils.deleteQuietly(delDir);
		FileUtils.deleteDirectory(delDir);
	}
	
	/**
	 * @description:移动文件
	 */
	@Test
	public void testMoveFile() throws IOException
	{
		File srcFile = new File(basePath + "src.txt");
		File destDir = new File(basePath + "move");
		FileUtils.moveToDirectory(srcFile, destDir, true);
	}
	
	/**
	 * @description:读文件
	 */
	@Test
	public void testRead() throws IOException
	{
		File srcFile = new File(basePath + "src.txt");
		String contents = FileUtils.readFileToString(srcFile, "UTF-8");
		System.out.println(contents);
		FileUtils.readFileToString(srcFile, Charset.forName("UTF-8"));
		System.out.println(contents);
	}
	
	/**
	 * @description:写文件
	 */
	@Test
	public void testWrite() throws IOException
	{
		File destFile = new File(basePath + "dest.txt");
		FileUtils.writeStringToFile(destFile, "\nnew: lijinlong", "UTF-8", true);
	}
	
	/**
	 * @description:比较文件内容
	 */
	@Test
	public void testCompareFile() throws IOException
	{
		File srcFile = new File(basePath + "src.txt");
		File destFile = new File(basePath + "dest.txt");
		boolean result = FileUtils.contentEquals(srcFile, destFile);
		System.out.println(result);
	}
	
	@Test
	public void testFreeSpace() throws IOException
	{
		System.out.println(FileSystemUtils.freeSpaceKb("F:")/1024/1024 + "G");
		System.out.println(FileSystemUtils.freeSpaceKb("D:")/1024/1024 + "G");
	}
	
	@Test
	public void testReadFileToList() throws IOException
	{
		File srcFile = new File(basePath + "src.txt");
		List<String> listContents = FileUtils.readLines(srcFile, "UTF-8");
		for(String line : listContents)
		{
			System.out.println(line);
		}
	}
}
