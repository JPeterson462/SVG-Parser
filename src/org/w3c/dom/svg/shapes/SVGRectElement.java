package org.w3c.dom.svg.shapes;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGRectElement extends SVGShapeElement {

	public SVGAnimatedLength getX();

	public SVGAnimatedLength getY();

	public SVGAnimatedLength getWidth();

	public SVGAnimatedLength getHeight();

	public SVGAnimatedLength getRX();

	public SVGAnimatedLength getRY();
	
	public static class Implementation extends SVGShapeElement.Implementation implements SVGRectElement {

		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				String xmlLang, String xmlSpace, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGAnimatedLength rx, SVGAnimatedLength ry,
				SVGElement nearestViewportElement, SVGElement farthestViewportElement, SVGAnimatedTransformList transform) {
			super(id, xmlBase, ownerSVGElement, viewportElement, xmlLang, xmlSpace, className, style, requiredFeatures,
					requiredExtensions, systemLanguage, externalResourcesRequired, nearestViewportElement,
					farthestViewportElement, transform);
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.rx = rx;
			this.ry = ry;
		}

		private SVGAnimatedLength x, y, width, height, rx, ry;
		
		@Override
		public SVGAnimatedLength getX() {
			return x;
		}

		@Override
		public SVGAnimatedLength getY() {
			return y;
		}

		@Override
		public SVGAnimatedLength getWidth() {
			return width;
		}

		@Override
		public SVGAnimatedLength getHeight() {
			return height;
		}

		@Override
		public SVGAnimatedLength getRX() {
			return rx;
		}

		@Override
		public SVGAnimatedLength getRY() {
			return ry;
		}
		
	}
	
}
