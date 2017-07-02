package com.digiturtle.svg.datatypes.animated;

public class AnimatedInteger {
	
	private long baseValue, animatedValue;
	
	public AnimatedInteger(long animatedValue) {
		this.animatedValue = animatedValue;
	}

	public long getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(long baseValue) {
		this.baseValue = baseValue;
	}

	public long getAnimatedValue() {
		return animatedValue;
	}

}
