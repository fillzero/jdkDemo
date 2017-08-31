package cn.tk.java.util.ftpclient;

/**
 * Created by lijinlong3 on 2017/8/28.
 */
public interface FtpHelper {

    /**
     * Description：上传文件，缺省文件名称跟本地文件一致
     * @param localPath 本地文件路径
     * @param remotePath 远程文件夹路径
     */
    void upload(String localPath, String remotePath);

    /**
     * Description：下载文件
     * @param localPath 本地文件路径
     * @param remotePath 远程文件路径
     */
    void downLoad(String localPath, String remotePath, String remoteFileName);

    /**
     * Description：删除文件或文件夹，文件夹只有为空时才可以删除
     * @param remotePath：远程文件（文件夹）路径
     * @param isFile：true 为文件，false 为文件夹
     */
    boolean delete(String remotePath, boolean isFile);


    /**
     * Description：重命名 FTP 服务器上某文件的名称
     * @param remotePath FTP 服务器上文件夹路径
     * @param oldName 旧名字
     * @param newName 新名称
     */
    void rename(String remotePath, String oldName, String newName);

    /**
     * Description：判断文件是否存在，不存在直接创建
     * @param remotePath：FTP 服务器上的文件夹路径
     */
    void checkAndMakeDirectory(String remotePath);
}
