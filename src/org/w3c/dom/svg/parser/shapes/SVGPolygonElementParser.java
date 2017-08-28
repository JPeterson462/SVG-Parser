package org.w3c.dom.svg.parser.shapes;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGPoint;
import org.w3c.dom.svg.SVGPointList;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;
import org.w3c.dom.svg.shapes.SVGPolygonElement;

public class SVGPolygonElementParser implements ElementParser<SVGPolygonElement> {

	@Override
	public SVGPolygonElement readElement(Element element, ParsingState parsingState) {
		// Read and validate
		ArrayList<SVGPoint> pointList = new ArrayList<>();
		ArrayList<String> parts = StringUtils.splitByWhitespace(element.getAttribute("points"));
		if (parts.size() % 3 != 0) {
			SVGErrors.error("Invalid Points List");
		}
		for (int i = 0; i < parts.size(); i += 2) {
			if (parts.get(i).endsWith(",")) {
				pointList.add(new SVGPoint.Implementation(Float.parseFloat(parts.get(i).substring(0, parts.get(i).length() - 1)), Float.parseFloat(parts.get(i + 1))));
			} else {
				SVGErrors.error("Invalid Points List");
			}
		}
		// Convert
		SVGPointList points = new SVGPointList.Implementation(pointList);
		// Get default values
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String xmlLang = element.getAttribute(Attributes.XML_LANG);
		if (xmlLang == null) {
			xmlLang = "en";
		}
		String xmlSpace = element.getAttribute(Attributes.XML_SPACE);
		if (xmlSpace == null) {
			xmlSpace = "default";
		}
		String classNameAsString = element.getAttribute(Attributes.CLASS);
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
		return new SVGPolygonElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, xmlLang, xmlSpace,
					className, style, requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired,
					points, points, nearestViewportElement, farthestViewportElement, transform);
	}

	@Override
	public Element writeElement(SVGPolygonElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.XML_LANG, element.getXMLLang());
		attributes.put(Attributes.XML_SPACE, element.getXMLSpace());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		attributes.put(Attributes.STYLE, element.getStyle().getCssText());
		attributes.put(Attributes.TRANSFORM, ElementParser.getTransforms(element.getTransform()));
		
		attributes.put(Attributes.REQUIRED_FEATURES, ElementParser.join(element.getRequiredFeatures(), " "));
		attributes.put(Attributes.REQUIRED_EXTENSIONS, ElementParser.join(element.getRequiredExtensions(), " "));
		attributes.put(Attributes.SYSTEM_LANGUAGE, ElementParser.join(element.getSystemLanguage(), " "));
		attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, element.getExternalResourcesRequired().getBaseValue().toString());
		return factory.createElement(Tags.POLYGON, attributes);
	}

}
