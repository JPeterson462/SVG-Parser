package org.w3c.dom.svg;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGLinearGradientElement extends SVGGradientElement {
	
	public SVGAnimatedLength getX1();
	
	public SVGAnimatedLength getY1();
	
	public SVGAnimatedLength getX2();
	
	public SVGAnimatedLength getY2();
	
	public static class Implementation extends SVGGradientElement.Implementation implements SVGLinearGradientElement {

		private SVGAnimatedLength x1, y1, x2, y2;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString href, SVGAnimatedBoolean externalResourcesRequired, SVGAnimatedString className,
				CSSStyleDeclaration style, SVGAnimatedEnumeration gradientUnits,
				SVGAnimatedTransformList gradientTransform, SVGAnimatedEnumeration spreadMethod,
				SVGAnimatedLength x1, SVGAnimatedLength y1, SVGAnimatedLength x2, SVGAnimatedLength y2) {
			super(id, xmlBase, ownerSVGElement, viewportElement, href, externalResourcesRequired, className, style, gradientUnits,
					gradientTransform, spreadMethod);
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		@Override
		public SVGAnimatedLength getX1() {
			return x1;
		}

		@Override
		public SVGAnimatedLength getY1() {
			return y1;
		}

		@Override
		public SVGAnimatedLength getX2() {
			return x2;
		}

		@Override
		public SVGAnimatedLength getY2() {
			return y2;
		}
		
	}

}
