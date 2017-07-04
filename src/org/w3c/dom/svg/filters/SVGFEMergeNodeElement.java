package org.w3c.dom.svg.filters;

import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFEMergeNodeElement extends SVGElement {

	public SVGAnimatedString getIn1();
	
	public static class Implementation extends SVGElement.Implementation implements SVGFEMergeNodeElement {

		private SVGAnimatedString in1;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString in1) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.in1 = in1;
		}

		@Override
		public SVGAnimatedString getIn1() {
			return in1;
		}
		
	}
	
}
