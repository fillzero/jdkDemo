package cn.tk.java.io;

import java.io.File;
import java.io.IOException;

/**
 * @description:查找指定目录下 指定扩展名的所有文件
 * 使用指定的策略在目录中穿梭
 */
public class ProcessFiles {
	/**
	 * @description: 内部接口， 要实现这个接口必须先继承 ProcessFiles
	 */
	public interface Strategy{
		void process(File file);
	}
	
	private Strategy strategy;
	
	private String ext;//指定扩展名
	
	public ProcessFiles(Strategy strategy, String ext)
	{
		this.strategy = strategy;
		this.ext = ext;
	}
	
	public void start(String[] args)
	{
		try {
			if(args.length == 0)
				processDirectoryTree(new File("."));
			else {
				for(String arg : args)
				{
					File fileArg = new File(arg);
					if(fileArg.isDirectory())
						processDirectoryTree(fileArg);
					else {
						if (!arg.endsWith("." + ext)) {
							arg += "." + ext;
						}
						strategy.process(new File(arg).getCanonicalFile());
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @description:java 中 \\ 表示反义字符， \\.ext 表示相对应的扩展名
	 */
	public void processDirectoryTree(File root) throws IOException {
		for(File file : Directory.walk(root.getAbsoluteFile(), ".*\\." + ext))
			strategy.process(file.getCanonicalFile());
	}
}
