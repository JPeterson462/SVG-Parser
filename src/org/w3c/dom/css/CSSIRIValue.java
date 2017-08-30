package org.w3c.dom.css;

import org.w3c.dom.css.CSSValue;

public interface CSSIRIValue extends CSSValue {

	public String getIRI();
	
	public boolean isNone();
	
	public boolean isInherit();
	
}
