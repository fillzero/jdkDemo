package cn.tk.java.io.commonsIo.image.thumbnailator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @Author: lijl85
 * @Title: ThumbnailUtil.java
 * @Package: cn.tk.java.io.commonsIo.image.thumbnailator
 * @Time: 2016年11月10日下午2:34:32
 *
 * @Description:图片处理类
 * 1. resize, resizeByScale: 生成缩略图: 按大小尺寸, 按比例
 * 2. watermark: 加水印
 * 3. rotate: 旋转
 * 4. writeToDirectoryWithCustomPrefix, writeToDirectoryWithCustomSuffix: 写入文件夹
 * 5. decodeImage: 图片解密, 去除 Base64前缀, 创建图片, 保存
 * 6. encoderImage: 图片加密生成 Base64, 加Base64前缀, 可以直接放到 img标签中使用
 * 7. getImageFormat: 获取图片格式
 * 8. getFormatBase64: 获取图片Base64前缀
 */
public class ThumbnailUtil {
	private static final Map<String, String> formatMap = new HashMap<String, String>();//<图片格式, 格式Base64前缀>

	static{
		formatMap.put(Format.PNG.format, Format.PNG.baseStr);
		formatMap.put(Format.JPEG.format, Format.JPEG.baseStr);
		formatMap.put(Format.GIF.format, Format.GIF.baseStr);
		formatMap.put(Format.BMP.format, Format.BMP.baseStr);
	}

	/**
	 * @Description: 图片样式
	 * png： data:image/png;base64,
	 * jpg： data:image/jpeg;base64,
	 * gif: data:image/gif;base64,
	 * bmp: data:image/bmp;base64,
	 */
	public enum Format{
		PNG("png", "data:image/png;base64,", 22),
		JPEG("jpeg", "data:image/jpeg;base64,", 23),
		GIF("gif", "data:image/gif;base64,", 22),
		BMP("bmp", "data:image/bmp;base64,", 22);
		@Getter @Setter private String format;
		@Getter @Setter private String baseStr;
		@Getter @Setter private int length;
		private Format(String format, String baseStr, int length) {
			this.format = format;
			this.baseStr = baseStr;
			this.length = length;
		}
	}

