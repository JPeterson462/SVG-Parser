package com.digiturtle.svg.datatypes;

import com.digiturtle.svg.datatypes.animated.AnimatedString;

public class URIReference {
	
	private AnimatedString href;
	
	public URIReference(AnimatedString href) {
		this.href = href;
	}
	
	public AnimatedString getHref() {
		return href;
	}

}
