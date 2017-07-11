package org.w3c.dom.svg.parser.shapes;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;

public class SVGRectElementParser implements ElementParser {

	@Override
	public SVGElement readElement(Element element) {
		if (!element.getTagName().equalsIgnoreCase("rect")) {
			throw new IllegalStateException("Invalid <rect> element");
		}
		String xStr = element.getAttribute("x");
		if (xStr == null) {
			xStr = "0";
		}
		String yStr = element.getAttribute("y");
		String widthStr = element.getAttribute("width");
		String heightStr = element.getAttribute("height");
		String rxStr = element.getAttribute("rx");
		String ryStr = element.getAttribute("ry");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element writeElement(SVGElement element, ElementFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

}
