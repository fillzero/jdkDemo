package cn.tk.java.util.ftpclient;

import lombok.SneakyThrows;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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
public class FtpHelperImpl implements FtpHelper{

    private FTPClient ftpClient = FtpApacheClient.getClient();

    /**
     * Description：上传文件，缺省文件名称跟本地文件一致
     * @param localPath 本地文件路径
     * @param remotePath 远程文件夹路径
     */
    @Override
    @SneakyThrows
    public void upload(String localPath, String remotePath)
    {
        checkAndMakeDirectory(remotePath);
        File file = new File(localPath);
        FileInputStream localFile = new FileInputStream(file);
        ftpClient.storeFile(file.getName(), localFile);
    }

    /**
     * Description：下载文件：需要单独指定远程文件名
     * @param localPath 本地文件路径
     * @param remotePath 远程文件路径
     */
    @Override
    @SneakyThrows
    public void downLoad(String localPath, String remotePath, String remoteFileName)
    {
        checkAndMakeDirectory(remotePath);
        ftpClient.changeWorkingDirectory(remotePath);
        FileOutputStream localFile = new FileOutputStream(new File(localPath));
        ftpClient.retrieveFile(remoteFileName, localFile);
    }

    /**
     * Description：删除文件或文件夹，文件夹只有为空时才可以删除
     * @param remotePath：远程文件（文件夹）路径
     * @param isFile：true 为文件，false 为文件夹
     */
    @Override
    @SneakyThrows
    public boolean delete(String remotePath, boolean isFile)
    {
        if (isFile) {
            return ftpClient.deleteFile(remotePath);
        }
        else {
            return ftpClient.removeDirectory(remotePath);
        }
    }

    /**
     * Description：重命名 FTP 服务器上某文件的名称
     * @param remotePath FTP 服务器上文件夹路径
     * @param oldName 旧名字
     * @param newName 新名称
     */
    @Override
    @SneakyThrows
    public void rename(String remotePath, String oldName, String newName)
    {
        checkAndMakeDirectory(remotePath);
        ftpClient.changeWorkingDirectory(remotePath);
        ftpClient.rename(oldName, newName);
    }

    /**
     * Description：根据远程路径，创建文件夹，依据是文件夹内部是否有文件
     * @param remotePath 远程文件夹路径
     */
    @Override
    @SneakyThrows
    public void checkAndMakeDirectory(String remotePath) {
        FTPFile[] ftpFiles = ftpClient.listFiles(remotePath);
        if (ftpFiles==null || ftpFiles.length == 0)
            ftpClient.makeDirectory(remotePath);
        ftpClient.changeWorkingDirectory(remotePath);
    }
}
