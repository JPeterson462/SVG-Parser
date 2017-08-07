package org.w3c.dom.css.impl;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static ArrayList<String> splitByWhitespace(String text) {
		ArrayList<String> list = new ArrayList<>();
		Matcher matcher = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(text);
		while (matcher.find()) {
			list.add(matcher.group(1).replaceAll("\"", ""));
		}
		return list;
	}
	
	public static boolean contains(String value, String[] array, boolean caseSensitive) {
		for (int i = 0; i < array.length; i++) {
			if (caseSensitive && array[i].equals(value)) {
				return true;
			}
			if (!caseSensitive && array[i].equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}
	
}
