package cn.tk.java.lang.ref;

import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/*
* @date: 2017/2/15
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description:
* 用软引用实现图片缓存, 读硬盘或者数据库太浪费时间, 所以使用软引用编写内存敏感的缓存, 如果内存空间不足的时候
* GC 会将图片缓存回收
*/
public class BitMapManager {

    private Map<String, SoftReference<File>> imageCache = new HashMap();

    /*
    * @description: 写缓存
    * 1. 建立强引用, 将强引用赋给软引用, 置空强引用
    * 2. 写缓存
    */
    public void put(String imagePath)
    {
        File image = new File(imagePath);
        SoftReference<File> imageSoftRef = new SoftReference<File>(image);
        imageCache.put(imagePath, imageSoftRef);
        image = null;
    }

    /*
    * @description: 读缓存
    */
    public File get(String imagePath)
    {
        SoftReference<File> imageSoftMap = imageCache.get(imagePath);
        return imageSoftMap!=null ? imageSoftMap.get() : null;
    }
}
