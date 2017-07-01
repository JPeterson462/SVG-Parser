package com.digiturtle.svg.datatypes;

public class AnimatedLength {
	
	private Length baseValue, animatedValue;

	public Length getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(Length baseValue) {
		this.baseValue = baseValue;
	}

	public Length getAnimatedValue() {
		return animatedValue;
	}

	public void setAnimatedValue(Length animatedValue) {
		this.animatedValue = animatedValue;
	}

}
