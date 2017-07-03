package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGLocatable {
	
	public SVGElement getNearestViewportElement();
	
	public SVGElement getFarthestViewportElement();
	
	public SVGRect getBBox();
	
	public SVGMatrix getCTM();
	
	public SVGMatrix getScreenCTM();
	
	public SVGMatrix getTransformToElement(SVGElement element) throws DOMException;
	
	// TODO implementation

}
