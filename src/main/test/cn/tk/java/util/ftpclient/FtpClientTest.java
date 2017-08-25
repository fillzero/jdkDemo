package cn.tk.java.util.ftpclient;

import cn.tk.java.util.date.DateUtils;
import it.sauronsoftware.ftp4j.FTPClient;
import lombok.SneakyThrows;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by lijinlong3 on 2017/8/25.
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
        String currentDirectory = client.currentDirectory();
        System.out.println(currentDirectory);

        client.createDirectory("./" + date);
        client.changeDirectory("./" + date);


        long start = System.currentTimeMillis();
        client.upload(new File("C:\\Users\\lijinlong3\\Desktop\\618.zip"));

//        File localFile = new File("C:\\Users\\lijinlong3\\Desktop\\619.zip");
//        client.download("618.zip", localFile);
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
    public void testFtpApacheClient()
    {
        org.apache.commons.net.ftp.FTPClient client = FtpApacheClient.getClient();
        System.out.println("Passive Host: " + client.getPassiveHost() + ", Port:" + client.getPassivePort());

        client.makeDirectory("./" + date);
        client.changeWorkingDirectory("./" + date);

        File file = new File("C:\\Users\\lijinlong3\\Desktop\\618.zip");
        FileInputStream fileInputStream = new FileInputStream(file);
        String remoteFileName = file.getName();

        long start = System.currentTimeMillis();
        client.storeFile(remoteFileName, fileInputStream);
//        FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\lijinlong3\\Desktop\\620.zip"));
//        client.retrieveFile(remoteFileName, fileOutputStream);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    @Test
    public void testFtpJdkClient()
    {

    }
}