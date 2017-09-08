package org.w3c.dom.css;

public interface CSSEnableBackgroundValue extends CSSValue {
	
	public static final float UNSET_VALUE = Float.NaN;

	public boolean isAccumulate();
	
	public boolean isInherit();

	public boolean isAuto();
	
	public float getX();
	
	public float getY();
	
	public float getWidth();
	
	public float getHeight();
	
}
