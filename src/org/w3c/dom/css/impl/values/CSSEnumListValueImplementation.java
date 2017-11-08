package org.w3c.dom.css.impl.values;

import java.util.ArrayList;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSEnumListValue;
import org.w3c.dom.css.CSSTypedValue;
import org.w3c.dom.css.CSSValueType;
import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.SVGErrors;

public class CSSEnumListValueImplementation implements CSSEnumListValue, CSSTypedValue {

	private String cssText;
	
	private String[] selectedValues;
	
	private String selectedDefaultValue;
	
	private String[] possibleListValues;
	
	private String[] possibleDefaultValues;
	
	public CSSEnumListValueImplementation(String[] possibleDefaultValues, String[] possibleListValues) {
		selectedValues = null;
		selectedDefaultValue = null;
		this.possibleDefaultValues = possibleDefaultValues;
		this.possibleListValues = possibleListValues;
	}
	
	@Override
	public String getCssText() {
		return cssText;
	}

	@Override
	public short getCssValueType() {
		return cssText.equals("inherit") ? CSS_INHERIT : CSS_PRIMITIVE_VALUE;
	}

	@Override
	public void setCssText(String text) throws DOMException {
		text = text.trim();
		cssText = text;
		if (StringUtils.contains(text, possibleDefaultValues, true)) {
			selectedValues = null;
			selectedDefaultValue = text;
		} else {
			ArrayList<String> valuesIncluded = StringUtils.splitByWhitespace(text);
			selectedValues = valuesIncluded.toArray(new String[0]);
			selectedDefaultValue = null;
			for (int i = 0; i < selectedValues.length; i++) {
				if (!StringUtils.contains(selectedValues[i], possibleListValues, true)) {
					SVGErrors.error("Invalid value: " + selectedValues[i] + " / " + java.util.Arrays.toString(possibleListValues));
				}
			}
		}
	}

	@Override
	public boolean isDefaultValue() {
		return selectedDefaultValue != null;
	}

	@Override
	public String getDefaultValue() {
		return selectedDefaultValue;
	}

	@Override
	public String[] getListValues() {
		return selectedValues;
	}

	@Override
	public String[] getPossibleDefaultValues() {
		return possibleDefaultValues;
	}

	@Override
	public String[] getPossibleListValues() {
		return possibleListValues;
	}

	@Override
	public CSSValueType getType() {
		return CSSValueType.ENUM_LIST;
	}

}
