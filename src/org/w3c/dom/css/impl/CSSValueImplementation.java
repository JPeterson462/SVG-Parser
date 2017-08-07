package org.w3c.dom.css.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.CSSValueList;
import org.w3c.dom.css.Counter;
import org.w3c.dom.css.RGBColor;
import org.w3c.dom.css.Rect;
import org.w3c.dom.DOMErrors;
import org.w3c.dom.svg.SVGColor;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGRegex;

public class CSSValueImplementation implements CSSPrimitiveValue, CSSValueList, Counter, Rect, RGBColor {

	// https://github.com/apache/batik/blob/c1d67eac2699e33807ee63a115dff5c46bcea2b7/batik-css/src/main/java/org/apache/batik/css/dom/CSSOMValue.java
	
	private SVGColor svgColor;
	
	private SVGLength top, right, bottom, left;
	
	private CSSPrimitiveValue topValue, rightValue, bottomValue, leftValue;
	
	private SVGLength length;
	
	private CSSPrimitiveValue lengthValue;
	
	private String text;
	
	private Counter counter;
	
	private CSSValueType type;
	
	private CSSValueImplementation[] list;
	
	public CSSValueImplementation(CSSValueType[] types, String text, SVGElement parent) {
		// TODO
	}
	
	public CSSValueImplementation(CSSValueType type, String text, SVGElement parent) {
		this.type = type;
		if (type.equals(CSSValueType.COLOR)) {
			svgColor = new SVGColor.Implementation();
			svgColor.setCssText(text);
		}
		else if (type.equals(CSSValueType.RECT)) {
			top = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parent);
			right = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parent);
			bottom = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parent);
			left = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parent);
			String[] parts = text.split(SVGRegex.WHITESPACE);
			if (parts.length == 4) {
				top.setValueAsString(parts[0]);
				right.setValueAsString(parts[1]);
				bottom.setValueAsString(parts[2]);
				left.setValueAsString(parts[3]);
			}
			else if (parts.length == 3) {
				top.setValueAsString(parts[0]);
				right.setValueAsString(parts[1]);
				bottom.setValueAsString(parts[2]);
				left.setValueAsString(parts[1]);
			}
			else if (parts.length == 2) {
				top.setValueAsString(parts[0]);
				right.setValueAsString(parts[1]);
				bottom.setValueAsString(parts[0]);
				left.setValueAsString(parts[1]);
			}
			else if (parts.length == 1) {
				top.setValueAsString(parts[0]);
				right.setValueAsString(parts[0]);
				bottom.setValueAsString(parts[0]);
				left.setValueAsString(parts[0]);
			}
			else {
				SVGErrors.error("Invalid Primitive Value");
			}
			topValue = new CSSPrimitiveValueNumberImplementation(top);
			rightValue = new CSSPrimitiveValueNumberImplementation(right);
			bottomValue = new CSSPrimitiveValueNumberImplementation(bottom);
			leftValue = new CSSPrimitiveValueNumberImplementation(left);
		}
		else if (type.equals(CSSValueType.NUMBER)) {
			length = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parent);
			length.setValueAsString(text);
			lengthValue = new CSSPrimitiveValueNumberImplementation(length);
		}
		else if (type.equals(CSSValueType.STRING)) {
			this.text = text;
		}
		else if (type.equals(CSSValueType.COUNTER)) {
			counter = new CounterImplementation(text);
		}
		else if (type.equals(CSSValueType.ATTR)) {
			// TODO
		}
		else if (type.equals(CSSValueType.IDENT)) {
			this.text = text;
		}
		else if (type.equals(CSSValueType.URI)) {
			// TODO
			
		}
		else {
			DOMErrors.invalidAccess();
		}
	}
	
	public CSSValueType getType() {
		return type;
	}
	
	@Override
	public String getCssText() {//TODO
		switch (type) {
			case COLOR:
				return svgColor.getCssText();
			case COUNTER:
				return ((CounterImplementation) counter).getCssText();
			case NUMBER:
				return length.getValueAsString();
			case RECT:
				return top.getValueAsString() + " " + right.getValueAsString() + " " + bottom.getValueAsString() + " " + left.getValueAsString();
			case STRING:
				return text;
			case ATTR:
				break;
			case IDENT:
				return text;
			case URI:
				break;
			default:
				SVGErrors.error("Unsupported CSS Type");
		}
		return null;
	}

	@Override
	public short getCssValueType() {
		// TODO Auto-generated method stub
		return CSS_PRIMITIVE_VALUE;
	}

	@Override
	public void setCssText(String text) throws DOMException {
		svgColor.setCssText(text);
	}

	@Override
	public CSSPrimitiveValue getBlue() {
		if (!type.equals(CSSValueType.COLOR)) {
			return DOMErrors.invalidAccess();
		}
		return svgColor.getRGBColor().getBlue();
	}

	@Override
	public CSSPrimitiveValue getGreen() {
		if (!type.equals(CSSValueType.COLOR)) {
			return DOMErrors.invalidAccess();
		}
		return svgColor.getRGBColor().getGreen();
	}

	@Override
	public CSSPrimitiveValue getRed() {
		if (!type.equals(CSSValueType.COLOR)) {
			return DOMErrors.invalidAccess();
		}
		return svgColor.getRGBColor().getRed();
	}

	@Override
	public CSSPrimitiveValue getBottom() {
		if (!type.equals(CSSValueType.RECT)) {
			return DOMErrors.invalidAccess();
		}
		return bottomValue;
	}

	@Override
	public CSSPrimitiveValue getLeft() {
		if (!type.equals(CSSValueType.RECT)) {
			return DOMErrors.invalidAccess();
		}
		return leftValue;
	}

	@Override
	public CSSPrimitiveValue getRight() {
		if (!type.equals(CSSValueType.RECT)) {
			return DOMErrors.invalidAccess();
		}
		return rightValue;
	}

	@Override
	public CSSPrimitiveValue getTop() {
		if (!type.equals(CSSValueType.RECT)) {
			return DOMErrors.invalidAccess();
		}
		return topValue;
	}

	@Override
	public String getIdentifier() {
		return counter.getIdentifier();
	}

	@Override
	public String getListStyle() {
		return counter.getListStyle();
	}

	@Override
	public String getSeparator() {
		return counter.getSeparator();
	}

	@Override
	public int getLength() {
		return list.length;
	}

	@Override
	public CSSValue item(int index) {
		return list[index];
	}

	@Override
	public Counter getCounterValue() throws DOMException {
		return this;
	}

	@Override
	public float getFloatValue(short unitType) throws DOMException {
		if (type.equals(CSSValueType.NUMBER)) {
			
		}
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public short getPrimitiveType() {//TODO
		switch (type) {
			case COLOR:
				break;
			case COUNTER:
				break;
			case NUMBER:
				return lengthValue.getPrimitiveType();
			case RECT:
				break;
			case STRING:
				break;
			case ATTR:
				break;
			case IDENT:
				break;
			case URI:
				break;
		}
		return 0;
	}

	@Override
	public RGBColor getRGBColorValue() throws DOMException {
		return this;
	}

	@Override
	public Rect getRectValue() throws DOMException {
		return this;
	}

	@Override
	public String getStringValue() throws DOMException {
		return text;
	}

	@Override
	public void setFloatValue(short unitType, float value) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStringValue(short unitType, String value) throws DOMException {
		// TODO Auto-generated method stub
		
	}
	
}
