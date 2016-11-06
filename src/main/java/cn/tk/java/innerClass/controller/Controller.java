package cn.tk.java.innerClass.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: lijl85
 * @date：2016年11月6日下午9:33:40
 * @description:事件控制器, 维护一个链表, 根据事件状态触发事件, 判断事件状态, 执行事件, 关闭事件
 */
public class Controller {
	List<Event> eventList = new CopyOnWriteArrayList<Event>();//这里有可能有多个线程访问 eventList, 所以不能使用 ArrayList
	public void addEvent(Event e)
	{
		eventList.add(e);
	}
	public void removeEvent(Event e)
	{
		eventList.remove(e);
	}

	public void run()
	{
		while (eventList.size() > 0) {
			for (Event event : eventList) {
				if (event.ready()) {
					System.out.println(event);
					event.action();
					eventList.remove(event);
				}
			}
		}
	}
}
