package org.w3c.dom.svg.shapes;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGPolylineElement extends SVGShapeElement {

	public SVGAnimatedPoints getPoints();
	
	public static class Implementation extends SVGShapeElement.Implementation implements SVGPolylineElement {

		private SVGAnimatedPoints points;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				String xmlLang, String xmlSpace, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedPoints points,
				SVGElement nearestViewportElement, SVGElement farthestViewportElement, SVGAnimatedTransformList transform) {
			super(id, xmlBase, ownerSVGElement, viewportElement, xmlLang, xmlSpace, className, style, requiredFeatures,
					requiredExtensions, systemLanguage, externalResourcesRequired, nearestViewportElement,
					farthestViewportElement, transform);
			this.points = points;
		}

		@Override
		public SVGAnimatedPoints getPoints() {
			return points;
		}
		
	}
	
}
