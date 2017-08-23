package org.w3c.dom.svg.animation;

public interface AnimationAddition {

	public static final short ADDITIVE_REPLACE = 0;//default
	public static final short ADDITIVE_SUM = 1;
	
	public static final short ACCUMULATE_NONE = 0;
	public static final short ACCUMULATE_SUM = 1;//default
	
	public short getAdditive();
	
	public short getAccumulate();

}
