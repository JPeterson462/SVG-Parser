package org.w3c.dom.css;

import org.w3c.dom.svg.SVGLengthList;

public interface CSSDashArrayValue extends CSSValue {

	public SVGLengthList getDashArray();
	
	public boolean isInherit();
	
	public boolean isNone();
	
}
