package org.w3c.dom.svg;

import org.w3c.dom.DOMException;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGScriptElement extends SVGElement, SVGURIReference, SVGExternalResourcesRequired {

	public String getType();
	
	public void setType(String type) throws DOMException;
	
	public static class Implementation extends SVGElement.Implementation implements SVGScriptElement {

		private SVGAnimatedString href;
		
		private SVGAnimatedBoolean externalResourcesRequired;
		
		private String type;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString href, SVGAnimatedBoolean externalResourcesRequired,
				String type) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.href = href;
			this.externalResourcesRequired = externalResourcesRequired;
			this.type = type;
		}

		@Override
		public SVGAnimatedString getHref() {
			return href;
		}

		@Override
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			return externalResourcesRequired;
		}

		@Override
		public String getType() {
			return type;
		}

		@Override
		public void setType(String type) throws DOMException {
			this.type = type;
		}
		
	}
	
}
