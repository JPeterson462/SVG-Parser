package org.w3c.dom.css.impl.values;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSSizeValue;
import org.w3c.dom.css.CSSTypedValue;
import org.w3c.dom.css.CSSValueType;
import org.w3c.dom.css.Connected;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGLength;

public class CSSSizeValueImplementation implements CSSSizeValue, Connected, CSSTypedValue {
	
	private CSSSize size;
	
	private SVGLength fixedSize;
	
	private String cssText;

	public void connect(SVGElement element) {
		if (fixedSize != null) {
			((SVGLength.Implementation) fixedSize).setElement(element);
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
		if (!isInherit()) {
			CSSRelativeSize relative = null;
			try {
				relative = CSSRelativeSize.valueOf(text);
			} catch (IllegalArgumentException e) {
				// Not found
			}
			if (relative != null) {
				size = relative;
				fixedSize = null;
			} else {
				CSSAbsoluteSize absolute = null;
				try {
					absolute = CSSAbsoluteSize.valueOf(text);
				} catch (IllegalArgumentException e) {
					// Not found
				}
				if (absolute != null) {
					size = absolute;
					fixedSize = null;
				} else {
					size = null;
					fixedSize = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, null);
					fixedSize.setValueAsString(text);
				}
			}
		}
	}

	@Override
	public CSSSize getSize() {
		return size;
	}

	@Override
	public SVGLength getFixedSize() {
		return fixedSize;
	}

	@Override
	public boolean isInherit() {
		return cssText.equals("inherit");
	}

	@Override
	public CSSValueType getType() {
		return CSSValueType.SIZE;
	}

}
