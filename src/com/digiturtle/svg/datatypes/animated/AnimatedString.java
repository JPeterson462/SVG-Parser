package com.digiturtle.svg.datatypes.animated;

public class AnimatedString {
	
	private String baseValue, animatedValue;
	
	public AnimatedString(String animatedValue) {
		this.animatedValue = animatedValue;
	}

	public String getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(String baseValue) {
		this.baseValue = baseValue;
	}

	public String getAnimatedValue() {
		return animatedValue;
	}

}
