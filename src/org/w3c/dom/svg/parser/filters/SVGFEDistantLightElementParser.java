package org.w3c.dom.svg.parser.filters;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.filters.SVGFEDistantLightElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFEDistantLightElementParser implements ElementParser<SVGFEDistantLightElement> {

	@Override
	public SVGFEDistantLightElement readElement(Element element, ParsingState parsingState) {
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		SVGNumber azimuthBase = new SVGNumber.Implementation(Float.parseFloat(element.getAttribute(Attributes.AZIMUTH)));
		SVGAnimatedNumber azimuth = new SVGAnimatedNumber.Implementation(azimuthBase.getValue(), azimuthBase.getValue());
		SVGNumber elevationBase = new SVGNumber.Implementation(Float.parseFloat(element.getAttribute(Attributes.ELEVATION)));
		SVGAnimatedNumber elevation = new SVGAnimatedNumber.Implementation(elevationBase.getValue(), elevationBase.getValue());
		return new SVGFEDistantLightElement.Implementation(id, xmlBase, ownerSVGElement,
				viewportElement, azimuth, elevation);
	}

	@Override
	public Element writeElement(SVGFEDistantLightElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.AZIMUTH, Float.toString(element.getAzimuth().getBaseValue()));
		attributes.put(Attributes.ELEVATION, Float.toString(element.getElevation().getBaseValue()));
		return factory.createElement(Tags.FE_DISTANTLIGHT, attributes);
	}

}
