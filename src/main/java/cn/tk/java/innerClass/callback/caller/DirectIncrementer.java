package cn.tk.java.innerClass.callback.caller;

/**
 * @author: lijl85
 * @date：2016年11月6日下午3:47:11
 * @description:直接实现接口
 */
public class DirectIncrementer implements Incrementable{
	
	private int i = 0;

	@Override
	public void increment() {
		i ++;
		System.out.println(i);
	}
}
