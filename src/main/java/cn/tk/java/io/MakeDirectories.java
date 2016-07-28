package cn.tk.java.io;

import java.io.File;

public class MakeDirectories {
	public static void fileData(File file)
	{
		System.out.println("Absolute path: " + file.getAbsolutePath());
		System.out.println("Can read: " + file.canRead());
		System.out.println("Can write: " + file.canWrite());
		System.out.println("getName: " + file.getName());
		System.out.println("getParrent: " + file.getParent());
		System.out.println("getPath: " + file.getPath());
		System.out.println("length: " + file.length());
		System.out.println("lastModified: " + file.lastModified());
		if (file.isFile()) {
			System.out.println("It's a file");
		}else if (file.isDirectory()) {
			System.out.println("It's a directory");
		}
	}
}
