package com.digiturtle.svg.datatypes;

import com.digiturtle.svg.datatypes.animated.AnimatedRectangle;

public class FitToViewBox {
	
	private AnimatedRectangle viewBox;
	
	// TODO AnimatedPreserveAspectRatio
	
	public FitToViewBox(AnimatedRectangle viewBox) {
		this.viewBox = viewBox;
	}
	
	public AnimatedRectangle getViewBox() {
		return viewBox;
	}

}
