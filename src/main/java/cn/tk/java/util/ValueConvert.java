package cn.tk.java.util;

import java.math.BigDecimal;

public class ValueConvert {
	// 人民币小写转大写
	public static String moneySmall2Big(String cash)
	{
		String sUnit = "分角元拾佰仟万拾佰仟亿拾佰仟万";
		String sNumber = "零壹贰叁肆伍陆柒捌玖";

		String outstr = "";
		boolean bError = false;
		int ascii;

		for (int i = 1; i <= cash.length(); i++) {
			ascii = cash.toCharArray()[i - 1];
			if (((ascii < 48) || (ascii > 57)) && (ascii != 46)) {
				bError = true;
				break;
			}
		}

		if (!bError) {
			// change by cg 大小写转换中魔幻数字的问题。
			BigDecimal b1 = new BigDecimal(cash);
			BigDecimal b2 = new BigDecimal("100");
			String temps = b1.multiply(b2).intValue() + "";
			// add end

			System.out.println("temps=" + temps);
			for (int i = temps.length(); i >= 1; i--) {
				String ss = temps.substring(i - 1, i);
				System.out.println("ss=" + ss + " i=" + i);
				if (ss.equals("0")) {
					if (temps.length() - i <= 1) {
						outstr = "零"
								+ sUnit.substring(temps.length() - i,
										temps.length() - i + 1) + outstr;
					} else if ((temps.length() - i) == 2) {
						outstr = "元" + outstr;
					} else {
						if (!temps.substring(i, i + 1).equals("0")) {
							outstr = "零" + outstr;
						}
					}
				} else {
					outstr = sNumber.substring(Integer.parseInt(ss),
							Integer.parseInt(ss) + 1)
							+ sUnit.substring(temps.length() - i,
									temps.length() - i + 1) + outstr;
				}
			}
		}
		if (bError) {
			return "格式错误";
		} else {
			return outstr;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(moneySmall2Big("12345609"));
	}
}
