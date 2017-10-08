package org.w3c.dom.svg.parser;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.DelayedInstantiation;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGGradientElement;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGLinearGradientElement;
import org.w3c.dom.svg.SVGRadialGradientElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public class SVGLinearGradientElementParser implements ElementParser<SVGLinearGradientElement>, DelayedElementParser<SVGLinearGradientElement> {

	private HashMap<String, Short> gradientUnits_strToEnum = new HashMap<>();
	private HashMap<Short, String> gradientUnits_enumToStr = new HashMap<>();
	
	private HashMap<String, Short> spreadMethod_strToEnum = new HashMap<>();
	private HashMap<Short, String> spreadMethod_enumToStr = new HashMap<>();
	
	public SVGLinearGradientElementParser() {
		gradientUnits_strToEnum.put("objectBoundingBox", SVGGradientElement.SVG_UNIT_TYPE_OBJECTBOUNDINGBOX);
		gradientUnits_strToEnum.put("userSpaceOnUse", SVGGradientElement.SVG_UNIT_TYPE_USERSPACEONUSE);
		gradientUnits_enumToStr.put(SVGGradientElement.SVG_UNIT_TYPE_OBJECTBOUNDINGBOX, "objectBoundingBox");
		gradientUnits_enumToStr.put(SVGGradientElement.SVG_UNIT_TYPE_USERSPACEONUSE, "userSpaceOnUse");
		spreadMethod_strToEnum.put("pad", SVGGradientElement.SVG_SPREADMETHOD_PAD);
		spreadMethod_strToEnum.put("reflect", SVGGradientElement.SVG_SPREADMETHOD_REFLECT);
		spreadMethod_strToEnum.put("repeat", SVGGradientElement.SVG_SPREADMETHOD_REPEAT);
		spreadMethod_enumToStr.put(SVGGradientElement.SVG_SPREADMETHOD_PAD, "pad");
		spreadMethod_enumToStr.put(SVGGradientElement.SVG_SPREADMETHOD_REFLECT, "reflect");
		spreadMethod_enumToStr.put(SVGGradientElement.SVG_SPREADMETHOD_REPEAT, "repeat");
	}
	
	@Override
	public SVGLinearGradientElement readElement(Element element, ParsingState parsingState) {
		String id = ElementParser.read(element, Attributes.ID);
		String href = ElementParser.read(element, Attributes.XLINK_HREF);
		SVGAnimatedString ahref = new SVGAnimatedString.Implementation(href, href);
		SVGGradientElement linkedElement = (SVGGradientElement) parsingState.getElement(href);
		if (href != null && linkedElement == null) {
			// Delay Instantiation
			SVGLinearGradientElement svgElement = new SVGLinearGradientElement.Implementation(id);
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
		String gradientUnitsStr = ElementParser.readOrDefault(element, Attributes.GRADIENT_UNITS, linkedElement != null ? gradientUnits_enumToStr.get(linkedElement.getGradientUnits().getBaseValue()) : "objectBoundingBox");
		short gradientUnitsEnum = gradientUnits_strToEnum.get(gradientUnitsStr);
		SVGAnimatedEnumeration gradientUnits = new SVGAnimatedEnumeration.Implementation(gradientUnitsEnum, gradientUnitsEnum);
		SVGAnimatedTransformList gradientTransform = ElementParser.parseTransforms(ElementParser.readOrDefault(element, Attributes.GRADIENT_TRANSFORM, linkedElement != null ? ElementParser.getTransforms(linkedElement.getGradientTransform()) : ""));
		String spreadMethodStr = ElementParser.readOrDefault(element, Attributes.SPREAD_METHOD, linkedElement != null ? spreadMethod_enumToStr.get(linkedElement.getSpreadMethod().getBaseValue()) : "pad");
		short spreadMethodEnum = spreadMethod_strToEnum.get(spreadMethodStr);
		SVGAnimatedEnumeration spreadMethod = new SVGAnimatedEnumeration.Implementation(spreadMethodEnum, spreadMethodEnum);
		SVGLinearGradientElement linkedElementSub = linkedElement instanceof SVGLinearGradientElement ? ((SVGLinearGradientElement) linkedElement) : null;
		String x1Str = ElementParser.readOrDefault(element, Attributes.X1, linkedElementSub != null ? linkedElementSub.getX1().getBaseValue().getValueAsString() : "0%");
		String y1Str = ElementParser.readOrDefault(element, Attributes.Y1, linkedElementSub != null ? linkedElementSub.getY1().getBaseValue().getValueAsString() : "0%");
		String x2Str = ElementParser.readOrDefault(element, Attributes.X2, linkedElementSub != null ? linkedElementSub.getX2().getBaseValue().getValueAsString() : "100%");
		String y2Str = ElementParser.readOrDefault(element, Attributes.Y2, linkedElementSub != null ? linkedElementSub.getY2().getBaseValue().getValueAsString() : "0%");
		SVGLength x1 = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		x1.setValueAsString(x1Str);
		SVGAnimatedLength ax1 = new SVGAnimatedLength.Implementation(x1, x1);
		SVGLength y1 = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		y1.setValueAsString(y1Str);
		SVGAnimatedLength ay1 = new SVGAnimatedLength.Implementation(y1, y1);
		SVGLength x2 = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		x2.setValueAsString(x2Str);
		SVGAnimatedLength ax2 = new SVGAnimatedLength.Implementation(x2, x2);
		SVGLength y2 = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		y2.setValueAsString(y2Str);
		SVGAnimatedLength ay2 = new SVGAnimatedLength.Implementation(y2, y2);
		SVGLinearGradientElement linearGradient = new SVGLinearGradientElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement,
				ahref, externalResourcesRequired, className, style, gradientUnits, gradientTransform,
				spreadMethod, ax1, ay1, ax2, ay2);
		ElementParser.connectLengthRoots(linearGradient);
		return linearGradient;
	}

	@Override
	public void readElement(SVGLinearGradientElement destination, Element element, ParsingState parsingState) {
		if (destination.getClass().getAnnotation(DelayedInstantiation.class) != null) {
			String href = ElementParser.read(element, Attributes.XLINK_HREF);
			SVGAnimatedString ahref = new SVGAnimatedString.Implementation(href, href);
			SVGGradientElement linkedElement = (SVGGradientElement) parsingState.getElement(href);
			if ((linkedElement instanceof SVGLinearGradientElement.Implementation && !((SVGLinearGradientElement.Implementation) linkedElement).hasBeenInstantiated()) ||
					(linkedElement instanceof SVGRadialGradientElement.Implementation && !((SVGRadialGradientElement.Implementation) linkedElement).hasBeenInstantiated())) {
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
			String gradientUnitsStr = ElementParser.readOrDefault(element, Attributes.GRADIENT_UNITS, linkedElement != null ? gradientUnits_enumToStr.get(linkedElement.getGradientUnits().getBaseValue()) : "objectBoundingBox");
			short gradientUnitsEnum = gradientUnits_strToEnum.get(gradientUnitsStr);
			SVGAnimatedEnumeration gradientUnits = new SVGAnimatedEnumeration.Implementation(gradientUnitsEnum, gradientUnitsEnum);
			SVGAnimatedTransformList gradientTransform = ElementParser.parseTransforms(ElementParser.readOrDefault(element, Attributes.GRADIENT_TRANSFORM, linkedElement != null ? ElementParser.getTransforms(linkedElement.getGradientTransform()) : ""));
			String spreadMethodStr = ElementParser.readOrDefault(element, Attributes.SPREAD_METHOD, linkedElement != null ? spreadMethod_enumToStr.get(linkedElement.getSpreadMethod().getBaseValue()) : "pad");
			short spreadMethodEnum = spreadMethod_strToEnum.get(spreadMethodStr);
			SVGAnimatedEnumeration spreadMethod = new SVGAnimatedEnumeration.Implementation(spreadMethodEnum, spreadMethodEnum);
			SVGLinearGradientElement linkedElementSub = linkedElement instanceof SVGLinearGradientElement ? ((SVGLinearGradientElement) linkedElement) : null;
			String x1Str = ElementParser.readOrDefault(element, Attributes.X1, linkedElementSub != null ? linkedElementSub.getX1().getBaseValue().getValueAsString() : "0%");
			String y1Str = ElementParser.readOrDefault(element, Attributes.Y1, linkedElementSub != null ? linkedElementSub.getY1().getBaseValue().getValueAsString() : "0%");
			String x2Str = ElementParser.readOrDefault(element, Attributes.X2, linkedElementSub != null ? linkedElementSub.getX2().getBaseValue().getValueAsString() : "100%");
			String y2Str = ElementParser.readOrDefault(element, Attributes.Y2, linkedElementSub != null ? linkedElementSub.getY2().getBaseValue().getValueAsString() : "0%");
			SVGLength x1 = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
			x1.setValueAsString(x1Str);
			SVGAnimatedLength ax1 = new SVGAnimatedLength.Implementation(x1, x1);
			SVGLength y1 = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
			y1.setValueAsString(y1Str);
			SVGAnimatedLength ay1 = new SVGAnimatedLength.Implementation(y1, y1);
			SVGLength x2 = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
			x2.setValueAsString(x2Str);
			SVGAnimatedLength ax2 = new SVGAnimatedLength.Implementation(x2, x2);
			SVGLength y2 = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
			y2.setValueAsString(y2Str);
			SVGAnimatedLength ay2 = new SVGAnimatedLength.Implementation(y2, y2);
			SVGLinearGradientElement linearGradient = new SVGLinearGradientElement.Implementation(destination.getID(), xmlBase, ownerSVGElement, viewportElement,
					ahref, externalResourcesRequired, className, style, gradientUnits, gradientTransform,
					spreadMethod, ax1, ay1, ax2, ay2);
			ElementParser.connectLengthRoots(linearGradient);
			((SVGLinearGradientElement.Implementation) destination).instantiateLinearGradient(xmlBase, ownerSVGElement, viewportElement, ahref,
					externalResourcesRequired, className, style, gradientUnits, gradientTransform, spreadMethod, ax1, ay1, ax2, ay2);
		}
	}
	@Override
	public Element writeElement(SVGLinearGradientElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		if (element.getClassName() != null) {
			attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		}
		if (element.getStyle() != null) {
			ElementParser.storeStyleFromAttributes(attributes, element.getStyle());
		}
		if (element.getExternalResourcesRequired() != null)	{
			attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(element.getExternalResourcesRequired().getBaseValue()));
		}
		if (element.getGradientUnits() != null) {
			attributes.put(Attributes.GRADIENT_UNITS, gradientUnits_enumToStr.get(element.getGradientUnits().getBaseValue()));
		}
		if (element.getGradientTransform() != null) {
			attributes.put(Attributes.GRADIENT_TRANSFORM, ElementParser.getTransforms(element.getGradientTransform()));
		}
		if (element.getSpreadMethod() != null) {
			attributes.put(Attributes.SPREAD_METHOD, spreadMethod_enumToStr.get(element.getSpreadMethod().getBaseValue()));
		}
		if (element.getX1() != null) {
			attributes.put(Attributes.X1, element.getX1().getBaseValue().getValueAsString());
		}
		if (element.getX2() != null) {
			attributes.put(Attributes.X2, element.getX2().getBaseValue().getValueAsString());
		}
		if (element.getY1() != null) {
			attributes.put(Attributes.Y1, element.getY1().getBaseValue().getValueAsString());
		}
		if (element.getY2() != null) {
			attributes.put(Attributes.Y2, element.getY2().getBaseValue().getValueAsString());
		}
		if (element.getHref() != null) {
			for (int i = 0; i < Attributes.XLINK_HREF.length; i++) {
				attributes.put(Attributes.XLINK_HREF[i], element.getHref().getBaseValue());
			}
		}
		return factory.createElement(Tags.LINEAR_GRADIENT, attributes);
	}


}
