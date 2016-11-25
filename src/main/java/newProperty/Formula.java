package newProperty;

import org.junit.Test;

/**
 * @description:接口的 default 方法在子类中可以直接使用
 */
public class Formula implements IFormula{
	@Override
	public double calculate(int a) {
		return sqrt(a * 100);
	}
	
	/**
	 * @description: default 方法也可以覆盖
	 */
	@Override
	public double sqrt(int a) {
		System.out.println("执行子类覆盖方法： ");
		return Math.sqrt(a);
	}
	
	@Test
	public void testCalculate()
	{
		System.out.println(calculate(100));
		System.out.println(sqrt(16));//default 方法子类可以直接使用
	}
}
