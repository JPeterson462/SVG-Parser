package org.w3c.dom.svg;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGRadialGradientElement extends SVGGradientElement {

	public SVGAnimatedLength getCX();
	
	public SVGAnimatedLength getCY();
	
	public SVGAnimatedLength getRadius();
	
	public SVGAnimatedLength getFX();
	
	public SVGAnimatedLength getFY();
	
	public static class Implementation extends SVGGradientElement.Implementation implements SVGRadialGradientElement {

		private SVGAnimatedLength cx, cy, radius, fx, fy;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString href, SVGAnimatedBoolean externalResourcesRequired, SVGAnimatedString className,
				CSSStyleDeclaration style, SVGAnimatedEnumeration gradientUnits,
				SVGAnimatedTransformList gradientTransform, SVGAnimatedEnumeration spreadMethod,
				SVGAnimatedLength cx, SVGAnimatedLength cy, SVGAnimatedLength radius, SVGAnimatedLength fx, SVGAnimatedLength fy) {
			super(id, xmlBase, ownerSVGElement, viewportElement, href, externalResourcesRequired, className, style, gradientUnits,
					gradientTransform, spreadMethod);
			this.cx = cx;
			this.cy = cy;
			this.radius = radius;
			this.fx = fx;
			this.fy = fy;
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

		@Override
		public SVGAnimatedLength getFX() {
			return fx;
		}

		@Override
		public SVGAnimatedLength getFY() {
			return fy;
		}
		
	}
	
}
