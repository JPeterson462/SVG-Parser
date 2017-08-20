package org.w3c.dom.svg.fonts;

import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFontFaceNameElement extends SVGElement {
	
	public String getName();

	public static class Implementation extends SVGElement.Implementation implements SVGFontFaceNameElement {

		private String name;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement, String name) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}
		
	}
	
}
