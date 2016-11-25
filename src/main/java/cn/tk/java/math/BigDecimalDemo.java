package cn.tk.java.math;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalDemo {
	/**
	 * @description: BigDecimal 构造函数
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
	 * @description:BigDecimal 加法
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
	
	/**
	 * @description:保费以元为单位，算利息可能会有问题， 所以要转化成分为单位， 这时候使用 double 的构造函数会有问题
	 * 要使用 String 的构造函数
	 */
	@Test
	public void testApply()
	{
	    BigDecimal bigDecimal = new BigDecimal(1.23);
	    System.out.println("保费(单位/元): " + bigDecimal);
	    bigDecimal = bigDecimal.multiply(new BigDecimal(100));
	    long lPremium = bigDecimal.longValue();
	    System.out.println("保费(单位/分): " + lPremium);
	    
	    BigDecimal bigDecimal2 = new BigDecimal(Double.toString(1.23));
	    System.out.println("保费(单位/元): " + bigDecimal2);
	    bigDecimal2 = bigDecimal2.multiply(new BigDecimal(100));
	    long lPremium2 = bigDecimal2.longValue();
	    System.out.println("保费(单位/分): " + lPremium2);
	}
}
