package org.w3c.dom.css.impl.values;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSColorValue;
import org.w3c.dom.css.CSSTypedValue;
import org.w3c.dom.css.CSSValueType;
import org.w3c.dom.css.RGBColor;
import org.w3c.dom.svg.Colors;
import org.w3c.dom.svg.SVGException;
import org.w3c.dom.svg.SVGRegex;
import org.w3c.dom.svg.impl.RGBColorImplementation;

public class CSSColorValueImplementation implements CSSColorValue, CSSTypedValue {
	
	private RGBColor rgbColor;
	
	private float alpha;
	
	private String cssText;
	
	public CSSColorValueImplementation(String cssText) {
		setCssText(cssText);
	}
	
	public int getRed() {
		return (int) (rgbColor.getRed().getFloatValue((short) 0) * RGBColorImplementation.MAX_COLOR_COMPONENT);
	}
	
	public int getGreen() {
		return (int) (rgbColor.getGreen().getFloatValue((short) 0) * RGBColorImplementation.MAX_COLOR_COMPONENT);
	}
	
	public int getBlue() {
		return (int) (rgbColor.getBlue().getFloatValue((short) 0) * RGBColorImplementation.MAX_COLOR_COMPONENT);
	}
	
	public float getAlpha() {
		return alpha;
	}

	@Override
	public String getCssText() {
		return cssText;
	}

	@Override
	public short getCssValueType() {
		if (cssText.equals("inherit")) {
			return CSS_INHERIT;
		}
		return CSS_PRIMITIVE_VALUE;
	}

	@Override
	public void setCssText(String cssText) throws DOMException {
		this.cssText = cssText;
		if (cssText.equals("inherit")) {
			// inherit
		} else {
			rgbColor = parseRGBColor(cssText);
		}
	}
	
	private int parseHex(char c) {
		if (c >= '0' && c <= '9') {
			return (int) c - '0';
		}
		c = Character.toLowerCase(c);
		if (c >= 'a' && c <= 'f') {
			return 10 + (c - 'a');
		}
		return -1;
	}
	
	private RGBColor parseRGBColor(String text) throws SVGException {
		text = text.trim();
		alpha = 1;
		int red = -1, green = -1, blue = -1;
		if (text.startsWith("#")) {
			if (text.length() == 7) {
				int r0 = parseHex(text.charAt(1));
				int r1 = parseHex(text.charAt(2));
				int g0 = parseHex(text.charAt(3));
				int g1 = parseHex(text.charAt(4));
				int b0 = parseHex(text.charAt(5));
				int b1 = parseHex(text.charAt(6));
				if (r0 < 0 || r1 < 0 || g0 < 0 || g1 < 0 || b0 < 0 || b1 < 0) {
					throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid hex code.");
				}
				red = r0 * 16 + r1;
				green = g0 * 16 + g1;
				blue = b0 * 16 + b1;
			}
			else if (text.length() == 9) {
				int r0 = parseHex(text.charAt(1));
				int r1 = parseHex(text.charAt(2));
				int g0 = parseHex(text.charAt(3));
				int g1 = parseHex(text.charAt(4));
				int b0 = parseHex(text.charAt(5));
				int b1 = parseHex(text.charAt(6));
				int a0 = parseHex(text.charAt(7));
				int a1 = parseHex(text.charAt(8));
				if (r0 < 0 || r1 < 0 || g0 < 0 || g1 < 0 || b0 < 0 || b1 < 0) {
					throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid hex code.");
				}
				red = r0 * 16 + r1;
				green = g0 * 16 + g1;
				blue = b0 * 16 + b1;
				alpha = (a0 * 16 + a1) / 256f;
			}
			else if (text.length() == 4) {
				int r0 = parseHex(text.charAt(1));
				int r1 = parseHex(text.charAt(1));
				int g0 = parseHex(text.charAt(2));
				int g1 = parseHex(text.charAt(2));
				int b0 = parseHex(text.charAt(3));
				int b1 = parseHex(text.charAt(3));
				if (r0 < 0 || r1 < 0 || g0 < 0 || g1 < 0 || b0 < 0 || b1 < 0) {
					throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid hex code.");
				}
				red = r0 * 16 + r1;
				green = g0 * 16 + g1;
				blue = b0 * 16 + b1;
			}
			else {
				throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid hex code.");
			}
		}
		else if (text.startsWith("rgb(") && text.endsWith(")")) {
			text = text.substring(4, text.length() - 1);
			text = text.replaceAll(SVGRegex.WHITESPACE, "");
			String[] components = text.split(",");
			if (components[0].endsWith("%") && components[1].endsWith("%") && components[2].endsWith("%")) {
				float rFloat = Float.parseFloat(components[0].substring(0, components[0].length() - 1)) / 100f;
				float gFloat = Float.parseFloat(components[1].substring(0, components[1].length() - 1)) / 100f;
				float bFloat = Float.parseFloat(components[2].substring(0, components[2].length() - 1)) / 100f;
				red = (int) (rFloat * RGBColorImplementation.MAX_COLOR_COMPONENT);
				green = (int) (gFloat * RGBColorImplementation.MAX_COLOR_COMPONENT);
				blue = (int) (bFloat * RGBColorImplementation.MAX_COLOR_COMPONENT);
			}
			else if (!components[0].endsWith("%") && !components[1].endsWith("%") && !components[2].endsWith("%")) {
				red = Integer.parseInt(components[0]);
				green = Integer.parseInt(components[1]);
				blue = Integer.parseInt(components[2]);
			}
			else {
				throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid RGB code.");
			}
		}
		else if (text.startsWith("rgba(") && text.endsWith(")")) {
			text = text.substring(5, text.length() - 1);
			text = text.replaceAll(SVGRegex.WHITESPACE, "");
			String[] components = text.split(",");
			if (components[0].endsWith("%") && components[1].endsWith("%") && components[2].endsWith("%")) {
				float rFloat = Float.parseFloat(components[0].substring(0, components[0].length() - 1)) / 100f;
				float gFloat = Float.parseFloat(components[1].substring(0, components[1].length() - 1)) / 100f;
				float bFloat = Float.parseFloat(components[2].substring(0, components[2].length() - 1)) / 100f;
				float aFloat = Float.parseFloat(components[3]);
				red = (int) (rFloat * RGBColorImplementation.MAX_COLOR_COMPONENT);
				green = (int) (gFloat * RGBColorImplementation.MAX_COLOR_COMPONENT);
				blue = (int) (bFloat * RGBColorImplementation.MAX_COLOR_COMPONENT);
				alpha = aFloat;
			}
			else if (!components[0].endsWith("%") && !components[1].endsWith("%") && !components[2].endsWith("%")) {
				red = Integer.parseInt(components[0]);
				green = Integer.parseInt(components[1]);
				blue = Integer.parseInt(components[2]);
				alpha = Float.parseFloat(components[3]);
			}
			else {
				throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid RGB code.");
			}
		}
		else {
			RGBColor byName = Colors.getColor(text);
			if (byName != null) {
				return new RGBColorImplementation(byName);
			}
			throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid color name.");
		}
		return new RGBColorImplementation(red, green, blue);
	}

	@Override
	public CSSValueType getType() {
		return CSSValueType.COLOR;
	}

}
