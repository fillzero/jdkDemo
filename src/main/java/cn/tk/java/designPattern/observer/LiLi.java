package cn.tk.java.designPattern.observer;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/1
* @description: 
*
**/
public class LiLi implements Staff {

    @Override
    public void attendMeeting(String meetingRoom) {
        System.out.println("LiLi will go to the " + meetingRoom + " soon!");
    }
}
