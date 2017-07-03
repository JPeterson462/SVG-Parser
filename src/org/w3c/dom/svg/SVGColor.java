package org.w3c.dom.svg;

import java.util.ArrayList;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.RGBColor;
import org.w3c.dom.svg.impl.RGBColorImplementation;

public interface SVGColor extends CSSValue {
	
	/** The color type is not one of predefined types. It is
	 * 	invalid to attempt to define a new value of this type
	 * 	or to attempt to switch an existing value to this type. */
	public static final short SVG_COLORTYPE_UNKNOWN = 0;
	/** An sRGB color has been specified without an
	 * 	alternative ICC color specification. */
	public static final short SVG_COLORTYPE_RGBCOLOR = 1;
	/** An sRGB color has been specified along with an
	 * 	alternative ICC color specification. */
	public static final short SVG_COLORTYPE_RGBCOLOR_ICCCOLOR = 2;
	/** Corresponds to when keyword currentColor has been specified. */
	public static final short SVG_COLORTYPE_CURRENTCOLOR = 3;

	public short getColorType();
	
	public RGBColor getRGBColor();
	
	public SVGICCColor getICCColor();
	
	public void setRGBColor(String rgbColor) throws SVGException;
	
	public void setRGBColorICCColor(String rgbColor, String iccColor) throws SVGException;
	
	public void setColor(short colorType, String rgbColor, String iccColor) throws SVGException;
	
	public static class Implementation implements SVGColor {

		private short colorType;
		
		private RGBColor rgbColor;
		
		private SVGICCColor iccColor;
		
		@Override
		public String getCssText() {
			// TODO
			return null;
		}

		@Override
		public short getCssValueType() {
			switch (colorType) {
				case SVG_COLORTYPE_RGBCOLOR:
					return CSS_PRIMITIVE_VALUE;
				case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
					return CSS_CUSTOM;
				case SVG_COLORTYPE_CURRENTCOLOR:
					return CSS_INHERIT;
			}
			return CSS_CUSTOM;
		}

		@Override
		public void setCssText(String text) throws DOMException {
			// TODO
			switch (colorType) {
				case SVG_COLORTYPE_RGBCOLOR:
					
				case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
					
				case SVG_COLORTYPE_CURRENTCOLOR:
					
			}
		}

		@Override
		public short getColorType() {
			return colorType;
		}

		@Override
		public RGBColor getRGBColor() {
			return rgbColor;
		}

		@Override
		public SVGICCColor getICCColor() {
			return iccColor;
		}

		@Override
		public void setRGBColor(String rgbColor) throws SVGException {
			colorType = SVG_COLORTYPE_RGBCOLOR;
			this.rgbColor = parseRGBColor(rgbColor);
			if (rgbColor == null) {
				
			}
		}

		@Override
		public void setRGBColorICCColor(String rgbColor, String iccColor) throws SVGException {
			colorType = SVG_COLORTYPE_RGBCOLOR_ICCCOLOR;
			this.rgbColor = parseRGBColor(rgbColor);
			this.iccColor = parseICCColor(iccColor);
		}

		@Override
		public void setColor(short colorType, String rgbColor, String iccColor) throws SVGException {
			this.colorType = colorType;
			this.rgbColor = parseRGBColor(rgbColor);
			this.iccColor = parseICCColor(iccColor);
		}
		
		private static int parseHex(char c) {
			if (c >= '0' && c <= '9') {
				return (int) c - '0';
			}
			c = Character.toLowerCase(c);
			if (c >= 'a' && c <= 'f') {
				return 10 + (c - 'a');
			}
			return -1;
		}
		
		private static RGBColor parseRGBColor(String text) throws SVGException {
			text = text.trim();
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
					blue = b0 * 10 + b1;
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
					blue = b0 * 10 + b1;
				}
				else {
					throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid hex code.");
				}
			}
			else if (text.startsWith("rgb(") && text.endsWith(")")) {
				text = text.substring(4, text.length() - 1);
				text = text.replaceAll("\\s", "");
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
					red = Integer.parseInt(components[0].substring(0, components[0].length() - 1));
					green = Integer.parseInt(components[1].substring(0, components[1].length() - 1));
					blue = Integer.parseInt(components[2].substring(0, components[2].length() - 1));
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
		
		private static SVGICCColor parseICCColor(String text) {
			text = text.trim();
			if (text.startsWith("icc-color(") && text.endsWith(")")) {
				text = text.substring(10, text.length() - 1);
				text = text.replaceAll("\\s", "");
				String[] components = text.split(",");
				String colorProfile = components[0];
				ArrayList<SVGNumber> numbers = new ArrayList<>();
				if (components.length < 2) {
					throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid ICC color code.");
				}
				for (int i = 1; i < components.length; i++) {
					SVGNumber number = new SVGNumber.Implementation(Float.parseFloat(components[i]));
					numbers.add(number);
				}
				SVGNumberList list = new SVGNumberList.Implementation(numbers);
				SVGICCColor color = new SVGICCColor.Implementation(colorProfile, list);
				return color;
				
			} else {
				throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid ICC color code.");
			}
		}
		
	}
	
}
