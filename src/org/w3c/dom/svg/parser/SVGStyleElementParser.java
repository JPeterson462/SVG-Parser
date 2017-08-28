package org.w3c.dom.svg.parser;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStyleElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public class SVGStyleElementParser implements ElementParser<SVGStyleElement> {

	@Override
	public SVGStyleElement readElement(Element element, ParsingState parsingState) {
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String xmlLang = element.getAttribute(Attributes.XML_LANG);
		String xmlSpace = element.getAttribute(Attributes.XML_SPACE);
		String type = ElementParser.readOrDefault(element, Attributes.TYPE, parsingState.getOwnerSVGElement().getAttribute(Attributes.CONTENT_STYLE_TYPE), "text/css");
		String media = ElementParser.readOrDefault(element, Attributes.MEDIA, "all");
		String title = element.getAttribute(Attributes.TITLE);
		SVGStyleElement styleElement = new SVGStyleElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, xmlLang, xmlSpace, type, media, title);
		styleElement.setTextContent(element.getTextContent());
		parsingState.addStyleSheet(element.getTextContent());
		return styleElement;
	}

	@Override
	public Element writeElement(SVGStyleElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<String, String>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.XML_LANG, element.getXMLLang());
		attributes.put(Attributes.XML_SPACE, element.getXMLSpace());
		attributes.put(Attributes.TYPE, element.getType());
		attributes.put(Attributes.MEDIA, element.getMedia());
		attributes.put(Attributes.TITLE, element.getTitle());
		Element e = factory.createElement(Tags.STYLE, attributes);
		e.setTextContent(element.getTextContent());
		return e;
	}

}
