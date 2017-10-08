package org.w3c.dom.svg.parser;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGElement;

public interface DelayedElementParser<T extends SVGElement> {
	
	public void readElement(T destination, Element element, ParsingState parsingState);

}
