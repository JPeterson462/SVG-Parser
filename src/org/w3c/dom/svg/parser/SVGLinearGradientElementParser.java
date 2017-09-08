package org.w3c.dom.svg.parser;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGGradientElement;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGLinearGradientElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public class SVGLinearGradientElementParser implements ElementParser<SVGLinearGradientElement> {

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
		String href = ElementParser.read(element, Attributes.XLINK_HREF);
		SVGAnimatedString ahref = new SVGAnimatedString.Implementation(href, href);
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
		String gradientUnitsStr = ElementParser.readOrDefault(element, Attributes.GRADIENT_UNITS, "objectBoundingBox");
		short gradientUnitsEnum = gradientUnits_strToEnum.get(gradientUnitsStr);
		SVGAnimatedEnumeration gradientUnits = new SVGAnimatedEnumeration.Implementation(gradientUnitsEnum, gradientUnitsEnum);
		SVGAnimatedTransformList gradientTransform = ElementParser.parseTransforms(ElementParser.readOrDefault(element, Attributes.GRADIENT_TRANSFORM, ""));
		String spreadMethodStr = ElementParser.readOrDefault(element, Attributes.SPREAD_METHOD, "pad");
		short spreadMethodEnum = spreadMethod_strToEnum.get(spreadMethodStr);
		SVGAnimatedEnumeration spreadMethod = new SVGAnimatedEnumeration.Implementation(spreadMethodEnum, spreadMethodEnum);
		String x1Str = ElementParser.readOrDefault(element, Attributes.X1, "0%");
		String y1Str = ElementParser.readOrDefault(element, Attributes.Y1, "0%");
		String x2Str = ElementParser.readOrDefault(element, Attributes.X2, "100%");
		String y2Str = ElementParser.readOrDefault(element, Attributes.Y2, "0%");
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
	public Element writeElement(SVGLinearGradientElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());		
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		ElementParser.storeStyleFromAttributes(attributes, element.getStyle());
		attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(element.getExternalResourcesRequired().getBaseValue()));
		attributes.put(Attributes.GRADIENT_UNITS, gradientUnits_enumToStr.get(element.getGradientUnits().getBaseValue()));
		attributes.put(Attributes.GRADIENT_TRANSFORM, ElementParser.getTransforms(element.getGradientTransform()));
		attributes.put(Attributes.SPREAD_METHOD, spreadMethod_enumToStr.get(element.getSpreadMethod().getBaseValue()));
		attributes.put(Attributes.X1, element.getX1().getBaseValue().getValueAsString());
		attributes.put(Attributes.X2, element.getX2().getBaseValue().getValueAsString());
		attributes.put(Attributes.Y1, element.getY1().getBaseValue().getValueAsString());
		attributes.put(Attributes.Y2, element.getY2().getBaseValue().getValueAsString());
		attributes.put(Attributes.XLINK_HREF[Attributes.XLINK_HREF.length - 1], element.getHref().getBaseValue());
		return factory.createElement(Tags.LINEAR_GRADIENT, attributes);
	}

}
