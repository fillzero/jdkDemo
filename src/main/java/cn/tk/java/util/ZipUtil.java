package cn.tk.java.util;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/9/4
 * Description: 压缩、解压缩工具类
 * （1）压缩
 * （2）解压缩
 */
public class ZipUtil {
    /**
     * Description：压缩文件（文件夹）
     * @param file 目标文件
     * @param zipPath 压缩文件路径
     *
     * 文件夹：压缩文件名为该文件夹，子文件文件名不变
     * 文件：压缩文件名为该文件
     */
    @SneakyThrows
    public static void compress(File file, String zipPath) {
        String rootPath = file.isFile() ? file.getParent() : file.getAbsolutePath();
        @Cleanup ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(zipPath)));
        List<String> entryNames = new ArrayList<>();
        getEntryNames(entryNames, rootPath, file);
        for (String entryName : entryNames) {
            int count, bufferLen = 1024;
            byte[] data = new byte[bufferLen];

            // name：子文件夹名 + separator + 文件的名字
            ZipEntry zipEntry = new ZipEntry(entryName);
            zos.putNextEntry(zipEntry);
            @Cleanup BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(rootPath + File.separator + entryName)));
            while ((count = bis.read(data, 0, bufferLen)) != -1)
            {
                zos.write(data, 0 , count);
            }
        }
    }

    /**
     * Description：解压文件（文件夹）
     * @param zipPath 压缩文件: *.zip
     * @param destPath 目标文件夹
     *
     * @note 解压是针对文件的，不是文件夹，不存在的文件夹要不断的创建。
     */
    @SneakyThrows
    public static void uncompress(String zipPath, String destPath, Charset charset)
    {
        File zipFile = new File(zipPath);

        File rootDir = new File(destPath);
        if (!rootDir.exists())
            rootDir.mkdirs();

        // 缺省 UTF-8 编码方式，entryName 都是 UTF-8 编码的
        ZipFile zip = new ZipFile(zipFile, charset);
        Enumeration<? extends ZipEntry> zipEntries = zip.entries();
        while (zipEntries.hasMoreElements()) {
            ZipEntry zipEntry = zipEntries.nextElement();
            String entryName = zipEntry.getName();

            // 级联创建子目录
            String outPath = createSubDir(destPath, entryName);
            if (outPath == null)
                continue;

            byte[] buffer = new byte[1024];
            @Cleanup InputStream in = zip.getInputStream(zipEntry);
            @Cleanup OutputStream os = new FileOutputStream(outPath);
            int count;
            while ((count = in.read(buffer)) > 0)
            {
                os.write(buffer, 0, count);
            }
        }
    }

    /**
     * Description：解压文件
     */
    @SneakyThrows
    public static void uncompress(byte[] data, String destPath, Charset charset)
    {
        // 字节数组转换成临时文件
        File zipFile = new File("./temp.zip");
        FileUtils.writeByteArrayToFile(zipFile, data);

        // 解压到指定 destPath
        uncompress("./temp.zip", destPath, charset);

        // 删除临时文件
        FileUtils.deleteQuietly(zipFile);
    }

    /**
     * Description：获取所有需要压缩的文件 entryName
     * @param entryNames 所有需要被压缩的元素
     * @param rootPath 根文件夹路径
     * @param file 根文件、文件夹
     */
    private static void getEntryNames(List<String> entryNames, String rootPath, File file)
    {
        if (file.isDirectory())
        {
            File[] files = file.listFiles();
            for (File childFile : files) {
                getEntryNames(entryNames, rootPath, childFile);
            }
        } else {
            String absolutePath = file.getAbsolutePath();
            int index = absolutePath.indexOf(rootPath);
            if (index != -1)
                entryNames.add(absolutePath.substring(rootPath.length() + File.separator.length()));
        }
    }

    /**
     * Description：根据 entryName 和 destPath 创建子目录，用于存放解压文件
     */
    private static String createSubDir(String rootPath, String entryName) {
        String outPath = (rootPath + File.separator + entryName).replaceAll("\\\\", "/");
        int endIndex = outPath.lastIndexOf("/");

        // 解压文件所在的文件夹
        String unZipDirPath = outPath.substring(0, endIndex);
        File unZipDir = new File(unZipDirPath);
        if (!unZipDir.exists())
        {
            unZipDir.mkdirs();
        }
        if (new File(outPath).isDirectory()){
            return null;
        }
        return outPath;
    }
}
