package org.w3c.dom.css.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSValue;

public class CSSIRIValueImplementation implements CSSValue {
	
	private String value;

	private static final int STATE_IRI = 0, STATE_NONE = 1, STATE_INHERIT = 2;
	
	private int state = STATE_NONE;
	
	public CSSIRIValueImplementation() {
		// Empty Constructor
	}
	
	public String getIRI() {
		return value;
	}
	
	public boolean isNone() {
		return state == STATE_NONE;
	}
	
	public boolean isInherit() {
		return state == STATE_INHERIT;
	}
	
	@Override
	public String getCssText() {
		return value;
	}

	@Override
	public short getCssValueType() {
		return value.equals("inherit") ? CSS_INHERIT : CSS_PRIMITIVE_VALUE;
	}

	@Override
	public void setCssText(String text) throws DOMException {
		value = text;
		if (text.equals("none")) {
			state = STATE_NONE;
		}
		else if (text.equals("inherit")) {
			state = STATE_INHERIT;
		}
		else {
			state = STATE_IRI;
			value = StringUtils.parseUri(text);
		}
	}

}
