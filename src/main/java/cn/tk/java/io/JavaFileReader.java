package cn.tk.java.io;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

public class JavaFileReader implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3552239600304882472L;

	public static Stream<File> getAllFiles(String dir){
		File rootFile = new File(dir);
		if(!rootFile.exists())
			throw new IllegalArgumentException("file is not exists");
		if(rootFile.isDirectory()){
			File[] fileLists = rootFile.listFiles((x,y)->(y.endsWith(".java") || x.isDirectory()));
			Stream<File> fl = Stream.of(fileLists);
			return fl.parallel()
					.map(x -> getAllFiles(x.getAbsolutePath()))
					.flatMap(x -> x);
			
		}else{
			return Stream.of(rootFile);
		}
	} 
	
	public static void javaFileDecorateAndMove(File f,String oldRootdir, String newRootDir, Charset charset){
		try{
			String javaFileString = FileUtils.readFileToString(f,charset);
			String decorated = FileDeconstructor.javaConvert(javaFileString);
			String newDir = f.getPath().replace(oldRootdir, newRootDir);
			System.out.println(newDir);
			FileUtils.write(new File(newDir), decorated, charset);
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}
	
	public static void allJavaFileDecorators(String javadir, String newRootDir, Charset charset){
		getAllFiles(javadir)
		.forEach(x -> javaFileDecorateAndMove(x, javadir, newRootDir, charset));
		
	}
	
	public static void main(String[] args) throws IOException{
		String javadir ="E:\\source_projects\\smalltest\\wechat_hera_center\\src";
		allJavaFileDecorators(javadir, "E:\\Test", Charset.forName("utf-8"));
	}
}
