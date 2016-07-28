package cn.tk.java.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Description: 目录列表器代码
 */
public class DirList {
	
	/**
	 * @Description: 直接打印给定路径的所有文件名
	 */
	public void printDirs(String directoryPath)
	{
		File directory = new File(directoryPath);
		String[] files = directory.list();
		for (String fileName : files) {
			System.out.print(fileName+", ");
		}
		System.out.println();
	}
	
	/**
	 * @Description:directory.list(new DirFilter(regex));
	 * 使用回调机制： directory.list(filter)
	 * 里面调用了 filter.accept()
	 * 
	 * list 调用 filter 进行过滤，  filter 使用 accept() 反过来影响 list, 对 list 进行过滤
	 * 
	 * 参数是 Filter 接口: 意味着我们可以传入任何实现 Filter 接口的类实例， 每一种实现代表了一种策略， 提高代码灵活性。
	 * 
	 * 接口只有一个方法  boolean accept(File dir, String name); 用语判断是否满足过滤器要求
	 */
	public void printDirsWithFilter(String regex, String directoryPath) {
		File directory = new File(directoryPath);
		String[] files = directory.list(new DirFilter(regex));//挑选出满足 filter 条件的项生成新的数组
		Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);//按字典排序
		for (String fileName : files) {
			System.out.print(fileName+", ");
		}
		System.out.println();
	}
	
	public static FilenameFilter filter(final String regex){
		return new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		};
	}
	
	/**
	 * @Description:使用匿名内部类实现过滤器
	 */
	public void printDirsWithFilter2(String regex, String directoryPath) {
		File directory = new File(directoryPath);
		String[] files = directory.list(filter(regex));
		Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
		for (String fileName : files) {
			System.out.print(fileName+", ");
		}
		System.out.println();
	}
	
	/**
	 * @Description:使用匿名内部类实现过滤器, 进一步简化代码
	 * directory.list()， 参数是一个指向 FilenameFilter 或其实现类的引用
	 */
	public void printDirsWithFilter3(String regex, String directoryPath)
	{
		File directory = new File(directoryPath);
		String[] files = directory.list(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		});
		Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
		for (String fileName : files) {
			System.out.print(fileName+", ");
		}
		System.out.println();
	}
}
