package org.w3c.dom.svg.fonts;

import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGFontFace;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFontFaceElement extends SVGElement {
	
	public SVGFontFace getFontFace();

	public static class Implementation extends SVGElement.Implementation implements SVGFontFaceElement {

		private SVGFontFace fontFace;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement, SVGFontFace fontFace) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.fontFace = fontFace;
		}

		@Override
		public SVGFontFace getFontFace() {
			return fontFace;
		}
		
	}
	
}
