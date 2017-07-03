package org.w3c.dom.svg.text;

import org.w3c.dom.DOMException;
import org.w3c.dom.svg.SVGAnimatedLengthList;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGURIReference;
import org.w3c.dom.svg.documents.SVGSVGElement;

public interface SVGAltGlyphElement extends SVGTextPositioningElement, SVGURIReference {

	public String getGlyphRef();
	
	public void setGlyphRef(String glyphRef) throws DOMException;
	
	public String getFormat();
	
	public void setFormat(String format) throws DOMException;
	
	public static class Implementation extends SVGTextPositioningElement.Implementation implements SVGAltGlyphElement {

		private SVGAnimatedString href;
		
		private String glyphRef, format;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLengthList x, SVGAnimatedLengthList y, SVGAnimatedLengthList dx, SVGAnimatedLengthList dy,
				SVGAnimatedLengthList rotate,
				SVGAnimatedString href, String glyphRef, String format) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, dx, dy, rotate);
			this.href = href;
			this.glyphRef = glyphRef;
			this.format = format;
		}

		@Override
		public SVGAnimatedString getHref() {
			return href;
		}

		@Override
		public String getGlyphRef() {
			return glyphRef;
		}

		@Override
		public void setGlyphRef(String glyphRef) throws DOMException {
			this.glyphRef = glyphRef;
		}

		@Override
		public String getFormat() {
			return format;
		}

		@Override
		public void setFormat(String format) throws DOMException {
			this.format = format;
		}
		
	}
	
}
