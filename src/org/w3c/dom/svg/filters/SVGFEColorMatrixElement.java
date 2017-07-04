package org.w3c.dom.svg.filters;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumberList;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFEColorMatrixElement extends SVGFEElement {

	/** The type is not one of predefined types. It is invalid to attempt to define a new value of this type or to attempt to switch an existing value to this type. */
	public static final short SVG_FECOLORMATRIX_TYPE_UNKNOWN = 0;
	/** Corresponds to value 'matrix'. */
	public static final short SVG_FECOLORMATRIX_TYPE_MATRIX = 1;
	/** Corresponds to value 'saturate'. */
	public static final short SVG_FECOLORMATRIX_TYPE_SATURATE = 2;
	/** Corresponds to value 'huerotate'. */
	public static final short SVG_FECOLORMATRIX_TYPE_HUEROTATE = 3;
	/** Corresponds to value 'luminancetoalpha'. */
	public static final short SVG_FECOLORMATRIX_TYPE_LUMINANCETOALPHA = 4;

	public SVGAnimatedString getIn1();
	
	public SVGAnimatedEnumeration getType();
	
	public SVGAnimatedNumberList getValues();
	
	public static class Implementation extends SVGFEElement.Implementation implements SVGFEColorMatrixElement {

		private SVGAnimatedString in1;
		
		private SVGAnimatedEnumeration type;
		
		private SVGAnimatedNumberList values;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGAnimatedString result, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedString in1, SVGAnimatedEnumeration type, SVGAnimatedNumberList values) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, width, height, result, className, style);
			this.in1 = in1;
			this.type = type;
			this.values = values;
		}

		@Override
		public SVGAnimatedString getIn1() {
			return in1;
		}

		@Override
		public SVGAnimatedEnumeration getType() {
			return type;
		}

		@Override
		public SVGAnimatedNumberList getValues() {
			return values;
		}
		
	}
	
}
