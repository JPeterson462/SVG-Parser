package com.digiturtle.svg.datatypes;

import com.digiturtle.svg.datatypes.animated.AnimatedString;
import com.digiturtle.svg.style.StyleDeclaration;

public class Stylable {
	
	private AnimatedString className;
	
	private StyleDeclaration style;
	
	public Stylable(AnimatedString className, StyleDeclaration style) {
		this.className = className;
		this.style = style;
	}
	
	public AnimatedString getClassName() {
		return className;
	}
	
	public StyleDeclaration getStyle() {
		return style;
	}

}
