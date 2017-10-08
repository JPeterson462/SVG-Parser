package org.w3c.dom.svg;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.svg.document.SVGElementInstance;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.impl.ElementImplementation;

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
	
	public SVGElementInstance createInstance();
	
	public String getAsString();
	
	public void setTag(String tagName);
	
	public String getTag();
	
	public void connectEventListeners(String onFocusIn, String onFocusOut, String onActivate, String onClick,
			String onMouseDown, String onMouseUp, String onMouseOver, String onMouseMove, String onMouseOut);
	
	public String getOnFocusIn();
	
	public String getOnFocusOut();
	
	public String getOnActivate();
	
	public String getOnClick();
	
	public String getOnMouseDown();
	
	public String getOnMouseUp();
	
	public String getOnMouseOver();
	
	public String getOnMouseMove();
	
	public String getOnMouseOut();
	
	@DelayedInstantiation
	public static class Implementation extends ElementImplementation implements SVGElement {

		private String id, xmlBase;
		
		private SVGSVGElement ownerSVGElement;
		
		private SVGElement viewportElement;
		
		private String tagName;
		
		private String onFocusIn, onFocusOut, onActivate, onClick, onMouseDown, onMouseUp, onMouseOver, onMouseMove, onMouseOut;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement) {
			super(id);
			this.id = id;
			this.xmlBase = xmlBase;
			this.ownerSVGElement = ownerSVGElement;
			this.viewportElement = viewportElement;
		}
		
		public Implementation(String id) {
			super(id);
			this.id = id;
		}
		
		public void instantiateBase(String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement) {
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

		@Override
		public SVGElementInstance createInstance() {
			return new SVGElementInstance.Implementation(getID());
		}
		
		public String toString() {
			return toString("");
		}
		
		private String toString(String prefix) {
			String thisNode = prefix + getAsString() + "\n";
			NodeList children = getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node node = children.item(i);
				if (node instanceof SVGElement.Implementation) {
					thisNode += ((SVGElement.Implementation) node).toString(prefix + "\t");
				}
			}
			return thisNode;
		}
		
		public String getAsString() {
			return getTag() + " id[" + getID() + "] xmlBase[" + getXMLBase() + "]";
		}

		@Override
		public void setTag(String tagName) {
			this.tagName = tagName;
		}

		@Override
		public String getTag() {
			return tagName;
		}

		@Override
		public void connectEventListeners(String onFocusIn, String onFocusOut, String onActivate, String onClick,
				String onMouseDown, String onMouseUp, String onMouseOver, String onMouseMove, String onMouseOut) {
			this.onActivate = onActivate;
			this.onClick = onClick;
			this.onFocusIn = onFocusIn;
			this.onFocusOut = onFocusOut;
			this.onMouseDown = onMouseDown;
			this.onMouseMove = onMouseMove;
			this.onMouseOut = onMouseOut;
			this.onMouseOver = onMouseOver;
			this.onMouseUp = onMouseUp;
		}

		@Override
		public String getOnFocusIn() {
			return onFocusIn;
		}

		@Override
		public String getOnFocusOut() {
			return onFocusOut;
		}

		@Override
		public String getOnActivate() {
			return onActivate;
		}

		@Override
		public String getOnClick() {
			return onClick;
		}

		@Override
		public String getOnMouseDown() {
			return onMouseDown;
		}

		@Override
		public String getOnMouseUp() {
			return onMouseUp;
		}

		@Override
		public String getOnMouseOver() {
			return onMouseOver;
		}

		@Override
		public String getOnMouseMove() {
			return onMouseMove;
		}

		@Override
		public String getOnMouseOut() {
			return onMouseOut;
		}

	}
	
}
