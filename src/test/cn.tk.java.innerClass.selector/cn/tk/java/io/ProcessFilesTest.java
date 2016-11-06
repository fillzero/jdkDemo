package cn.tk.java.io;

import java.io.File;

public class ProcessFilesTest {
	/**
	 * @Description: 打印根目录下所有的 java 文件
	 */
	public static void main(String[] args)
	{
		new ProcessFiles(new ProcessFiles.Strategy() {
			@Override
			public void process(File file) {
				System.out.println(file);
			}
		}, "java").start(args);
	}
}
