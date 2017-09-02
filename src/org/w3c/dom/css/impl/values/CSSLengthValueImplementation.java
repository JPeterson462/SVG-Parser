package org.w3c.dom.css.impl.values;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSLengthValue;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGLength;

public class CSSLengthValueImplementation implements CSSLengthValue {
	
	public static final int VALUE_AUTO = 1 << 0;
	public static final int VALUE_NORMAL = 1 << 1;
	public static final int VALUE_INHERIT = 1 << 2;
	
	private int valueFlags;
	
	private SVGLength length;
	
	private String cssText;
	
	public CSSLengthValueImplementation(String cssText, int valueFlags) {
		this.valueFlags = valueFlags;
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
	
	public boolean isInherit() {
		return cssText.equals("inherit");
	}
	
	public SVGLength getValue() {
		return length;
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
		cssText = cssText.trim();
		this.cssText = cssText;
		if (cssText.equals("auto")) {
			if ((valueFlags & VALUE_AUTO) == 0) {
				DOMErrors.invalidValue();
			}
		}
		else if (cssText.equals("normal")) {
			if ((valueFlags & VALUE_NORMAL) == 0) {
				DOMErrors.invalidValue();
			}
		}
		else if (cssText.equals("inherit")) {
			if ((valueFlags & VALUE_INHERIT) == 0) {
				DOMErrors.invalidValue();
			}
		}
		else {
			length.setValueAsString(cssText);
		}
	}

}
