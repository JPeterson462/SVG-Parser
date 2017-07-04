package org.w3c.dom.svg.filters;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFECompositeElement extends SVGFEElement {

	/** The type is not one of predefined types. It is invalid to attempt to define a new value of this type or to attempt to switch an existing value to this type. */
	public static final short SVG_FECOMPOSITE_OPERATOR_UNKNOWN = 0;
	/** Corresponds to value 'over'. */
	public static final short SVG_FECOMPOSITE_OPERATOR_OVER = 1;
	/** Corresponds to value 'in'. */
	public static final short SVG_FECOMPOSITE_OPERATOR_IN = 2;
	/** Corresponds to value 'out'. */
	public static final short SVG_FECOMPOSITE_OPERATOR_OUT = 3;
	/** Corresponds to value 'atop'. */
	public static final short SVG_FECOMPOSITE_OPERATOR_ATOP = 4;
	/** Corresponds to value 'xor'. */
	public static final short SVG_FECOMPOSITE_OPERATOR_XOR = 5;
	/** Corresponds to value 'arithmetic'. */
	public static final short SVG_FECOMPOSITE_OPERATOR_ARITHMETIC = 6;

	public SVGAnimatedString getIn1();
	
	public SVGAnimatedString getIn2();
	
	public SVGAnimatedEnumeration getOperator();
	
	public SVGAnimatedNumber getK1();

	public SVGAnimatedNumber getK2();

	public SVGAnimatedNumber getK3();

	public SVGAnimatedNumber getK4();
	
	public static class Implementation extends SVGFEElement.Implementation implements SVGFECompositeElement {

		private SVGAnimatedString in1, in2;
		
		private SVGAnimatedEnumeration operator;
		
		private SVGAnimatedNumber k1, k2, k3, k4;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGAnimatedString result, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedString in1, SVGAnimatedString in2, SVGAnimatedEnumeration operator,
				SVGAnimatedNumber k1, SVGAnimatedNumber k2, SVGAnimatedNumber k3, SVGAnimatedNumber k4) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, width, height, result, className, style);
			this.in1 = in1;
			this.in2 = in2;
			this.operator = operator;
			this.k1 = k1;
			this.k2 = k2;
			this.k3 = k3;
			this.k4 = k4;
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
		public SVGAnimatedEnumeration getOperator() {
			return operator;
		}

		@Override
		public SVGAnimatedNumber getK1() {
			return k1;
		}

		@Override
		public SVGAnimatedNumber getK2() {
			return k2;
		}

		@Override
		public SVGAnimatedNumber getK3() {
			return k3;
		}

		@Override
		public SVGAnimatedNumber getK4() {
			return k4;
		}
		
	}
	
}
