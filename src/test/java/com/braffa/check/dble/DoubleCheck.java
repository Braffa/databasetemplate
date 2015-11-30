package com.braffa.check.dble;

import java.math.BigDecimal;

public class DoubleCheck {

	public static String formatDouble(String sInput) {
		if (sInput == null || sInput.length() == 0) {
			return "0";
		}
		BigDecimal bd = new BigDecimal(Double.parseDouble(sInput));
		BigDecimal rounded = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		String format = rounded.toPlainString();
		if (format.endsWith(".00")) {
			return format.substring(0, format.indexOf('.'));
		} else {
			return format;
		}
	}

	public static void main(String[] args) {
		System.out.println(formatDouble("49.3969750000000"));
		System.out.println(formatDouble("0"));
		System.out.println(formatDouble("4"));
	}

}
