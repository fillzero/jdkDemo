package cn.tk.java.designPattern.tinyEngine;

import com.alibaba.fastjson.JSONObject;

/*
* @date: 2017/3/1
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description: 洗衣服任务
* 
*/
public class WashHandler implements ITaskHandler {

    @Override
    public void handle(JSONObject content) {
        System.out.println(content);
        System.out.println("I'll wash your clothes right now!");
    }
}
