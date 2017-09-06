package org.w3c.dom.svg.parser.fonts;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.fonts.SVGFontElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFontElementParser implements ElementParser<SVGFontElement> {

	@Override
	public SVGFontElement readElement(Element element, ParsingState parsingState) {
		SVGNumber horizontalOriginX = new SVGNumber.Implementation(Float.parseFloat(ElementParser.readOrDefault(element, Attributes.HORIZ_ORIGIN_X, "0")));
		SVGNumber horizontalOriginY = new SVGNumber.Implementation(Float.parseFloat(ElementParser.readOrDefault(element, Attributes.HORIZ_ORIGIN_Y, "0")));
		SVGNumber horizontalAdvanceX = new SVGNumber.Implementation(Float.parseFloat(ElementParser.read(element, Attributes.HORIZ_ADV_X)));
		if (horizontalAdvanceX.getValue() < 0) {
			SVGErrors.error("Invalid " + Attributes.HORIZ_ADV_X + ": " + ElementParser.read(element, Attributes.HORIZ_ADV_X));
		}
		SVGNumber verticalOriginX = new SVGNumber.Implementation(Float.parseFloat(ElementParser.readOrDefault(element, Attributes.VERT_ORIGIN_X, Float.toString(horizontalOriginX.getValue()))));
		SVGNumber verticalOriginY = new SVGNumber.Implementation(Float.parseFloat(ElementParser.readOrDefault(element, Attributes.VERT_ORIGIN_Y, Float.toString(horizontalOriginY.getValue()))));
		SVGNumber verticalAdvanceY = null;
		if (element.hasAttribute(Attributes.VERT_ADV_Y)) {
			verticalAdvanceY = new SVGNumber.Implementation(Float.parseFloat(ElementParser.readOrDefault(element, Attributes.VERT_ADV_Y)));
		} else {
			verticalAdvanceY = new SVGNumber.Implementation(Float.NaN);
		}
		// Get default values
		String id = ElementParser.read(element, Attributes.ID);
		String xmlBase = ElementParser.read(element, Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String classNameAsString = ElementParser.read(element, Attributes.CLASS);
		SVGAnimatedString className = new SVGAnimatedString.Implementation(classNameAsString, classNameAsString);
		CSSStyleDeclarationImplementation style = new CSSStyleDeclarationImplementation(parsingState.findParentRule());
		style.setCssText(ElementParser.readOrDefault(element, Attributes.STYLE, ""));
		ElementParser.parseStyleFromAttributes(element, style);
		boolean externalResourcesRequiredAsBoolean = Boolean.parseBoolean(ElementParser.readOrDefault(element, Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(false)));
		SVGAnimatedBoolean externalResourcesRequired = new SVGAnimatedBoolean.Implementation(externalResourcesRequiredAsBoolean, externalResourcesRequiredAsBoolean);
		return new SVGFontElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, externalResourcesRequired,
				className, style, horizontalOriginX, horizontalOriginY, horizontalAdvanceX, 
				verticalOriginX, verticalOriginY, verticalAdvanceY);
	}

	@Override
	public Element writeElement(SVGFontElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.HORIZ_ORIGIN_X, Float.toString(element.getHorizontalOriginX().getValue()));
		attributes.put(Attributes.HORIZ_ORIGIN_Y, Float.toString(element.getHorizontalOriginY().getValue()));
		attributes.put(Attributes.HORIZ_ADV_X, Float.toString(element.getHorizontalAdvanceX().getValue()));
		attributes.put(Attributes.VERT_ORIGIN_X, Float.toString(element.getVerticalOriginX().getValue()));
		attributes.put(Attributes.VERT_ORIGIN_Y, Float.toString(element.getVerticalOriginY().getValue()));
		attributes.put(Attributes.VERT_ADV_Y, Float.toString(element.getVerticalAdvanceY().getValue()));
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		ElementParser.storeStyleFromAttributes(attributes, element.getStyle());
		attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(element.getExternalResourcesRequired().getBaseValue()));
		return factory.createElement(Tags.FONT, attributes);
	}

}
