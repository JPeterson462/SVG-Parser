package com.digiturtle.svg.datatypes;

import com.digiturtle.svg.dom.SVGElement;

public class Element {

	private String id;
	
	private String xmlBase;
	
	private SVGElement ownerSVGElement;
	
	private Element viewportElement;
	
	public Element(SVGElement ownerSVGElement, Element viewportElement) {
		this.ownerSVGElement = ownerSVGElement;
		this.viewportElement = viewportElement;
		id = "";
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getXmlBase() {
		return xmlBase;
	}

	public void setXmlBase(String xmlBase) {
		this.xmlBase = xmlBase;
	}

	public SVGElement getOwnerSVGElement() {
		return ownerSVGElement;
	}

	public Element getViewportElement() {
		return viewportElement;
	}

}
