package cn.tk.java.math;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalDemo {
	/**
	 * @Description: BigDecimal 构造函数
	 * String 构造函数可预知， 推荐使用
	 * double 构造函数不可预知
	 */
	@Test
	public void testBigDecimalConstruct()
	{
		BigDecimal aDouble = new BigDecimal(1.22);
		System.out.println(aDouble);
		BigDecimal aDoubleString = new BigDecimal("1.22");
		System.out.println(aDoubleString);
		
		BigDecimal trasferDouble = new BigDecimal(Double.toString(1.22));
		System.out.println(trasferDouble);
	}
	
	/**
	 * @Description:BigDecimal 加法
	 */
	@Test
	public void testBigDecimalAdd()
	{
		BigDecimal aDouble = new BigDecimal("2.52");
		BigDecimal bDouble = new BigDecimal("1.26");
		BigDecimal addDouble = aDouble.add(bDouble);
		BigDecimal subDouble = aDouble.subtract(bDouble);
		BigDecimal mulDouble = aDouble.multiply(bDouble);
		BigDecimal divDouble = aDouble.divide(bDouble);
		System.out.println(addDouble);
		System.out.println(subDouble);
		System.out.println(mulDouble);
		System.out.println(divDouble);
	}
}
