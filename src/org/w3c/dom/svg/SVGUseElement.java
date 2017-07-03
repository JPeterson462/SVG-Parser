package org.w3c.dom.svg;

public interface SVGUseElement extends FileElement, SVGURIReference {

	public SVGAnimatedLength getX();
	
	public SVGAnimatedLength getY();
	
	public SVGAnimatedLength getWidth();
	
	public SVGAnimatedLength getHeight();
	
	public SVGElementInstance getInstanceRoot();
	
	public SVGElementInstance getAnimatedInstanceRoot();
	
	// TODO implementation
	
}
