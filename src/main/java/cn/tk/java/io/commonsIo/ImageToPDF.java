package cn.tk.java.io.commonsIo;

import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import lombok.SneakyThrows;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/*
* @date: 2017/2/10
* @author: lijl85
* @mail: ljldeepinit@163.com
*
* @param docuList: 文件路径名称集合
* @param claim_id: 理赔编号
* @param claim_date: 出险时间
* @param localpath: 本地路径
*/
public class ImageToPDF{

    /*
    * @description: 将多个图片生成统一的 PDF
    */
    @SneakyThrows
    public void imageToPDF(List<String> imageList, String targetDir, String pdfName)
    {
        // 创建一个文档对象
        Document doc = new Document();
        FileOutputStream fos = null;
        if(imageList!=null&&imageList.size()>0)
        {
            String imageName="";
            fos=new FileOutputStream(targetDir +"/"+pdfName+".pdf");
            // 定义输出文件的位置
            PdfWriter.getInstance(doc,fos);
            // 开启文档
            doc.open();

            for(int i=0;i<imageList.size();i++)
            {
                imageName = (String)imageList.get(i);
                imageName = targetDir +"/" +imageName;

                // 取得图片~~~图片格式：
                Image image = Image.getInstance(imageName); // 原来的图片的路径
                // 获得图片的高度
                float height = image.getHeight();
                float width = image.getWidth();
                // 合理压缩，h>w，按w压缩，否则按w压缩
                int percent = getPercent(height,width);
                // 统一按照宽度压缩
                // int percent=getPercent2(height, width);
                // 设置图片居中显示
                image.setAlignment(Image.MIDDLE);
                // 直接设置图片的大小~~~~~~~第三种解决方案，按固定比例压缩
                image.scaleAbsolute(height,width);
                // 按百分比显示图片的比例
                image.scalePercent(percent);// 表示是原来图像的比例;
                // 可设置图像高和宽的比例
                // jpg1.scalePercent(5, 5);
                doc.add(image);
            }
        }
        if(doc!=null) doc.close();
        if(fos!=null) fos.close();
    }

    public int getPercent(float h, float w)
    {
        int p = 0;
        float p2 = 0.0f;
        if (h > w)
        {
            p2 = 297 / h * 180;
        } else
        {
            p2 = 210 / w * 180;
        }
        p = Math.round(p2);
        return p;
    }

    public int getPercent2(float h, float w)
    {
        int p = 0;
        float p2 = 0.0f;
        p2 = 530 / w * 50;
        p = Math.round(p2);
        return p;
    }
}
