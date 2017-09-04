package org.w3c.dom.svg.parser.shapes;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;
import org.w3c.dom.svg.shapes.SVGEllipseElement;

public class SVGEllipseElementParser implements ElementParser<SVGEllipseElement> {

	@Override
	public SVGEllipseElement readElement(Element element, ParsingState parsingState) {
		// Read and validate
		String cxStr = ElementParser.readOrDefault(element, Attributes.CX, "0");
		String cyStr = ElementParser.readOrDefault(element, Attributes.CY, "0");
		String rxStr = ElementParser.read(element, Attributes.RX);
		String ryStr = ElementParser.read(element, Attributes.RY);
		if (rxStr.startsWith("-")) {
			SVGErrors.error("X Radius must be >= 0");
		}
		if (ryStr.startsWith("-")) {
			SVGErrors.error("Y Radius must be >= 0");
		}
		// Convert
		SVGLength cx = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		cx.setValueAsString(cxStr);
		SVGLength cy = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		cy.setValueAsString(cyStr);
		SVGLength rx = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		rx.setValueAsString(rxStr);
		SVGLength ry = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		ry.setValueAsString(ryStr);
		// SVGLength -> SVGAnimatedLength
		SVGAnimatedLength acx = new SVGAnimatedLength.Implementation(cx, cx);
		SVGAnimatedLength acy = new SVGAnimatedLength.Implementation(cy, cy);
		SVGAnimatedLength arx = new SVGAnimatedLength.Implementation(rx, rx);
		SVGAnimatedLength ary = new SVGAnimatedLength.Implementation(ry, ry);
		// Get default values
		String id = ElementParser.read(element, Attributes.ID);
		String xmlBase = ElementParser.read(element, Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String xmlLang = ElementParser.read(element, Attributes.XML_LANG);
		if (xmlLang == null) {
			xmlLang = "en";
		}
		String xmlSpace = ElementParser.read(element, Attributes.XML_SPACE);
		if (xmlSpace == null) {
			xmlSpace = "default";
		}
		String classNameAsString = ElementParser.read(element, Attributes.CLASS);
		SVGAnimatedString className = new SVGAnimatedString.Implementation(classNameAsString, classNameAsString);
		CSSStyleDeclarationImplementation style = new CSSStyleDeclarationImplementation(parsingState.findParentRule());
		style.setCssText(ElementParser.readOrDefault(element, Attributes.STYLE, ""));
		ElementParser.parseStyleFromAttributes(element, style);
		SVGStringList requiredFeatures = ElementParser.readOrNull(element, Attributes.REQUIRED_FEATURES, " ", true);
		SVGStringList requiredExtensions = ElementParser.readOrNull(element, Attributes.REQUIRED_EXTENSIONS, " ", true);
		SVGStringList systemLanguage = ElementParser.readOrNull(element, Attributes.SYSTEM_LANGUAGE, " ", true);
		boolean externalResourcesRequiredAsBoolean = Boolean.parseBoolean(ElementParser.readOrDefault(element, Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(false)));
		SVGAnimatedBoolean externalResourcesRequired = new SVGAnimatedBoolean.Implementation(externalResourcesRequiredAsBoolean, externalResourcesRequiredAsBoolean);
		SVGElement nearestViewportElement = ElementParser.getNearestViewportElement(parsingState);
		SVGElement farthestViewportElement = ElementParser.getFarthestViewportElement(parsingState);
		SVGAnimatedTransformList transform = ElementParser.parseTransforms(element);
		// Construct the implementation
		return new SVGEllipseElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, xmlLang, xmlSpace,
					className, style, requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired,
					acx, acy, arx, ary, nearestViewportElement, farthestViewportElement, transform);
	}

	@Override
	public Element writeElement(SVGEllipseElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.XML_LANG, element.getXMLLang());
		attributes.put(Attributes.XML_SPACE, element.getXMLSpace());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		attributes.put(Attributes.STYLE, element.getStyle().getCssText());
		attributes.put(Attributes.TRANSFORM, ElementParser.getTransforms(element.getTransform()));
		attributes.put(Attributes.CX, element.getCX().getBaseValue().getValueAsString());
		attributes.put(Attributes.CY, element.getCY().getBaseValue().getValueAsString());
		attributes.put(Attributes.RX, element.getRadiusX().getBaseValue().getValueAsString());
		attributes.put(Attributes.RY, element.getRadiusY().getBaseValue().getValueAsString());
		attributes.put(Attributes.REQUIRED_FEATURES, ElementParser.join(element.getRequiredFeatures(), " "));
		attributes.put(Attributes.REQUIRED_EXTENSIONS, ElementParser.join(element.getRequiredExtensions(), " "));
		attributes.put(Attributes.SYSTEM_LANGUAGE, ElementParser.join(element.getSystemLanguage(), " "));
		attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, element.getExternalResourcesRequired().getBaseValue().toString());
		return factory.createElement(Tags.ELLIPSE, attributes);
	}

}
