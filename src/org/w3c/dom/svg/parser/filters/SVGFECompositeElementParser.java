package org.w3c.dom.svg.parser.filters;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.filters.SVGFECompositeElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFECompositeElementParser implements ElementParser<SVGFECompositeElement> {

	private HashMap<String, Short> operator_strToEnum = new HashMap<>();
	private HashMap<Short, String> operator_enumToStr = new HashMap<>();
	
	public SVGFECompositeElementParser() {
		operator_strToEnum.put("over", SVGFECompositeElement.SVG_FECOMPOSITE_OPERATOR_OVER);
		operator_strToEnum.put("in", SVGFECompositeElement.SVG_FECOMPOSITE_OPERATOR_IN);
		operator_strToEnum.put("out", SVGFECompositeElement.SVG_FECOMPOSITE_OPERATOR_OUT);
		operator_strToEnum.put("atop", SVGFECompositeElement.SVG_FECOMPOSITE_OPERATOR_ATOP);
		operator_strToEnum.put("xor", SVGFECompositeElement.SVG_FECOMPOSITE_OPERATOR_XOR);
		operator_strToEnum.put("arithmetic", SVGFECompositeElement.SVG_FECOMPOSITE_OPERATOR_ARITHMETIC);
		operator_enumToStr.put(SVGFECompositeElement.SVG_FECOMPOSITE_OPERATOR_OVER, "over");
		operator_enumToStr.put(SVGFECompositeElement.SVG_FECOMPOSITE_OPERATOR_IN, "in");
		operator_enumToStr.put(SVGFECompositeElement.SVG_FECOMPOSITE_OPERATOR_OUT, "out");
		operator_enumToStr.put(SVGFECompositeElement.SVG_FECOMPOSITE_OPERATOR_ATOP, "atop");
		operator_enumToStr.put(SVGFECompositeElement.SVG_FECOMPOSITE_OPERATOR_XOR, "xor");
		operator_enumToStr.put(SVGFECompositeElement.SVG_FECOMPOSITE_OPERATOR_ARITHMETIC, "arithmetic");
	}
	
	@Override
	public SVGFECompositeElement readElement(Element element, ParsingState parsingState) {
		String id = ElementParser.read(element, Attributes.ID);
		String xmlBase = ElementParser.read(element, Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String xStr = ElementParser.read(element, Attributes.X);
		SVGLength x = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		x.setValueAsString(xStr);
		SVGAnimatedLength ax = new SVGAnimatedLength.Implementation(x, x);
		String yStr = ElementParser.read(element, Attributes.Y);
		SVGLength y = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		y.setValueAsString(yStr);
		SVGAnimatedLength ay = new SVGAnimatedLength.Implementation(y, y);
		String widthStr = ElementParser.read(element, Attributes.WIDTH);
		SVGLength width = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		width.setValueAsString(widthStr);
		SVGAnimatedLength awidth = new SVGAnimatedLength.Implementation(width, width);
		String heightStr = ElementParser.read(element, Attributes.HEIGHT);
		SVGLength height = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		height.setValueAsString(heightStr);
		SVGAnimatedLength aheight = new SVGAnimatedLength.Implementation(height, height);
		String resultStr = ElementParser.read(element, Attributes.RESULT);
		SVGAnimatedString result = new SVGAnimatedString.Implementation(resultStr, resultStr);
		String classNameStr = ElementParser.read(element, Attributes.CLASS);
		SVGAnimatedString className = new SVGAnimatedString.Implementation(classNameStr, classNameStr);
		CSSStyleDeclarationImplementation style = new CSSStyleDeclarationImplementation(parsingState.findParentRule());
		style.setCssText(ElementParser.readOrDefault(element, Attributes.STYLE, ""));
		ElementParser.parseStyleFromAttributes(element, style);
		String in1Str = ElementParser.read(element, Attributes.IN);
		SVGAnimatedString in1 = new SVGAnimatedString.Implementation(in1Str, in1Str);
		String in2Str = ElementParser.read(element, Attributes.IN2);
		SVGAnimatedString in2 = new SVGAnimatedString.Implementation(in2Str, in2Str);
		String operatorStr = ElementParser.readOrDefault(element, Attributes.OPERATOR, "over");
		short operatorEnum = operator_strToEnum.get(operatorStr);
		SVGAnimatedEnumeration operator = new SVGAnimatedEnumeration.Implementation(operatorEnum, operatorEnum);
		String k1Str = ElementParser.readOrDefault(element, Attributes.K1, "0");
		float k1Value = Float.parseFloat(k1Str);
		SVGAnimatedNumber k1 = new SVGAnimatedNumber.Implementation(k1Value, k1Value);
		String k2Str = ElementParser.readOrDefault(element, Attributes.K2, "0");
		float k2Value = Float.parseFloat(k2Str);
		SVGAnimatedNumber k2 = new SVGAnimatedNumber.Implementation(k2Value, k2Value);
		String k3Str = ElementParser.readOrDefault(element, Attributes.K3, "0");
		float k3Value = Float.parseFloat(k3Str);
		SVGAnimatedNumber k3 = new SVGAnimatedNumber.Implementation(k3Value, k3Value);
		String k4Str = ElementParser.readOrDefault(element, Attributes.K4, "0");
		float k4Value = Float.parseFloat(k4Str);
		SVGAnimatedNumber k4 = new SVGAnimatedNumber.Implementation(k4Value, k4Value);
		SVGFECompositeElement feComposite = new SVGFECompositeElement.Implementation(id, xmlBase, ownerSVGElement,
				viewportElement, ax, ay, awidth, aheight, result, className, style, in1, in2,
				operator, k1, k2, k3, k4);
		ElementParser.connectLengthRoots(feComposite);
		return feComposite;
	}

	@Override
	public Element writeElement(SVGFECompositeElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.X, element.getX().getBaseValue().getValueAsString());
		attributes.put(Attributes.Y, element.getY().getBaseValue().getValueAsString());
		attributes.put(Attributes.WIDTH, element.getWidth().getBaseValue().getValueAsString());
		attributes.put(Attributes.HEIGHT, element.getHeight().getBaseValue().getValueAsString());
		attributes.put(Attributes.RESULT, element.getResult().getBaseValue());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		ElementParser.storeStyleFromAttributes(attributes, element.getStyle());
		attributes.put(Attributes.IN, element.getIn1().getBaseValue());
		attributes.put(Attributes.IN2, element.getIn2().getBaseValue());
		attributes.put(Attributes.OPERATOR, operator_enumToStr.get(element.getOperator().getBaseValue()));
		attributes.put(Attributes.K1, Float.toString(element.getK1().getBaseValue()));
		attributes.put(Attributes.K2, Float.toString(element.getK2().getBaseValue()));
		attributes.put(Attributes.K3, Float.toString(element.getK3().getBaseValue()));
		attributes.put(Attributes.K4, Float.toString(element.getK4().getBaseValue()));
		return factory.createElement(Tags.FE_COMPOSITE, attributes);
	}

}
