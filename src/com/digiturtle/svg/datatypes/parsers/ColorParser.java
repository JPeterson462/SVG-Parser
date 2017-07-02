package com.digiturtle.svg.datatypes.parsers;

import com.digiturtle.svg.DataParser;
import com.digiturtle.svg.datatypes.Color;
import com.digiturtle.svg.datatypes.Colors;

public class ColorParser implements DataParser<Color> {

	private int parseHex(char c) {
		if (Character.isDigit(c)) {
			return c - '0';
		}
		c = Character.toLowerCase(c);
		if (c >= 'a' && c <= 'f') {
			return 10 + (c - 'a');
		}
		return -1;
	}
	
	private int parseHex(char a, char b) {
		int ax = parseHex(a), bx = parseHex(b);
		if (ax < 0 || bx < 0) {
			return -1;
		}
		return ax * 16 + bx;
	}
	
	@Override
	public Color parse(String text, boolean presentationAttribute) {
		text = text.trim();
		text = text.replaceAll(" ", "").replaceAll("\t", "").replaceAll("\r", "").replaceAll("\n", "");
		Color color = null;
		if (text.startsWith("#")) {
			text = text.substring(1);
			if (text.length() == 6) {
				int red = parseHex(text.charAt(0), text.charAt(1));
				int green = parseHex(text.charAt(2), text.charAt(3));
				int blue = parseHex(text.charAt(4), text.charAt(5));
				color = new Color(red, green, blue);
			}
			else if (text.length() == 3) {
				int red = parseHex(text.charAt(0), text.charAt(0));
				int green = parseHex(text.charAt(1), text.charAt(1));
				int blue = parseHex(text.charAt(2), text.charAt(2));
				color = new Color(red, green, blue);
			}
			else {
				return null;
			}
		}
		else if (text.startsWith("rgb(")) {
			text = text.substring(4, text.length() - 1);
			String[] parts = text.split(",");
			if (parts[0].contains("%") && parts[1].contains("%") && parts[2].contains("%")) {
				int red = Integer.parseInt(parts[0].substring(0, parts[0].length() - 1)) * 255 / 100;
				int green = Integer.parseInt(parts[1].substring(0, parts[1].length() - 1)) * 255 / 100;
				int blue = Integer.parseInt(parts[2].substring(0, parts[2].length() - 1)) * 255 / 100;
				color = new Color(red, green, blue);
			}
			else if (!parts[0].contains("%") && !parts[1].contains("%") && !parts[2].contains("%")) {
				int red = Integer.parseInt(parts[0]);
				int green = Integer.parseInt(parts[1]);
				int blue = Integer.parseInt(parts[2]);
				color = new Color(red, green, blue);
			}
		}
		else {
			Color template = Colors.getColor(text);
			if (template == null) {
				return null;
			}
			color = new Color(template);
		}
		return color;
	}

}
