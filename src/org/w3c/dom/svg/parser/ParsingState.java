package org.w3c.dom.svg.parser;

import java.util.Stack;

import org.w3c.dom.css.CSSRule;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public class ParsingState {
	
	private SVGSVGElement ownerSVGElement;
	
	private Stack<SVGElement> elementHierarchy = new Stack<>();

	public SVGSVGElement getOwnerSVGElement() {
		return ownerSVGElement;
	}

	public void setOwnerSVGElement(SVGSVGElement ownerSVGElement) {
		this.ownerSVGElement = ownerSVGElement;
	}
	
	public SVGElement getCurrentParent() {
		return elementHierarchy.peek();
	}
	
	public CSSRule findParentRule() {
		return null;//TODO
	}
	
	public void pushParent(SVGElement element) {
		elementHierarchy.push(element);
	}
	
	public SVGElement popParent() {
		return elementHierarchy.pop();
	}

}
