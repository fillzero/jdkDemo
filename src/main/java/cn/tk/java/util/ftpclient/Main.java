package cn.tk.java.util.ftpclient;

import cn.tk.java.util.date.DateUtils;
import com.alibaba.fastjson.JSONObject;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPConnector;
import it.sauronsoftware.ftp4j.FTPFile;
import lombok.SneakyThrows;

import java.io.File;
import java.util.Date;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/8/23
 * Description:
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {

        FTPClient client = Ftp4jClient.getClient();

        String currentDirectory = client.currentDirectory();
        System.out.println(currentDirectory);
        String date = DateUtils.date2Str(new Date(), DateUtils.yyyyMMdd);
        client.createDirectory("./" + date);
        client.changeDirectory("./" + date);
        client.setType(FTPClient.TYPE_BINARY);
        FTPFile[] list = client.list();
        for (FTPFile ftpFile : list) {
            System.out.println("ftpFile.getName()" + ftpFile.getSize());
        }
        client.upload(new File("C:\\Users\\lijinlong3\\Desktop\\jdpay.txt"));
        // upload

        // download
    }
}
