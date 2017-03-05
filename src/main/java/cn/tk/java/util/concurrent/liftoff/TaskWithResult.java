package cn.tk.java.util.concurrent.liftoff;

import java.util.concurrent.Callable;

/*
*@date: 2017/3/4 0004
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 
*/
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
