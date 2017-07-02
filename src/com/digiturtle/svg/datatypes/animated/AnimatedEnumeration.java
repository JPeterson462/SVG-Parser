package com.digiturtle.svg.datatypes.animated;

public class AnimatedEnumeration {
	
	private short baseValue, animatedValue;
	
	public AnimatedEnumeration(short animatedValue) {
		this.animatedValue = animatedValue;
	}

	public short getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(short baseValue) {
		this.baseValue = baseValue;
	}

	public short getAnimatedValue() {
		return animatedValue;
	}

}
