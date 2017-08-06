package org.w3c.dom.css.impl;

import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.stylesheets.MediaList;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGRegex;

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
	
//	private static 
	
	// TODO ignore whitespace between quotes
	
	public static CSSRule createRule(String text, CSSRule parentRule, CSSStyleDeclaration declaration, CSSStyleSheet stylesheet) {
		String[] data = text.trim().split(SVGRegex.WHITESPACE);
		if (text.startsWith(CSSRulePrefixes.CHARSET)) {
			if (data.length < 2) {
				return new CSSCharsetRuleImplementation(parentRule, stylesheet, 
						new CSSStyleDeclarationImplementation(parentRule, declaration), unquote(data[1]));
			} else {
				SVGErrors.error("Invalid " + CSSRulePrefixes.CHARSET);
			}
		}
		if (text.startsWith(CSSRulePrefixes.FONT_FACE)) {
			
		}
		if (text.startsWith(CSSRulePrefixes.IMPORT)) {
			String href = null;
			MediaList mediaList = new MediaListImplementation();
			if (data[1].startsWith("\"") && data[1].endsWith("\"")) {
				href = unquote(data[1]);
			}
			else if (data[1].startsWith("url(") && data[1].endsWith(")")) {
				String subtext = data[1].substring(4, data[1].length() - 1);
				if (subtext.startsWith("\"")) {
					href = unquote(subtext);
				} else {
					href = subtext;
				}
			}
			else {
				return SVGErrors.error("Invalid " + CSSRulePrefixes.IMPORT);
			}//TODO end before {
			mediaList.setMediaText(join(data, " ", 2));
			return new CSSImportRuleImplementation(parentRule, stylesheet, 
					new CSSStyleDeclarationImplementation(parentRule, declaration), href, mediaList, stylesheet);
		}
		if (text.startsWith(CSSRulePrefixes.MEDIA)) {
			MediaList mediaList = new MediaListImplementation();
			mediaList.setMediaText(join(data, " ", 1));		
			return new CSSMediaRuleImplementation(parentRule, stylesheet,
					new CSSStyleDeclarationImplementation(parentRule, declaration), null, mediaList);
		}
		//TODO
		return null;
	}

}
