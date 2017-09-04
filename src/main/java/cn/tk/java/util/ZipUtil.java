package cn.tk.java.util;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
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
     *
     */
    @SneakyThrows
    public static void compress(File file, String zipPath) {
        String rootPath = file.isFile() ? file.getPath() : file.getParent();
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

    @SneakyThrows
    public static void main(String[] args) {
//        File file = new File("C:\\Users\\lijinlong3\\Desktop\\zipfile");
//        String zipPath = "C:\\Users\\lijinlong3\\Desktop\\zipfile.zip";
//        compress(file, zipPath);

        File file1 = new File("C:\\Users\\lijinlong3\\Desktop\\618");
        String zipPath1 = "C:\\Users\\lijinlong3\\Desktop\\618.zip";
//        compress(file1, zipPath1);

        uncompress(new File(zipPath1), file1);
    }

    /**
     * Description：解压文件（文件夹）
     * @param zipFile 文件类型
     *
     * @note 解压是针对文件的，不是文件夹，不存在的文件夹要不断的创建。
     */
    @SneakyThrows
    public static void uncompress(File zipFile, File srcFile)
    {
        if (!srcFile.exists())
            srcFile.mkdirs();

        ZipFile zip = new ZipFile(zipFile);
        for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements();){
            ZipEntry zipEntry = entries.nextElement();
            String entryName = zipEntry.getName();
            @Cleanup InputStream in = zip.getInputStream(zipEntry);
            String outPath = (srcFile.getAbsolutePath() + File.separator + entryName);
            int endIndex = outPath.lastIndexOf(File.separator);
            String substring = outPath.substring(0, endIndex);
            File file = new File(substring);
            if (!file.exists())
            {
                file.mkdirs();
            }

            if (new File(outPath).isDirectory()){
                continue;
            }

            byte[] buffer = new byte[1024];
            @Cleanup OutputStream os = new FileOutputStream(outPath);
            int count;
            while ((count = in.read(buffer)) > 0)
            {
                os.write(buffer, 0, count);
            }
        }
    }

    /**
     * Description：解压文件（文件夹）
     * @param data 字节数组
     * @param
     */
//    @SneakyThrows
//    public static File uncompress(byte[] data, File srcFile)
//    {
//        if (!srcFile.exists())
//            srcFile.mkdir();
//
//
//
//    }
}
