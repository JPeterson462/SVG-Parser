package org.w3c.dom.css;

import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.SVGLength;

public interface CSSLengthValue extends CSSValue {

	public boolean isAuto();
	
	public boolean isNormal();
	
	public boolean isInherit();
	
	public SVGLength getValue();
	
	public int getValueFlags();
	
}
