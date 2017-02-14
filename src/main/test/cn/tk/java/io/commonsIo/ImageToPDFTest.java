package cn.tk.java.io.commonsIo;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lijl85 on 2017/2/10.
 */
public class ImageToPDFTest {
    @Test
    public void imageToPDF() throws Exception {
        ImageToPDF imageToPDF = new ImageToPDF();
        String imagePath = "D:/MyDocuments/lijl85/桌面/doc";
        File directory = new File(imagePath);
        File[] files = directory.listFiles();
        List<String> imageList = new ArrayList<String>();
        for (File file : files)
        {
            imageList.add(file.getName());
        }
        imageToPDF.imageToPDF(imageList, imagePath, "images");
    }

    @Test
    public void getPercent() throws Exception {

    }

}