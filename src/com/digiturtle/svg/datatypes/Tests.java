package com.digiturtle.svg.datatypes;

public class Tests {
	
	private StringList requiredFeatures, requiredExtensions, systemLanguage;

	public Tests(StringList requiredFeatures, StringList requiredExtensions, StringList systemLanguage) {
		this.requiredFeatures = requiredFeatures;
		this.requiredExtensions = requiredExtensions;
		this.systemLanguage = systemLanguage;
	}

	public StringList getRequiredFeatures() {
		return requiredFeatures;
	}

	public StringList getRequiredExtensions() {
		return requiredExtensions;
	}

	public StringList getSystemLanguage() {
		return systemLanguage;
	}
	
	public boolean hasExtension(String extension) {
		// TODO
		return true;
	}

}
