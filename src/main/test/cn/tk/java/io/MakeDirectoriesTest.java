package cn.tk.java.io;

import java.io.File;

import org.junit.Test;

public class MakeDirectoriesTest {
	@Test
	public void testFileData()
	{
		File old = new File("logs");
		File rname = new File("log");
		old.renameTo(rname);
		MakeDirectories.fileData(old);
		MakeDirectories.fileData(rname);
	}
}
