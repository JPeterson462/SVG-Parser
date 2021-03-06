package org.w3c.dom.svg.parser;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.DelayedInstantiation;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio;
import org.w3c.dom.svg.SVGAnimatedRect;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGPatternElement;
import org.w3c.dom.svg.SVGPreserveAspectRatio;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;

public class SVGPatternElementParser implements ElementParser<SVGPatternElement>, DelayedElementParser<SVGPatternElement> {

	private HashMap<String, Short> patternUnits_strToEnum = new HashMap<>();
	private HashMap<Short, String> patternUnits_enumToStr = new HashMap<>();
	
	public SVGPatternElementParser() {
		patternUnits_strToEnum.put("objectBoundingBox", SVGPatternElement.SVG_UNIT_TYPE_OBJECTBOUNDINGBOX);
		patternUnits_strToEnum.put("userSpaceOnUse", SVGPatternElement.SVG_UNIT_TYPE_USERSPACEONUSE);
		patternUnits_enumToStr.put(SVGPatternElement.SVG_UNIT_TYPE_OBJECTBOUNDINGBOX, "objectBoundingBox");
		patternUnits_enumToStr.put(SVGPatternElement.SVG_UNIT_TYPE_USERSPACEONUSE, "userSpaceOnUse");
	}
	
	@Override
	public SVGPatternElement readElement(Element element, ParsingState parsingState) {
		String id = ElementParser.read(element, Attributes.ID);
		String href = ElementParser.read(element, Attributes.XLINK_HREF);
		SVGAnimatedString ahref = new SVGAnimatedString.Implementation(href, href);
		SVGPatternElement linkedElement = (SVGPatternElement) parsingState.getElement(href);
		if (href != null && linkedElement == null) {
			// Delay Instantiation
			SVGPatternElement svgElement = new SVGPatternElement.Implementation(id);
			parsingState.delayInstantiation(svgElement, element);
			return svgElement;
		}
		// Get default values
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
		String xmlLang = ElementParser.read(element, Attributes.XML_LANG);
		if (xmlLang == null) {
			xmlLang = "en";
		}
		String xmlSpace = ElementParser.read(element, Attributes.XML_SPACE);
		if (xmlSpace == null) {
			xmlSpace = "default";
		}
		SVGStringList requiredFeatures = ElementParser.readOrNull(element, Attributes.REQUIRED_FEATURES, " ", true);
		SVGStringList requiredExtensions = ElementParser.readOrNull(element, Attributes.REQUIRED_EXTENSIONS, " ", true);
		SVGStringList systemLanguage = ElementParser.readOrNull(element, Attributes.SYSTEM_LANGUAGE, " ", true);
		String xStr = ElementParser.readOrDefault(element, Attributes.X, linkedElement != null ? linkedElement.getX().getBaseValue().getValueAsString() : "0");
		String yStr = ElementParser.readOrDefault(element, Attributes.Y, linkedElement != null ? linkedElement.getY().getBaseValue().getValueAsString() : "0");
		String widthStr = ElementParser.readOrDefault(element, Attributes.WIDTH, linkedElement != null ? linkedElement.getWidth().getBaseValue().getValueAsString() : "0");
		String heightStr = ElementParser.readOrDefault(element, Attributes.HEIGHT, linkedElement != null ? linkedElement.getHeight().getBaseValue().getValueAsString() : "0");
		if (widthStr.startsWith("-")) {
			SVGErrors.error("Invalid Width: " + widthStr);
		}
		if (heightStr.startsWith("-")) {
			SVGErrors.error("Invalid Height: " + heightStr);
		}
		SVGLength x = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		x.setValueAsString(xStr);
		SVGLength y = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		y.setValueAsString(yStr);
		SVGLength width = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		width.setValueAsString(widthStr);
		SVGLength height = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		height.setValueAsString(heightStr);
		SVGAnimatedLength ax = new SVGAnimatedLength.Implementation(x, x);
		SVGAnimatedLength ay = new SVGAnimatedLength.Implementation(y, y);
		SVGAnimatedLength awidth = new SVGAnimatedLength.Implementation(width, width);
		SVGAnimatedLength aheight = new SVGAnimatedLength.Implementation(height, height);
		String inheritedAspectRatio = "";
		if (linkedElement != null) {
			SVGPreserveAspectRatio.Implementation inheritedImpl = new SVGPreserveAspectRatio.Implementation();
			inheritedImpl.setAlign(linkedElement.getPreserveAspectRatio().getBaseValue().getAlign());
			inheritedImpl.setMeetOrSlice(linkedElement.getPreserveAspectRatio().getBaseValue().getMeetOrSlice());
			inheritedAspectRatio = inheritedImpl.getAsString();
		}
		SVGPreserveAspectRatio.Implementation preserveAspectRatioValue = new SVGPreserveAspectRatio.Implementation();
		ArrayList<String> preserveAspectRatioParts = StringUtils.splitByWhitespace(ElementParser.readOrDefault(element, Attributes.PRESERVE_ASPECT_RATIO, linkedElement != null ? inheritedAspectRatio : "xMidYMid meet"));
		preserveAspectRatioValue.setFromString(preserveAspectRatioParts.get(0), preserveAspectRatioParts.size() == 1 ? null : preserveAspectRatioParts.get(1));
		SVGAnimatedPreserveAspectRatio preserveAspectRatio = new SVGAnimatedPreserveAspectRatio.Implementation(preserveAspectRatioValue, preserveAspectRatioValue);
		String viewBoxStr = ElementParser.read(element, Attributes.VIEW_BOX);
		SVGAnimatedRect viewBox = null;
		if (viewBoxStr != null && viewBoxStr.length() > 0) {
			ArrayList<String> viewBoxStrValues = StringUtils.splitByWhitespace(viewBoxStr);
			SVGRect viewBoxValue = new SVGRect.Implementation(Float.parseFloat(viewBoxStrValues.get(0)), Float.parseFloat(viewBoxStrValues.get(1)),
					Float.parseFloat(viewBoxStrValues.get(2)), Float.parseFloat(viewBoxStrValues.get(3)));
			viewBox = new SVGAnimatedRect.Implementation(viewBoxValue, viewBoxValue);
		}
		String patternUnitsStr = ElementParser.readOrDefault(element, Attributes.PATTERN_UNITS, linkedElement != null ? patternUnits_enumToStr.get(linkedElement.getPatternUnits().getBaseValue()) : "objectBoundingBox");
		short patternUnitsEnum = patternUnits_strToEnum.get(patternUnitsStr);
		SVGAnimatedEnumeration patternUnits = new SVGAnimatedEnumeration.Implementation(patternUnitsEnum, patternUnitsEnum);
		String patternContentUnitsStr = ElementParser.readOrDefault(element, Attributes.PATTERN_CONTENT_UNITS, linkedElement != null ? patternUnits_enumToStr.get(linkedElement.getPatternContentUnits().getBaseValue()) : "userSpaceOnUse");
		short patternContentUnitsEnum = patternUnits_strToEnum.get(patternContentUnitsStr);
		SVGAnimatedEnumeration patternContentUnits = new SVGAnimatedEnumeration.Implementation(patternContentUnitsEnum, patternContentUnitsEnum);
		SVGAnimatedTransformList patternTransform = ElementParser.parseTransforms(ElementParser.readOrDefault(element, Attributes.PATTERN_TRANSFORM, linkedElement != null ? ElementParser.getTransforms(linkedElement.getPatternTransform()) : ""));
		SVGPatternElement pattern = new SVGPatternElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, ahref, 
				requiredFeatures, requiredExtensions, systemLanguage, xmlLang, xmlSpace, 
				externalResourcesRequired, className, style, viewBox, preserveAspectRatio, 
				patternUnits, patternContentUnits, patternTransform, ax, ay, awidth, aheight);
		ElementParser.connectLengthRoots(pattern);
		return pattern;
	}

	@Override
	public void readElement(SVGPatternElement destination, Element element, ParsingState parsingState) {
		if (destination.getClass().getAnnotation(DelayedInstantiation.class) != null) {
			String href = ElementParser.read(element, Attributes.XLINK_HREF);
			SVGAnimatedString ahref = new SVGAnimatedString.Implementation(href, href);
			SVGPatternElement linkedElement = (SVGPatternElement) parsingState.getElement(href);
			if (linkedElement instanceof SVGPatternElement.Implementation && !((SVGPatternElement.Implementation) linkedElement).hasBeenInstantiated()) {
				// Delay Instantiation
				parsingState.delayInstantiation(destination, element);
				return;
			}
			// Get default values
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
			String xmlLang = ElementParser.read(element, Attributes.XML_LANG);
			if (xmlLang == null) {
				xmlLang = "en";
			}
			String xmlSpace = ElementParser.read(element, Attributes.XML_SPACE);
			if (xmlSpace == null) {
				xmlSpace = "default";
			}
			SVGStringList requiredFeatures = ElementParser.readOrNull(element, Attributes.REQUIRED_FEATURES, " ", true);
			SVGStringList requiredExtensions = ElementParser.readOrNull(element, Attributes.REQUIRED_EXTENSIONS, " ", true);
			SVGStringList systemLanguage = ElementParser.readOrNull(element, Attributes.SYSTEM_LANGUAGE, " ", true);
			String xStr = ElementParser.readOrDefault(element, Attributes.X, linkedElement != null ? linkedElement.getX().getBaseValue().getValueAsString() : "0");
			String yStr = ElementParser.readOrDefault(element, Attributes.Y, linkedElement != null ? linkedElement.getY().getBaseValue().getValueAsString() : "0");
			String widthStr = ElementParser.readOrDefault(element, Attributes.WIDTH, linkedElement != null ? linkedElement.getWidth().getBaseValue().getValueAsString() : "0");
			String heightStr = ElementParser.readOrDefault(element, Attributes.HEIGHT, linkedElement != null ? linkedElement.getHeight().getBaseValue().getValueAsString() : "0");
			if (widthStr.startsWith("-")) {
				SVGErrors.error("Invalid Width: " + widthStr);
			}
			if (heightStr.startsWith("-")) {
				SVGErrors.error("Invalid Height: " + heightStr);
			}
			SVGLength x = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
			x.setValueAsString(xStr);
			SVGLength y = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
			y.setValueAsString(yStr);
			SVGLength width = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
			width.setValueAsString(widthStr);
			SVGLength height = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
			height.setValueAsString(heightStr);
			SVGAnimatedLength ax = new SVGAnimatedLength.Implementation(x, x);
			SVGAnimatedLength ay = new SVGAnimatedLength.Implementation(y, y);
			SVGAnimatedLength awidth = new SVGAnimatedLength.Implementation(width, width);
			SVGAnimatedLength aheight = new SVGAnimatedLength.Implementation(height, height);	
			String inheritedAspectRatio = "";
			if (linkedElement != null && linkedElement.getPreserveAspectRatio() != null) {
				SVGPreserveAspectRatio.Implementation inheritedImpl = new SVGPreserveAspectRatio.Implementation();
				inheritedImpl.setAlign(linkedElement.getPreserveAspectRatio().getBaseValue().getAlign());
				inheritedImpl.setMeetOrSlice(linkedElement.getPreserveAspectRatio().getBaseValue().getMeetOrSlice());
				inheritedAspectRatio = inheritedImpl.getAsString();
			}
			SVGPreserveAspectRatio.Implementation preserveAspectRatioValue = new SVGPreserveAspectRatio.Implementation();
			ArrayList<String> preserveAspectRatioParts = StringUtils.splitByWhitespace(ElementParser.readOrDefault(element, Attributes.PRESERVE_ASPECT_RATIO, linkedElement != null && linkedElement.getPreserveAspectRatio() != null ? inheritedAspectRatio : "xMidYMid meet"));
			preserveAspectRatioValue.setFromString(preserveAspectRatioParts.get(0), preserveAspectRatioParts.size() == 1 ? null : preserveAspectRatioParts.get(1));
			SVGAnimatedPreserveAspectRatio preserveAspectRatio = new SVGAnimatedPreserveAspectRatio.Implementation(preserveAspectRatioValue, preserveAspectRatioValue);
			String viewBoxStr = ElementParser.read(element, Attributes.VIEW_BOX);
			SVGAnimatedRect viewBox = null;
			if (viewBoxStr != null && viewBoxStr.length() > 0) {
				ArrayList<String> viewBoxStrValues = StringUtils.splitByWhitespace(viewBoxStr);
				SVGRect viewBoxValue = new SVGRect.Implementation(Float.parseFloat(viewBoxStrValues.get(0)), Float.parseFloat(viewBoxStrValues.get(1)),
						Float.parseFloat(viewBoxStrValues.get(2)), Float.parseFloat(viewBoxStrValues.get(3)));
				viewBox = new SVGAnimatedRect.Implementation(viewBoxValue, viewBoxValue);
			}
			String patternUnitsStr = ElementParser.readOrDefault(element, Attributes.PATTERN_UNITS, linkedElement != null ? patternUnits_enumToStr.get(linkedElement.getPatternUnits().getBaseValue()) : "objectBoundingBox");
			short patternUnitsEnum = patternUnits_strToEnum.get(patternUnitsStr);
			SVGAnimatedEnumeration patternUnits = new SVGAnimatedEnumeration.Implementation(patternUnitsEnum, patternUnitsEnum);
			String patternContentUnitsStr = ElementParser.readOrDefault(element, Attributes.PATTERN_CONTENT_UNITS, linkedElement != null ? patternUnits_enumToStr.get(linkedElement.getPatternContentUnits().getBaseValue()) : "userSpaceOnUse");
			short patternContentUnitsEnum = patternUnits_strToEnum.get(patternContentUnitsStr);
			SVGAnimatedEnumeration patternContentUnits = new SVGAnimatedEnumeration.Implementation(patternContentUnitsEnum, patternContentUnitsEnum);
			SVGAnimatedTransformList patternTransform = ElementParser.parseTransforms(ElementParser.readOrDefault(element, Attributes.PATTERN_TRANSFORM, linkedElement != null ? ElementParser.getTransforms(linkedElement.getPatternTransform()) : ""));
			((SVGPatternElement.Implementation) destination).instantiatePattern(xmlBase, ownerSVGElement, viewportElement, ahref,
					requiredFeatures, requiredExtensions, systemLanguage, xmlLang, xmlSpace, externalResourcesRequired, className,
					style, viewBox, preserveAspectRatio, patternUnits, patternContentUnits, patternTransform, ax, ay, awidth, aheight);
			if (style != null) {
				ElementParser.connectLengthRoots(destination);
			}
		}
	}

	@Override
	public Element writeElement(SVGPatternElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		for (int i = 0; i < Attributes.XLINK_HREF.length; i++) {
			attributes.put(Attributes.XLINK_HREF[i], element.getHref().getBaseValue());
		}
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.XML_LANG, element.getXMLLang());
		attributes.put(Attributes.XML_SPACE, element.getXMLSpace());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		ElementParser.storeStyleFromAttributes(attributes, element.getStyle());
		attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(element.getExternalResourcesRequired().getBaseValue()));
		attributes.put(Attributes.REQUIRED_EXTENSIONS, ElementParser.concatenate(element.getRequiredExtensions(), " "));
		attributes.put(Attributes.REQUIRED_FEATURES, ElementParser.concatenate(element.getRequiredFeatures(), " "));
		attributes.put(Attributes.SYSTEM_LANGUAGE, ElementParser.concatenate(element.getSystemLanguage(), " "));
		attributes.put(Attributes.X, element.getX().getBaseValue().getValueAsString());
		attributes.put(Attributes.Y, element.getY().getBaseValue().getValueAsString());
		attributes.put(Attributes.WIDTH, element.getWidth().getBaseValue().getValueAsString());
		attributes.put(Attributes.HEIGHT, element.getHeight().getBaseValue().getValueAsString());
		SVGPreserveAspectRatio preserveAspectRatio = element.getPreserveAspectRatio().getBaseValue();
		SVGPreserveAspectRatio.Implementation preserveAspectRatioImpl = null;
		if (preserveAspectRatio instanceof SVGPreserveAspectRatio.Implementation) {
			preserveAspectRatioImpl = (SVGPreserveAspectRatio.Implementation) preserveAspectRatio;
		} else {
			preserveAspectRatioImpl = new SVGPreserveAspectRatio.Implementation();
			preserveAspectRatioImpl.setAlign(preserveAspectRatio.getAlign());
			preserveAspectRatioImpl.setMeetOrSlice(preserveAspectRatio.getMeetOrSlice());
		}
		attributes.put(Attributes.PRESERVE_ASPECT_RATIO, preserveAspectRatioImpl.getAsString());
		if (element.getViewBox() != null) {
			SVGRect viewBox = element.getViewBox().getBaseValue();
			if (viewBox != null) {
				attributes.put(Attributes.VIEW_BOX, viewBox.getX() + " " + viewBox.getY() + " " + viewBox.getWidth() + " " + viewBox.getHeight());	
			}
		}
		attributes.put(Attributes.PATTERN_UNITS, patternUnits_enumToStr.get(element.getPatternUnits().getBaseValue()));
		attributes.put(Attributes.PATTERN_CONTENT_UNITS, patternUnits_enumToStr.get(element.getPatternContentUnits().getBaseValue()));
		attributes.put(Attributes.PATTERN_TRANSFORM, ElementParser.getTransforms(element.getPatternTransform()));
		return factory.createElement(Tags.PATTERN, attributes);
	}

}
