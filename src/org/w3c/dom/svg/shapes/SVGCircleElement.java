package org.w3c.dom.svg.shapes;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGCircleElement extends SVGShapeElement {

	public SVGAnimatedLength getCX();
	
	public SVGAnimatedLength getCY();
	
	public SVGAnimatedLength getRadius();
	
	public static class Implementation extends SVGShapeElement.Implementation implements SVGCircleElement {

		private SVGAnimatedLength cx, cy, radius;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				String xmlLang, String xmlSpace, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedLength cx, SVGAnimatedLength cy, SVGAnimatedLength radius,
				SVGElement nearestViewportElement, SVGElement farthestViewportElement, SVGAnimatedTransformList transform) {
			super(id, xmlBase, ownerSVGElement, viewportElement, xmlLang, xmlSpace, className, style, requiredFeatures,
					requiredExtensions, systemLanguage, externalResourcesRequired, nearestViewportElement,
					farthestViewportElement, transform);
			this.cx = cx;
			this.cy = cy;
			this.radius = radius;
		}

		@Override
		public SVGAnimatedLength getCX() {
			return cx;
		}

		@Override
		public SVGAnimatedLength getCY() {
			return cy;
		}

		@Override
		public SVGAnimatedLength getRadius() {
			return radius;
		}
		
	}
	
}
