package cn.tk.java.net;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/*
*@date: 2017/3/2 0002
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: URL是统一资源定位符，用于描述资源
* protocol: 通信协议
* host: 服务器地址
* port: 端口号
* 资源都可以转换成 InputStream 二进制流， InputStreamReader 包装成字符
*
*/
public class URLDemo {
    @SneakyThrows
    public void getResource(String urlPath){
        URL url = new URL(urlPath);
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String str;
        while ((str=bufferedReader.readLine())!=null)
            System.out.println(str);
    }
}
