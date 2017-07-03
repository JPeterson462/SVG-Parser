package org.w3c.dom.svg.text;

import org.w3c.dom.svg.SVGAnimatedLengthList;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGURIReference;
import org.w3c.dom.svg.documents.SVGSVGElement;

public interface SVGTRefElement extends SVGTextPositioningElement, SVGURIReference {

	public static class Implementation extends SVGTextPositioningElement.Implementation implements SVGTRefElement {

		private SVGAnimatedString href;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLengthList x, SVGAnimatedLengthList y, SVGAnimatedLengthList dx, SVGAnimatedLengthList dy,
				SVGAnimatedLengthList rotate, SVGAnimatedString href) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, dx, dy, rotate);
			this.href = href;
		}

		@Override
		public SVGAnimatedString getHref() {
			return href;
		}
		
	}
	
}
