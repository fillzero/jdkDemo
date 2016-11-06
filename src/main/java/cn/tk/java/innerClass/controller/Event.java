package cn.tk.java.innerClass.controller;

/**
 * @author: lijl85
 * @date：2016年11月6日下午9:33:07
 * @description:事件类: 触发, 执行 action()
 * 这里实现时间触发
 */
public abstract class Event {
	private long eventTime; //事件开始时间
	protected final long delayTime; //延迟时间, protected final 方便继承类可以直接使用, 添加多次
	
	public Event(long delayTime) {
		this.delayTime = delayTime;
		start();
	}
	
	/**
	 * @description:已经超过时间开始时间, 准备就绪
	 */
	public boolean ready()
	{
		return System.nanoTime() > eventTime;
	}
	
	/**
	 * @description: 开始计算事件开始时间
	 */
	public void start()
	{
		eventTime = delayTime + System.nanoTime();
	}
	
	public abstract void action(); // 要触发的事件
}
