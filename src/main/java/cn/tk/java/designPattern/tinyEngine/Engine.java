package cn.tk.java.designPattern.tinyEngine;

import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;

/*
* @date: 2017/3/1
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description: 一个分发引擎, 不同的入参决定不同的处理机制
* 
*/
public class Engine {
    public void dispatcher(JSONObject task)
    {
        String taskId = task.getString("taskId");
        ITaskHandler taskHandler = getConcreteHandler(taskId);
        taskHandler.handle(task);
    }

    /*
    * @description:
     * 1. 可以主动 new 出来
     * 2. 拿到全类名, 通过反射 newInstance 搞到对象
     * 3. 拿到类名, 通过 Spring 容器搞到对象:
     * public class Engine extends ApplicationObjectSupport
     * (WorkStepAble)super.getApplicationContext().getBean(className);
    */
    @SneakyThrows
    private ITaskHandler getConcreteHandler(String taskId) {
        switch (taskId){
            case "wash":
                return new WashHandler();
            case "sweep":
                return new SweepHandler();
            default:
                return new CleanHandler();
        }
    }
}
