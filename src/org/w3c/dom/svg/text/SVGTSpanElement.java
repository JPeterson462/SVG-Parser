package org.w3c.dom.svg.text;

import org.w3c.dom.svg.SVGAnimatedLengthList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.documents.SVGSVGElement;

public interface SVGTSpanElement extends SVGTextPositioningElement {

	public static class Implementation extends SVGTextPositioningElement.Implementation implements SVGTSpanElement {

		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLengthList x, SVGAnimatedLengthList y, SVGAnimatedLengthList dx, SVGAnimatedLengthList dy,
				SVGAnimatedLengthList rotate) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, dx, dy, rotate);
		}
		
	}
	
}
