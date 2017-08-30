package org.w3c.dom.css.impl.values;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStringListValue;

public class CSSStringListValueImplementation implements CSSStringListValue {
	
	private String cssText, values[];

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
		cssText = text;
		String[] valuesRaw = text.split(",");
		values = new String[valuesRaw.length];
		for (int i = 0; i < valuesRaw.length; i++) {
			values[i] = valuesRaw[i].trim();
		}
	}

	@Override
	public String[] getValues() {
		return values;
	}

	@Override
	public boolean isInherit() {
		return values == null;
	}

}
