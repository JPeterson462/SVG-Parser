package org.w3c.dom.svg.fonts;

import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFontFaceUriElement extends SVGElement {

	public String getHref();
	
	public static class Implementation extends SVGElement.Implementation implements SVGFontFaceUriElement {

		private String href;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement, String href) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.href = href;
		}
		
		public String getHref() {
			return href;
		}
		
	}
	
}
