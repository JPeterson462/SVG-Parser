package org.w3c.dom.css.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.SVGErrors;

public class CSSCursor implements CSSValue {
	
	private String cssText;
	
	private String[] urls;
	
	private String type;
	
	private static final String[] TYPES = {
		"auto", "crosshair", "default", "pointer", "move", "e-resize", "ne-resize",
		"nw-resize", "n-resize", "se-resize", "sw-resize", "s-resize", "w-resize",
		"text", "wait", "help"
	};
	
	public CSSCursor(String cssText) {
		setCssText(cssText);
	}
	
	public String[] getURLS() {
		return urls;
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
		this.cssText = cssText;
		if (!cssText.equals("inherit")) {
			String[] parts = cssText.split("\\),");
			urls = new String[parts.length - 1];
			for (int i = 0; i < parts.length - 1; i++) {
				urls[i] = StringUtils.parseUri((parts[i] + ")").trim());
			}
			type = parts[parts.length - 1];
			if (!StringUtils.contains(type, TYPES, true)) {
				SVGErrors.error("Invalid Cursor Type: " + type);
			}
		}
	}
	
}
