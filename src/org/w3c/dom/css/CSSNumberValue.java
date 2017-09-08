package org.w3c.dom.css;

public interface CSSNumberValue extends CSSValue {

	public static final int NUMBER_NONE = 1 << 0, NUMBER_INHERIT = 1 << 1;
	
	public int getFlags();
	
	public float getValue();
	
	public boolean isNone();
	
	public boolean isInherit();
	
}
