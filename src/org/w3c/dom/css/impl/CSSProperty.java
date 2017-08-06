package org.w3c.dom.css.impl;

@FunctionalInterface
public interface CSSProperty {
	
	public void parseValue(String cssText, CSSStyleDeclarationImplementation declaration);
	
}
