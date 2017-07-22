package org.w3c.dom.svg.fonts;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.DOMErrors;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGExternalResourcesRequired;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFontElement extends SVGElement, SVGExternalResourcesRequired, SVGStylable {

	public static class Implementation extends SVGElement.Implementation implements SVGFontElement {

		private SVGAnimatedBoolean externalResourcesRequired;
		
		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedBoolean externalResourcesRequired, SVGAnimatedString className, CSSStyleDeclaration style) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.externalResourcesRequired = externalResourcesRequired;
			this.className = className;
			this.style = style;
		}

		@Override
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			return externalResourcesRequired;
		}

		@Override
		public SVGAnimatedString getClassName() {
			return className;
		}

		@Override
		public CSSStyleDeclaration getStyle() {
			return style;
		}

		@Override
		public CSSValue getPresentationAttribute(String name) {
			return DOMErrors.deprecatedMethod();
		}
		
	}
	
}
