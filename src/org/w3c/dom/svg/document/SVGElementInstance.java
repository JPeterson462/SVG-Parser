package org.w3c.dom.svg.document;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.svg.SVGElement;

public interface SVGElementInstance extends EventTarget {

	public SVGElement getCorrespondingElement();
	
	public SVGUseElement getCorrespondingUseElement();
	
	public SVGElementInstance getParentNode();
	
	public SVGElementInstanceList getChildNodes();

	public SVGElementInstance getFirstChild();

	public SVGElementInstance getLastChild();

	public SVGElementInstance getPreviousSibling();

	public SVGElementInstance getNextSibling();
	
	// TODO implementation
	
}
