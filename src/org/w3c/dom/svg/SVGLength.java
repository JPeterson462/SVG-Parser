package org.w3c.dom.svg;

import java.util.ArrayList;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.impl.StringUtils;

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

	public void setValueInSpecifiedUnits(float valueInSpecifiedUnits) throws DOMException;

	public String getValueAsString();

	public void setValueAsString(String value) throws DOMException;

	public void newValueSpecifiedUnits(short unitType, float valueInSpecifiedUnits) throws DOMException;

	public void convertToSpecifiedUnits(short unitType) throws DOMException;
	
	public SVGElement getBaselineElement();
	
	public static class Pool {
		
		public static ArrayList<Implementation> instances = new ArrayList<>();
		
		public static void calculate() {
			for (int i = 0; i < instances.size(); i++) {
				instances.get(i).convertToSpecifiedUnits(instances.get(i).unitType);
			}
		}
		
	}

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
			Pool.instances.add(this);
			this.valueInSpecifiedUnits = valueInSpecifiedUnits;
			this.element = element;
			convertToSpecifiedUnits(unitType);
		}
		
		public void setElement(SVGElement element) {
			this.element = element;
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
				case SVG_LENGTHTYPE_PERCENTAGE:
					SVGElement viewportElement = element.getViewportElement();
					if (viewportElement != null) {
						if (viewportElement instanceof SVGLocatable) {
							valueInSpecifiedUnits = value * 100f / ((SVGLocatable) viewportElement).getBBox().getWidth();
						} else {
							throw new DOMException(DOMException.INVALID_STATE_ERR, "This element (" + viewportElement + ") cannot be used for relative positioning");
						}
					} else {
						throw new DOMException(DOMException.INVALID_STATE_ERR, "Root elements cannot use relative positioning"); 
					}
					break;
				case SVG_LENGTHTYPE_EMS:
					valueInSpecifiedUnits = value / pixelsPerEM;
					break;
				case SVG_LENGTHTYPE_EXS:
					valueInSpecifiedUnits = value / (float) Math.ceil(pixelsPerEM / SVGSettings.EFFECTIVE_ZOOM);
					break;
				case SVG_LENGTHTYPE_PX:
					valueInSpecifiedUnits = value;
					break;
				case SVG_LENGTHTYPE_CM:
					valueInSpecifiedUnits = value / pixelsPerCM;
					break;
				case SVG_LENGTHTYPE_MM:
					valueInSpecifiedUnits = value / pixelsPerMM;
					break;
				case SVG_LENGTHTYPE_IN:
					valueInSpecifiedUnits = value / pixelsPerInch;
					break;
				case SVG_LENGTHTYPE_PT:
					valueInSpecifiedUnits = value / pixelsPerPoint;
					break;
				case SVG_LENGTHTYPE_PC:
					valueInSpecifiedUnits = value / pixelsPerPica;
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
			convertToSpecifiedUnits(unitType);
		}

		@Override
		public String getValueAsString() {
			if (unitType == SVG_LENGTHTYPE_PX) {
				return getValueInSpecifiedUnitsAsString();
			}
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
			return getValueInSpecifiedUnitsAsString() + extension;
		}
		
		private String getValueInSpecifiedUnitsAsString() {
			return StringUtils.convertToWritable(valueInSpecifiedUnits);
		}

		@Override
		public void setValueAsString(String value) throws DOMException {
			if (value.endsWith("%")) {
				value = value.substring(0, value.length() - 1);
				unitType = SVG_LENGTHTYPE_PERCENTAGE;
			} else {
				if (value.endsWith("em") || value.endsWith("ex") || value.endsWith("px") || value.endsWith("cm") || 
						value.endsWith("mm") || value.endsWith("in") || value.endsWith("pt") || value.endsWith("pc")) {
					String extension = value.substring(value.length() - 2).toLowerCase();
					switch (extension) {
						case "em":
							unitType = SVG_LENGTHTYPE_EMS;
							break;
						case "ex":
							unitType = SVG_LENGTHTYPE_EXS;
							break;
						case "px":
							unitType = SVG_LENGTHTYPE_PX;
							break;
						case "cm":
							unitType = SVG_LENGTHTYPE_CM;
							break;
						case "mm":
							unitType = SVG_LENGTHTYPE_MM;
							break;
						case "in":
							unitType = SVG_LENGTHTYPE_IN;
							break;
						case "pt":
							unitType = SVG_LENGTHTYPE_PT;
							break;
						case "pc":
							unitType = SVG_LENGTHTYPE_PC;
							break;
					}
					value = value.substring(0, value.length() - 2);
				} else {
					unitType = SVG_LENGTHTYPE_PX;
				}
			}
			setValueInSpecifiedUnits(Float.parseFloat(value));
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
					if (valueInSpecifiedUnits > 0) {
						throw new DOMException(DOMException.INVALID_STATE_ERR, "CSS values of type number must be zero");
					} else {
						value = 0;
					}
					break;
				case SVG_LENGTHTYPE_PERCENTAGE:
					if (element != null) {
						SVGElement viewportElement = element.getViewportElement();
						if (viewportElement != null) {
							SVGRect boundingBox = ((SVGLocatable) viewportElement).getBBox();
							if (viewportElement instanceof SVGLocatable) {
								if (boundingBox != null) {
									value = (valueInSpecifiedUnits * 0.01f) * boundingBox.getWidth();
								}
							} else {
								throw new DOMException(DOMException.INVALID_STATE_ERR, "This element (" + viewportElement + ") cannot be used for relative positioning");
							}
						} else {
							throw new DOMException(DOMException.INVALID_STATE_ERR, "Root elements cannot use relative positioning"); 
						}
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

		@Override
		public SVGElement getBaselineElement() {
			return element;
		}

	}

}
