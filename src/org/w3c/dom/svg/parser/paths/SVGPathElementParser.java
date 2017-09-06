package org.w3c.dom.svg.parser.paths;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;
import org.w3c.dom.svg.paths.NormalizedPathSegListBuilder;
import org.w3c.dom.svg.paths.SVGPathElement;
import org.w3c.dom.svg.paths.SVGPathMath;
import org.w3c.dom.svg.paths.SVGPathSegList;

public class SVGPathElementParser implements ElementParser<SVGPathElement> {

	@Override
	public SVGPathElement readElement(Element element, ParsingState parsingState) {
		String pathLengthStr = ElementParser.read(element, Attributes.PATH_LENGTH);
		SVGPathSegList pathSegList = ElementParser.parsePathSegList(ElementParser.read(element, Attributes.D));
		if (pathLengthStr == null || pathLengthStr.length() == 0) {
			pathLengthStr = Float.toString(SVGPathMath.getPathLength(pathSegList));
		}
		SVGAnimatedNumber aPathLength = new SVGAnimatedNumber.Implementation(Float.parseFloat(pathLengthStr), Float.parseFloat(pathLengthStr));
		NormalizedPathSegListBuilder builder1 = new NormalizedPathSegListBuilder();
		SVGPathSegList normalizedPathSegList = builder1.process(pathSegList);
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
		return new SVGPathElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, xmlLang, xmlSpace,
					className, style, requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired,
					pathSegList, normalizedPathSegList, new SVGPathSegList.Implementation(pathSegList), new SVGPathSegList.Implementation(normalizedPathSegList), aPathLength, nearestViewportElement, farthestViewportElement, transform);
	}

	@Override
	public Element writeElement(SVGPathElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
//		attributes.put(Attributes.PATH_LENGTH, Float.toString(element.getPathLength().getBaseValue()));
		attributes.put(Attributes.D, ElementParser.join(element.getPathSegList(), " "));
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.XML_LANG, element.getXMLLang());
		attributes.put(Attributes.XML_SPACE, element.getXMLSpace());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		ElementParser.storeStyleFromAttributes(attributes, element.getStyle());
		attributes.put(Attributes.REQUIRED_FEATURES, ElementParser.join(element.getRequiredFeatures(), " "));
		attributes.put(Attributes.REQUIRED_EXTENSIONS, ElementParser.join(element.getRequiredExtensions(), " "));
		attributes.put(Attributes.SYSTEM_LANGUAGE, ElementParser.join(element.getSystemLanguage(), " "));
		attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, element.getExternalResourcesRequired().getBaseValue().toString());
		attributes.put(Attributes.TRANSFORM, ElementParser.getTransforms(element.getTransform()));
		return factory.createElement(Tags.PATH, attributes);
	}

}
