package org.w3c.dom.svg.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.Counter;
import org.w3c.dom.css.RGBColor;
import org.w3c.dom.css.Rect;

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
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
		}

		@Override
		public short getCssValueType() {
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
		}

		@Override
		public void setCssText(String text) throws DOMException {
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
		}

		@Override
		public Counter getCounterValue() throws DOMException {
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
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
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
		}

		@Override
		public Rect getRectValue() throws DOMException {
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
		}

		@Override
		public String getStringValue() throws DOMException {
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
		}

		@Override
		public void setFloatValue(short unitType, float value) throws DOMException {
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
		}

		@Override
		public void setStringValue(short unitType, String text) throws DOMException {
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
		}
		
	}
	
	public RGBColorImplementation(int red, int green, int blue) {
		this.red = new RGBComponent(red);
		this.green = new RGBComponent(green);
		this.blue = new RGBComponent(blue);
	}
	
	public RGBColorImplementation(RGBColor color) {
		red = new RGBComponent((int) (color.getRed().getFloatValue(CSSPrimitiveValue.CSS_NUMBER) * MAX_COLOR_COMPONENT));
		green = new RGBComponent((int) (color.getGreen().getFloatValue(CSSPrimitiveValue.CSS_NUMBER) * MAX_COLOR_COMPONENT));
		blue = new RGBComponent((int) (color.getBlue().getFloatValue(CSSPrimitiveValue.CSS_NUMBER) * MAX_COLOR_COMPONENT));
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

}
