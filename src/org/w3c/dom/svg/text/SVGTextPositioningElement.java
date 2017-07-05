package org.w3c.dom.svg.text;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedLengthList;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGTextPositioningElement extends SVGTextContentElement {
	
	public SVGAnimatedLengthList getX();
	
	public SVGAnimatedLengthList getY();

	public SVGAnimatedLengthList getDX();
	
	public SVGAnimatedLengthList getDY();
	
	public SVGAnimatedLengthList getRotate();
	
	public static class Implementation extends SVGTextContentElement.Implementation implements SVGTextPositioningElement {

		private SVGAnimatedLengthList x, y, dx, dy, rotate;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLengthList x, SVGAnimatedLengthList y, SVGAnimatedLengthList dx, SVGAnimatedLengthList dy, SVGAnimatedLengthList rotate,
				String xmlLang, String xmlSpace,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedLength textLength, SVGAnimatedEnumeration lengthAdjust) {
			super(id, xmlBase, ownerSVGElement, viewportElement, xmlLang, xmlSpace, className, style, requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired, textLength, lengthAdjust);
			this.x = x;
			this.y = y;
			this.dx = dx;
			this.dy = dy;
			this.rotate = rotate;
		}

		@Override
		public SVGAnimatedLengthList getX() {
			return x;
		}

		@Override
		public SVGAnimatedLengthList getY() {
			return y;
		}

		@Override
		public SVGAnimatedLengthList getDX() {
			return dx;
		}

		@Override
		public SVGAnimatedLengthList getDY() {
			return dy;
		}

		@Override
		public SVGAnimatedLengthList getRotate() {
			return rotate;
		}
		
	}

}
