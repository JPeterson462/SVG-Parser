package org.w3c.dom.svg.filters;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFEBlendElement extends SVGFEElement {

	/** The type is not one of predefined types. It is invalid
	 * 	to attempt to define a new value of this type or to
	 * 	attempt to switch an existing value to this type. */
	public static final short SVG_FEBLEND_MODE_UNKNOWN = 0;
	/** Corresponds to value 'normal'. */
	public static final short SVG_FEBLEND_MODE_NORMAL = 1;
	/** Corresponds to value 'multiply'. */
	public static final short SVG_FEBLEND_MODE_MULTIPLY = 2;
	/** Corresponds to value 'screen'. */
	public static final short SVG_FEBLEND_MODE_SCREEN = 3;
	/** Corresponds to value 'darken'. */
	public static final short SVG_FEBLEND_MODE_DARKEN = 4;
	/** Corresponds to value 'lighten'. */
	public static final short SVG_FEBLEND_MODE_LIGHTEN = 5;

	public SVGAnimatedString getIn1();
	
	public SVGAnimatedString getIn2();
	
	public SVGAnimatedEnumeration getMode();
	
	public static class Implementation extends SVGFEElement.Implementation implements SVGFEBlendElement {

		private SVGAnimatedString in1, in2;
		
		private SVGAnimatedEnumeration mode;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGAnimatedString result, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedString in1, SVGAnimatedString in2, SVGAnimatedEnumeration mode) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, width, height, result, className, style);
			this.in1 = in1;
			this.in2 = in2;
			this.mode = mode;
		}

		@Override
		public SVGAnimatedString getIn1() {
			return in1;
		}

		@Override
		public SVGAnimatedString getIn2() {
			return in2;
		}

		@Override
		public SVGAnimatedEnumeration getMode() {
			return mode;
		}
		
	}
	
}
