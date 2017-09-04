package org.w3c.dom.svg.parser.fonts;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.fonts.SVGFontFaceNameElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFontFaceNameElementParser implements ElementParser<SVGFontFaceNameElement> {

	@Override
	public SVGFontFaceNameElement readElement(Element element, ParsingState parsingState) {
		String name = ElementParser.read(element, Attributes.NAME);
		// Get default values
		String id = ElementParser.read(element, Attributes.ID);
		String xmlBase = ElementParser.read(element, Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		return new SVGFontFaceNameElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, name);
	}

	@Override
	public Element writeElement(SVGFontFaceNameElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.NAME, element.getName());
		return factory.createElement(Tags.FONT_FACE_NAME, attributes);
	}

}
