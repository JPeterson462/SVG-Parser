package org.w3c.dom.svg.animation;

import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGAnimateMotionElement extends SVGAnimationElement {
	
	public static class Implementation extends SVGAnimationElement.Implementation implements SVGAnimateMotionElement {

		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
		}
		
	}

}
