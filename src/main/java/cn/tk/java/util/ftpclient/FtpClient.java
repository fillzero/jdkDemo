package cn.tk.java.util.ftpclient;

import lombok.*;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/8/23
 * Description: 用于完成跟 FTP 服务器的各种交互
 */
public class FtpClient {

    @Getter private String fileType; //必传参数
    @Getter private String connectionMode;//连接模式：PASV
    @Getter private String transferMode;//传输模式：BINARY
    @Getter private String user;//可传参数
    @Getter private String password;//可传参数
    @Getter private String address;//可传参数
    @Getter private Integer port;//可传参数

    private FtpClient() {

    }

    private FtpClient(FtpClientBuilder ftpClientBuilder)
    {
        this.fileType = ftpClientBuilder.fileType;
        this.user = ftpClientBuilder.user;
        this.password = ftpClientBuilder.password;
        this.address = ftpClientBuilder.address;
        this.port = ftpClientBuilder.port;
    }

    /**
     * Description：构造请求体：FtpClientBuilder 模式处理多参数构造函数类
     * 传递参数使用链式调用：可读性很高
     */
    public static class FtpClientBuilder {

        private final String fileType; //必传参数
        private String user;//可传参数
        private String password;//可传参数
        private String address;//可传参数
        private Integer port;//可传参数

        public FtpClientBuilder(String fileType){
            this.fileType = fileType;
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

        public FtpClient build()
        {
             return new FtpClient();
        }
    }
}