	/**
	 * @Description: 按尺寸缩略, 缩略后格式不变
	 * @param filePath: 输入图片
	 * @param outputPath: 输出图片
	 * @param height: 高度
	 * @param width: 宽度
	 */
	public static void resize(String filePath, String destPath, int height, int width)
	{
		try {
			String format = getImageFormat(filePath);//获取原图格式
			@Cleanup InputStream inputStream = new FileInputStream(new File(filePath));
			Thumbnails.of(inputStream)
			    .size(height, width)
			    .outputFormat(format)
			    .toFile(new File(destPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description:按比例缩略
	 */
	public static void resizeByScale(String filePath, String destPath, double scale)
	{
		try {
			String format = getImageFormat(filePath);
			@Cleanup InputStream inputStream = new FileInputStream(new File(filePath));
			Thumbnails.of(inputStream)
				.scale(scale)
			    .outputFormat(format)
			    .toFile(new File(destPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description:按高度和比例缩略
	 */
	public static void resizeByHeight(String filePath, String destPath, int width)
	{
		try {
			BufferedImage read = ImageIO.read(new File(filePath));
			double scale = Double.valueOf(width) / Double.valueOf(read.getWidth());
			String format = getImageFormat(filePath);
			@Cleanup InputStream inputStream = new FileInputStream(new File(filePath));
			Thumbnails.of(inputStream)
				.scale(scale)
			    .outputFormat(format)
			    .toFile(new File(destPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description:添加水印
	 * @param filePath: 原图
	 * @param waterMarkPath: 水印图片
	 * @param opacity: 透明度
	 */
	public static void watermark(String filePath, String waterMarkPath, Positions positions, float opacity)
	{
		try {
			String format = getImageFormat(filePath);
			@Cleanup InputStream inputStream = new FileInputStream(new File(filePath));
			Thumbnails.of(inputStream)
				.scale(1)
				.watermark(positions, ImageIO.read(new File(waterMarkPath)), opacity)
			    .outputFormat(format)
			    .toFile(new File(filePath + "-with-watermark"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description: 旋转
	 */
	public static void rotate(String filePath, double angle)
	{
		try {
			String format = getImageFormat(filePath);
			if (format.equals("jpeg")) {
				format = "jpg";
			}
			@Cleanup InputStream inputStream = new FileInputStream(new File(filePath));
			String fileName = filePath.substring(0, filePath.indexOf("." + format));
			Thumbnails.of(inputStream)
				.scale(1)
				.rotate(angle)
			    .outputFormat(format)
			    .toFile(new File(fileName + "-with-rotate." + format));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description: 文件集写入文件夹
	 * @param noChange: 名字是否改变
	 * @param prefix: 文件名统一增加前缀
	 * @param directoryPath: 文件夹名
	 * @param filePaths: 文件集
	 */
	public static void writeToDirectoryWithCustomPrefix(boolean noChange, String prefix, String directoryPath, String ... filePaths)
	{
		try {
			File directory = new File(directoryPath);
			if (!directory.exists()) {
				directory.mkdir();
			}
			if (noChange) {
				Thumbnails.of(filePaths)
				.scale(1)
				.toFiles(directory, Rename.NO_CHANGE);
			}else {
				Thumbnails.of(filePaths)
				.scale(1)
				.toFiles(directory, getCustomPrefix(prefix));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @Description: 文件集写入文件夹
	 * @param noChange: 名字是否改变
	 * @param prefix: 文件名统一增加后缀
	 * @param directoryPath: 文件夹名
	 * @param filePaths: 文件集
	 */
	public static void writeToDirectoryWithCustomSuffix(boolean noChange, String suffix, String directoryPath, String ... filePaths)
	{
		try {
			File directory = new File(directoryPath);
			if (!directory.exists()) {
				directory.mkdir();
			}
			if (noChange) {
				Thumbnails.of(filePaths)
				.scale(1)
				.toFiles(directory, Rename.NO_CHANGE);
			}else {
				Thumbnails.of(filePaths)
				.scale(1)
				.toFiles(directory, getCustomSuffix(suffix));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description: 字符串进行Base64解码并生成图片, 过滤 data:image/png;base64,
	 */
	public static boolean decodeImage(String base64Str, String filePath) {

        if (base64Str == null) //图像数据为空
            return false;
        base64Str = deleteFormat(base64Str);
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            byte[] b = decoder.decodeBuffer(base64Str);//Base64解码
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {
                    b[i]+=256;//调整异常数据
                }
            }
            @Cleanup OutputStream out = new FileOutputStream(filePath);
            out.write(b);
            out.flush();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
	}

	/**
	 * @Description: 根据图片地址转换为base64编码字符串
	 * 字符串最前面加上： "data:image/png;base64," 方便 img 标签直接使用
	 */
	public static String encoderImage(String filePath) {

		InputStream inputStream = null;
		byte[] data = null;
		try {
			inputStream = new FileInputStream(filePath);
			data = new byte[inputStream.available()];
			inputStream.read(data);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BASE64Encoder encoder = new BASE64Encoder();
		String imageFormat = getFormatBase64(filePath);
		return imageFormat + encoder.encode(data);
	}

	/**
	 * @Description: 获取文件图片类型, 加密图片加上样式

	 */
	public static String getImageFormat(String filePath) {
        File file = new File(filePath);
        ImageInputStream imageStream;
		try {
			imageStream = ImageIO.createImageInputStream(file);
	        Iterator<ImageReader> iterator = ImageIO.getImageReaders(imageStream);
	        if (!iterator.hasNext()) {
	            throw new RuntimeException("无法识别的图片格式！");
	        }
	        ImageReader reader = iterator.next();
	        imageStream.close();
	        String formatName = reader.getFormatName().toLowerCase();
	        return formatName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Description:获取 Base64 图片字符串前缀
	 * @return: 图片格式
	 * png： data:image/png;base64,
	 * jpg： data:image/jpeg;base64,
	 * gif: data:image/gif;base64,
	 * bmp: data:image/bmp;base64,
	 */
	public static String getFormatBase64(String formatName)
	{
		return formatMap.get(getImageFormat(formatName));
	}

	/**
	 * @Description: 解密的时候需要将样式截取掉
	 */
	public static String deleteFormat(String base64Str) {
		Format[] values = Format.values();
		for (Format format : values) {
			if (base64Str.startsWith(format.baseStr)) {
				return base64Str.substring(format.length);
			}
		}
		return null;
	}
	
	/**
	 * @Description: 匿名类实现定制化前缀
	 */
	public static Rename getCustomPrefix(String prefix)
	{
		return new Rename(){
			@Override
			public String apply(String name, ThumbnailParameter param) {
				return appendPrefix(name, prefix);
			}
		};
	}
	
	/**
	 * @Description: 普通内部类实现定制化后缀, 改变文件后缀名, 先去除之前后缀, 变成新的后缀
	 */
	public static Rename getCustomSuffix(String suffix)
	{
		return new SuffixRename(suffix);
	}
	private static class SuffixRename extends Rename{
		
		private String suffix;
		public SuffixRename(String suffix) {
			this.suffix = suffix;
		}
		
		@Override
		public String apply(String name, ThumbnailParameter param) {
			return appendSuffix(name, suffix);
		}
	}
}
