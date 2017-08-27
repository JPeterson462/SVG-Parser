package org.w3c.dom.svg.animation;

import org.w3c.dom.svg.SVGStringList;

public interface AnimationValue {
	
	public static final short CALCMODE_DISCRETE = 0;
	public static final short CALCMODE_LINEAR = 1;//default
	public static final short CALCMODE_PACED = 2;//default:animateMotion
	public static final short CALCMODE_SPLINE = 3;
	
	public short getCalcMode();
	
	public SVGStringList getValues();
	
	public SVGStringList getKeyTimes();
	
	public SVGStringList getKeySplines();
	
	public String getFrom();
	
	public String getTo();
	
	public String getBy();

}
