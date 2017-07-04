package org.w3c.dom.svg.filters;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFEComponentTransferElement extends SVGFEElement {

	public SVGAnimatedString getIn1();
	
	public static class Implementation extends SVGFEElement.Implementation implements SVGFEComponentTransferElement {

		private SVGAnimatedString in1;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGAnimatedString result, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedString in1) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, width, height, result, className, style);
			this.in1 = in1;
		}

		@Override
		public SVGAnimatedString getIn1() {
			return in1;
		}
		
	}
	
}
