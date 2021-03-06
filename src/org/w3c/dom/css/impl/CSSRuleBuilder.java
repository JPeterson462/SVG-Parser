package org.w3c.dom.css.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.stylesheets.MediaList;
import org.w3c.dom.svg.SVGColorProfileRule;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.fonts.SVGFontFaceParser;
import org.w3c.dom.svg.parser.ParsingState;

public class CSSRuleBuilder {

	private static String unquote(String text) {
		if (text.startsWith("\"") && text.endsWith("\"")) {
			return text.substring(1, text.length() - 1);
		}
		return SVGErrors.error("Invalid quoted text");
	}
	
	private static String join(String[] array, String joinBy, int offset) {
		String text = "";
		for (int i = offset; i < array.length; i++) {
			if (i > offset) {
				text += joinBy;
			}
			text += array[i];
		}
		return text;
	}
	
	private static String[] splitHeader(String text) {
		if (!text.contains("{")) {
			return new String[] { text, "" };
		}
		int lBrace = text.indexOf('{');
		String header = text.substring(0, lBrace);
		String body = text.substring(lBrace + 1, text.lastIndexOf('}'));
		header = header.trim();
		body = body.trim();
		return new String[] { header, body };
	}
	
	public static CSSRuleListImplementation createRuleList(String text, CSSRule parentRule, CSSStyleDeclarationImplementation declaration, CSSStyleSheet stylesheet, ParsingState parsingState) {
		// go until { (+1) and } (-1) is zero
		int tally = 0;
		boolean foundBrace = false;
		char[] textArray = text.toCharArray();
		int seek = 0, start = 0, end = 0;
		ArrayList<CSSRule> rules = new ArrayList<>();
		while (seek < textArray.length) {
			if (textArray[seek] == '{') {
				if (tally == 0) {
					start = seek;
				}
				tally++;
			}
			if (textArray[seek] == '}') {
				tally--;
				if (tally == 0) {
					end = seek;
				}
			}
			if (textArray[seek] == '{' || textArray[seek] == '}') {
				foundBrace = true;
			}
			seek++;
			if (foundBrace && tally == 0) {
				String subText = text.substring(start, end + 1);
				rules.add(createRule(subText, parentRule, declaration, stylesheet, parsingState));
				start = seek;
				foundBrace = false;
			}
		}
		return new CSSRuleListImplementation(rules);
	}
	
