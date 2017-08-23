package org.w3c.dom.svg.animation;

public interface AnimationValue {
	
	public static final short CALCMODE_DISCRETE = 0;
	public static final short CALCMODE_LINEAR = 1;//default
	public static final short CALCMODE_PACED = 2;//default:animateMotion
	public static final short CALCMODE_SPLINE = 3;
	
	public short getCalcMode();
	
	//values TODO
	
	//keyTimes
	
	//keySplines
	
	//from
	
	//to
	
	//by

}
