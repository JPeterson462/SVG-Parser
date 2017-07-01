package com.digiturtle.svg;

public class StringUtils {
	
	public static boolean isNumber(String text) {
		try {
			Float.parseFloat(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
