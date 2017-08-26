package org.w3c.dom.svg.parser.filters;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.filters.SVGFEMorphologyElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFEMorphologyElementParser implements ElementParser<SVGFEMorphologyElement> {

	private HashMap<String, Short> operator_strToEnum = new HashMap<>();
	private HashMap<Short, String> operator_enumToStr = new HashMap<>();
	
	public SVGFEMorphologyElementParser() {
		operator_strToEnum.put("erode", SVGFEMorphologyElement.SVG_MORPHOLOGY_OPERATOR_ERODE);
		operator_strToEnum.put("dilate", SVGFEMorphologyElement.SVG_MORPHOLOGY_OPERATOR_DILATE);
		operator_enumToStr.put(SVGFEMorphologyElement.SVG_MORPHOLOGY_OPERATOR_ERODE, "erode");
		operator_enumToStr.put(SVGFEMorphologyElement.SVG_MORPHOLOGY_OPERATOR_DILATE, "dilate");
	}
	
	@Override
	public SVGFEMorphologyElement readElement(Element element, ParsingState parsingState) {
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String xStr = element.getAttribute(Attributes.X);
		SVGLength x = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		x.setValueAsString(xStr);
		SVGAnimatedLength ax = new SVGAnimatedLength.Implementation(x, x);
		String yStr = element.getAttribute(Attributes.Y);
		SVGLength y = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		y.setValueAsString(yStr);
		SVGAnimatedLength ay = new SVGAnimatedLength.Implementation(y, y);
		String widthStr = element.getAttribute(Attributes.WIDTH);
		SVGLength width = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		width.setValueAsString(widthStr);
		SVGAnimatedLength awidth = new SVGAnimatedLength.Implementation(width, width);
		String heightStr = element.getAttribute(Attributes.HEIGHT);
		SVGLength height = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		height.setValueAsString(heightStr);
		SVGAnimatedLength aheight = new SVGAnimatedLength.Implementation(height, height);
		String resultStr = element.getAttribute(Attributes.RESULT);
		SVGAnimatedString result = new SVGAnimatedString.Implementation(resultStr, resultStr);
		String classNameStr = element.getAttribute(Attributes.CLASS);
		SVGAnimatedString className = new SVGAnimatedString.Implementation(classNameStr, classNameStr);
		CSSStyleDeclarationImplementation style = new CSSStyleDeclarationImplementation(parsingState.findParentRule());
		style.setCssText(ElementParser.readOrDefault(element, Attributes.STYLE, ""));
		ElementParser.parseStyleFromAttributes(element, style);
		String in1Str = element.getAttribute(Attributes.IN);
		SVGAnimatedString in1 = new SVGAnimatedString.Implementation(in1Str, in1Str);
		String operatorStr = ElementParser.readOrDefault(element, Attributes.OPERATOR, "erode");
		short operatorBase = operator_strToEnum.get(operatorStr);
		SVGAnimatedEnumeration operator = new SVGAnimatedEnumeration.Implementation(operatorBase, operatorBase);
		String radiusStr = ElementParser.readOrDefault(element, Attributes.RADIUS, "0");
		ArrayList<String> radiusList = StringUtils.splitByWhitespace(radiusStr);
		SVGAnimatedNumber radiusX = null, radiusY = null;
		if (radiusList.size() < 2) {
			if (radiusList.size() > 0) {
				float radiusValue = Float.parseFloat(radiusList.get(0));
				radiusX = new SVGAnimatedNumber.Implementation(radiusValue, radiusValue);
				radiusY = new SVGAnimatedNumber.Implementation(radiusValue, radiusValue);
			} else {
				SVGErrors.error("Invalid radius: " + radiusStr);
			}
		}
		else {
			float radiusXValue = Float.parseFloat(radiusList.get(0));
			float radiusYValue = Float.parseFloat(radiusList.get(1));
			radiusX = new SVGAnimatedNumber.Implementation(radiusXValue, radiusXValue);
			radiusY = new SVGAnimatedNumber.Implementation(radiusYValue, radiusYValue);
		}
		return new SVGFEMorphologyElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, 
				ax, ay, awidth, aheight, result, className, style, in1, operator, radiusX, radiusY);
	}

	@Override
	public Element writeElement(SVGFEMorphologyElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.X, element.getX().getBaseValue().getValueAsString());
		attributes.put(Attributes.Y, element.getY().getBaseValue().getValueAsString());
		attributes.put(Attributes.WIDTH, element.getWidth().getBaseValue().getValueAsString());
		attributes.put(Attributes.HEIGHT, element.getHeight().getBaseValue().getValueAsString());
		attributes.put(Attributes.RESULT, element.getResult().getBaseValue());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		attributes.put(Attributes.STYLE, element.getStyle().getCssText());
		attributes.put(Attributes.IN, element.getIn1().getBaseValue());
		attributes.put(Attributes.OPERATOR, operator_enumToStr.get(element.getOperator().getBaseValue()));
		attributes.put(Attributes.RADIUS, element.getRadiusX().getBaseValue() + " " + element.getRadiusY().getBaseValue());
		return factory.createElement(Tags.FE_MORPHOLOGY, attributes);
	}

}
