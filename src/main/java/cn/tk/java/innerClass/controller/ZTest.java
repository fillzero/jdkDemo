package cn.tk.java.innerClass.controller;


/**
 * @author: lijl85
 * @date：2016年11月6日下午10:14:14
 * @description: 内部类 + 抽象类/接口 实现控制框架
 * http://blog.csdn.net/izard999/article/details/6708738
 */
public class ZTest {
	public static void main(String[] args) {
		GreenhouseController controller = new GreenhouseController();
		controller.addEvent(controller.new Bell(1000));
		
		Event[] eventList = {
				controller.new ThermostatNight(0),
				controller.new LightOn(200),
				controller.new LightOff(400),
				controller.new WaterOn(600),
				controller.new WaterOff(800),
				controller.new ThermostatDay(1400)
		};
		
		controller.addEvent(controller.new Restart(2000, eventList));
		controller.addEvent(new GreenhouseController.Terminate(3000));
		controller.run();
	}
}
