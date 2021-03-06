package org.w3c.dom.svg;

import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGMetadataElement extends SVGElement {

	public static class Implementation extends SVGElement.Implementation implements SVGMetadataElement {

		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
		}
		
	}
	
}
