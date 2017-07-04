package org.w3c.dom.svg.shapes;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGEllipseElement extends SVGShapeElement {

	public SVGAnimatedLength getCX();
	
	public SVGAnimatedLength getCY();
	
	public SVGAnimatedLength getRadiusX();

	public SVGAnimatedLength getRadiusY();
	
	public static class Implementation extends SVGShapeElement.Implementation implements SVGEllipseElement {

		private SVGAnimatedLength cx, cy, radiusX, radiusY;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				String xmlLang, String xmlSpace, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedLength cx, SVGAnimatedLength cy, SVGAnimatedLength radiusX, SVGAnimatedLength radiusY) {
			super(id, xmlBase, ownerSVGElement, viewportElement, xmlLang, xmlSpace, className, style, requiredFeatures,
					requiredExtensions, systemLanguage, externalResourcesRequired);
			this.cx = cx;
			this.cy = cy;
			this.radiusX = radiusX;
			this.radiusY = radiusY;
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
		public SVGAnimatedLength getRadiusX() {
			return radiusX;
		}

		@Override
		public SVGAnimatedLength getRadiusY() {
			return radiusY;
		}
		
	}
	
}
