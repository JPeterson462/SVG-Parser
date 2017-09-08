package org.w3c.dom.css;

import org.w3c.dom.svg.SVGLength;

public interface CSSBaselineShiftValue extends CSSValue {
	
	public boolean isBaseline();
	
	public boolean isSub();
	
	public boolean isSuper();
	
	public boolean isInherit();
	
	public SVGLength getLength();

}
