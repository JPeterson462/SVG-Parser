package org.w3c.dom.css.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.css.CSSImportRule;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.stylesheets.MediaList;
import org.w3c.dom.stylesheets.StyleSheet;

public class CSSStyleSheetImplementation implements CSSStyleSheet {

	private CSSImportRule ownerRule;
	
	private boolean disabled;
	
	private String href, title, type;
	
	private MediaList media;
	
	private Node ownerNode;
	
	private CSSStyleSheet parentStyleSheet;
	
	private CSSRuleListImplementation ruleList;
	
	public CSSStyleSheetImplementation(CSSImportRuleImplementation ownerRule, boolean disabled, String href, MediaList media, Node ownerNode, CSSStyleSheet parentStyleSheet, String title, String type, CSSRuleListImplementation ruleList) {
		this.ownerRule = ownerRule;
		this.disabled = disabled;
		this.href = href;
		this.media = media;
		this.ownerNode = ownerNode;
		this.parentStyleSheet = parentStyleSheet;
		this.title = title;
		this.type = type;
		this.ruleList = ruleList;
	}
	
	@Override
	public boolean getDisabled() {
		return disabled;
	}

	@Override
	public String getHref() {
		return href;
	}

	@Override
	public MediaList getMedia() {
		return media;
	}

	@Override
	public Node getOwnerNode() {
		return ownerNode;
	}

	@Override
	public StyleSheet getParentStyleSheet() {
		return parentStyleSheet;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public void deleteRule(int index) throws DOMException {
		ruleList.removeRule(index);
	}

	@Override
	public CSSRuleList getCssRules() {
		return ruleList;
	}

	@Override
	public CSSRule getOwnerRule() {
		return ownerRule;
	}

	@Override
	public int insertRule(String text, int index) throws DOMException {
		ruleList.insertRule(index, CSSRuleBuilder.createRule(text, ownerRule, ((CSSRuleImplementation) ownerRule).declaration, this));
		return ruleList.getLength();
	}

}
