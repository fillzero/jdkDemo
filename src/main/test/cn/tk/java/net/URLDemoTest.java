package cn.tk.java.net;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/2 0002.
 */
public class URLDemoTest {
    @Test
    public void getResource() throws Exception {
        URLDemo urlDemo = new URLDemo();
        urlDemo.getResource("http://www.baidu.com");
    }
}