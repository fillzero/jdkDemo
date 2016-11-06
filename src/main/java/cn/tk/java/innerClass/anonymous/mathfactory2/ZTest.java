package cn.tk.java.innerClass.anonymous.mathfactory2;


/**
 * @author: lijl85
 * @date：2016年11月6日上午11:29:42
 * @Description: 非工厂模式....作为反例
 */
public class ZTest {
	
	public static void process(Integer a, Integer b, CalFactory<Integer> factory)
	{
		System.out.println(factory.calculate(a, b));
	}
	
	public static void main(String[] args) {
		process(123, 32, Adder.getInstance());
		process(123, 32, Suber.getInstance());
		process(123, 32, Muler.getInstance());
		process(123, 32, Diver.getInstance());
	}
}
