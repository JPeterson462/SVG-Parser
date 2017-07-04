package org.w3c.dom.svg;

import org.w3c.dom.DOMException;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGCursorElement extends SVGElement, SVGURIReference, SVGTests, SVGExternalResourcesRequired {

	public SVGAnimatedLength getX();
	
	public SVGAnimatedLength getY();
	
	public static class Implementation extends SVGElement.Implementation implements SVGCursorElement {

		private SVGAnimatedString href;
		
		private SVGStringList requiredFeatures;
		
		private SVGStringList requiredExtensions;
		
		private SVGStringList systemLanguage;
		
		private SVGAnimatedBoolean externalResourcesRequired;
		
		private SVGAnimatedLength x, y;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString href, SVGStringList requiredFeatures,
				SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedLength x, SVGAnimatedLength y) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.href = href;
			this.requiredFeatures = requiredFeatures;
			this.requiredExtensions = requiredExtensions;
			this.systemLanguage = systemLanguage;
			this.externalResourcesRequired = externalResourcesRequired;
			this.x = x;
			this.y = y;
		}

		@Override
		public SVGAnimatedString getHref() {
			return href;
		}

		@Override
		public SVGStringList getRequiredFeatures() {
			return requiredFeatures;
		}

		@Override
		public SVGStringList getRequiredExtensions() {
			return requiredExtensions;
		}

		@Override
		public SVGStringList getSystemLanguage() {
			return systemLanguage;
		}

		@Override
		public boolean hasExtension(String extension) throws DOMException {
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
		}

		@Override
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			return externalResourcesRequired;
		}

		@Override
		public SVGAnimatedLength getX() {
			return x;
		}

		@Override
		public SVGAnimatedLength getY() {
			return y;
		}
		
	}
	
}
