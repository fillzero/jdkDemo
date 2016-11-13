package cn.tk.java.io;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class DirListTest {
	@Test
	public void testPrintDirs(){
		DirList dirList = new DirList();
		System.out.println("工程根目录：");
		dirList.printDirs(".");
		System.out.println("磁盘根目录：");
		dirList.printDirs("/");
	}

	@Test
	public void testPrintDirsWithFilter()
	{
		DirList dirList = new DirList();
		dirList.printDirsWithFilter("./.[c]*", ".");
	}
	
	/**
	 * @Description: 
	 */
	@Test
	public void testPrintDirsWithFilter2()
	{
		DirList dirList = new DirList();
		dirList.printDirsWithFilter2(".*", ".");
	}
	
	@Test
	public void testPrintDirsWithFilter3()
	{
		DirList dirList = new DirList();
		dirList.printDirsWithFilter3(".*", ".");
	}
	
	@Test
	public void testCanonicalFile() throws IOException
	{
		File file = new File(".");
		System.out.println(file.getCanonicalPath());
		System.out.println(new File(file.getCanonicalPath())); 
		System.out.println(file.getCanonicalFile());
		System.out.println(file.getAbsolutePath());
	}
}
