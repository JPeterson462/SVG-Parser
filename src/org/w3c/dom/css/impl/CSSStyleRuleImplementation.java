package org.w3c.dom.css.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleRule;
import org.w3c.dom.css.CSSStyleSheet;

public class CSSStyleRuleImplementation extends CSSRuleImplementation implements CSSStyleRule {

	private String selectorText;
	
	public CSSStyleRuleImplementation(CSSRule parentRule, CSSStyleSheet stylesheet, CSSStyleDeclaration declaration, String selectorText) {
		super(parentRule, stylesheet, declaration);
		this.selectorText = selectorText;
	}

	@Override
	public short getType() {
		return STYLE_RULE;
	}

	@Override
	public String getSelectorText() {
		return selectorText;
	}

	@Override
	public CSSStyleDeclaration getStyle() {
		return declaration;
	}

	@Override
	public void setSelectorText(String selectorText) throws DOMException {
		this.selectorText = selectorText;
	}
	
}
