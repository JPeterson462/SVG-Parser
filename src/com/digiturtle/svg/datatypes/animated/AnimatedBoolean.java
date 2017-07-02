package com.digiturtle.svg.datatypes.animated;

public class AnimatedBoolean {
	
	private boolean baseValue, animatedValue;
	
	public AnimatedBoolean(boolean animatedValue) {
		this.animatedValue = animatedValue;
	}

	public boolean getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(boolean baseValue) {
		this.baseValue = baseValue;
	}

	public boolean getAnimatedValue() {
		return animatedValue;
	}

}
