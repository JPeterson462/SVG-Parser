package com.digiturtle.svg.datatypes;

import com.digiturtle.svg.datatypes.animated.AnimatedBoolean;

public class ExternalResourcesRequired {
	
	private AnimatedBoolean externalResourcesRequired;
	
	public ExternalResourcesRequired(AnimatedBoolean externalResourcesRequired) {
		this.externalResourcesRequired = externalResourcesRequired;
	}

	public AnimatedBoolean isExternalResourcesRequired() {
		return externalResourcesRequired;
	}

}
