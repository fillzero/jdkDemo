package cn.tk.java.io.commonsIo;

import java.io.File;

import org.apache.commons.io.comparator.CompositeFileComparator;
import org.apache.commons.io.comparator.DirectoryFileComparator;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.io.comparator.PathFileComparator;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: lijl85
 * @Title: ComparatorTest.java
 * @Package: cn.tk.java.io.commonsIo
 * @Time: 2016年10月13日下午1:40:14
 *
 * @description:文件比较器
 */
public class ComparatorTest {
	private String basePath = null;
	
	@Before
	public void setUp()
	{
		basePath = "src/main/java/cn/tk/java/io/commonsIo/file/";
	}
	
	/**
	 * @description: 文件名称比较器
	 */
	@Test
	public void testNameFileComparator()
	{
		File aFile = new File(basePath + "src.txt");
		File bFile = new File(basePath + "dest.txt");
		int result = NameFileComparator.NAME_COMPARATOR.compare(aFile, bFile);
		System.out.println(result);
	}
	
	/**
	 * @description: 文件路径比较器
	 */
	@Test
	public void testPathFileComparator()
	{
		File aFile = new File(basePath + "src.txt");
		File bFile = new File(basePath + "dest.txt");
		int result = PathFileComparator.PATH_COMPARATOR.compare(aFile, bFile);
		System.out.println(result);
	}
	
	/**
	 * @description: 组合比较器
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCompositeFileComparator()
	{
		File dir = new File(basePath);
		File[] files = dir.listFiles();
		for(File file : files)
		{
			System.out.println(file.getName());
		}
		CompositeFileComparator cfc = new CompositeFileComparator(DirectoryFileComparator.DIRECTORY_COMPARATOR, NameFileComparator.NAME_COMPARATOR);
		cfc.sort(files);
		System.out.println("************* After Sorted! **************");
		for(File file : files)
		{
			System.out.println(file.getName());
		}
	}
}
