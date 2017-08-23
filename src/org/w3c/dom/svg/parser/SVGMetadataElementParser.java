package org.w3c.dom.svg.parser;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGMetadataElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public class SVGMetadataElementParser implements ElementParser<SVGMetadataElement> {

	@Override
	public SVGMetadataElement readElement(Element element, ParsingState parsingState) {
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		return new SVGMetadataElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement);
	}

	@Override
	public Element writeElement(SVGMetadataElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<String, String>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		return factory.createElement(Tags.METADATA, attributes);
	}

}
