package org.w3c.dom.svg.parser.fonts;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGFontFace;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.fonts.SVGFontElement;
import org.w3c.dom.svg.fonts.SVGFontFaceElement;
import org.w3c.dom.svg.fonts.SVGFontFaceParser;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFontFaceElementParser implements ElementParser<SVGFontFaceElement> {

	private SVGFontFaceParser fontFaceParser = new SVGFontFaceParser();
	
	@Override
	public SVGFontFaceElement readElement(Element element, ParsingState parsingState) {
		SVGFontFace fontFace = fontFaceParser.parseFontFace((attribute, defaultValue) -> {
			if (defaultValue == null) {
//				if (!element.hasAttribute(attribute)) {
//					SVGErrors.error("Attribute not found: " + attribute);
//				}
				return ElementParser.read(element, attribute);
			}
			return ElementParser.readOrDefault(element, attribute, defaultValue);
		}, parsingState);
		SVGElement parent = parsingState.getCurrentParent();
		if (parent instanceof SVGFontElement) {
			((SVGFontElement) parent).getVerticalAdvanceY().setValue(fontFace.getUnitsPerEm().getValue() * 1);
		} else {
			// TODO
		}
		// Get default values
		String id = ElementParser.read(element, Attributes.ID);
		String xmlBase = ElementParser.read(element, Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		return new SVGFontFaceElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement,
				fontFace);
	}

	@Override
	public Element writeElement(SVGFontFaceElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		fontFaceParser.saveFontFace(attributes, element.getFontFace());
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		return factory.createElement(Tags.FONT_FACE, attributes);
	}

}
