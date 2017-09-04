package org.w3c.dom.svg.parser.fonts;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.fonts.SVGFontFaceUriElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFontFaceUriElementParser implements ElementParser<SVGFontFaceUriElement> {

	@Override
	public SVGFontFaceUriElement readElement(Element element, ParsingState parsingState) {
		String uri = ElementParser.read(element, Attributes.XLINK_HREF);
		// Get default values
		String id = ElementParser.read(element, Attributes.ID);
		String xmlBase = ElementParser.read(element, Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		return new SVGFontFaceUriElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, uri);
	}

	@Override
	public Element writeElement(SVGFontFaceUriElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.XLINK_HREF[Attributes.XLINK_HREF.length - 1], element.getHref());
		return factory.createElement(Tags.FONT_FACE_NAME, attributes);
	}

}
