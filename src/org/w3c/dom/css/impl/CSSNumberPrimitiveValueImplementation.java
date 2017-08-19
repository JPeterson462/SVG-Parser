package org.w3c.dom.css.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.Counter;
import org.w3c.dom.css.RGBColor;
import org.w3c.dom.css.Rect;
import org.w3c.dom.DOMErrors;
import org.w3c.dom.svg.SVGLength;

public class CSSNumberPrimitiveValueImplementation implements CSSPrimitiveValue {
	
	private SVGLength length;
	
	public CSSNumberPrimitiveValueImplementation(SVGLength length) {
		this.length = length;
	}
	
	public CSSNumberPrimitiveValueImplementation() {
		// Empty
	}
	
	private short getLengthCSSUnits() {
		switch (length.getUnitType()) {
			case SVGLength.SVG_LENGTHTYPE_NUMBER:
				return CSS_NUMBER;
			case SVGLength.SVG_LENGTHTYPE_PERCENTAGE:
				return CSS_PERCENTAGE;
			case SVGLength.SVG_LENGTHTYPE_EMS:
				return CSS_EMS;
			case SVGLength.SVG_LENGTHTYPE_EXS:
				return CSS_EXS;
			case SVGLength.SVG_LENGTHTYPE_PX:
				return CSS_PX;
			case SVGLength.SVG_LENGTHTYPE_CM:
				return CSS_CM;
			case SVGLength.SVG_LENGTHTYPE_MM:
				return CSS_MM;
			case SVGLength.SVG_LENGTHTYPE_IN:
				return CSS_IN;
			case SVGLength.SVG_LENGTHTYPE_PT:
				return CSS_PT;
			case SVGLength.SVG_LENGTHTYPE_PC:
				return CSS_PC;
		}
		return 0;
	}
	
	@Override
	public String getCssText() {
		return DOMErrors.notSupported();
	}

	@Override
	public short getCssValueType() {
		if (length == null) {
			return CSS_INHERIT;
		}
		return CSS_PRIMITIVE_VALUE;
	}

	@Override
	public void setCssText(String text) throws DOMException {
		DOMErrors.notSupported();
	}

	@Override
	public Counter getCounterValue() throws DOMException {
		return DOMErrors.notSupported();
	}

	@Override
	public float getFloatValue(short units) throws DOMException {
		length.convertToSpecifiedUnits(units);
		return length.getValueInSpecifiedUnits();
	}

	@Override
	public short getPrimitiveType() {
		return getLengthCSSUnits();
	}

	@Override
	public RGBColor getRGBColorValue() throws DOMException {
		return DOMErrors.notSupported();
	}

	@Override
	public Rect getRectValue() throws DOMException {
		return DOMErrors.notSupported();
	}

	@Override
	public String getStringValue() throws DOMException {
		return DOMErrors.notSupported();
	}

	@Override
	public void setFloatValue(short units, float value) throws DOMException {
		length.newValueSpecifiedUnits(units, value);
	}

	@Override
	public void setStringValue(short arg0, String arg1) throws DOMException {
		DOMErrors.notSupported();
	}

}
