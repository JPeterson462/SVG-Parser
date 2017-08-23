package org.w3c.dom.svg.parser;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGCursorElement;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;

public class SVGCursorElementParser implements ElementParser<SVGCursorElement> {

	@Override
	public SVGCursorElement readElement(Element element, ParsingState parsingState) {
		String xStr = ElementParser.readOrDefault(element, Attributes.X, "0");
		String yStr = ElementParser.readOrDefault(element, Attributes.Y, "0");
		SVGLength x = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		x.setValueAsString(xStr);
		SVGLength y = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		y.setValueAsString(yStr);
		SVGAnimatedLength ax = new SVGAnimatedLength.Implementation(x, x);
		SVGAnimatedLength ay = new SVGAnimatedLength.Implementation(y, y);
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String rawHrefAsString = element.getAttribute(Attributes.XLINK_HREF);
		if (rawHrefAsString == null || !rawHrefAsString.startsWith("url(") || !rawHrefAsString.endsWith(")")) {
			SVGErrors.error("Invalid Functional IRI: " + rawHrefAsString);
		}
		String hrefAsString = rawHrefAsString.substring(4, rawHrefAsString.length() - 1);
		SVGAnimatedString href = new SVGAnimatedString.Implementation(hrefAsString, hrefAsString);
		SVGStringList requiredFeatures = ElementParser.concatenate(ElementParser.readOrDefault(element, Attributes.REQUIRED_FEATURES, "").split(" "));
		SVGStringList requiredExtensions = ElementParser.concatenate(ElementParser.readOrDefault(element, Attributes.REQUIRED_EXTENSIONS, "").split(" "));
		SVGStringList systemLanguage = ElementParser.concatenate(ElementParser.readOrDefault(element, Attributes.SYSTEM_LANGUAGE, "").split(" "));
		boolean externalResourcesRequiredAsBoolean = Boolean.parseBoolean(ElementParser.readOrDefault(element, Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(false)));
		SVGAnimatedBoolean externalResourcesRequired = new SVGAnimatedBoolean.Implementation(externalResourcesRequiredAsBoolean, externalResourcesRequiredAsBoolean);
		return new SVGCursorElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, href, 
				requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired, ax, ay);
	}

	@Override
	public Element writeElement(SVGCursorElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.X, element.getX().getBaseValue().getValueAsString());
		attributes.put(Attributes.Y, element.getY().getBaseValue().getValueAsString());
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.XLINK_HREF, element.getHref().getBaseValue());
		if (element.getRequiredFeatures().getLength() > 0) {
			attributes.put(Attributes.REQUIRED_FEATURES, ElementParser.concatenate(element.getRequiredFeatures(), " "));
		}
		if (element.getRequiredExtensions().getLength() > 0) {
			attributes.put(Attributes.REQUIRED_EXTENSIONS, ElementParser.concatenate(element.getRequiredExtensions(), " "));
		}
		if (element.getSystemLanguage().getLength() > 0) {
			attributes.put(Attributes.SYSTEM_LANGUAGE, ElementParser.concatenate(element.getSystemLanguage(), " "));
		}
		return factory.createElement(Tags.CURSOR, attributes);
	}

}
