package org.w3c.dom.svg.parser;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGClipPathElement;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;

public class SVGClipPathElementParser implements ElementParser<SVGClipPathElement> {

	private HashMap<String, Short> strToEnum = new HashMap<>();
	private HashMap<Short, String> enumToStr = new HashMap<>();
	
	public SVGClipPathElementParser() {
		strToEnum.put("userSpaceOnUse", SVGClipPathElement.SVG_UNIT_TYPE_USERSPACEONUSE);
		strToEnum.put("objectBoundingBox", SVGClipPathElement.SVG_UNIT_TYPE_OBJECTBOUNDINGBOX);
		enumToStr.put(SVGClipPathElement.SVG_UNIT_TYPE_USERSPACEONUSE, "userSpaceOnUse");
		enumToStr.put(SVGClipPathElement.SVG_UNIT_TYPE_OBJECTBOUNDINGBOX, "objectBoundingBox");
	}
	
	@Override
	public SVGClipPathElement readElement(Element element, ParsingState parsingState) {
		String clipPathUnitsStr = ElementParser.readOrDefault(element, Attributes.CLIP_PATH_UNITS, "userSpaceOnUse");
		short clipPathUnitsValue = strToEnum.get(clipPathUnitsStr);
		SVGAnimatedEnumeration clipPathUnits = new SVGAnimatedEnumeration.Implementation(clipPathUnitsValue, clipPathUnitsValue);
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
		SVGClipPathElement clipPath = new SVGClipPathElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement,
				requiredFeatures, requiredExtensions, systemLanguage, xmlLang, xmlSpace, externalResourcesRequired,
				className, style, clipPathUnits, nearestViewportElement, farthestViewportElement, transform);
		ElementParser.connectLengthRoots(clipPath);
		return clipPath;
	}

	@Override
	public Element writeElement(SVGClipPathElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.CLIP_PATH_UNITS, enumToStr.get(element.getClipPathUnits().getBaseValue()));
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.XML_LANG, element.getXMLLang());
		attributes.put(Attributes.XML_SPACE, element.getXMLSpace());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		ElementParser.storeStyleFromAttributes(attributes, element.getStyle());
		attributes.put(Attributes.REQUIRED_FEATURES, ElementParser.join(element.getRequiredFeatures(), " "));
		attributes.put(Attributes.REQUIRED_EXTENSIONS, ElementParser.join(element.getRequiredExtensions(), " "));
		attributes.put(Attributes.SYSTEM_LANGUAGE, ElementParser.join(element.getSystemLanguage(), " "));
		attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(element.getExternalResourcesRequired().getBaseValue()));
		attributes.put(Attributes.TRANSFORM, ElementParser.getTransforms(element.getTransform()));
		return factory.createElement(Tags.CLIP_PATH, attributes);
	}

}
