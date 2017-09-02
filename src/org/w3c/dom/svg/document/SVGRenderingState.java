package org.w3c.dom.svg.document;

import org.w3c.dom.NodeList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGRect;

public interface SVGRenderingState {
	
	public NodeList getIntersectionList(SVGRect rect, SVGElement referenceElement);
	
	public NodeList getEnclosureList(SVGRect rect, SVGElement referenceElement);
	
	public boolean checkIntersection(SVGElement element, SVGRect rect);
	
	public boolean checkEnclosure(SVGElement element, SVGRect rect);

	public void deselectAll();
	
	public float getPixelsPerInch();
	
}
