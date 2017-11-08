package org.w3c.dom.css.impl.values;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSEnumValue;
import org.w3c.dom.css.CSSTypedValue;
import org.w3c.dom.css.CSSValueType;
import org.w3c.dom.css.impl.StringUtils;

public class CSSEnumValueImplementation implements CSSEnumValue, CSSTypedValue {
	
	private String[] possibleValues;
	
	private String value = "inherit";
	
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

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String[] getPossibleValues() {
		return possibleValues;
	}

	@Override
	public CSSValueType getType() {
		return CSSValueType.ENUM;
	}

}
