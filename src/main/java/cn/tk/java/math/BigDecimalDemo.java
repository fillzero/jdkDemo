package cn.tk.java.math;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

import lombok.SneakyThrows;
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
		
		BigDecimal transferDouble = new BigDecimal(Double.toString(1.22));
		System.out.println(transferDouble);
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
	@SneakyThrows
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

	/**
	 * Description: BigDecimal 舍入模式分析
	 */
	@Test
	public void testRoundingMode()
	{
		double number = 2.45;
		BigDecimal roundUp = new BigDecimal(number).setScale(1, BigDecimal.ROUND_UP);//远离0方向舍入
		BigDecimal roundDown = new BigDecimal(number).setScale(1, BigDecimal.ROUND_DOWN);//靠近0方向
		BigDecimal roundCeiling = new BigDecimal(number).setScale(1, BigDecimal.ROUND_CEILING);//向上取整（正无穷大）
		BigDecimal roundFloor = new BigDecimal(number).setScale(1, BigDecimal.ROUND_FLOOR);//向下取整（负无穷大）
		BigDecimal roundHalfUp = new BigDecimal(number).setScale(1, BigDecimal.ROUND_HALF_UP);//向距离最接近数字舍入，相等的话向上舍入
		BigDecimal roundHalfDown = new BigDecimal(number).setScale(1, BigDecimal.ROUND_HALF_DOWN);//向距离最接近数字舍入，相等的话向下舍入
		BigDecimal roundHalfEven = new BigDecimal(number).setScale(1, BigDecimal.ROUND_HALF_EVEN);//向距离最接近数字舍入，相等的话向偶数舍入

		System.out.println(roundUp);
		System.out.println(roundDown);
		System.out.println(roundCeiling);
		System.out.println(roundFloor);
		System.out.println(roundHalfUp);
		System.out.println(roundHalfDown);
		System.out.println(roundHalfEven);
	}
}
