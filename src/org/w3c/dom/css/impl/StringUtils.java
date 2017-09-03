package org.w3c.dom.css.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.svg.SVGErrors;

public class StringUtils {
	
	public static final String URI_PREFIX = "url(", URI_SUFFIX = ")";

	public static String convertToWritable(float value) {
		if (Math.floor(value) == value) {
			return Integer.toString((int) Math.floor(value));
		}
		return Float.toString(value);
	}
	
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
	
	public static HashMap<String, String> getWhitespaceStrippedMap(String text) {
		HashMap<String, String> map = new HashMap<>();
		String[] lines = text.split(";");
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i].trim();
			if (line.length() == 0) {
				continue;
			}
			String[] keyValue = line.split(":");
			if (keyValue.length == 2) {
				map.put(keyValue[0].trim(), keyValue[1].trim());
			} else {
				continue; // Skip invalid lines
			}
		}
		return map;
	}
	
	public static String parseUri(String text) {
		if (text.startsWith(URI_PREFIX) && text.endsWith(URI_SUFFIX)) {
			return unquote(text.substring(URI_PREFIX.length(), text.length() - URI_SUFFIX.length()));
		}
		return SVGErrors.error("Invalid Functional URI: " + text);
	}
	
	private static String unquote(String text) {
		while (text.startsWith("\"")) {
			if (!text.endsWith("\"")) {
				SVGErrors.error("Invalid Functional URI: " + text);
			}
			text = text.substring(1, text.length() - 1);
		}
		return text;
	}
	
}
