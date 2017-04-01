package cn.tk.java.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/1
* @description: 目标类
*
**/
public class Jack implements Boss {

      private List<Staff> staffs = new ArrayList<Staff>();

    /*
    * @description: 注册观察者
    */
    @Override
    public void employ(Staff staff) {
        staffs.add(staff);
    }

    /*
    * @description: 删除观察者
    */
    @Override
    public void fire(Staff staff) {
        staffs.remove(staff);
    }

    /*
    * @description: 消息通知，轮询所有观察者，每个人都要通知到
    */
    @Override
    public void haveAMeeting(String meetingRoom) {
        System.out.println("The meetingRoom is " + meetingRoom +", Please come here soon!");
        for (Staff staff : staffs) {
            staff.attendMeeting(meetingRoom);
        }
    }
}
