package org.w3c.dom.svg.parser;

import org.w3c.dom.svg.document.SVGSVGElement;

public class ParsingState {
	
	private SVGSVGElement ownerSVGElement;

	public SVGSVGElement getOwnerSVGElement() {
		return ownerSVGElement;
	}

	public void setOwnerSVGElement(SVGSVGElement ownerSVGElement) {
		this.ownerSVGElement = ownerSVGElement;
	}

}
