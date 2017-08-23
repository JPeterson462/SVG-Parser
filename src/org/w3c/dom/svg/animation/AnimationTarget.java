package org.w3c.dom.svg.animation;

public interface AnimationTarget {
	
	public static final short ANIMATIONTARGET_CSS = 0;
	public static final short ANIMATIONTARGET_XML = 1;
	public static final short ANIMATIONTARGET_AUTO = 2;//default
	
	public short getAttributeType();
	
	public String getAttributeName();

}
