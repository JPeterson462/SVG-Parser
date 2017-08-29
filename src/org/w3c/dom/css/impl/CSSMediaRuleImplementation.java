package org.w3c.dom.css.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSMediaRule;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.stylesheets.MediaList;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.DOMErrors;

public class CSSMediaRuleImplementation extends CSSRuleImplementation implements CSSMediaRule {

	private CSSRuleListImplementation ruleList;
	
	private MediaList media;
	
	private transient ParsingState parsingState;
	
	public CSSMediaRuleImplementation(CSSRule parentRule, CSSStyleSheet stylesheet,
			CSSStyleDeclaration declaration, CSSRuleListImplementation ruleList, MediaList media, ParsingState parsingState) {
		super(parentRule, stylesheet, declaration);
		this.ruleList = ruleList;
		this.media = media;
		this.parsingState = parsingState;
	}

	@Override
	public short getType() {
		return MEDIA_RULE;
	}

	@Override
	public void deleteRule(int index) throws DOMException {
		if (index >= ruleList.getLength()) {
			DOMErrors.indexTooHigh();
		}
		ruleList.removeRule(index);
	}

	@Override
	public CSSRuleList getCssRules() {
		return ruleList;
	}

	@Override
	public MediaList getMedia() {
		return media;
	}

	@Override
	public int insertRule(String text, int index) throws DOMException {
		if (index > ruleList.getLength()) {
			DOMErrors.indexTooHigh();
		}
		ruleList.insertRule(index, CSSRuleBuilder.createRule(text, getParentRule(), (CSSStyleDeclarationImplementation) declaration, getParentStyleSheet(), parsingState));
		return index;
	}
	
}
