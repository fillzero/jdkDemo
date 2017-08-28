package cn.tk.java.util.ftpclient;

import lombok.*;
import sun.net.ftp.FtpClient;

import java.net.InetSocketAddress;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/8/23
 * Description: 使用 jdk 获取 FTP 服务器的连接
 */
public class FtpJdkClient {

    private volatile static FtpClient ftpClient;

    private static String address = "192.168.1.110";
    private static Integer port = 21;
    private static String user = "jdftp";
    private static String password = "uchanceftp";

    private FtpJdkClient() {

    }

    public static FtpClient getClient()
    {
        if (ftpClient == null)
        {
            synchronized (FtpJdkClient.class)
            {
                if (ftpClient == null)
                    ftpClient = FtpClientBuilder
                            .builder()
                            .address(address)
                            .port(port)
                            .user(user)
                            .password(password)
                            .build();
            }
        }
        return ftpClient;
    }


    /**
     * Description：构造请求体：FtpClientBuilder 模式处理多参数构造函数类
     * 传递参数使用链式调用：可读性很高
     */
    public static class FtpClientBuilder {

        private String address;
        private Integer port;
        private String user;
        private String password;

        public static FtpClientBuilder builder()
        {
            return new FtpClientBuilder();
        }

        public FtpClientBuilder address(String address)
        {
            this.address = address;
            return this;
        }

        public FtpClientBuilder port(Integer port)
        {
            this.port = port;
            return this;
        }

        public FtpClientBuilder user(String user)
        {
            this.user = user;
            return this;
        }

        public FtpClientBuilder password(String password)
        {
            this.password = password;
            return this;
        }

        @SneakyThrows
        public FtpClient build()
        {
            FtpClient ftpClient = FtpClient.create();
            ftpClient.connect(new InetSocketAddress(this.address, this.port));
            ftpClient.login(this.user, this.password.toCharArray());
            ftpClient.enablePassiveMode(true);
            ftpClient.setBinaryType();
            System.out.println(ftpClient.getWelcomeMsg());
            return ftpClient;
        }
    }
}
