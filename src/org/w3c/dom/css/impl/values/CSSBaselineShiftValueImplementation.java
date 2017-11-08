package org.w3c.dom.css.impl.values;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSBaselineShiftValue;
import org.w3c.dom.css.CSSTypedValue;
import org.w3c.dom.css.CSSValueType;
import org.w3c.dom.css.Connected;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGLength;

public class CSSBaselineShiftValueImplementation implements CSSBaselineShiftValue, Connected, CSSTypedValue {

	private SVGLength length;
	
	private String cssText;
	
	public void connect(SVGElement element) {
		if (length != null) {
			((SVGLength.Implementation) length).setElement(element);
		}
	}
	
	@Override
	public String getCssText() {
		return cssText;
	}

	@Override
	public short getCssValueType() {
		return isInherit() ? CSS_INHERIT : CSS_PRIMITIVE_VALUE;
	}

	@Override
	public void setCssText(String text) throws DOMException {
		text = text.trim();
		cssText = text;
		if (isBaseline() || isSub() || isSuper() || isInherit()) {
			length = null;
		} else {
			length = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, null);
			length.setValueAsString(text);
		}
	}

	@Override
	public boolean isBaseline() {
		return cssText.equals("baseline");
	}

	@Override
	public boolean isSub() {
		return cssText.equals("sub");
	}

	@Override
	public boolean isSuper() {
		return cssText.equals("super");
	}

	@Override
	public boolean isInherit() {
		return cssText.equals("inherit");
	}

	@Override
	public SVGLength getLength() {
		return length;
	}

	@Override
	public CSSValueType getType() {
		return CSSValueType.BASELINE_SHIFT;
	}

}
