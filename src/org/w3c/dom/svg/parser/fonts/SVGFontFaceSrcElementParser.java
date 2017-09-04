package org.w3c.dom.svg.parser.fonts;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.fonts.SVGFontFaceSrcElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFontFaceSrcElementParser implements ElementParser<SVGFontFaceSrcElement> {

	@Override
	public SVGFontFaceSrcElement readElement(Element element, ParsingState parsingState) {
		// Get default values
		String id = ElementParser.read(element, Attributes.ID);
		String xmlBase = ElementParser.read(element, Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		return new SVGFontFaceSrcElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement);
	}

	@Override
	public Element writeElement(SVGFontFaceSrcElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		return factory.createElement(Tags.FONT_FACE_SRC, attributes);
	}

}
