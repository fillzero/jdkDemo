package cn.tk.java.io;

import java.io.IOException;

import org.junit.Test;

public class BufferedInputFileTest {
	@Test
	public void testRead() throws IOException
	{
		System.out.println(BufferedInputFile.read("./src/main/java/cn/tk/java/io/MakeDirectories.java"));
	}
	
	@Test
	public void testRead2() throws IOException
	{
		BufferedInputFile.read2("./src/main/java/cn/tk/java/io/MakeDirectories.java");
	}
}
