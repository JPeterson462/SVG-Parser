package org.w3c.dom.svg.parser.text;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;
import org.w3c.dom.svg.text.SVGAltGlyphItemElement;

public class SVGAltGlyphItemElementParser implements ElementParser<SVGAltGlyphItemElement> {

	@Override
	public SVGAltGlyphItemElement readElement(Element element, ParsingState parsingState) {
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getOwnerSVGElement();
		return new SVGAltGlyphItemElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement);
	}

	@Override
	public Element writeElement(SVGAltGlyphItemElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		return factory.createElement(Tags.ALT_GLYPH_ITEM, attributes);
	}

}
