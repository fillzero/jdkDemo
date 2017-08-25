package cn.tk.java.util.ftpclient;

import it.sauronsoftware.ftp4j.FTPClient;
import lombok.Builder;
import lombok.SneakyThrows;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/8/23
 * Description: 使用 ftp4j 获取 FTP 服务器的连接
 *
 * 单例 + Builder
 * 单例用于保证实例的唯一性，Builder 用于显式的创建实例
 */
@SuppressWarnings("Duplicates")
public class Ftp4jClient {

    private volatile static FTPClient ftpClient;

    private static String address = "192.168.1.110";
    private static Integer port = 21;
    private static String user = "jdftp";
    private static String password = "uchanceftp";

    private Ftp4jClient(){}

    public static FTPClient getClient(){
        if (ftpClient == null)
        {
            synchronized (Ftp4jClient.class)
            {
                if (ftpClient == null)
                {
                    ftpClient = Ftp4jClientBuilder.builder()
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

    public static class Ftp4jClientBuilder
    {
        private String address;
        private Integer port;
        private String user;
        private String password;

        private static Ftp4jClientBuilder builder()
        {
            return new Ftp4jClientBuilder();
        }

        public Ftp4jClientBuilder address(String address)
        {
            this.address = address;
            return this;
        }

        public Ftp4jClientBuilder port(Integer port)
        {
            this.port = port;
            return this;
        }

        public Ftp4jClientBuilder user(String user)
        {
            this.user = user;
            return this;
        }

        public Ftp4jClientBuilder password(String password)
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
            ftpClient.setPassive(true);
            ftpClient.setType(FTPClient.TYPE_BINARY);
            return ftpClient;
        }
    }
}
