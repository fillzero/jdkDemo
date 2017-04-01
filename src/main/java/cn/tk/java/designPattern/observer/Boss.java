package cn.tk.java.designPattern.observer;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/1
* @description: 目标接口，提供三个操作
*
* 1. 添加观察者（订阅）
* 2. 删除观察者（解除订阅）
* 3. 发布消息（轮询观察者）
**/
public interface Boss {
    void employ(Staff staff);
    void fire(Staff staff);
    void haveAMeeting(String meetingRoom);
}
