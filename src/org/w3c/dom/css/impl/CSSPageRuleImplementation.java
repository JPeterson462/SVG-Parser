package org.w3c.dom.css.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSPageRule;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleSheet;

public class CSSPageRuleImplementation extends CSSRuleImplementation implements CSSPageRule {

	private String selectorText;
	
	public CSSPageRuleImplementation(CSSRule parentRule, CSSStyleSheet stylesheet, CSSStyleDeclaration declaration, String selectorText) {
		super(parentRule, stylesheet, declaration);
		this.selectorText = selectorText;
	}

	@Override
	public short getType() {
		return PAGE_RULE;
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