	public static CSSRule createRule(String text, CSSRule parentRule, CSSStyleDeclarationImplementation declaration, CSSStyleSheet stylesheet, ParsingState parsingState) {
		text = text.trim();
		String[] headerBody = splitHeader(text);
		String[] header = StringUtils.splitByWhitespace(headerBody[0]).toArray(new String[0]);
		String body = headerBody[1];
		if (text.startsWith(CSSRulePrefixes.CHARSET)) {
			if (header.length == 2) {
				return new CSSCharsetRuleImplementation(parentRule, stylesheet, 
						new CSSStyleDeclarationImplementation(parentRule, declaration), unquote(header[1]));
			} else {
				SVGErrors.error("Invalid " + CSSRulePrefixes.CHARSET);
			}
		}
		if (text.startsWith(CSSRulePrefixes.FONT_FACE)) {
			if (header.length == 1) {
				HashMap<String, String> properties = new HashMap<>();
				String[] rules = body.split(";");
				for (int i = 0; i < rules.length; i++) {
					String ruleRaw = rules[i].trim();
					if (ruleRaw.length() == 0) {
						continue;
					}
					String[] rule = ruleRaw.split(":");
					String propertyName = rule[0].trim();
					String cssText = rule[1];
					properties.put(propertyName, cssText);
				}
				SVGFontFaceParser parser = new SVGFontFaceParser();
				return new CSSFontFaceRuleImplementation(parentRule, stylesheet, declaration, parser.parseFontFace(properties::getOrDefault, parsingState));
			} else {
				return SVGErrors.error("Invalid " + CSSRulePrefixes.FONT_FACE);
			}
		}
		if (text.startsWith(CSSRulePrefixes.IMPORT)) {
			String href = null;
			MediaList mediaList = new MediaListImplementation();
			if (header[1].startsWith("\"") && header[1].endsWith("\"")) {
				href = unquote(header[1]);
			}
			else if (header[1].startsWith("url(") && header[1].endsWith(")")) {
				String subtext = header[1].substring(4, header[1].length() - 1);
				if (subtext.startsWith("\"")) {
					href = unquote(subtext);
				} else {
					href = subtext;
				}
			}
			else {
				return SVGErrors.error("Invalid " + CSSRulePrefixes.IMPORT);
			}
			mediaList.setMediaText(join(header, " ", 2));
			return new CSSImportRuleImplementation(parentRule, stylesheet, 
					new CSSStyleDeclarationImplementation(parentRule, declaration), href, mediaList, stylesheet);
		}
		if (text.startsWith(CSSRulePrefixes.MEDIA)) {
			MediaList mediaList = new MediaListImplementation();
			mediaList.setMediaText(join(header, " ", 1));
			return new CSSMediaRuleImplementation(parentRule, stylesheet,
					new CSSStyleDeclarationImplementation(parentRule, declaration), createRuleList(body, parentRule, declaration, stylesheet, parsingState), mediaList, parsingState);
		}
		if (text.startsWith(CSSRulePrefixes.PAGE) || text.startsWith(CSSRulePrefixes.KEYFRAMES) ||
				text.startsWith(CSSRulePrefixes.KEYFRAME) || text.startsWith(CSSRulePrefixes.NAMESPACE) ||
				text.startsWith(CSSRulePrefixes.COUNTER_STYLE) || text.startsWith(CSSRulePrefixes.SUPPORTS) ||
				text.startsWith(CSSRulePrefixes.DOCUMENT) || text.startsWith(CSSRulePrefixes.FONT_FEATURE_VALUES) ||
				text.startsWith(CSSRulePrefixes.VIEWPORT) || text.startsWith(CSSRulePrefixes.REGION_STYLE)) {
			DOMErrors.notSupported();
		}
		if (text.startsWith(CSSRulePrefixes.COLOR_PROFILE)) {
			String src = "sRGB", name = null;
			short renderingIntent = SVGColorProfileRule.RENDERING_INTENT_AUTO;
			String[] rules = body.split(";");
			for (int i = 0; i < rules.length; i++) {
				String ruleRaw = rules[i].trim();
				if (ruleRaw.length() == 0) {
					continue;
				}
				String[] rule = ruleRaw.split(":");
				String propertyName = rule[0].trim();
				String cssText = rule[1].trim();
				if (propertyName.equals("src")) {
					src = cssText;
				}
				else if (propertyName.equals("name")) {
					name = cssText;
				}
				else if (propertyName.equals("rendering-intent")) {
					if (cssText.equals("auto"))
						renderingIntent = SVGColorProfileRule.RENDERING_INTENT_AUTO;
					else if (cssText.equals("perceptual"))
						renderingIntent = SVGColorProfileRule.RENDERING_INTENT_PERCEPTUAL;
					else if (cssText.equals("relative-colorimetric"))
						renderingIntent = SVGColorProfileRule.RENDERING_INTENT_RELATIVE_COLORIMETRIC;
					else if (cssText.equals("saturation"))
						renderingIntent = SVGColorProfileRule.RENDERING_INTENT_SATURATION;
					else if (cssText.equals("absolute-colorimetric"))
						renderingIntent = SVGColorProfileRule.RENDERING_INTENT_ABSOLUTE_COLORIMETRIC;
				}
			}
			return new SVGColorProfileRule.Implementation(body, parentRule, stylesheet, src, name, renderingIntent);
		}
		if (text.startsWith(CSSRulePrefixes.PREFIX)) {
			return new CSSUnknownRuleImplementation(parentRule, stylesheet, new CSSStyleDeclarationImplementation(parentRule, declaration));
		}
		CSSStyleDeclarationImplementation declarationSub = new CSSStyleDeclarationImplementation(parentRule, declaration);
		String[] rules = body.split(";");
		for (int i = 0; i < rules.length; i++) {
			String ruleRaw = rules[i].trim();
			if (ruleRaw.length() == 0) {
				continue;
			}
			String[] rule = ruleRaw.split(":");
			String name = rule[0].trim();
			String cssText = rule[1].trim();
			CSSProperties.tryCreateProperties();
			CSSProperties.parseValue(name, cssText, declarationSub);
		}
		return new CSSStyleRuleImplementation(parentRule, stylesheet, declarationSub, join(header, " ", 0));
	}

}
