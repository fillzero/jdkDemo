package cn.tk.java.util.ftpclient;

import lombok.SneakyThrows;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/8/24
 * Description: 使用 apache ftpclient 获取 FTP 服务器的连接
 */
@SuppressWarnings("Duplicates")
public class FtpApacheClient {
    private volatile static FTPClient ftpClient;

    private static String address = "192.168.1.110";
    private static Integer port = 21;
    private static String user = "jdftp";
    private static String password = "uchanceftp";

    private FtpApacheClient(){}

    public static FTPClient getClient(){
        if (ftpClient == null)
        {
            synchronized (Ftp4jClient.class)
            {
                if (ftpClient == null)
                {
                    ftpClient = FtpApacheClientBuilder.builder()
                            .address(address)
                            .port(port)
                            .user(user)
                            .password(password)
                            .build();
                    return ftpClient;
                }

            }
        }
        return ftpClient;
    }

    public static class FtpApacheClientBuilder
    {
        private String address;
        private Integer port;
        private String user;
        private String password;

        private static FtpApacheClientBuilder builder()
        {
            return new FtpApacheClientBuilder();
        }

        public FtpApacheClientBuilder address(String address)
        {
            this.address = address;
            return this;
        }

        public FtpApacheClientBuilder port(Integer port)
        {
            this.port = port;
            return this;
        }

        public FtpApacheClientBuilder user(String user)
        {
            this.user = user;
            return this;
        }

        public FtpApacheClientBuilder password(String password)
        {
            this.password = password;
            return this;
        }

        @SneakyThrows
        public FTPClient build()
        {
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(this.address, this.port);
            ftpClient.login(this.user, this.password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.setControlEncoding("UTF-8");
            return ftpClient;
        }
    }
}
