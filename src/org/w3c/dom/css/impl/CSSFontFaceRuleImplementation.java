package org.w3c.dom.css.impl;

import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.svg.SVGFontFace;

public class CSSFontFaceRuleImplementation extends CSSRuleImplementation implements SVGCSSFontFaceRule {

	private SVGFontFace fontFace;
	
	public CSSFontFaceRuleImplementation(CSSRule parentRule, CSSStyleSheet stylesheet,
			CSSStyleDeclaration declaration, SVGFontFace fontFace) {
		super(parentRule, stylesheet, declaration);
		this.fontFace = fontFace;
	}

	@Override
	public short getType() {
		return FONT_FACE_RULE;
	}

	@Override
	public CSSStyleDeclaration getStyle() {
		return declaration;
	}

	@Override
	public SVGFontFace getFontFace() {
		return fontFace;
	}

}
