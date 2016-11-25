package cn.tk.java.innerClass.controller;

/**
 * @author: lijl85
 * @date：2016年11月6日下午9:34:18
 * @description: 具体实现类
 * 外部类继承 Controller, 拥有控制器的各种功能, 内部
 */
@SuppressWarnings("unused")
public class GreenhouseController extends Controller{
	
	/**
	 * @description:灯开关事件
	 */
	private boolean light = false;
	public class LightOn extends Event{
		public LightOn(long delayTime){
			super(delayTime);
		}
		@Override
		public void action() {
			light = true;
		}
		public String toString()
		{
			return "Light is on!";
		}
	}
	public class LightOff extends Event{
		public LightOff(long delayTime){
			super(delayTime);
		}
		@Override
		public void action() {
			light = false;
		}
		public String toString()
		{
			return "Light is off!";
		}
	}
	
	/**
	 * @description:水龙头关闭事件
	 */
	private boolean water = false;
	public class WaterOn extends Event{
		public WaterOn(long delayTime){
			super(delayTime);
		}
		@Override
		public void action() {
			water = true;
		}
		public String toString()
		{
			return "Water is on!";
		}
	}
	public class WaterOff extends Event{
		public WaterOff(long delayTime){
			super(delayTime);
		}
		@Override
		public void action() {
			water = false;
		}
		public String toString()
		{
			return "Water is off!";
		}
	}
	
	/**
	 * @description:气温调节器白天黑夜事件
	 */
	private boolean thermostat = false;
	public class ThermostatNight extends Event{
		public ThermostatNight(long delayTime){
			super(delayTime);
		}
		@Override
		public void action() {
			thermostat = true;
		}
		public String toString()
		{
			return "Thermostat on night setting!";
		}
	}
	public class ThermostatDay extends Event{
		public ThermostatDay(long delayTime){
			super(delayTime);
		}
		@Override
		public void action() {
			thermostat = false;
		}
		public String toString()
		{
			return "Thermostat on day setting!";
		}
	}
	
	/**
	 * @description: 响铃事件
	 */
	public class Bell extends Event{
		public Bell(long delayTime) {
			super(delayTime);
		}
		@Override
		public void action() {
			addEvent(new Bell(delayTime));//响铃多添加一次, 会响两次
		}
		public String toString()
		{
			return "Bing!";
		}
	}
	
	/**
	 * @description:重启事件
	 */
	public class Restart extends Event{
		private Event[] eventList;
		public Restart(long delayTime, Event[] eventList) {
			super(delayTime);
			this.eventList = eventList;
			for(Event event : eventList)
				addEvent(event);
		}
		@Override
		public void action() {
			for(Event event : eventList)
			{
				super.start();
				addEvent(event);
			}
			start();
			addEvent(this); //将自己也加入事件列表, Restart 操作也属于事件的一种
		}
		public String toString()
		{
			return "Restarting System!";
		}
	}
	
	/**
	 * @description:关闭终端事件
	 */
	public static class Terminate extends Event{
		public Terminate(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			System.exit(0);
		}
		public String toString()
		{
			return "Terminating";
		}
	}
}
