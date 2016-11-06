package cn.tk.java.innerClass.callback.caller;

/**
 * @author: lijl85
 * @date：2016年11月6日下午4:02:55
 * @description:回调器
 */
public class Caller {
	Incrementable incrementable;
	public Caller(Incrementable incrementable) {
		this.incrementable = incrementable;
	}
	public void go()
	{
		incrementable.increment();
	}
}
