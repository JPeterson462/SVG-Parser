package org.w3c.dom.svg.text;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedLengthList;
import org.w3c.dom.svg.SVGAnimatedNumberList;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGURIReference;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGTRefElement extends SVGTextPositioningElement, SVGURIReference {

	public static class Implementation extends SVGTextPositioningElement.Implementation implements SVGTRefElement {

		private SVGAnimatedString href;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLengthList x, SVGAnimatedLengthList y, SVGAnimatedLengthList dx, SVGAnimatedLengthList dy,
				SVGAnimatedNumberList rotate, SVGAnimatedString href,
				String xmlLang, String xmlSpace,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedLength textLength, SVGAnimatedEnumeration lengthAdjust) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, dx, dy, rotate, xmlLang, xmlSpace, className, style, requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired, textLength, lengthAdjust);
			this.href = href;
		}

		@Override
		public SVGAnimatedString getHref() {
			return href;
		}
		
	}
	
}
