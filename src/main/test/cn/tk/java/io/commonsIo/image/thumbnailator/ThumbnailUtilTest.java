package cn.tk.java.io.commonsIo.image.thumbnailator;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * Created by lijl85 on 2016/11/22.
 */
public class ThumbnailUtilTest {
    @Test
    public void resize() throws Exception {

    }

    @Test
    public void resizeByScale() throws Exception {

    }

    @Test
    public void resizeAuto() throws Exception {
        String filePath = "D:\\MyDocuments\\lijl85\\桌面\\logl.jpg";
        String destPath = "D:\\MyDocuments\\lijl85\\桌面\\loglA.jpg";
        int expectHeight = 50;
        int expectWidth = 136;

        ThumbnailUtil.resizeAuto(filePath, destPath, expectHeight, expectWidth);
    }

}