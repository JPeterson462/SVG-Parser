package org.w3c.dom.svg.parser;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGElement;

public interface ElementParser {
	
	public SVGElement readElement(Element element);
	
	public Element writeElement(SVGElement element, ElementFactory factory);

}
