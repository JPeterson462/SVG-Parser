package org.w3c.dom.svg.animation;

import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGExternalResourcesRequired;
import org.w3c.dom.svg.SVGURIReference;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGMPathElement extends SVGElement, SVGURIReference, SVGExternalResourcesRequired {

	public static class Implementation extends SVGElement.Implementation implements SVGMPathElement {

		private SVGAnimatedString href;
		
		private SVGAnimatedBoolean externalResourcesRequired;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString href, SVGAnimatedBoolean externalResourcesRequired) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.href = href;
			this.externalResourcesRequired = externalResourcesRequired;
		}

		@Override
		public SVGAnimatedString getHref() {
			return href;
		}

		@Override
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			return externalResourcesRequired;
		}
		
	}
	
}
