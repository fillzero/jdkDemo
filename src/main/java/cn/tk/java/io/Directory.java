package cn.tk.java.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @description:目录实用工具
 */
public class Directory {
	/**
	 * @Param：File dir: 指定的目录
	 * @description:通过正则表达式过滤返回指定目录下的所有文件和文件夹， list() 方法只是返回文件名， listFiles() 是返回文件对象
	 */
	public static File[] local(File dir, final String regex)
	{
		return dir.listFiles(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}
	
	/**
	 * @Param：String path： 指定目录的所在路径
	 */
	public static File[] local(String path, final String regex)
	{
		return local(new File(path), regex);
	}
	
	/**
	 * @description:新建数据结构， 用于显示目录下的所有文件和所有文件夹
	 */
	public static class TreeInfo implements Iterable<File>{
		public List<File> files = new ArrayList<File>();//所有文件
		public List<File> dirs = new ArrayList<File>();//所有文件夹
		
		@Override
		public Iterator<File> iterator() {
			return files.iterator();
		}
		
		void addAll(TreeInfo other)
		{
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}

		@Override
		public String toString() {
			return "TreeInfo [files=" + files + ", dirs=" + dirs + "]";
		}
	}
	
	public static TreeInfo walk(String start, String regex)
	{
		return recurseDirs(new File(start), regex);
	}
	
	public static TreeInfo walk(String start)
	{
		return recurseDirs(new File(start), ".*");
	}
	
	public static TreeInfo walk(File start, String regex)
	{
		return recurseDirs(start, regex);
	}
	
	public static TreeInfo walk(File start)
	{
		return recurseDirs(start, ".*");
	}

	/**
	 * @description: 递归方法， 获取一个目录下的所有文件和文件夹（形成一个巨大的树形结构）
	 */
	static TreeInfo recurseDirs(File startDir, String regex) {
		TreeInfo fileTree = new TreeInfo();
		for(File item : startDir.listFiles())
		{
			if (item.isDirectory()) {
				fileTree.dirs.add(item);
				fileTree.addAll(recurseDirs(item, regex));//目录需要递归遍历
			}else {
				if (item.getName().matches(regex)) {
					fileTree.files.add(item);
				}
			}
		}
		return fileTree;
	}
}
