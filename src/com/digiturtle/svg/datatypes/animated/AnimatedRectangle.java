package com.digiturtle.svg.datatypes.animated;

import com.digiturtle.svg.datatypes.Rectangle;

public class AnimatedRectangle {
	
	private Rectangle baseValue, animatedValue;
	
	public AnimatedRectangle(Rectangle baseValue, Rectangle animatedValue) {
		this.baseValue = baseValue;
		this.animatedValue = animatedValue;
	}

	public Rectangle getBaseValue() {
		return baseValue;
	}

	public Rectangle getAnimatedValue() {
		return animatedValue;
	}

}
