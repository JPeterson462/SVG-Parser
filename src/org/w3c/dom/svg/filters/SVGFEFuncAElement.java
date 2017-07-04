package org.w3c.dom.svg.filters;

import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedNumberList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFEFuncAElement extends SVGComponentTransferFunctionElement {

	public static class Implementatation extends SVGComponentTransferFunctionElement.Implementation implements SVGFEFuncAElement {

		public Implementatation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedEnumeration type, SVGAnimatedNumberList tableValues, SVGAnimatedNumber slope,
				SVGAnimatedNumber intercept, SVGAnimatedNumber amplitude, SVGAnimatedNumber exponent,
				SVGAnimatedNumber offset) {
			super(id, xmlBase, ownerSVGElement, viewportElement, type, tableValues, slope, intercept, amplitude, exponent, offset);
		}
		
	}
	
}
