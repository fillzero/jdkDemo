package cn.tk.java.util.ftpclient;

import lombok.Builder;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/8/23
 * Description:
 */
public class Ftp4jClient {
    private volatile Ftp4jClient ftpClient;

    private String address = "192.168.1.110";
    private String user = "jdftp";
    private String password = "uchanceftp";

    private Ftp4jClient(Ftp4jClientBuilder ftpInfo) {
        this.address = ftpInfo.address;
        this.user = ftpInfo.user;
        this.password = ftpInfo.password;
    }

    public Ftp4jClient getClient(){
        if (ftpClient == null)
        {
            synchronized (Ftp4jClient.class)
            {
                if (ftpClient == null)
                {
                    Ftp4jClientBuilder ftpInfo = Ftp4jClientBuilder.builder()
                            .address(address)
                            .user(user)
                            .password(password)
                            .build();
                    return new Ftp4jClient(ftpInfo);
                }

            }
        }
        return ftpClient;
    }

    @Builder
    public static class Ftp4jClientBuilder
    {
        private String address;
        private String user;
        private String password;
    }
}
