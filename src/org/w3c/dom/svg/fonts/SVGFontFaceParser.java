package org.w3c.dom.svg.fonts;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.SVGEnumerationList;
import org.w3c.dom.svg.SVGFontFace;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGLengthList;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGNumberList;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGUnicodeRange;
import org.w3c.dom.svg.SVGUnicodeRangeList;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ParsingState;

public class SVGFontFaceParser {

	private HashMap<String, Short> fontStyle_strToEnum = new HashMap<>();
	private HashMap<Short, String> fontStyle_enumToStr = new HashMap<>();
	
	private HashMap<String, Short> fontVariant_strToEnum = new HashMap<>();
	private HashMap<Short, String> fontVariant_enumToStr = new HashMap<>();
	
	private HashMap<String, Short> fontWeight_strToEnum = new HashMap<>();
	private HashMap<Short, String> fontWeight_enumToStr = new HashMap<>();

	private HashMap<String, Short> fontStretch_strToEnum = new HashMap<>();
	private HashMap<Short, String> fontStretch_enumToStr = new HashMap<>();
	
	public SVGFontFaceParser() {
		register(fontStyle_strToEnum, fontStyle_enumToStr, "all", SVGFontFace.FONTSTYLE_ALL);
		register(fontStyle_strToEnum, fontStyle_enumToStr, "normal", SVGFontFace.FONTSTYLE_NORMAL);
		register(fontStyle_strToEnum, fontStyle_enumToStr, "italic", SVGFontFace.FONTSTYLE_ITALIC);
		register(fontStyle_strToEnum, fontStyle_enumToStr, "oblique", SVGFontFace.FONTSTYLE_OBLIQUE);
		register(fontVariant_strToEnum, fontVariant_enumToStr, "normal", SVGFontFace.FONTVARIANT_NORMAL);
		register(fontVariant_strToEnum, fontVariant_enumToStr, "small-caps", SVGFontFace.FONTVARIANT_SMALLCAPS);
		register(fontWeight_strToEnum, fontWeight_enumToStr, "all", SVGFontFace.FONTWEIGHT_ALL);
		register(fontWeight_strToEnum, fontWeight_enumToStr, "normal", SVGFontFace.FONTWEIGHT_NORMAL);
		register(fontWeight_strToEnum, fontWeight_enumToStr, "bold", SVGFontFace.FONTWEIGHT_BOLD);
		register(fontWeight_strToEnum, fontWeight_enumToStr, "100", SVGFontFace.FONTWEIGHT_100);
		register(fontWeight_strToEnum, fontWeight_enumToStr, "200", SVGFontFace.FONTWEIGHT_200);
		register(fontWeight_strToEnum, fontWeight_enumToStr, "300", SVGFontFace.FONTWEIGHT_300);
		register(fontWeight_strToEnum, fontWeight_enumToStr, "400", SVGFontFace.FONTWEIGHT_400);
		register(fontWeight_strToEnum, fontWeight_enumToStr, "500", SVGFontFace.FONTWEIGHT_500);
		register(fontWeight_strToEnum, fontWeight_enumToStr, "600", SVGFontFace.FONTWEIGHT_600);
		register(fontWeight_strToEnum, fontWeight_enumToStr, "700", SVGFontFace.FONTWEIGHT_700);
		register(fontWeight_strToEnum, fontWeight_enumToStr, "800", SVGFontFace.FONTWEIGHT_800);
		register(fontWeight_strToEnum, fontWeight_enumToStr, "900", SVGFontFace.FONTWEIGHT_900);
		register(fontStretch_strToEnum, fontStretch_enumToStr, "all", SVGFontFace.FONTSTRETCH_ALL);
		register(fontStretch_strToEnum, fontStretch_enumToStr, "normal", SVGFontFace.FONTSTRETCH_NORMAL);
		register(fontStretch_strToEnum, fontStretch_enumToStr, "ultra-condensed", SVGFontFace.FONTSTRETCH_ULTRACONDENSED);
		register(fontStretch_strToEnum, fontStretch_enumToStr, "extra-condensed", SVGFontFace.FONTSTRETCH_EXTRACONDENSED);
		register(fontStretch_strToEnum, fontStretch_enumToStr, "condensed", SVGFontFace.FONTSTRETCH_CONDENSED);
		register(fontStretch_strToEnum, fontStretch_enumToStr, "semi-condensed", SVGFontFace.FONTSTRETCH_SEMICONDENSED);
		register(fontStretch_strToEnum, fontStretch_enumToStr, "ultra-expanded", SVGFontFace.FONTSTRETCH_ULTRAEXPANDED);
		register(fontStretch_strToEnum, fontStretch_enumToStr, "extra-expanded", SVGFontFace.FONTSTRETCH_EXTRAEXPANDED);
		register(fontStretch_strToEnum, fontStretch_enumToStr, "expanded", SVGFontFace.FONTSTRETCH_EXPANDED);
		register(fontStretch_strToEnum, fontStretch_enumToStr, "semi-expanded", SVGFontFace.FONTSTRETCH_SEMIEXPANDED);
	}
	
