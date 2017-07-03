package org.w3c.dom.svg.text;

import org.w3c.dom.DOMException;
import org.w3c.dom.svg.SVGAnimatedLengthList;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGMatrix;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGTransformable;
import org.w3c.dom.svg.documents.SVGSVGElement;

public interface SVGTextElement extends SVGTextPositioningElement, SVGTransformable {

	public static class Implementation extends SVGTextPositioningElement.Implementation implements SVGTextElement {

		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLengthList x, SVGAnimatedLengthList y, SVGAnimatedLengthList dx, SVGAnimatedLengthList dy,
				SVGAnimatedLengthList rotate) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, dx, dy, rotate);
			
		}

		@Override
		public SVGAnimatedTransformList getTransform() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGElement getNearestViewportElement() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGElement getFarthestViewportElement() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGRect getBBox() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGMatrix getCTM() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGMatrix getScreenCTM() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGMatrix getTransformToElement(SVGElement element) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
