package com.digiturtle.svg.datatypes.animated;

import com.digiturtle.svg.datatypes.Length;

public class AnimatedLength {
	
	private Length baseValue, animatedValue;

	public AnimatedLength(Length baseValue, Length animatedValue) {
		this.baseValue = baseValue;
		this.animatedValue = animatedValue;
	}
	
	public Length getBaseValue() {
		return baseValue;
	}

	public Length getAnimatedValue() {
		return animatedValue;
	}

}
