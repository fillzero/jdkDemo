package cn.tk.java.designPattern.tinyEngine;

import com.alibaba.fastjson.JSONObject;

/*
* @date: 2017/3/1
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description: 任务处理器接口
* 
*/
public interface ITaskHandler {
    public void handle(JSONObject content);
}
