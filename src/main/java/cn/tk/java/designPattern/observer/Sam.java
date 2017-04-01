package cn.tk.java.designPattern.observer;

import cn.tk.java.designPattern.observer.Staff;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/1
* @description: 
*
**/
public class Sam implements Staff {

    @Override
    public void attendMeeting(String meetingRoom) {
        System.out.println("Sam will go to the " + meetingRoom + " soon!");
    }
}
