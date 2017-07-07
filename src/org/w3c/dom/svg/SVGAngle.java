package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGAngle {

	/** The unit type is not one of predefined unit types.
	 * 	It is invalid to attempt to define a new value of
	 * 	this type or to attempt to switch an existing value to this type. */
	public static final short SVG_ANGLETYPE_UNKNOWN = 0;
	/** No unit type was provided (i.e., a unitless value was specified).
	 * 	For angles, a unitless value is treated the same as if degrees were specified. */
	public static final short SVG_ANGLETYPE_UNSPECIFIED = 1;
	/** The unit type was explicitly set to degrees. */
	public static final short SVG_ANGLETYPE_DEG = 2;
	/** The unit type is radians. */
	public static final short SVG_ANGLETYPE_RAD = 3;
	/** The unit type is radians. */
	public static final short SVG_ANGLETYPE_GRAD = 4;
	
	public short getUnitType();
	
	public float getValue();
	
	public void setValue(float value) throws DOMException;
	
	public float getValueInSpecifiedUnits();
	
	public void setValueInSpecifiedUnits(float valueInSpecifiedUnits) throws DOMException;
	
	public String getValueAsString();
	
	public void setValueAsString(String valueAsString) throws DOMException;
	
	public void newValueSpecifiedUnits(short unitType, float valueInSpecifiedUnits) throws DOMException;
	
	public void convertToSpecifiedUnits(short unitType) throws DOMException;
	
	public static class Implementation implements SVGAngle {

		private short unitType;

		private float value; // value in user units, degrees

		private float valueInSpecifiedUnits;
		
		private static final float degreesPerRadian = 180f / (float) Math.PI;
		private static final float radiansPerGradian = (float) Math.PI / 200f;
		private static final float degreesPerGradian = degreesPerRadian * radiansPerGradian;
		private static final float radiansPerDegree = 1f / degreesPerRadian;
//		private static final float gradiansPerRadian = 1f / radiansPerGradian;
		private static final float gradiansPerDegree = 1f / degreesPerGradian;
		
		public Implementation(short unitType, float valueInSpecifiedUnits) {
			this.unitType = unitType;
			setValueInSpecifiedUnits(valueInSpecifiedUnits);
		}

		@Override
		public short getUnitType() {
			return unitType;
		}

		@Override
		public float getValue() {
			return value;
		}

		@Override
		public void setValue(float value) throws DOMException {
			this.value = value;
			switch (unitType) {
				case SVG_ANGLETYPE_UNSPECIFIED:
					valueInSpecifiedUnits = value;
					break;
				case SVG_ANGLETYPE_DEG:
					valueInSpecifiedUnits = value;
					break;
				case SVG_ANGLETYPE_RAD:
					valueInSpecifiedUnits = value * radiansPerDegree;
					break;
				case SVG_ANGLETYPE_GRAD:
					valueInSpecifiedUnits = value * gradiansPerDegree;
					break;
			}
		}

		@Override
		public float getValueInSpecifiedUnits() {
			return valueInSpecifiedUnits;
		}

		@Override
		public void setValueInSpecifiedUnits(float valueInSpecifiedUnits) throws DOMException {
			this.valueInSpecifiedUnits = valueInSpecifiedUnits;
			switch (unitType) {
				case SVG_ANGLETYPE_UNSPECIFIED:
					value = valueInSpecifiedUnits;
					break;
				case SVG_ANGLETYPE_DEG:
					value = valueInSpecifiedUnits;
					break;
				case SVG_ANGLETYPE_RAD:
					value = valueInSpecifiedUnits * degreesPerRadian;
					break;
				case SVG_ANGLETYPE_GRAD:
					value = valueInSpecifiedUnits * degreesPerGradian;
					break;
			}
		}

		@Override
		public String getValueAsString() {
			String units = "";
			switch (unitType) {
				case SVG_ANGLETYPE_DEG:
					units = "deg";
					break;
				case SVG_ANGLETYPE_RAD:
					units = "rad";
					break;
				case SVG_ANGLETYPE_GRAD:
					units = "grad";
					break;
				default:
					break;
			}
			return valueInSpecifiedUnits + units;
		}

		@Override
		public void setValueAsString(String valueAsString) throws DOMException {
			if (valueAsString.endsWith("deg")) {
				unitType = SVG_ANGLETYPE_DEG;
				setValueInSpecifiedUnits(Float.parseFloat(valueAsString.substring(0, valueAsString.length() - 3)));
			}
			else if (valueAsString.endsWith("grad")) {
				unitType = SVG_ANGLETYPE_GRAD;
				setValueInSpecifiedUnits(Float.parseFloat(valueAsString.substring(0, valueAsString.length() - 4)));			}
			else if (valueAsString.endsWith("rad")) {
				unitType = SVG_ANGLETYPE_RAD;
				setValueInSpecifiedUnits(Float.parseFloat(valueAsString.substring(0, valueAsString.length() - 3)));
			}
			else {
				throw new DOMException(DOMException.SYNTAX_ERR, "Invalid <angle> attribute.");
			}
		}

		@Override
		public void newValueSpecifiedUnits(short unitType, float valueInSpecifiedUnits) throws DOMException {
			this.unitType = unitType;
			this.valueInSpecifiedUnits = valueInSpecifiedUnits;
			switch (unitType) {
				case SVG_ANGLETYPE_DEG:
					value = valueInSpecifiedUnits;
					break;
				case SVG_ANGLETYPE_RAD:
					value = valueInSpecifiedUnits * degreesPerRadian;
					break;
				case SVG_ANGLETYPE_GRAD:
					value = valueInSpecifiedUnits * degreesPerGradian;
					break;
				default:
					throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Invalid unit type constant");
			}
		}

		@Override
		public void convertToSpecifiedUnits(short unitType) throws DOMException {
			this.unitType = unitType;
			switch (unitType) {
				case SVG_ANGLETYPE_DEG:
					valueInSpecifiedUnits = value;
					break;
				case SVG_ANGLETYPE_RAD:
					valueInSpecifiedUnits = value * radiansPerDegree;
					break;
				case SVG_ANGLETYPE_GRAD:
					valueInSpecifiedUnits = value * gradiansPerDegree;
					break;
				default:
					throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Invalid unit type constant");
			}
		}
		
	}

}
