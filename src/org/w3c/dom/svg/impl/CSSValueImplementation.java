package org.w3c.dom.svg.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.CSSValueList;
import org.w3c.dom.css.Counter;
import org.w3c.dom.css.RGBColor;
import org.w3c.dom.css.Rect;

public class CSSValueImplementation implements CSSPrimitiveValue, CSSValueList, Counter, Rect, RGBColor {

	// https://github.com/apache/batik/blob/c1d67eac2699e33807ee63a115dff5c46bcea2b7/batik-css/src/main/java/org/apache/batik/css/dom/CSSOMValue.java
	
	@Override
	public String getCssText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public short getCssValueType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCssText(String arg0) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CSSPrimitiveValue getBlue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CSSPrimitiveValue getGreen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CSSPrimitiveValue getRed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CSSPrimitiveValue getBottom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CSSPrimitiveValue getLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CSSPrimitiveValue getRight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CSSPrimitiveValue getTop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getListStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSeparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CSSValue item(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Counter getCounterValue() throws DOMException {
		return this;
	}

	@Override
	public float getFloatValue(short arg0) throws DOMException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public short getPrimitiveType() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFloatValue(short arg0, float arg1) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStringValue(short arg0, String arg1) throws DOMException {
		// TODO Auto-generated method stub
		
	}
	
}
