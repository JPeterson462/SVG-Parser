package org.w3c.dom.svg.text;

import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.documents.SVGSVGElement;

public interface SVGAltGlyphItemElement extends SVGElement {

	public static class Implementation extends SVGElement.Implementation implements SVGAltGlyphItemElement {

		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
		}
		
	}
	
}
