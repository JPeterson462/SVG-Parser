package org.w3c.dom.css.impl.values;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSNumberValue;

public class CSSNumberValueImplementation implements CSSNumberValue {
	
	private float value;
	
	private int flags;
	
	private String cssText;
	
	public CSSNumberValueImplementation(int flags) {
		this.flags = flags;
	}
	
	public float getValue() {
		return value;
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
		if (isInherit()) {
			if ((flags & NUMBER_INHERIT) == 0) {
				DOMErrors.invalidValue();
			}
		}
		else if (isNone()) {
			if ((flags & NUMBER_NONE) == 0) {
				DOMErrors.invalidValue();
			}
		}
		else {
			try {
				value = Float.parseFloat(text);
			} catch (NumberFormatException e) {
				DOMErrors.invalidValue();
			}
		}
	}

	@Override
	public int getFlags() {
		return flags;
	}

	@Override
	public boolean isNone() {
		return cssText.equals("none");
	}

	@Override
	public boolean isInherit() {
		return cssText.equals("inherit");
	}

}
