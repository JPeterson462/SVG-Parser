package com.digiturtle.svg.datatypes;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

public interface SVGElement extends Element {
	
	/** The value of the ‘id’ attribute on the given element, or the empty string if ‘id’ is not present.  */
	public String getID();

	public void setID(String id) throws DOMException;
	
	/** Corresponds to attribute ‘xml:base’ on the given element. */
	public String getXMLBase();
	
	public void setXMLBase(String xmlBase) throws DOMException;
	
	/** The nearest ancestor ‘svg’ element. Null if the given element is the outermost svg element.  */
	public SVGSVGElement getOwnerSVGElement();

	/** The element which established the current viewport. Often, the nearest ancestor ‘svg’ element. Null if the given element is the outermost svg element.  */
	public SVGElement getViewportElement();
	
	public static class Implementation extends ElementImplementation implements SVGElement {

		private String id, xmlBase;
		
		private SVGSVGElement ownerSVGElement;
		
		private SVGElement viewportElement;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement) {
			this.id = id;
			this.xmlBase = xmlBase;
			this.ownerSVGElement = ownerSVGElement;
			this.viewportElement = viewportElement;
		}
		
		@Override
		public String getID() {
			return id;
		}

		@Override
		public void setID(String id) throws DOMException {
			this.id = id;
		}

		@Override
		public String getXMLBase() {
			return xmlBase;
		}

		@Override
		public void setXMLBase(String xmlBase) throws DOMException {
			this.xmlBase = xmlBase;
		}

		@Override
		public SVGSVGElement getOwnerSVGElement() {
			return ownerSVGElement;
		}

		@Override
		public SVGElement getViewportElement() {
			return viewportElement;
		}

	}
	
}
