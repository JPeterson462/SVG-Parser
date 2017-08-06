package org.w3c.dom.css.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleSheet;

public abstract class CSSRuleImplementation implements CSSRule {
	
	private CSSRule parentRule;
	
	private CSSStyleSheet stylesheet;
	
	protected CSSStyleDeclaration declaration;
	
	public CSSRuleImplementation(CSSRule parentRule, CSSStyleSheet stylesheet, CSSStyleDeclaration declaration) {
		this.parentRule = parentRule;
		this.stylesheet = stylesheet;
		this.declaration = declaration;
	}

	@Override
	public String getCssText() {
		return declaration.getCssText();
	}

	@Override
	public CSSRule getParentRule() {
		return parentRule;
	}

	@Override
	public CSSStyleSheet getParentStyleSheet() {
		return stylesheet;
	}

	@Override
	public void setCssText(String text) throws DOMException {
		declaration.setCssText(text);
	}

}
