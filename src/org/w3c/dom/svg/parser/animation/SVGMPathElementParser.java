package org.w3c.dom.svg.parser.animation;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.animation.SVGMPathElement;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGMPathElementParser implements ElementParser<SVGMPathElement> {

	@Override
	public SVGMPathElement readElement(Element element, ParsingState parsingState) {
		String id = ElementParser.read(element, Attributes.ID);
		String xmlBase = ElementParser.read(element, Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String hrefStr = ElementParser.read(element, Attributes.XLINK_HREF);
		SVGAnimatedString href = new SVGAnimatedString.Implementation(hrefStr, hrefStr);
		String externalResourcesRequiredAsString = ElementParser.readOrDefault(element, Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(false));
		SVGAnimatedBoolean externalResourcesRequired = new SVGAnimatedBoolean.Implementation(Boolean.parseBoolean(externalResourcesRequiredAsString), Boolean.parseBoolean(externalResourcesRequiredAsString));
		return new SVGMPathElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, href, externalResourcesRequired);
	}

	@Override
	public Element writeElement(SVGMPathElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.XLINK_HREF[Attributes.XLINK_HREF.length - 1], element.getHref().getBaseValue());
		attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(element.getExternalResourcesRequired().getBaseValue()));
		return factory.createElement(Tags.MPATH, attributes);
	}

}
