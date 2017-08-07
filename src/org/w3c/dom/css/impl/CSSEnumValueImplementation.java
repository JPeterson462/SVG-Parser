package org.w3c.dom.css.impl;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSValue;

public class CSSEnumValueImplementation implements CSSValue {
	
	private String[] possibleValues;
	
	private String value;
	
	public CSSEnumValueImplementation(String[] possibleValues) {
		this.possibleValues = possibleValues;
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
		if (!StringUtils.contains(text, possibleValues, true)) {
			DOMErrors.invalidValue();
		}
	}

}
