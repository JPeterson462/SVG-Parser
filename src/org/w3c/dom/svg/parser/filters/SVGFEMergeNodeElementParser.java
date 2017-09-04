package org.w3c.dom.svg.parser.filters;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.filters.SVGFEMergeNodeElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFEMergeNodeElementParser implements ElementParser<SVGFEMergeNodeElement> {

	@Override
	public SVGFEMergeNodeElement readElement(Element element, ParsingState parsingState) {
		String id = ElementParser.read(element, Attributes.ID);
		String xmlBase = ElementParser.read(element, Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String in1Str = ElementParser.read(element, Attributes.IN);
		SVGAnimatedString in1 = new SVGAnimatedString.Implementation(in1Str, in1Str);
		return new SVGFEMergeNodeElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, in1);
	}

	@Override
	public Element writeElement(SVGFEMergeNodeElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.IN, element.getIn1().getBaseValue());
		return factory.createElement(Tags.FE_MERGENODE, attributes);
	}

}
