package org.w3c.dom.svg.parser.text;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.DelayedInstantiation;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.DelayedElementParser;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;
import org.w3c.dom.svg.paths.SVGPathElement;
import org.w3c.dom.svg.text.SVGTRefElement;
import org.w3c.dom.svg.text.SVGTSpanElement;
import org.w3c.dom.svg.text.SVGTextContentElement;
import org.w3c.dom.svg.text.SVGTextElement;
import org.w3c.dom.svg.text.SVGTextPathElement;

public class SVGTextPathElementParser implements ElementParser<SVGTextPathElement>, DelayedElementParser<SVGTextPathElement> {

	private HashMap<Short, String> lengthAdjust_enumToStr = new HashMap<>();
	private HashMap<String, Short> lengthAdjust_strToEnum = new HashMap<>();

	private HashMap<Short, String> method_enumToStr = new HashMap<>();
	private HashMap<String, Short> method_strToEnum = new HashMap<>();

	private HashMap<Short, String> spacing_enumToStr = new HashMap<>();
	private HashMap<String, Short> spacing_strToEnum = new HashMap<>();
	
	public SVGTextPathElementParser() {
		lengthAdjust_enumToStr.put(SVGTextContentElement.LENGTHADJUST_SPACING, "spacing");
		lengthAdjust_strToEnum.put("spacing", SVGTextContentElement.LENGTHADJUST_SPACING);
		lengthAdjust_enumToStr.put(SVGTextContentElement.LENGTHADJUST_SPACINGANDGLYPHS, "spacingAndGlyphs");
		lengthAdjust_strToEnum.put("spacingAndGlyphs", SVGTextContentElement.LENGTHADJUST_SPACINGANDGLYPHS);
		method_enumToStr.put(SVGTextPathElement.TEXTPATH_METHODTYPE_ALIGN, "align");
		method_strToEnum.put("align", SVGTextPathElement.TEXTPATH_METHODTYPE_ALIGN);
		method_enumToStr.put(SVGTextPathElement.TEXTPATH_METHODTYPE_STRETCH, "stretch");
		method_strToEnum.put("stretch", SVGTextPathElement.TEXTPATH_METHODTYPE_STRETCH);
		spacing_enumToStr.put(SVGTextPathElement.TEXTPATH_SPACINGTYPE_AUTO, "auto");
		spacing_strToEnum.put("auto", SVGTextPathElement.TEXTPATH_SPACINGTYPE_AUTO);
		spacing_enumToStr.put(SVGTextPathElement.TEXTPATH_SPACINGTYPE_EXACT, "exact");
		spacing_strToEnum.put("exact", SVGTextPathElement.TEXTPATH_SPACINGTYPE_EXACT);
	}
	
