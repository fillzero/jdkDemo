package cn.tk.java.util;

import java.math.BigDecimal;

import org.junit.Test;

public class ValueConvert {

	private static final String UNIT = "万千佰拾亿千佰拾万千佰拾元角分";
	private static final String DIGIT = "零壹贰叁肆伍陆柒捌玖";
	private static final double MAX_VALUE = 9999999999999.99D;

	/**
	 * @description:
	 * @param v： 金额
	 * @return 人民币小写转大写
	 */
	public static String change(double v) {
		if (v < 0 || v > MAX_VALUE) {
			return "参数非法!";
		}
		long l = Math.round(v * 100);
		if (l == 0) {
			return "零元整";
		}
		String strValue = l + "";
		// i用来控制数
		int i = 0;
		// j用来控制单位
		int j = UNIT.length() - strValue.length();
		String rs = "";
		boolean isZero = false;
		for (; i < strValue.length(); i++, j++) {
			char ch = strValue.charAt(i);
			if (ch == '0') {
				isZero = true;
				if (UNIT.charAt(j) == '亿' || UNIT.charAt(j) == '万'
						|| UNIT.charAt(j) == '元') {
					rs = rs + UNIT.charAt(j);
					isZero = false;
				}
			} else {
				if (isZero) {
					rs = rs + "零";
					isZero = false;
				}
				rs = rs + DIGIT.charAt(ch - '0') + UNIT.charAt(j);
			}
		}
		if (!rs.endsWith("分")) {
			rs = rs + "整";
		}
		rs = rs.replaceAll("亿万", "亿");
		return rs;
	}

	/**
	 * @description:四舍五入
	 * @param num
	 * @param i
	 * @return
	 */
	public static double formatUserDefNew(double num, int i) {
		double num_calc;
		if (num < 0.0D) {
			num_calc = 0.0D - num;
		} else {
			num_calc = num;
		}

		long ratio = (long) Math.pow(10.0D, i + 1);
		double num_new = new BigDecimal(num_calc + "")
				.multiply(new BigDecimal(ratio + "")).add(new BigDecimal("5"))
				.doubleValue();

		long cut = (long) num_new;
		cut /= 10L;

		double res = cut / Math.pow(10.0D, i);

		if (num < 0.0D) {
			res = 0.0D - res;
		}
		return res;
	}

	@Test
	public void testChange() {
		System.out.println(change(209280.00));
		System.out.println(change(412815.50));
	}

	@Test
	public void testFormatUserDefNew() {
		System.out.println(formatUserDefNew(173.4341, 2));
		System.out.println(formatUserDefNew(173.4351, 2));

		System.out.println(formatUserDefNew(173.4341, 2) * 100 / 10);
		System.out.println(formatUserDefNew(173.4351, 2) * 100 / 10);

		System.out.println(formatUserDefNew(17.515, 2));
		System.out.println(formatUserDefNew(17.515, 2) * 100 / 10);
	}
}
