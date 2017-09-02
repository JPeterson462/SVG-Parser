package org.w3c.dom.css;

import org.w3c.dom.svg.SVGAngle;

public interface CSSAngleValue extends CSSValue {

	public SVGAngle getAngle();
	
	public boolean isAuto();
	
	public boolean isInherit();
	
}
