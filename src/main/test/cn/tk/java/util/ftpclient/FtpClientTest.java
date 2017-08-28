package cn.tk.java.util.ftpclient;

import cn.tk.java.util.date.DateUtils;
import it.sauronsoftware.ftp4j.FTPClient;
import lombok.SneakyThrows;
import org.junit.Test;
import sun.net.ftp.FtpClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * Created by lijinlong3 on 2017/8/25.
 * Ftp4j: API 简单好理解，性能比较好
 *  upload(localFile)
 *  download(remoteFileName, localFile)
 *
 * Apache：remote 是文件名， local 是 I/O 流，API好理解，性能比较好，开源社区活跃
 *  storeFile(remote, local)
 *  retrieveFile(remote, local)
 *
 * JDK：API 较好理解，性能较差
 *  putFile(remote, local, true)
 *  getFile(remote, local)
 */
@SuppressWarnings("Duplicates")
public class FtpClientTest {

    private final String date = DateUtils.date2Str(new Date(), DateUtils.yyyyMMdd);

    /**
     * Description
     * 83M 数据
     * upload：13549ms
     * download：1409ms
     */
    @Test
    @SneakyThrows
    public void testFtp4jClient()
    {
        FTPClient client = Ftp4jClient.getClient();

        client.createDirectory("./" + date);
        client.changeDirectory("./" + date);

        long start = System.currentTimeMillis();
        client.upload(new File("C:\\Users\\lijinlong3\\Desktop\\618.zip"));
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    @Test
    @SneakyThrows
    public void testFtp4jDownLoad()
    {
        FTPClient client = Ftp4jClient.getClient();

        client.changeDirectory("./" + date);

        long start = System.currentTimeMillis();
        File localFile = new File("C:\\Users\\lijinlong3\\Desktop\\619.zip");
        client.download("618.zip", localFile);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    /**
     * Description
     * 83M 数据
     * upload：17726ms
     * download：1891ms
     */
    @Test
    @SneakyThrows
    public void testApacheUpload()
    {
        org.apache.commons.net.ftp.FTPClient client = FtpApacheClient.getClient();

        client.makeDirectory("./" + date);
        client.changeWorkingDirectory("./" + date);

        File file = new File("C:\\Users\\lijinlong3\\Desktop\\618.zip");
        FileInputStream fileInputStream = new FileInputStream(file);
        String remoteFileName = file.getName();

        long start = System.currentTimeMillis();
        client.storeFile(remoteFileName, fileInputStream);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    @Test
    @SneakyThrows
    public void testApacheDownLoad()
    {
        org.apache.commons.net.ftp.FTPClient client = FtpApacheClient.getClient();

        client.changeWorkingDirectory("./" + date);

        File file = new File("C:\\Users\\lijinlong3\\Desktop\\618.zip");
        String remoteFileName = file.getName();

        long start = System.currentTimeMillis();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\lijinlong3\\Desktop\\620.zip"));
        client.retrieveFile(remoteFileName, fileOutputStream);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    /**
     * Description:
     * upload：37511ms
     * download: 2152ms
     */
    @Test
    @SneakyThrows
    public void testJdkUpload()
    {
        FtpClient client = FtpJdkClient.getClient();

        client.makeDirectory("./" + date);

        File file = new File("C:\\Users\\lijinlong3\\Desktop\\618.zip");
        FileInputStream fileInputStream = new FileInputStream(file);
        String remoteFileName = file.getName();

        long start = System.currentTimeMillis();
        client.putFile("./" + date + "/" + remoteFileName, fileInputStream, true);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    @Test
    @SneakyThrows
    public void testJdkDownLoad()
    {
        FtpClient client = FtpJdkClient.getClient();

        client.changeDirectory("./" + date);
        File file = new File("C:\\Users\\lijinlong3\\Desktop\\618.zip");
        String remoteFileName = file.getName();

        long start = System.currentTimeMillis();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\lijinlong3\\Desktop\\620.zip"));
        client.getFile(remoteFileName, fileOutputStream);
        long end = System.currentTimeMillis();

        System.out.println(end - start + "ms");
    }
}