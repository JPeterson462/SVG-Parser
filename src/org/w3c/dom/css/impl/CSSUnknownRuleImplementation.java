package org.w3c.dom.css.impl;

import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.css.CSSUnknownRule;

public class CSSUnknownRuleImplementation extends CSSRuleImplementation implements CSSUnknownRule {

	public CSSUnknownRuleImplementation(CSSRule parentRule, CSSStyleSheet stylesheet,
			CSSStyleDeclaration declaration) {
		super(parentRule, stylesheet, declaration);
	}

	@Override
	public short getType() {
		return UNKNOWN_RULE;
	}

}
