package org.w3c.dom.css.impl.values;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSLengthValue;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGLength;

public class CSSLengthValueImplementation implements CSSLengthValue {
	
	private boolean autoOrNormal; // true = auto, false = inherit
	
	private SVGLength length;
	
	private String cssText;
	
	public CSSLengthValueImplementation(String cssText, boolean autoOrNormal) {
		this.autoOrNormal = autoOrNormal;
		length = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, null);
		setCssText(cssText);
	}
	
	public void setBaseElement(SVGElement baseElement) {
		((SVGLength.Implementation) length).setElement(baseElement);
		setCssText(cssText);
	}
	
	public boolean isAuto() {
		return cssText.equals("auto");
	}
	
	public boolean isNormal() {
		return cssText.equals("normal");
	}
	
	public float getValue() {
		return length.getValue();
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
		if (autoOrNormal && cssText.equals("auto")) {
			// Ignore
		}
		else if (!autoOrNormal && cssText.equals("normal")) {
			// Ignore
		}
		else {
			length.setValueAsString(cssText);
		}
	}

}
