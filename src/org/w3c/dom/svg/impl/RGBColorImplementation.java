package org.w3c.dom.svg.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.Counter;
import org.w3c.dom.css.RGBColor;
import org.w3c.dom.css.Rect;
import org.w3c.dom.svg.DOMErrors;

public class RGBColorImplementation implements RGBColor {
	
	private CSSPrimitiveValue red, green, blue;
	
	public static final float MAX_COLOR_COMPONENT = 255f;
	
	private class RGBComponent implements CSSPrimitiveValue {
		
		private float value;
		
		public RGBComponent(int value) {
			this.value = (float) value / MAX_COLOR_COMPONENT;
		}

		@Override
		public String getCssText() {
			return DOMErrors.notSupported();
		}

		@Override
		public short getCssValueType() {
			return DOMErrors.notSupported();
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
		public float getFloatValue(short unitType) throws DOMException {
			return value;
		}

		@Override
		public short getPrimitiveType() {
			return CSS_NUMBER;
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
		public void setFloatValue(short unitType, float value) throws DOMException {
			DOMErrors.notSupported();
		}

		@Override
		public void setStringValue(short unitType, String text) throws DOMException {
			DOMErrors.notSupported();
		}
		
	}
	
	private int redInt, greenInt, blueInt;
	
	public RGBColorImplementation(int red, int green, int blue) {
		this.red = new RGBComponent(red);
		this.green = new RGBComponent(green);
		this.blue = new RGBComponent(blue);
		redInt = red;
		greenInt = green;
		blueInt = blue;
	}
	
	public RGBColorImplementation(RGBColor color) {
		redInt = (int) (color.getRed().getFloatValue(CSSPrimitiveValue.CSS_NUMBER) * MAX_COLOR_COMPONENT);
		greenInt = (int) (color.getGreen().getFloatValue(CSSPrimitiveValue.CSS_NUMBER) * MAX_COLOR_COMPONENT);
		blueInt = (int) (color.getBlue().getFloatValue(CSSPrimitiveValue.CSS_NUMBER) * MAX_COLOR_COMPONENT);
		red = new RGBComponent(redInt);
		green = new RGBComponent(greenInt);
		blue = new RGBComponent(blueInt);
	}

	@Override
	public CSSPrimitiveValue getRed() {
		return red;
	}

	@Override
	public CSSPrimitiveValue getGreen() {
		return green;
	}

	@Override
	public CSSPrimitiveValue getBlue() {
		return blue;
	}
	
	public String toString() {
		return "rgb(" + redInt + ", " + greenInt + ", " + blueInt + ")";
	}

}
