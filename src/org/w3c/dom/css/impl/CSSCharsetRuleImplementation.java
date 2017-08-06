package org.w3c.dom.css.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSCharsetRule;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleSheet;

public class CSSCharsetRuleImplementation extends CSSRuleImplementation implements CSSCharsetRule {

	private String encoding;
	
	public CSSCharsetRuleImplementation(CSSRule parentRule, CSSStyleSheet stylesheet,
			CSSStyleDeclaration declaration, String encoding) {
		super(parentRule, stylesheet, declaration);
		this.encoding = encoding;
	}

	@Override
	public short getType() {
		return CHARSET_RULE;
	}

	@Override
	public String getEncoding() {
		return encoding;
	}

	@Override
	public void setEncoding(String encoding) throws DOMException {
		this.encoding = encoding;
	}

}
