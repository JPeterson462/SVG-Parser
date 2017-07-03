package org.w3c.dom.svg.documents;

import org.w3c.dom.svg.FileElement;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio;
import org.w3c.dom.svg.SVGURIReference;

public interface SVGImageElement extends FileElement, SVGURIReference {

	public SVGAnimatedLength getX();
	
	public SVGAnimatedLength getY();
	
	public SVGAnimatedLength getWidth();
	
	public SVGAnimatedLength getHeight();
	
	public SVGAnimatedPreserveAspectRatio getPreserveAspectRatio();
	
	// TODO implementation
	
}
