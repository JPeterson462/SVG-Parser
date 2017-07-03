package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGLength {

	/** The unit type is not one of predefined unit types.
	 * 	It is invalid to attempt to define a new value of
	 * 	this type or to attempt to switch an existing value
	 * 	to this type. */
	public static final short SVG_LENGTHTYPE_UNKNOWN = 0;
	/** No unit type was provided (i.e., a unitless value
	 * 	was specified), which indicates a value in user units. */
	public static final short SVG_LENGTHTYPE_NUMBER = 1;
	/** A percentage value was specified. */
	public static final short SVG_LENGTHTYPE_PERCENTAGE = 2;
	/** A value was specified using the em units defined in CSS2. */
	public static final short SVG_LENGTHTYPE_EMS = 3;
	/** A value was specified using the ex units defined in CSS2. */
	public static final short SVG_LENGTHTYPE_EXS = 4;
	/** A value was specified using the px units defined in CSS2. */
	public static final short SVG_LENGTHTYPE_PX = 5;
	/** A value was specified using the cm units defined in CSS2. */
	public static final short SVG_LENGTHTYPE_CM = 6;
	/** A value was specified using the mm units defined in CSS2. */
	public static final short SVG_LENGTHTYPE_MM = 7;
	/** A value was specified using the in units defined in CSS2. */
	public static final short SVG_LENGTHTYPE_IN = 8;
	/** A value was specified using the pt units defined in CSS2. */
	public static final short SVG_LENGTHTYPE_PT = 9;
	/** A value was specified using the pc units defined in CSS2. */
	public static final short SVG_LENGTHTYPE_PC = 10;

	public short getUnitType();

	public float getValue();

	public void setValue(float value) throws DOMException;

	public float getValueInSpecifiedUnits();

	public void setValueInSpecifiedUnits(float value) throws DOMException;

	public String getValueAsString();

	public void setValueAsString(String value) throws DOMException;

	public void newValueSpecifiedUnits(short unitType, float valueInSpecifiedUnits) throws DOMException;

	public void convertToSpecifiedUnits(short unitType) throws DOMException;

	public static class Implementation implements SVGLength {

		private short unitType;

		private float value; // value in user units, pixels

		private float valueInSpecifiedUnits;

		private final float pixelsPerInch = SVGSettings.PPI;
		private final float pixelsPerCM = pixelsPerInch * 2.54f;
		private final float pixelsPerMM = pixelsPerCM * 10f;
		private final float pixelsPerPoint = SVGSettings.PIXELS_PER_PT;
		private final float pixelsPerPica = pixelsPerPoint / 12f;
		private final float pixelsPerEM = SVGSettings.FONT_SIZE * SVGSettings.PIXELS_PER_PT;

		private SVGElement element;

		public Implementation(short unitType, float valueInSpecifiedUnits, SVGElement element) {
			this.valueInSpecifiedUnits = valueInSpecifiedUnits;
			this.element = element;
			convertToSpecifiedUnits(unitType);
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
			// TODO
		}

		@Override
		public float getValueInSpecifiedUnits() {
			return valueInSpecifiedUnits;
		}

		@Override
		public void setValueInSpecifiedUnits(float value) throws DOMException {
			// TODO
		}

		@Override
		public String getValueAsString() {
			String extension = "";
			switch (unitType) {
				case SVG_LENGTHTYPE_PERCENTAGE:
					extension = "%";
					break;
				case SVG_LENGTHTYPE_EMS:
					extension = "em";
					break;
				case SVG_LENGTHTYPE_EXS:
					extension = "ex";
					break;
				case SVG_LENGTHTYPE_PX:
					extension = "px";
					break;
				case SVG_LENGTHTYPE_CM:
					extension = "cm";
					break;
				case SVG_LENGTHTYPE_MM:
					extension = "mm";
					break;
				case SVG_LENGTHTYPE_IN:
					extension = "in";
					break;
				case SVG_LENGTHTYPE_PT:
					extension = "pt";
					break;
				case SVG_LENGTHTYPE_PC:
					extension = "pc";
					break;
			}
			return Float.toString(valueInSpecifiedUnits) + extension;
		}

		@Override
		public void setValueAsString(String value) throws DOMException {
			// TODO
		}

		@Override
		public void newValueSpecifiedUnits(short unitType, float valueInSpecifiedUnits) throws DOMException {
			this.valueInSpecifiedUnits = valueInSpecifiedUnits;
			convertToSpecifiedUnits(unitType);
		}

		@Override
		public void convertToSpecifiedUnits(short unitType) throws DOMException {
			this.unitType = unitType;
			switch (unitType) {
				case SVG_LENGTHTYPE_NUMBER:
					break;
				case SVG_LENGTHTYPE_PERCENTAGE:
					// TODO
					if (element.getViewportElement() != null) {
	
					} else {
						SVGSVGElement rootElement = element.getOwnerSVGElement();
					}
					break;
				case SVG_LENGTHTYPE_EMS:
					value = valueInSpecifiedUnits * pixelsPerEM;
					break;
				case SVG_LENGTHTYPE_EXS:
					value = valueInSpecifiedUnits * (float) Math.ceil(pixelsPerEM / SVGSettings.EFFECTIVE_ZOOM);
					break;
				case SVG_LENGTHTYPE_PX:
					value = valueInSpecifiedUnits;
					break;
				case SVG_LENGTHTYPE_CM:
					value = valueInSpecifiedUnits * pixelsPerCM;
					break;
				case SVG_LENGTHTYPE_MM:
					value = valueInSpecifiedUnits * pixelsPerMM;
					break;
				case SVG_LENGTHTYPE_IN:
					value = valueInSpecifiedUnits * pixelsPerInch;
					break;
				case SVG_LENGTHTYPE_PT:
					value = valueInSpecifiedUnits * pixelsPerPoint;
					break;
				case SVG_LENGTHTYPE_PC:
					value = valueInSpecifiedUnits * pixelsPerPica;
					break;
			}
		}

	}

}
