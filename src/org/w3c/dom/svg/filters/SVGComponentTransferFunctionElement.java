package org.w3c.dom.svg.filters;

import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedNumberList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGComponentTransferFunctionElement extends SVGElement {

	/** The type is not one of predefined types. It is invalid to attempt to define a new value of this type or to attempt to switch an existing value to this type. */
	public static final short SVG_FECOMPONENTTRANSFER_TYPE_UNKNOWN = 0;
	/** Corresponds to value 'identity'. */
	public static final short SVG_FECOMPONENTTRANSFER_TYPE_IDENTITY = 1;
	/** Corresponds to value 'table'. */
	public static final short SVG_FECOMPONENTTRANSFER_TYPE_TABLE = 2;
	/** Corresponds to value 'discrete'. */
	public static final short SVG_FECOMPONENTTRANSFER_TYPE_DISCRETE = 3;
	/** Corresponds to value 'linear'. */
	public static final short SVG_FECOMPONENTTRANSFER_TYPE_LINEAR = 4;
	/** Corresponds to value 'gamma'. */
	public static final short SVG_FECOMPONENTTRANSFER_TYPE_GAMMA = 5;

	public SVGAnimatedEnumeration getType();
	
	public SVGAnimatedNumberList getTableValues();
	
	public SVGAnimatedNumber getSlope();

	public SVGAnimatedNumber getIntercept();

	public SVGAnimatedNumber getAmplitude();

	public SVGAnimatedNumber getExponent();

	public SVGAnimatedNumber getOffset();
	
	public static class Implementation extends SVGElement.Implementation implements SVGComponentTransferFunctionElement {

		private SVGAnimatedEnumeration type;
		
		private SVGAnimatedNumberList tableValues;
		
		private SVGAnimatedNumber slope, intercept, amplitude, exponent, offset;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedEnumeration type, SVGAnimatedNumberList tableValues,
				SVGAnimatedNumber slope, SVGAnimatedNumber intercept, SVGAnimatedNumber amplitude, SVGAnimatedNumber exponent, SVGAnimatedNumber offset) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.type = type;
			this.tableValues = tableValues;
			this.slope = slope;
			this.intercept = intercept;
			this.amplitude = amplitude;
			this.exponent = exponent;
			this.offset = offset;
		}

		@Override
		public SVGAnimatedEnumeration getType() {
			return type;
		}

		@Override
		public SVGAnimatedNumberList getTableValues() {
			return tableValues;
		}

		@Override
		public SVGAnimatedNumber getSlope() {
			return slope;
		}

		@Override
		public SVGAnimatedNumber getIntercept() {
			return intercept;
		}

		@Override
		public SVGAnimatedNumber getAmplitude() {
			return amplitude;
		}

		@Override
		public SVGAnimatedNumber getExponent() {
			return exponent;
		}

		@Override
		public SVGAnimatedNumber getOffset() {
			return offset;
		}
		
	}
	
}
