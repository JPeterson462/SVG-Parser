package org.w3c.dom.css;

import org.w3c.dom.css.CSSValue;

public interface CSSLengthValue extends CSSValue {

	public boolean isAuto();
	
	public boolean isNormal();
	
	public float getValue();
	
}
