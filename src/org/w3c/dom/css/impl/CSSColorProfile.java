package org.w3c.dom.css.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSValue;

public class CSSColorProfile implements CSSValue {
	
	private String name, uri, type, cssText;
	
//	private static final String[] VALUES = {
//		"auto", "sRGB", "inherit"	
//	};
	
	public CSSColorProfile(String cssText) {
		setCssText(cssText);
	}
	
	public String getName() {
		return name;
	}
	
	public String getURI() {
		return uri;
	}
	
	public String getType() {
		return type;
	}
	
	public boolean isNamed() {
		return name != null;
	}
	
	public boolean isURI() {
		return uri != null;
	}

	@Override
	public String getCssText() {
		return cssText;
	}

	@Override
	public short getCssValueType() {
		if (cssText.equals("inherit")) {
			return CSS_INHERIT;
		}
		return CSS_PRIMITIVE_VALUE;
	}

	@Override
	public void setCssText(String cssText) throws DOMException {
		name = null;
		uri = null;
		type = null;
		cssText = cssText.trim();
		this.cssText = cssText;
		if (cssText.equals("auto") || cssText.equals("sRGB") || cssText.equals("inherit")) {
			type = cssText;
		}
		else if (cssText.startsWith("url(")) {
			uri = StringUtils.parseUri(cssText);
		}
		else {
			name = cssText;
		}
	}

}
