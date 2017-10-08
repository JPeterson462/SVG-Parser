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

public class SVGRadialGradientElementParser implements ElementParser<SVGRadialGradientElement>, DelayedElementParser<SVGRadialGradientElement> {

	private HashMap<String, Short> gradientUnits_strToEnum = new HashMap<>();
	private HashMap<Short, String> gradientUnits_enumToStr = new HashMap<>();
	
	private HashMap<String, Short> spreadMethod_strToEnum = new HashMap<>();
	private HashMap<Short, String> spreadMethod_enumToStr = new HashMap<>();
	
	public SVGRadialGradientElementParser() {
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
	public SVGRadialGradientElement readElement(Element element, ParsingState parsingState) {
		String id = ElementParser.read(element, Attributes.ID);
		String href = ElementParser.read(element, Attributes.XLINK_HREF);
		SVGAnimatedString ahref = new SVGAnimatedString.Implementation(href, href);
		SVGGradientElement linkedElement = (SVGGradientElement) parsingState.getElement(href);
		if (href != null && linkedElement == null) {
			// Delay Instantiation
			SVGRadialGradientElement svgElement = new SVGRadialGradientElement.Implementation(id);
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
		SVGRadialGradientElement linkedElementSub = linkedElement instanceof SVGRadialGradientElement ? ((SVGRadialGradientElement) linkedElement) : null;
		String cxStr = ElementParser.readOrDefault(element, Attributes.CX, linkedElementSub != null ? linkedElementSub.getCX().getBaseValue().getValueAsString() : "50%");
		String cyStr = ElementParser.readOrDefault(element, Attributes.CY, linkedElementSub != null ? linkedElementSub.getCY().getBaseValue().getValueAsString() : "50%");
		String rStr = ElementParser.readOrDefault(element, Attributes.R, linkedElementSub != null ? linkedElementSub.getRadius().getBaseValue().getValueAsString() : "50%");
		String fxStr = ElementParser.readOrDefault(element, Attributes.FX, linkedElementSub != null ? linkedElementSub.getFX().getBaseValue().getValueAsString() : cxStr);
		String fyStr = ElementParser.readOrDefault(element, Attributes.FY, linkedElementSub != null ? linkedElementSub.getFY().getBaseValue().getValueAsString() : cyStr);
		SVGLength cx = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		cx.setValueAsString(cxStr);
		SVGAnimatedLength acx = new SVGAnimatedLength.Implementation(cx, cx);
		SVGLength cy = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		cy.setValueAsString(cyStr);
		SVGAnimatedLength acy = new SVGAnimatedLength.Implementation(cy, cy);
		SVGLength r = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		r.setValueAsString(rStr);
		SVGAnimatedLength ar = new SVGAnimatedLength.Implementation(r, r);
		SVGLength fx = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		fx.setValueAsString(fxStr);
		SVGAnimatedLength afx = new SVGAnimatedLength.Implementation(fx, fx);
		SVGLength fy = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		fy.setValueAsString(fyStr);
		SVGAnimatedLength afy = new SVGAnimatedLength.Implementation(fy, fy);
		SVGRadialGradientElement radialGradient = new SVGRadialGradientElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, ahref, 
				externalResourcesRequired, className, style, gradientUnits, gradientTransform, spreadMethod, acx, acy, ar, afx, afy);
		ElementParser.connectLengthRoots(radialGradient);
		return radialGradient;
	}

	@Override
	public void readElement(SVGRadialGradientElement destination, Element element, ParsingState parsingState) {
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
			SVGRadialGradientElement linkedElementSub = linkedElement instanceof SVGRadialGradientElement ? ((SVGRadialGradientElement) linkedElement) : null;
			String cxStr = ElementParser.readOrDefault(element, Attributes.CX, linkedElementSub != null ? linkedElementSub.getCX().getBaseValue().getValueAsString() : "50%");
			String cyStr = ElementParser.readOrDefault(element, Attributes.CY, linkedElementSub != null ? linkedElementSub.getCY().getBaseValue().getValueAsString() : "50%");
			String rStr = ElementParser.readOrDefault(element, Attributes.R, linkedElementSub != null ? linkedElementSub.getRadius().getBaseValue().getValueAsString() : "50%");
			String fxStr = ElementParser.readOrDefault(element, Attributes.FX, linkedElementSub != null ? linkedElementSub.getFX().getBaseValue().getValueAsString() : cxStr);
			String fyStr = ElementParser.readOrDefault(element, Attributes.FY, linkedElementSub != null ? linkedElementSub.getFY().getBaseValue().getValueAsString() : cyStr);
			SVGLength cx = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
			cx.setValueAsString(cxStr);
			SVGAnimatedLength acx = new SVGAnimatedLength.Implementation(cx, cx);
			SVGLength cy = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
			cy.setValueAsString(cyStr);
			SVGAnimatedLength acy = new SVGAnimatedLength.Implementation(cy, cy);
			SVGLength r = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
			r.setValueAsString(rStr);
			SVGAnimatedLength ar = new SVGAnimatedLength.Implementation(r, r);
			SVGLength fx = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
			fx.setValueAsString(fxStr);
			SVGAnimatedLength afx = new SVGAnimatedLength.Implementation(fx, fx);
			SVGLength fy = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
			fy.setValueAsString(fyStr);
			SVGAnimatedLength afy = new SVGAnimatedLength.Implementation(fy, fy);
			((SVGRadialGradientElement.Implementation) destination).instantiateRadialGradient(xmlBase, ownerSVGElement, viewportElement, ahref,
					externalResourcesRequired, className, style, gradientUnits, gradientTransform, spreadMethod, acx, acy, ar, afx, afy);
		}
	}

	@Override
	public Element writeElement(SVGRadialGradientElement element, ElementFactory factory) {
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
		if (element.getCX() != null) {
			attributes.put(Attributes.CX, element.getCX().getBaseValue().getValueAsString());
		}
		if (element.getCY() != null) {
			attributes.put(Attributes.CY, element.getCY().getBaseValue().getValueAsString());
		}
		if (element.getRadius() != null) {
			attributes.put(Attributes.R, element.getRadius().getBaseValue().getValueAsString());
		}
		if (element.getFX() != null) {
			attributes.put(Attributes.FX, element.getFX().getBaseValue().getValueAsString());
		}
		if (element.getFY() != null) {
			attributes.put(Attributes.FY, element.getFY().getBaseValue().getValueAsString());
		}
		if (element.getHref() != null) {
			for (int i = 0; i < Attributes.XLINK_HREF.length; i++) {
				attributes.put(Attributes.XLINK_HREF[i], element.getHref().getBaseValue());
			}
		}
		return factory.createElement(Tags.RADIAL_GRADIENT, attributes);
	}

}
