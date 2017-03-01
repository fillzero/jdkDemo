package cn.tk.java.designPattern.tinyEngine;

import com.alibaba.fastjson.JSONObject;

/*
* @date: 2017/3/1
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description: 扫地处理器
* 
*/
public class SweepHandler implements ITaskHandler {

    @Override
    public void handle(JSONObject content) {
        System.out.println(content);
        System.out.println("I'll sweep the floor right now!");
    }
}
