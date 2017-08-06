package org.w3c.dom.css.impl;

import java.util.HashMap;

import org.w3c.dom.svg.SVGErrors;

public class CSSProperties {

	private static HashMap<String, CSSProperty> properties = new HashMap<>();
	
	public static void tryCreateProperties() {
		if (properties.size() == 0) {
			
			// TODO add more properties
		}
	}
	
	public static void parseValue(String propertyName, String cssText, CSSStyleDeclarationImplementation declaration) {
		if (!properties.containsKey(propertyName)) {
			SVGErrors.error("Invalid CSS Property: " + propertyName);
		}
		properties.get(propertyName).parseValue(cssText, declaration);
	}
	
}
