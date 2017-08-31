package cn.tk.java.util.ftpclient;

import cn.tk.java.util.date.DateUtils;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by lijinlong3 on 2017/8/28.
 */
public class FtpHelperTest {

    FtpHelper ftpHelper = new FtpHelperImpl();
    private final String date = DateUtils.date2Str(new Date(), DateUtils.yyyyMMdd);

    @Test
    public void testUpload() throws Exception {
        String localPath = "C:\\Users\\lijinlong3\\Desktop\\618.zip";
        String remotePath = "./" + date;
        ftpHelper.upload(localPath, remotePath);
    }

    @Test
    public void testDownLoad() throws Exception {
        String localPath = "C:\\Users\\lijinlong3\\Desktop\\620.zip";
        String remotePath = "./" + date;
        ftpHelper.downLoad(localPath, remotePath, "618.zip");
    }

    @Test
    public void testDelete() throws Exception {
        String remotePath = "./" + date;
        System.out.println(ftpHelper.delete(remotePath, false));

        remotePath += "/618.zip";
        System.out.println(ftpHelper.delete(remotePath, true));

        String remotePath2 = "./" + date;
        System.out.println(ftpHelper.delete(remotePath2, false));
    }

    @Test
    public void testRename() throws Exception {
        String remotePath = "./" + date;
        ftpHelper.rename(remotePath, "618.zip", "619.zip");
    }
}