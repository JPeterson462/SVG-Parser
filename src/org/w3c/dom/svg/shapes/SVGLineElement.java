package org.w3c.dom.svg.shapes;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.documents.SVGSVGElement;

public interface SVGLineElement extends SVGShapeElement {

	public SVGAnimatedLength getX1();
	
	public SVGAnimatedLength getY1();
	
	public SVGAnimatedLength getX2();

	public SVGAnimatedLength getY2();
	
	public static class Implementation extends SVGShapeElement.Implementation implements SVGLineElement {

		private SVGAnimatedLength x1, y1, x2, y2;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				String xmlLang, String xmlSpace, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedLength x1, SVGAnimatedLength y1, SVGAnimatedLength x2, SVGAnimatedLength y2) {
			super(id, xmlBase, ownerSVGElement, viewportElement, xmlLang, xmlSpace, className, style, requiredFeatures,
					requiredExtensions, systemLanguage, externalResourcesRequired);
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
