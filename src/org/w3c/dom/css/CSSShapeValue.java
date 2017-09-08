package org.w3c.dom.css;

import org.w3c.dom.svg.SVGLength;

public interface CSSShapeValue extends CSSValue {

	public SVGLength getTop();
	
	public SVGLength getRight();
	
	public SVGLength getBottom();
	
	public SVGLength getLeft();
	
	public boolean isTopAuto();
	
	public boolean isRightAuto();
	
	public boolean isBottomAuto();
	
	public boolean isLeftAuto();
	
}
