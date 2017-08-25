package cn.tk.java.util.ftpclient;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/8/23
 * Description: 提供给客户使用：提供常用功能
 * （1）upload
 * （2）downLoad
 * （3）delete
 * （4）rename
 */
public class FtpHelper {

    private final String address = "192.168.1.110";
    private final Integer port = 21;
    private final String user = "jdftp";
    private final String password = "uchanceftp";
    private final String fileType = "txt";


    /**
     * Description：上传文件
     * @param localPath 本地文件（文件夹）路径
     * @param remotePath FTP 服务器上文件（文件夹）路径
     */
    public void upload(String localPath, String remotePath)
    {
        FtpJdkClient ftpClient = new FtpJdkClient.FtpClientBuilder(fileType)
                .address(address)
                .port(port)
                .user(user)
                .password(password)
                .build();
    }

    /**
     * Description：下载文件
     * @param localPath 本地文件（文件夹）路径
     * @param remotePath FTP 服务器上文件（文件夹）路径
     */
    public void downLoad(String localPath, String remotePath)
    {

    }

    /**
     * Description：删除 FTP 服务器某文件，或文件夹下的所有文件
     * @param remotePath FTP 服务器上文件（文件夹）
     */
    public void delete(String remotePath)
    {

    }

    /**
     * Description：重命名 FTP 服务器上某文件的名称
     * @param remotePath FTP 服务器上文件路径
     * @param newName 新名称
     */
    public void rename(String remotePath, String newName)
    {

    }
}
