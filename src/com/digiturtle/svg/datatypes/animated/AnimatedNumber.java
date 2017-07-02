package com.digiturtle.svg.datatypes.animated;

public class AnimatedNumber {
	
	private float baseValue, animatedValue;
	
	public AnimatedNumber(float animatedValue) {
		this.animatedValue = animatedValue;
	}

	public float getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(float baseValue) {
		this.baseValue = baseValue;
	}

	public float getAnimatedValue() {
		return animatedValue;
	}

}
