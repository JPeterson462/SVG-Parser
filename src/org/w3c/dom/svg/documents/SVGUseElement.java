package org.w3c.dom.svg.documents;

import org.w3c.dom.svg.FileElement;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGURIReference;

public interface SVGUseElement extends FileElement, SVGURIReference {

	public SVGAnimatedLength getX();
	
	public SVGAnimatedLength getY();
	
	public SVGAnimatedLength getWidth();
	
	public SVGAnimatedLength getHeight();
	
	public SVGElementInstance getInstanceRoot();
	
	public SVGElementInstance getAnimatedInstanceRoot();
	
	// TODO implementation
	
}
