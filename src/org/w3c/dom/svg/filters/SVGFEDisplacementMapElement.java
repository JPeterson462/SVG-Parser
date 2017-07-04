package org.w3c.dom.svg.filters;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFEDisplacementMapElement extends SVGFEElement {

	/** The type is not one of predefined types. It is invalid to attempt to define a new value of this type or to attempt to switch an existing value to this type. */
	public static final short SVG_CHANNEL_UNKNOWN = 0;
	/** Corresponds to value 'R'. */
	public static final short SVG_CHANNEL_R = 1;
	/** Corresponds to value 'G'. */
	public static final short SVG_CHANNEL_G = 2;
	/** Corresponds to value 'B'. */
	public static final short SVG_CHANNEL_B = 3;
	/** Corresponds to value 'A'. */
	public static final short SVG_CHANNEL_A = 4;

	public SVGAnimatedString getIn1();
	
	public SVGAnimatedString getIn2();
	
	public SVGAnimatedNumber getScale();
	
	public SVGAnimatedEnumeration getXChannelSelector();

	public SVGAnimatedEnumeration getYChannelSelector();
	
	public static class Implementation extends SVGFEElement.Implementation implements SVGFEDisplacementMapElement {

		private SVGAnimatedString in1, in2;
		
		private SVGAnimatedNumber scale;
		
		private SVGAnimatedEnumeration xChannelSelector, yChannelSelector;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGAnimatedString result, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedString in1, SVGAnimatedString in2, SVGAnimatedNumber scale,
				SVGAnimatedEnumeration xChannelSelector, SVGAnimatedEnumeration yChannelSelector) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, width, height, result, className, style);
			this.in1 = in1;
			this.in2 = in2;
			this.scale = scale;
			this.xChannelSelector = xChannelSelector;
			this.yChannelSelector = yChannelSelector;
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
		public SVGAnimatedNumber getScale() {
			return scale;
		}

		@Override
		public SVGAnimatedEnumeration getXChannelSelector() {
			return xChannelSelector;
		}

		@Override
		public SVGAnimatedEnumeration getYChannelSelector() {
			return yChannelSelector;
		}
		
	}
	
}
