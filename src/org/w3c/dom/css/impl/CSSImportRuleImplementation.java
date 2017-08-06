package org.w3c.dom.css.impl;

import org.w3c.dom.css.CSSImportRule;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.stylesheets.MediaList;

public class CSSImportRuleImplementation extends CSSRuleImplementation implements CSSImportRule {

	private String href;
	
	private MediaList media;
	
	private CSSStyleSheet stylesheet;
	
	public CSSImportRuleImplementation(CSSRule parentRule, CSSStyleSheet stylesheet,
			CSSStyleDeclaration declaration, String href, MediaList media, CSSStyleSheet loaded) {
		super(parentRule, stylesheet, declaration);
		this.stylesheet = loaded;
	}

	@Override
	public short getType() {
		return IMPORT_RULE;
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
	public CSSStyleSheet getStyleSheet() {
		return stylesheet;
	}

}
