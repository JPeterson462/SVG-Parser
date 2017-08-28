package org.w3c.dom.svg;

@FunctionalInterface
public interface ElementFinder {
	
	public SVGElement findElement(String id);

}
