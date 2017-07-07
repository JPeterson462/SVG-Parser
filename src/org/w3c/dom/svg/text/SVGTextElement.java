package org.w3c.dom.svg.text;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedLengthList;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGMatrix;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGTransformable;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGTextElement extends SVGTextPositioningElement, SVGTransformable {

	public static class Implementation extends SVGTextPositioningElement.Implementation implements SVGTextElement {

		private SVGTransformable transformableBase;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLengthList x, SVGAnimatedLengthList y, SVGAnimatedLengthList dx, SVGAnimatedLengthList dy,
				SVGAnimatedLengthList rotate, SVGAnimatedString href,
				String xmlLang, String xmlSpace,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedLength textLength, SVGAnimatedEnumeration lengthAdjust,
				SVGElement nearestViewportElement, SVGElement farthestViewportElement, SVGAnimatedTransformList transform) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, dx, dy, rotate, xmlLang, xmlSpace, className, style, requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired, textLength, lengthAdjust);
			transformableBase = new SVGTransformable.Implementation(nearestViewportElement, farthestViewportElement, transform);
		}

		@Override
		public SVGAnimatedTransformList getTransform() {
			return transformableBase.getTransform();
		}

		@Override
		public SVGElement getNearestViewportElement() {
			return transformableBase.getNearestViewportElement();
		}

		@Override
		public SVGElement getFarthestViewportElement() {
			return transformableBase.getFarthestViewportElement();
		}

		@Override
		public SVGRect getBBox() {
			return transformableBase.getBBox();
		}

		@Override
		public SVGMatrix getCTM() {
			return transformableBase.getCTM();
		}

		@Override
		public SVGMatrix getScreenCTM() {
			return transformableBase.getScreenCTM();
		}

		@Override
		public SVGMatrix getTransformToElement(SVGElement element) throws DOMException {
			return transformableBase.getTransformToElement(element);
		}
		
	}
	
}
