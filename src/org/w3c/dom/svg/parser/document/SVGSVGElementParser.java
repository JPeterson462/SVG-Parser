package org.w3c.dom.svg.parser.document;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;

public class SVGSVGElementParser implements ElementParser {

	@Override
	public SVGElement readElement(Element element) {
		if (!element.getTagName().equalsIgnoreCase("svg")) {
			throw new IllegalStateException("Invalid <svg> element");
		}
		String version = element.getAttribute("version");
		String baseProfile = element.getAttribute("baseProfile"); // or 'none'
		String xStr = element.getAttribute("x");
		//TODO
		return null;
	}

	@Override
	public Element writeElement(SVGElement element, ElementFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

}
