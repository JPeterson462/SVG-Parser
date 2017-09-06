package org.w3c.dom.svg.parser;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGScriptElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public class SVGScriptElementParser implements ElementParser<SVGScriptElement> {

	@Override
	public SVGScriptElement readElement(Element element, ParsingState parsingState) {
		String hrefStr = ElementParser.read(element, Attributes.XLINK_HREF);
		SVGAnimatedString href = new SVGAnimatedString.Implementation(hrefStr, hrefStr);
		String type = ElementParser.read(element, Attributes.TYPE);
		// Get default values
		String id = ElementParser.read(element, Attributes.ID);
		String xmlBase = ElementParser.read(element, Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		boolean externalResourcesRequiredAsBoolean = Boolean.parseBoolean(ElementParser.readOrDefault(element, Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(false)));
		SVGAnimatedBoolean externalResourcesRequired = new SVGAnimatedBoolean.Implementation(externalResourcesRequiredAsBoolean, externalResourcesRequiredAsBoolean);
		SVGScriptElement scriptElement = new SVGScriptElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, 
				href, externalResourcesRequired, type);
		scriptElement.setTextContent("<![CDATA[" + element.getTextContent() + "]]>");
		return scriptElement;
	}

	@Override
	public Element writeElement(SVGScriptElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.XLINK_HREF[Attributes.XLINK_HREF.length - 1], element.getHref().getBaseValue());
		attributes.put(Attributes.TYPE, element.getType());
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, element.getID());
		Element scriptElement = factory.createElement(Tags.SCRIPT, attributes);
		scriptElement.setTextContent(element.getTextContent());
		return scriptElement;
	}

}