	@Override
	public SVGTextPathElement readElement(Element element, ParsingState parsingState) {
		String href = ElementParser.read(element, Attributes.XLINK_HREF);
		SVGAnimatedString ahref = new SVGAnimatedString.Implementation(href, href);
		String textLengthStr = ElementParser.readOrDefault(element, Attributes.TEXT_LENGTH, "0");
		if (textLengthStr.startsWith("-")) {
			SVGErrors.error("Invalid Length: " + textLengthStr);
		}
		String id = ElementParser.read(element, Attributes.ID);
		SVGPathElement linkedElement = (SVGPathElement) parsingState.getElement(href);
		if (href != null && linkedElement == null) {
			SVGTextPathElement svgElement = new SVGTextPathElement.Implementation(id);
			parsingState.delayInstantiation(svgElement, element);
			return svgElement;
		}
		SVGLength textLength = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		textLength.setValueAsString(textLengthStr);
		SVGAnimatedLength atextLength = new SVGAnimatedLength.Implementation(textLength, textLength);
		String lengthAdjustStr = ElementParser.readOrDefault(element, Attributes.LENGTH_ADJUST, "spacing");
		short lengthAdjustEnum = lengthAdjust_strToEnum.get(lengthAdjustStr);
		SVGAnimatedEnumeration lengthAdjust = new SVGAnimatedEnumeration.Implementation(lengthAdjustEnum, lengthAdjustEnum);
		String startOffsetStr = ElementParser.readOrDefault(element, Attributes.START_OFFSET, "0");
		SVGLength startOffset = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		startOffset.setValueAsString(startOffsetStr);
		SVGAnimatedLength astartOffset = new SVGAnimatedLength.Implementation(startOffset, startOffset);
		String methodStr = ElementParser.readOrDefault(element, Attributes.METHOD, "align");
		short methodValue = method_strToEnum.get(methodStr);
		SVGAnimatedEnumeration method = new SVGAnimatedEnumeration.Implementation(methodValue, methodValue);
		String spacingStr = ElementParser.readOrDefault(element, Attributes.SPACING, "exact");
		short spacingValue = spacing_strToEnum.get(spacingStr);
		SVGAnimatedEnumeration spacing = new SVGAnimatedEnumeration.Implementation(spacingValue, spacingValue);
		// Get default values
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
		SVGTextPathElement textPathElement = new SVGTextPathElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement,
				ahref, linkedElement, astartOffset, method, spacing, xmlLang, xmlSpace, className, style,
				requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired,
				atextLength, lengthAdjust);
		textPathElement.setTextContent(element.getTextContent());
		ElementParser.connectLengthRoots(textPathElement);
		return textPathElement;
	}
	
	@Override
	public void readElement(SVGTextPathElement destination, Element element, ParsingState parsingState) {
		if (destination.getClass().getAnnotation(DelayedInstantiation.class) != null) {
			String href = ElementParser.read(element, Attributes.XLINK_HREF);
			SVGAnimatedString ahref = new SVGAnimatedString.Implementation(href, href);
			String textLengthStr = ElementParser.readOrDefault(element, Attributes.TEXT_LENGTH, "0");
			if (textLengthStr.startsWith("-")) {
				SVGErrors.error("Invalid Length: " + textLengthStr);
			}
			SVGPathElement linkedElement = (SVGPathElement) parsingState.getElement(href);
			if (href != null && linkedElement == null) {
				// Delay Instantiation
				parsingState.delayInstantiation(destination, element);
				return;
			}
			SVGLength textLength = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
			textLength.setValueAsString(textLengthStr);
			SVGAnimatedLength atextLength = new SVGAnimatedLength.Implementation(textLength, textLength);
			String lengthAdjustStr = ElementParser.readOrDefault(element, Attributes.LENGTH_ADJUST, "spacing");
			short lengthAdjustEnum = lengthAdjust_strToEnum.get(lengthAdjustStr);
			SVGAnimatedEnumeration lengthAdjust = new SVGAnimatedEnumeration.Implementation(lengthAdjustEnum, lengthAdjustEnum);
			String startOffsetStr = ElementParser.readOrDefault(element, Attributes.START_OFFSET, "0");
			SVGLength startOffset = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
			startOffset.setValueAsString(startOffsetStr);
			SVGAnimatedLength astartOffset = new SVGAnimatedLength.Implementation(startOffset, startOffset);
			String methodStr = ElementParser.readOrDefault(element, Attributes.METHOD, "align");
			short methodValue = method_strToEnum.get(methodStr);
			SVGAnimatedEnumeration method = new SVGAnimatedEnumeration.Implementation(methodValue, methodValue);
			String spacingStr = ElementParser.readOrDefault(element, Attributes.SPACING, "exact");
			short spacingValue = spacing_strToEnum.get(spacingStr);
			SVGAnimatedEnumeration spacing = new SVGAnimatedEnumeration.Implementation(spacingValue, spacingValue);
			// Get default values
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
			destination.setTextContent(element.getTextContent());
			((SVGTextPathElement.Implementation) destination).instantiateTextPath(xmlBase, ownerSVGElement, viewportElement,
					ahref, linkedElement, astartOffset, method, spacing, xmlLang,
					xmlSpace, className, style, requiredFeatures, requiredExtensions,
					systemLanguage, externalResourcesRequired, atextLength, lengthAdjust);
			ElementParser.connectLengthRoots(destination);
		}
	}

	@Override
	public Element writeElement(SVGTextPathElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		if (element.getTextLength().getBaseValue().getValue() > 0) {
			attributes.put(Attributes.TEXT_LENGTH, element.getTextLength().getBaseValue().getValueAsString());
		}
		attributes.put(Attributes.LENGTH_ADJUST, lengthAdjust_enumToStr.get(element.getLengthAdjust().getBaseValue()));
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
		for (int i = 0; i < Attributes.XLINK_HREF.length; i++) {
			attributes.put(Attributes.XLINK_HREF[i], element.getHref().getBaseValue());
		}
		attributes.put(Attributes.METHOD, method_enumToStr.get(element.getMethod().getBaseValue()));
		attributes.put(Attributes.SPACING, spacing_enumToStr.get(element.getSpacing().getBaseValue()));
		Element textPathElement = factory.createElement(Tags.TEXT_PATH, attributes);
		if (!hasChildTextElement(element)) {
			// Only write the <text> content if there aren't child nodes like <tspan>
			textPathElement.setTextContent(element.getTextContent());
		}
		return textPathElement;
	}
	
	private boolean hasChildTextElement(SVGElement element) {
		NodeList children = element.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (child instanceof SVGTextElement || child instanceof SVGTextPathElement || 
					child instanceof SVGTRefElement || child instanceof SVGTSpanElement) {
				return true;
			}
		}
		return false;
	}
	
}
