package org.w3c.dom.svg.animation;

public interface AnimationTiming {
	
	public static final short RESTART_ALWAYS = 0;//default
	public static final short RESTART_WHENNOTACTIVE = 1;
	public static final short RESTART_NEVER = 2;
	
	public static final short FILL_REMOVE = 0;//default
	public static final short FILL_FREEZE = 1;

	//begin TODO
	
	public SMILClockValue getDuration();
	
	//end
	
	public SMILClockValue getMin();
	
	public SMILClockValue getMax();
	
	public short getRestart();
	
	public float getRepeatCount();
	public boolean isRepeatIndefinite();
	
	public SMILClockValue getRepeatDuration();
	
	public short getFill();
	
}
