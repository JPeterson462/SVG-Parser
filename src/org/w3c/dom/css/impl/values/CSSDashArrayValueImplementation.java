package org.w3c.dom.css.impl.values;

import java.util.ArrayList;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSDashArrayValue;
import org.w3c.dom.css.CSSTypedValue;
import org.w3c.dom.css.CSSValueType;
import org.w3c.dom.css.Connected;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGLengthList;

public class CSSDashArrayValueImplementation implements CSSDashArrayValue, Connected, CSSTypedValue {
	
	private SVGLengthList dashArray;
	
	private String cssText;
	
	public void connect(SVGElement element) {
		if (dashArray != null) {
			for (int i = 0; i < dashArray.getNumberOfItems(); i++) {
				((SVGLength.Implementation) dashArray.getItem(i)).setElement(element);
			}
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
		if (!isInherit() && !isNone()) {
			ArrayList<String> textValues = new ArrayList<>();
			ArrayList<SVGLength> dashArrayValues = new ArrayList<>();
			int count = 0;
			char[] tokens = text.toCharArray();
			char[] string = new char[tokens.length];
			int position = 0, stringLength = 0;
			while (position < count) {
				if (tokens[position] == ' ' || tokens[position] == ',' || tokens[position] == '\n' || tokens[position] == '\r' || tokens[position] == '\t') {
					char[] substr = new char[stringLength];
					System.arraycopy(string, 0, substr, 0, stringLength);
					textValues.add(new String(substr));
					stringLength = 0;
				} else {
					string[stringLength] = tokens[position];
					stringLength++;
				}				
				position++;
			}
			int size = textValues.size();
			if (size % 2 != 0) {
				for (int i = 0; i < size; i++) {
					textValues.add(new String(textValues.get(i).toCharArray()));
				}
			}
			for (int i = 0; i < textValues.size(); i++) {
				SVGLength length = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, null);
				length.setValueAsString(textValues.get(i));
				dashArrayValues.add(length);
			}
			dashArray = new SVGLengthList.Implementation(dashArrayValues);
		}
	}

	@Override
	public SVGLengthList getDashArray() {
		return dashArray;
	}

	@Override
	public boolean isInherit() {
		return cssText.equals("inherit");
	}

	@Override
	public boolean isNone() {
		return cssText.equals("none");
	}

	@Override
	public CSSValueType getType() {
		return CSSValueType.DASH_ARRAY;
	}

}
