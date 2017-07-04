package org.w3c.dom.svg.filters;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFEMorphologyElement extends SVGFEElement {

	/** The type is not one of predefined types. It is invalid to attempt to define a new value of this type or to attempt to switch an existing value to this type. */
	public static final short SVG_MORPHOLOGY_OPERATOR_UNKNOWN = 0;
	/** Corresponds to value 'erode'. */
	public static final short SVG_MORPHOLOGY_OPERATOR_ERODE = 1;
	/** Corresponds to value 'dilate'. */
	public static final short SVG_MORPHOLOGY_OPERATOR_DILATE = 2;

	public SVGAnimatedString getIn1();
	
	public SVGAnimatedEnumeration getOperator();
	
	public SVGAnimatedNumber getRadiusX();
	
	public SVGAnimatedNumber getRadiusY();
	
	public static class Implementation extends SVGFEElement.Implementation implements SVGFEMorphologyElement {

		private SVGAnimatedString in1;
		
		private SVGAnimatedEnumeration operator;
		
		private SVGAnimatedNumber radiusX, radiusY;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGAnimatedString result, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedString in1, SVGAnimatedEnumeration operator, SVGAnimatedNumber radiusX, SVGAnimatedNumber radiusY) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, width, height, result, className, style);
			this.in1 = in1;
			this.operator = operator;
			this.radiusX = radiusX;
			this.radiusY = radiusY;
		}

		@Override
		public SVGAnimatedString getIn1() {
			return in1;
		}

		@Override
		public SVGAnimatedEnumeration getOperator() {
			return operator;
		}

		@Override
		public SVGAnimatedNumber getRadiusX() {
			return radiusX;
		}

		@Override
		public SVGAnimatedNumber getRadiusY() {
			return radiusY;
		}
		
	}
	
}
