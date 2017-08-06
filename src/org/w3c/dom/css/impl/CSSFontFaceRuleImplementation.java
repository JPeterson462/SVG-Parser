package org.w3c.dom.css.impl;

import org.w3c.dom.css.CSSFontFaceRule;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleSheet;

public class CSSFontFaceRuleImplementation extends CSSRuleImplementation implements CSSFontFaceRule {

	public CSSFontFaceRuleImplementation(CSSRule parentRule, CSSStyleSheet stylesheet,
			CSSStyleDeclaration declaration) {
		super(parentRule, stylesheet, declaration);
	}

	@Override
	public short getType() {
		return FONT_FACE_RULE;
	}

	@Override
	public CSSStyleDeclaration getStyle() {
		return declaration;
	}

}
