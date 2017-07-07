package org.w3c.dom.svg.document;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGExternalResourcesRequired;
import org.w3c.dom.svg.SVGLangSpace;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.SVGTests;
import org.w3c.dom.svg.SVGTransformable;

public interface SVGSwitchElement extends SVGElement, SVGLangSpace, SVGStylable, SVGTests, SVGExternalResourcesRequired, SVGTransformable {

	public static class Implementation extends SVGBaseElement.Implementation implements SVGSwitchElement {

		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				String xmlLang, String xmlSpace, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired, SVGElement nearestViewportElement,
				SVGElement farthestViewportElement, SVGAnimatedTransformList transform) {
			super(id, xmlBase, ownerSVGElement, viewportElement, xmlLang, xmlSpace, className, style, requiredFeatures,
					requiredExtensions, systemLanguage, externalResourcesRequired, nearestViewportElement, farthestViewportElement,
					transform);
		}
		
	}
	
}
