package cn.tk.java.io.commonsIo.image.thumbnailator;

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
import net.coobird.thumbnailator.Thumbnails;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ThumbnailUtil {
	private static final Map<String, String> formatMap = new HashMap<String, String>();

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

	public static void resize(String filePath, String outputPath, int height, int width, String format)
	{
		try {
			InputStream inputStream = new FileInputStream(new File(filePath));
			Thumbnails.of(inputStream)
			    .size(height, width)
			    .outputFormat(format)
			    .toFile(new File(outputPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description: 字符串进行Base64解码并生成图片, 过滤 data:image/png;base64,
	 */
	public static boolean generateImage(String base64Str, String filePath) {

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
		String imageFormat = getImageFormat(filePath);
		return imageFormat + encoder.encode(data);
	}

	/**
	 * @Description: 获取文件图片类型, 加密图片加上样式
	 * 图片格式：
	 * png： data:image/png;base64,
	 * jpg： data:image/jpeg;base64,
	 * gif: data:image/gif;base64,
	 * bmp: data:image/bmp;base64,
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
	        return formatMap.get(formatName);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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
}
