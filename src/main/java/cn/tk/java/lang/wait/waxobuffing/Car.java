package cn.tk.java.lang.wait.waxobuffing;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/4
* @description: 
* 打蜡操作（唤醒抛光）--> 等待抛光
* 抛光操作（唤醒打蜡） --> 等待打蜡
**/
public class Car {

    private boolean isWaxing = false;//是否正在打蜡：true:是的，false: 不是

    /*
    * @description: 打蜡 --> 唤醒抛光
    */
    public synchronized void waxed()
    {
        isWaxing = true;
        notifyAll();
    }

    /*
    * @description: 抛光 --> 唤醒打蜡
    */
    public synchronized void buffed()
    {
        isWaxing = false;
        notifyAll();
    }

    /*
    * @description: 等待打蜡（等待 isisWaxing 为 false）
    */
    public synchronized void waitForWaxing() throws InterruptedException {
        while (!isWaxing)//如果还在抛光，就一直等着，等着被打蜡唤醒
            wait();
    }

    /*
    * @description: 等待抛光，如果还在打蜡，就一直等待，直到抛光被唤醒
    * 等待感兴趣的条件满足，如果不满足就一直 wait()
    */
    public synchronized void waitForBuffing() throws InterruptedException {
        while (isWaxing)
            wait();
    }
}
