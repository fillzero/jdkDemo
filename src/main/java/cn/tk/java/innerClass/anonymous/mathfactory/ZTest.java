package cn.tk.java.innerClass.anonymous.mathfactory;


/**
 * @author: lijl85
 * @date：2016年11月6日上午11:29:42
 * @description:简单的计算器工厂
 * 
 * 工厂抽象 --> 产品抽象 --> 具体产品
 * 
 * 每个具体产品中都有工厂的实现, 用于获取具体的产品.
 * 工厂 --> 多类产品 --> 每一类下面又有多种具体产品
 */
public class ZTest {
	
	/**
	 * @description:抽象流程
	 */
	public static Integer process(Integer a, Integer b, CalFactory<Integer> calFactory)
	{
		CalBuilder<Integer> calculator = calFactory.getBuilder();//工厂中获取到具体产品
		return calculator.calculate(a, b);//用产品完成任务
	}
	
	public static void main(String[] args) {
		System.out.println(process(19, 3, Adder.addFactory));
		System.out.println(process(19, 3, Suber.subFactory));
		System.out.println(process(19, 3, Muler.mulFactory));
		System.out.println(process(19, 3, Diver.divFactory));
	}
}
