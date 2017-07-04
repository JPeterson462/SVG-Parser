package org.w3c.dom.svg.filters;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFEOffsetElement extends SVGFEElement {

	public SVGAnimatedString getIn1();
	
	public SVGAnimatedNumber getDX();
	
	public SVGAnimatedNumber getDY();
	
	public static class Implementation extends SVGFEElement.Implementation implements SVGFEOffsetElement {

		private SVGAnimatedString in1;
		
		private SVGAnimatedNumber dx, dy;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGAnimatedString result, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedString in1, SVGAnimatedNumber dx, SVGAnimatedNumber dy) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, width, height, result, className, style);
			this.in1 = in1;
			this.dx = dx;
			this.dy = dy;
		}

		@Override
		public SVGAnimatedString getIn1() {
			return in1;
		}

		@Override
		public SVGAnimatedNumber getDX() {
			return dx;
		}

		@Override
		public SVGAnimatedNumber getDY() {
			return dy;
		}
		
	}
	
}
