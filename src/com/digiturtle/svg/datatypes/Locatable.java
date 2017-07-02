package com.digiturtle.svg.datatypes;

public class Locatable {
	
	private Element nearestViewportElement, farthestViewportElement;
	
	public Locatable(Element nearestViewportElement, Element farthestViewportElement) {
		this.nearestViewportElement = nearestViewportElement;
		this.farthestViewportElement = farthestViewportElement;
	}
	
	public Element getNearestViewportElement() {
		return nearestViewportElement;
	}

	public Element getFarthestViewportElement() {
		return farthestViewportElement;
	}

	public Rectangle getBBox() {
		// TODO
		return null;
	}
	
	public Matrix getCTM() {
		// TODO
		return null;
	}
	
	public Matrix getScreenCTM() {
		// TODO
		return null;
	}
	
	public Matrix getTransformToElement(Element element) {
		// TODO
		return null;
	}

}
