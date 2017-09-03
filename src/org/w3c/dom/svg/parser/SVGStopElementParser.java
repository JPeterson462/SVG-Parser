package org.w3c.dom.svg.parser;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStopElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public class SVGStopElementParser implements ElementParser<SVGStopElement> {

	@Override
	public SVGStopElement readElement(Element element, ParsingState parsingState) {
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String classNameAsString = element.getAttribute(Attributes.CLASS);
		SVGAnimatedString className = new SVGAnimatedString.Implementation(classNameAsString, classNameAsString);
		CSSStyleDeclarationImplementation style = new CSSStyleDeclarationImplementation(parsingState.findParentRule());
		style.setCssText(ElementParser.readOrDefault(element, Attributes.STYLE, ""));
		ElementParser.parseStyleFromAttributes(element, style);
		String offsetStr = ElementParser.readOrDefault(element, Attributes.OFFSET, "0");
		float offsetValue = Float.parseFloat(offsetStr);
		SVGAnimatedNumber offset = new SVGAnimatedNumber.Implementation(offsetValue, offsetValue);
		return new SVGStopElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, className, style, offset);
	}

	@Override
	public Element writeElement(SVGStopElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		attributes.put(Attributes.STYLE, element.getStyle().getCssText());
		attributes.put(Attributes.OFFSET, Float.toString(element.getOffset().getBaseValue()));
		return factory.createElement(Tags.STOP, attributes);
	}

}
