package com.digiturtle.svg.datatypes.animated;

import com.digiturtle.svg.datatypes.NumberList;

public class AnimatedNumberList {
	
	private NumberList baseValue, animatedValue;
	
	public AnimatedNumberList(NumberList baseValue, NumberList animatedValue) {
		this.baseValue = baseValue;
		this.animatedValue = animatedValue;
	}

	public NumberList getBaseValue() {
		return baseValue;
	}

	public NumberList getAnimatedValue() {
		return animatedValue;
	}

}
