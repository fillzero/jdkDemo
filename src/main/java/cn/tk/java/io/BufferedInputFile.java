package cn.tk.java.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class BufferedInputFile {
	/**
	 * @description:根据 filename 读文件内容
	 * 提供 readLine() 方法， 当读到 null 时就读到了文件的末尾。
	 * BufferedReader 会将文件暂存缓冲区
	 */
	public static String read(String filepath) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(filepath));
		String string;
		StringBuilder sBuilder = new StringBuilder();
		while((string = in.readLine()) != null)
			sBuilder.append(string + "\n");
		in.close();
		return sBuilder.toString();
	}
	
	/**
	 * @description:一个字符一个字符的读文件
	 */
	public static void read2(String filepath) throws IOException
	{
		StringReader in = new StringReader(BufferedInputFile.read(filepath));
		int c;
		while((c = in.read()) != -1)
			System.out.print((char)c);//强转很重要
	}
}
