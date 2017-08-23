package org.w3c.dom.svg.parser.filters;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.filters.SVGFEPointLightElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFEPointLightElementParser implements ElementParser<SVGFEPointLightElement> {

	@Override
	public SVGFEPointLightElement readElement(Element element, ParsingState parsingState) {
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		float xBase = Float.parseFloat(element.getAttribute(Attributes.X));
		float yBase = Float.parseFloat(element.getAttribute(Attributes.Y));
		float zBase = Float.parseFloat(element.getAttribute(Attributes.Z));
		SVGAnimatedNumber x = new SVGAnimatedNumber.Implementation(xBase, xBase);
		SVGAnimatedNumber y = new SVGAnimatedNumber.Implementation(yBase, yBase);
		SVGAnimatedNumber z = new SVGAnimatedNumber.Implementation(zBase, zBase);
		return new SVGFEPointLightElement.Implementation(id, xmlBase, ownerSVGElement, 
				viewportElement, x, y, z);
	}

	@Override
	public Element writeElement(SVGFEPointLightElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.X, Float.toString(element.getX().getBaseValue()));
		attributes.put(Attributes.Y, Float.toString(element.getY().getBaseValue()));
		attributes.put(Attributes.Z, Float.toString(element.getZ().getBaseValue()));
		return factory.createElement(Tags.FE_POINTLIGHT, attributes);
	}

}
