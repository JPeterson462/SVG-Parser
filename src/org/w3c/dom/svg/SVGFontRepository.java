package org.w3c.dom.svg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.css.CSSNumberValue;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStringListValue;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.css.impl.CSSFontFaceRuleImplementation;
import org.w3c.dom.css.impl.CSSPropertyNames;
import org.w3c.dom.fonts.SVGFont;
import org.w3c.dom.fonts.SVGFontAttributes;
import org.w3c.dom.fonts.SVGFontFormat;
import org.w3c.dom.fonts.SVGFontParser;
import org.w3c.dom.svg.fonts.SVGFontFaceElement;
import org.w3c.dom.svg.fonts.SVGFontFaceNameElement;
import org.w3c.dom.svg.fonts.SVGFontFaceParser;
import org.w3c.dom.svg.fonts.SVGFontFaceSrcElement;
import org.w3c.dom.svg.fonts.SVGFontFaceUriElement;

import com.digiturtle.util.FloatList;
import com.digiturtle.util.ShortList;

@SuppressWarnings("rawtypes")
public class SVGFontRepository {

	private static HashMap<String, SVGFont> fontMapping = new HashMap<>();
	
	private static ArrayList<String> toList(SVGStringList stringList) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < stringList.getLength(); i++) {
			list.add(stringList.getItem(i));
		}
		return list;
	}

	private static ArrayList<String> toList(SVGLengthList lengthList) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < lengthList.getNumberOfItems(); i++) {
			list.add(lengthList.getItem(i).getValueAsString());
		}
		return list;
	}
	
	private static ShortList toList(SVGEnumerationList enumList) {
		ShortList list = new ShortList();
		for (int i = 0; i < enumList.getNumberOfItems(); i++) {
			list.add(enumList.getItem(i));
		}
		return list;
	}
	
	private static FloatList toList(SVGNumberList numberList) {
		FloatList list = new FloatList();
		for (int i = 0; i < numberList.getNumberOfItems(); i++) {
			list.add(numberList.getItem(i).getValue());
		}
		return list;
	}
	
	private static ArrayList<String> toList(SVGUnicodeRangeList unicodeRangeList) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < unicodeRangeList.getNumberOfItems(); i++) {
			list.add(unicodeRangeList.getItem(i).getValue());
		}
		return list;
	}
	
	private static HashMap<Integer, Float> toMap(HashMap<Integer, SVGNumber> map) {
		HashMap<Integer, Float> floatMap = new HashMap<>();
		for (Map.Entry<Integer, SVGNumber> entry : map.entrySet()) {
			floatMap.put(entry.getKey(), entry.getValue().getValue());
		}
		return floatMap;
	}
	
	private static SVGFontAttributes loadAttributes(SVGFontFace fontFace) {
		SVGFontAttributes fontAttributes = new SVGFontAttributes();
		fontAttributes.setAccentHeight(fontFace.getAccentHeight().getValue());
		fontAttributes.setAlphabetic(fontFace.getAlphabetic().getValue());
		fontAttributes.setAscent(fontFace.getAscent().getValue());
		fontAttributes.setBBox(new float[] { fontFace.getBBox().getX(), fontFace.getBBox().getY(), fontFace.getBBox().getWidth(), fontFace.getBBox().getHeight() });
		fontAttributes.setCapHeight(fontFace.getCapHeight().getValue());
		fontAttributes.setDescent(fontFace.getDescent().getValue());
		fontAttributes.setFontFamily(toList(fontFace.getFontFamily()));
		fontAttributes.setFontSize(toList(fontFace.getFontSize()));
		fontAttributes.setFontSources(fontFace.getFontSources());
		fontAttributes.setFontStretch(toList(fontFace.getFontStretch()));
		fontAttributes.setFontStyle(toList(fontFace.getFontStyle()));
		fontAttributes.setFontVariant(toList(fontFace.getFontVariant()));
		fontAttributes.setFontWeight(toList(fontFace.getFontWeight()));
		fontAttributes.setForAllFontSizes(fontFace.isForAllFontSizes());
		fontAttributes.setHanging(fontFace.getHanging().getValue());
		fontAttributes.setIdeographic(fontFace.getIdeographic().getValue());
		fontAttributes.setMathematical(fontFace.getMathematical().getValue());
		fontAttributes.setOverlinePosition(fontFace.getOverlinePosition().getValue());
		fontAttributes.setOverlineThickness(fontFace.getOverlineThickness().getValue());
		fontAttributes.setPanose1(toList(fontFace.getPanose1()));
		fontAttributes.setSlope(fontFace.getSlope().getValue());
		fontAttributes.setStemH(fontFace.getStemH().getValue());
		fontAttributes.setStemV(fontFace.getStemV().getValue());
		fontAttributes.setStrikethroughPosition(fontFace.getStrikethroughPosition().getValue());
		fontAttributes.setStrikethroughThickness(fontFace.getStrikethroughThickness().getValue());
		fontAttributes.setUnderlinePosition(fontFace.getUnderlinePosition().getValue());
		fontAttributes.setUnderlineThickness(fontFace.getUnderlineThickness().getValue());
		fontAttributes.setUnicodeRange(toList(fontFace.getUnicodeRange()));
		fontAttributes.setUnitsPerEm(fontFace.getUnitsPerEm().getValue());
		fontAttributes.setVAlphabetic(fontFace.getVAlphabetic().getValue());
		fontAttributes.setVHanging(fontFace.getVHanging().getValue());
		fontAttributes.setVIdeographic(fontFace.getVIdeographic().getValue());
		fontAttributes.setVMathematical(fontFace.getVMathematical().getValue());
		fontAttributes.setWidths(toMap(fontFace.getWidths()));
		fontAttributes.setWidthsString(fontFace.getWidthsString());
		fontAttributes.setXHeight(fontFace.getXHeight().getValue());
		return fontAttributes;
	}
	
	public static void registerFontDefinitions(CSSStyleSheet style, SVGFontParser fontParser) {
		for (int i = 0; i < style.getCssRules().getLength(); i++) {
			CSSRule rule = style.getCssRules().item(i);
			if (rule instanceof CSSFontFaceRuleImplementation) {
				CSSFontFaceRuleImplementation fontFaceRule = (CSSFontFaceRuleImplementation) rule;
				SVGFontFace fontFace = fontFaceRule.getFontFace();
				SVGFontAttributes fontAttributes = loadAttributes(fontFace);
				HashMap<String, String> fontSources = fontFace.getFontSources();
				boolean found = false;
				for (Map.Entry<String, String> entry : fontSources.entrySet()) {
					SVGFontFormat format = SVGFontFormat.determineType(entry.getValue());
					if (!found && format != null) {
						try {
							String path = entry.getKey();
							InputStream stream;
							if (path.startsWith(SVGFontFaceParser.LOCAL_FLAG)) {
								stream = new FileInputStream(path.substring(SVGFontFaceParser.LOCAL_FLAG.length()));
							} else {
								stream = new URL(path).openStream();
							}
							SVGFont font = fontParser.parseFont(format, stream, fontAttributes);
							if (font != null) {
								found = true;
							}
							fontMapping.put(fontAttributes.getFontFamily().get(0), font);
						} catch (IOException e) {
							SVGErrors.error(e);
						}
					}
				}
			}
		}
	}
	
	public static void registerFontDefinition(SVGFontFaceElement fontElement, SVGFontParser fontParser) {
		SVGFontFace fontFace = fontElement.getFontFace();
		SVGFontAttributes fontAttributes = loadAttributes(fontFace);
		NodeList children = fontElement.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (child instanceof SVGFontFaceSrcElement) {
				NodeList subChildren = child.getChildNodes();
				for (int j = 0; j < subChildren.getLength(); j++) {
					Node subChild = subChildren.item(j);
					try {
						if (subChild instanceof SVGFontFaceNameElement) { // Local Font
							String path = ((SVGFontFaceNameElement) subChild).getName();
							String suffix = path.substring(path.lastIndexOf('.') + 1);
							SVGFont font = fontParser.parseFont(SVGFontFormat.determineType(suffix), new FileInputStream(path), fontAttributes);
							fontMapping.put(fontAttributes.getFontFamily().get(0), font);
						}
						if (subChild instanceof SVGFontFaceUriElement) { // Remote Font
							String path = ((SVGFontFaceUriElement) subChild).getHref();
							String suffix = path.substring(path.lastIndexOf('.') + 1);
							SVGFont font = fontParser.parseFont(SVGFontFormat.determineType(suffix), new URL(path).openStream(), fontAttributes);
							fontMapping.put(fontAttributes.getFontFamily().get(0), font);
						}
					} catch (IOException e) {
						SVGErrors.error(e);
					}
				}
			}
		}
		
	}
	
	public static SVGFontDefinition getFont(SVGElement element) {
		if (!(element instanceof SVGStylable)) {
			return null;
		}
		CSSStyleDeclaration style = ((SVGStylable) element).getStyle();
		CSSStringListValue fontFamilies = (CSSStringListValue) style.getPropertyCSSValue(CSSPropertyNames.FONT_FAMILY);
		if (fontFamilies.isInherit()) {
			Node parent = element.getParentNode();
			while (parent != null) {
				if (parent instanceof SVGStylable) {
					return getFont((SVGElement) parent);
				}
			}
			return null;
		}
		String[] values = fontFamilies.getValues();
		SVGFont font = null;
		for (int i = 0; i < values.length && font == null; i++) {
			if (fontMapping.containsKey(values[i])) {
				font = fontMapping.get(values[i]);
			}
		}
		CSSNumberValue fontSize = (CSSNumberValue) style.getPropertyCSSValue(CSSPropertyNames.FONT_SIZE);
		if (font != null) {
			return new SVGFontDefinition(font, fontSize.getValue() / SVGFont.BASE_SIZE);
		}
		return null;
	}

	public static class SVGFontDefinition {
		
		private SVGFont font;
		
		private float scale;
		
		public SVGFontDefinition(SVGFont font, float scale) {
			this.font = font;
			this.scale = scale;
		}
		
		public SVGFont getFont() {
			return font;
		}
		
		public float getScale() {
			return scale;
		}
		
	}

}
