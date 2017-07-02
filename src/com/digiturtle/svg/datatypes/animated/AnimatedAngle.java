package com.digiturtle.svg.datatypes.animated;

import com.digiturtle.svg.datatypes.Angle;

public class AnimatedAngle {
	
	private Angle baseValue, animatedValue;

	public AnimatedAngle(Angle baseValue, Angle animatedValue) {
		this.baseValue = baseValue;
		this.animatedValue = animatedValue;
	}
	
	public Angle getBaseValue() {
		return baseValue;
	}

	public Angle getAnimatedValue() {
		return animatedValue;
	}

}
