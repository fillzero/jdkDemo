package cn.tk.java.io;

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
}
