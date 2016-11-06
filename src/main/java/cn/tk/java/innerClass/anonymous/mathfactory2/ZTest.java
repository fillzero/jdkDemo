package cn.tk.java.innerClass.anonymous.mathfactory2;


/**
 * @author: lijl85
 * @date：2016年11月6日上午11:29:42
 * @description:简单的计算器工厂
 */
public class ZTest {
	
	public static void process(Integer a, Integer b, CalFactory<Integer> factory)
	{
		CalFactory<Integer> realFactory = factory.getInstance();
		System.out.println(realFactory.calculate(a, b, realFactory));
	}
	
	public static void main(String[] args) {
		process(123, 32, new Adder());
		process(123, 32, new Suber());
		process(123, 32, new Muler());
		process(123, 32, new Diver());
	}
}
