package org.w3c.dom.css.impl.values;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSNumberValue;

public class CSSNumberValueImplementation implements CSSNumberValue {
	
	private float value;
	
	private boolean inherit = false;
	
	public CSSNumberValueImplementation() {
		// Empty Constructor
	}
	
	public float getValue() {
		return value;
	}

	@Override
	public String getCssText() {
		return Float.toString(value);
	}

	@Override
	public short getCssValueType() {
		return inherit ? CSS_INHERIT : CSS_PRIMITIVE_VALUE;
	}

	@Override
	public void setCssText(String text) throws DOMException {
		if (text.equals("inherit")) {
			inherit = true;
		} else {
			inherit = false;
			try {
				value = Float.parseFloat(text);
			} catch (NumberFormatException e) {
				DOMErrors.invalidValue();
			}
		}
	}

}