	private void register(HashMap<String, Short> strToEnum, HashMap<Short, String> enumToStr, String str, short value) {
		strToEnum.put(str, value);
		enumToStr.put(value, str);
	}
	
	@FunctionalInterface
	public interface FontAttributeGetter {
		public String getAttribute(String attribute, String defaultValue);
	}
	
	public SVGFontFace parseFontFace(FontAttributeGetter element, ParsingState parsingState) {
		String fontFamilyStr = element.getAttribute(Attributes.FONT_FAMILY, null);
		String[] fontFamilyParts = fontFamilyStr.split(",");
		ArrayList<String> fontFamilyList = new ArrayList<>();
		for (int i = 0; i < fontFamilyParts.length; i++) {
			fontFamilyList.add(fontFamilyParts[i].trim());
		}
		SVGStringList fontFamily = new SVGStringList.Implementation(fontFamilyList);
		String fontStyleStr = element.getAttribute(Attributes.FONT_STYLE, "all");
		String[] fontStyleParts = fontStyleStr.split(",");
		ArrayList<Short> fontStyleEnum = new ArrayList<>();
		for (int i = 0; i < fontStyleParts.length; i++) {
			fontStyleEnum.add(fontStyle_strToEnum.get(fontStyleParts[i].trim()));
		}
		SVGEnumerationList fontStyle = new SVGEnumerationList.Implementation(fontStyleEnum);
		String fontVariantStr = element.getAttribute(Attributes.FONT_VARIANT, "normal");
		String[] fontVariantParts = fontVariantStr.split(",");
		ArrayList<Short> fontVariantEnum = new ArrayList<>();
		for (int i = 0; i < fontVariantParts.length; i++) {
			fontVariantEnum.add(fontVariant_strToEnum.get(fontVariantParts[i].trim()));
		}
		SVGEnumerationList fontVariant = new SVGEnumerationList.Implementation(fontVariantEnum);
		String fontWeightStr = element.getAttribute(Attributes.FONT_WEIGHT, "all");
		String[] fontWeightParts = fontWeightStr.split(",");
		ArrayList<Short> fontWeightEnum = new ArrayList<>();
		for (int i = 0; i < fontWeightParts.length; i++) {
			fontWeightEnum.add(fontWeight_strToEnum.get(fontWeightParts[i].trim()));
		}
		SVGEnumerationList fontWeight = new SVGEnumerationList.Implementation(fontWeightEnum);
		String fontStretchStr = element.getAttribute( Attributes.FONT_STRETCH, "normal");
		String[] fontStretchParts = fontStretchStr.split(",");
		ArrayList<Short> fontStretchEnum = new ArrayList<>();
		for (int i = 0; i < fontStretchParts.length; i++) {
			fontStretchEnum.add(fontWeight_strToEnum.get(fontStretchParts[i].trim()));
		}
		SVGEnumerationList fontStretch = new SVGEnumerationList.Implementation(fontStretchEnum);
		String fontSizeStr = element.getAttribute(Attributes.FONT_SIZE, "all");
		boolean forAllFontSizes = fontSizeStr.equals("all");
		ArrayList<SVGLength> fontSizes = new ArrayList<>();
		if (!forAllFontSizes) {
			String[] fontSizeParts = fontSizeStr.split(",");
			for (int i = 0; i < fontSizeParts.length; i++) {
				SVGLength length = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
				length.setValueAsString(fontSizeParts[i].trim());
				fontSizes.add(length);
			}
		}
		SVGLengthList fontSize = new SVGLengthList.Implementation(fontSizes);
		String unicodeRangeStr = element.getAttribute(Attributes.UNICODE_RANGE, "U+0-7FFFFFFF");
		String[] unicodeRangeParts = unicodeRangeStr.split(",");
		ArrayList<SVGUnicodeRange> unicodeRanges = new ArrayList<>();
		for (int i = 0; i < unicodeRangeParts.length; i++) {
			SVGUnicodeRange range = new SVGUnicodeRange.Implementation();
			range.setValue(unicodeRangeParts[i].trim());
			unicodeRanges.add(range);
		}
		SVGUnicodeRangeList unicodeRange = new SVGUnicodeRangeList.Implementation(unicodeRanges);
		SVGNumber unitsPerEm = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.UNITS_PER_EM, null)));
		String panose1Str = element.getAttribute(Attributes.PANOSE_1, "0 0 0 0 0 0 0 0 0 0");
		ArrayList<String> panose1Parts = StringUtils.splitByWhitespace(panose1Str);
		ArrayList<SVGNumber> panose1Values = new ArrayList<>();
		for (int i = 0; i < panose1Parts.size(); i++) {
			panose1Values.add(new SVGNumber.Implementation(Float.parseFloat(panose1Parts.get(i))));
		}
		SVGNumberList panose1 = new SVGNumberList.Implementation(panose1Values);
		SVGNumber stemV = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.STEMV, null)));
		SVGNumber stemH = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.STEMH, null)));
		SVGNumber slope = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.SLOPE, null)));
		SVGNumber capHeight = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.CAP_HEIGHT, null)));
		SVGNumber xHeight = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.X_HEIGHT, null)));
		SVGNumber accentHeight = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.ACCENT_HEIGHT, null)));
		SVGNumber ascent = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.ASCENT, null)));
		SVGNumber descent = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.DESCENT, null)));
		HashMap<Integer, SVGNumber> widths = new HashMap<>();
		String widthsStr = element.getAttribute(Attributes.WIDTHS, "0");
		String[] widthsParts = widthsStr.split(",");
		for (int i = 0; i < widthsParts.length; i++) {
			ArrayList<String> parts = StringUtils.splitByWhitespace(widthsParts[i]);
			int offset = 0;
			SVGUnicodeRange range = new SVGUnicodeRange.Implementation();
			if (parts.get(0).startsWith("U+")) {
				range.setValue(parts.get(0));
				offset = 1;
			}
			int c = range.getMin();
			SVGNumber last = new SVGNumber.Implementation(0);
			for (int j = offset; j < parts.size() && j < (range.getMax() - range.getMin() + 1); j++) {
				widths.put(c, last = new SVGNumber.Implementation(Float.parseFloat(parts.get(j))));
				c++;
			}
			if (parts.size() < (range.getMax() - range.getMin() + 1)) {
				while (c < range.getMax()) {
					widths.put(c, new SVGNumber.Implementation(last.getValue()));
					c++;
				}
			}
		}
		String[] bBoxValues = element.getAttribute(Attributes.BBOX, null).split(",");
		SVGRect bBox = null;
		if (bBoxValues.length >= 4) {
			bBox = new SVGRect.Implementation(Float.parseFloat(bBoxValues[0].trim()), Float.parseFloat(bBoxValues[1].trim()), 
					Float.parseFloat(bBoxValues[2].trim()), Float.parseFloat(bBoxValues[3].trim()));
		}
		SVGNumber ideographic = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.IDEOGRAPHIC, null)));
		SVGNumber alphabetic = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.ALPHABETIC, null)));
		SVGNumber mathematical = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.MATHEMATICAL, null)));
		SVGNumber hanging = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.HANGING, null)));
		SVGNumber vIdeographic = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.V_IDEOGRAPHIC, null)));
		SVGNumber vAlphabetic = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.V_ALPHABETIC, null)));
		SVGNumber vMathematical = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.V_MATHEMATICAL, null)));
		SVGNumber vHanging = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.V_HANGING, null)));
		SVGNumber underlinePosition = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.UNDERLINE_POSITION, null)));
		SVGNumber underlineThickness = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.UNDERLINE_THICKNESS, null)));
		SVGNumber strikethroughPosition = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.STRIKETHROUGH_POSITION, null)));
		SVGNumber strikethroughThickness = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.STRIKETHROUGH_THICKNESS, null)));
		SVGNumber overlinePosition = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.OVERLINE_POSITION, null)));
		SVGNumber overlineThickness = new SVGNumber.Implementation(parseFloat(element.getAttribute(Attributes.OVERLINE_THICKNESS, null)));
		SVGFontFace fontFace = new SVGFontFace.Implementation(fontFamily, fontStyle, fontVariant,
				fontWeight, fontStretch, fontSize, forAllFontSizes, unicodeRange, unitsPerEm, panose1, stemV,
				stemH, slope, capHeight, xHeight, accentHeight, ascent, descent, widths, widthsStr, bBox,
				ideographic, alphabetic, mathematical, hanging, vIdeographic, vAlphabetic,
				vMathematical, vHanging, underlinePosition, underlineThickness, 
				strikethroughPosition, strikethroughThickness, overlinePosition, overlineThickness);
		return fontFace;
	}
	
	public void saveFontFace(HashMap<String, String> attributes, SVGFontFace fontFace) {
		attributes.put(Attributes.FONT_FAMILY, join(fontFace.getFontFamily(), ", "));
		attributes.put(Attributes.FONT_STYLE, join(fontFace.getFontStyle(), ", ", fontStyle_enumToStr));
		attributes.put(Attributes.FONT_WEIGHT, join(fontFace.getFontWeight(), ", ", fontWeight_enumToStr));
		attributes.put(Attributes.FONT_STRETCH, join(fontFace.getFontStretch(), ", ", fontStretch_enumToStr));
		attributes.put(Attributes.FONT_SIZE, fontFace.isForAllFontSizes() ? "all" : join(fontFace.getFontSize(), ", "));
		attributes.put(Attributes.UNICODE_RANGE, join(fontFace.getUnicodeRange(), ", "));
		attributes.put(Attributes.UNITS_PER_EM, Float.toString(fontFace.getUnitsPerEm().getValue()));
		attributes.put(Attributes.PANOSE_1, join(fontFace.getPanose1(), " ", true));
		attributes.put(Attributes.STEMV, toString(fontFace.getStemV().getValue()));
		attributes.put(Attributes.STEMH, toString(fontFace.getStemH().getValue()));
		attributes.put(Attributes.SLOPE, toString(fontFace.getSlope().getValue()));
		attributes.put(Attributes.CAP_HEIGHT, toString(fontFace.getCapHeight().getValue()));
		attributes.put(Attributes.X_HEIGHT, toString(fontFace.getXHeight().getValue()));
		attributes.put(Attributes.ACCENT_HEIGHT, toString(fontFace.getAccentHeight().getValue()));
		attributes.put(Attributes.ASCENT, toString(fontFace.getAscent().getValue()));
		attributes.put(Attributes.DESCENT, toString(fontFace.getDescent().getValue()));
		attributes.put(Attributes.WIDTHS, fontFace.getWidthsString());
		if (fontFace.getBBox() != null) {
			attributes.put(Attributes.BBOX, toString(fontFace.getBBox().getX()) + " " + toString(fontFace.getBBox().getY()) + " " + 
											toString(fontFace.getBBox().getWidth()) + " " + toString(fontFace.getBBox().getHeight()));
		}
		attributes.put(Attributes.IDEOGRAPHIC, toString(fontFace.getIdeographic().getValue()));
		attributes.put(Attributes.ALPHABETIC, toString(fontFace.getAlphabetic().getValue()));
		attributes.put(Attributes.MATHEMATICAL, toString(fontFace.getMathematical().getValue()));
		attributes.put(Attributes.HANGING, toString(fontFace.getHanging().getValue()));
		attributes.put(Attributes.V_IDEOGRAPHIC, toString(fontFace.getVIdeographic().getValue()));
		attributes.put(Attributes.V_ALPHABETIC, toString(fontFace.getVAlphabetic().getValue()));
		attributes.put(Attributes.V_MATHEMATICAL, toString(fontFace.getVMathematical().getValue()));
		attributes.put(Attributes.V_HANGING, toString(fontFace.getVHanging().getValue()));
		attributes.put(Attributes.UNDERLINE_POSITION, toString(fontFace.getUnderlinePosition().getValue()));
		attributes.put(Attributes.UNDERLINE_THICKNESS, toString(fontFace.getUnderlineThickness().getValue()));
		attributes.put(Attributes.STRIKETHROUGH_POSITION, toString(fontFace.getStrikethroughPosition().getValue()));
		attributes.put(Attributes.STRIKETHROUGH_THICKNESS, toString(fontFace.getStrikethroughThickness().getValue()));
		attributes.put(Attributes.OVERLINE_POSITION, toString(fontFace.getOverlinePosition().getValue()));
		attributes.put(Attributes.OVERLINE_THICKNESS, toString(fontFace.getOverlineThickness().getValue()));
	}
	
	private String join(SVGStringList list, String joinBy) {
		String result = "";
		for (int i = 0; i < list.getNumberOfItems(); i++) {
			if (i > 0) {
				result += joinBy;
			}
			result += list.getItem(i);
		}
		return result;
	}
	
	private String join(SVGEnumerationList list, String joinBy, HashMap<Short, String> enumToStr) {
		String result = "";
		for (int i = 0; i < list.getNumberOfItems(); i++) {
			if (i > 0) {
				result += joinBy;
			}
			result += enumToStr.get(list.getItem(i));
		}
		return result;
	}

	private String join(SVGLengthList list, String joinBy) {
		String result = "";
		for (int i = 0; i < list.getNumberOfItems(); i++) {
			if (i > 0) {
				result += joinBy;
			}
			result += list.getItem(i).getValueAsString();
		}
		return result;
	}

	private String join(SVGUnicodeRangeList list, String joinBy) {
		String result = "";
		for (int i = 0; i < list.getNumberOfItems(); i++) {
			if (i > 0) {
				result += joinBy;
			}
			result += list.getItem(i).getValue();
		}
		return result;
	}
	
	private String join(SVGNumberList list, String joinBy, boolean integers) {
		String result = "";
		for (int i = 0; i < list.getNumberOfItems(); i++) {
			if (i > 0) {
				result += joinBy;
			}
			if (integers) {
				result += Integer.toString((int) list.getItem(i).getValue());
			} else {
				result += Float.toString(list.getItem(i).getValue());
			}
		}
		return result;
	}
	
	private String toString(Float value) {
		if (value == Float.NaN) {
			return null;
		}
		return Float.toString(value);
	}
	
	private Float parseFloat(String value) {
		if (value == null || value.length() == 0) {
			return Float.NaN;
		}
		return Float.parseFloat(value);
	}

}
