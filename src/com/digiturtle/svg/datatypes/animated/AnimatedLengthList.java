package com.digiturtle.svg.datatypes.animated;

import com.digiturtle.svg.datatypes.LengthList;

public class AnimatedLengthList {
	
	private LengthList baseValue, animatedValue;
	
	public AnimatedLengthList(LengthList baseValue, LengthList animatedValue) {
		this.baseValue = baseValue;
		this.animatedValue = animatedValue;
	}

	public LengthList getBaseValue() {
		return baseValue;
	}

	public LengthList getAnimatedValue() {
		return animatedValue;
	}

}
