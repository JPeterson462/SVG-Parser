package org.w3c.dom.svg.parser.filters;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.filters.SVGFEBlendElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFEBlendElementParser implements ElementParser<SVGFEBlendElement> {

	private HashMap<String, Short> mode_strToEnum = new HashMap<>();
	private HashMap<Short, String> mode_enumToStr = new HashMap<>();
	
	public SVGFEBlendElementParser() {
		mode_strToEnum.put("normal", SVGFEBlendElement.SVG_FEBLEND_MODE_NORMAL);
		mode_strToEnum.put("multiply", SVGFEBlendElement.SVG_FEBLEND_MODE_MULTIPLY);
		mode_strToEnum.put("screen", SVGFEBlendElement.SVG_FEBLEND_MODE_SCREEN);
		mode_strToEnum.put("darken", SVGFEBlendElement.SVG_FEBLEND_MODE_DARKEN);
		mode_strToEnum.put("lighten", SVGFEBlendElement.SVG_FEBLEND_MODE_LIGHTEN);
		mode_enumToStr.put(SVGFEBlendElement.SVG_FEBLEND_MODE_NORMAL, "normal");
		mode_enumToStr.put(SVGFEBlendElement.SVG_FEBLEND_MODE_MULTIPLY, "multiply");
		mode_enumToStr.put(SVGFEBlendElement.SVG_FEBLEND_MODE_SCREEN, "screen");
		mode_enumToStr.put(SVGFEBlendElement.SVG_FEBLEND_MODE_DARKEN, "darken");
		mode_enumToStr.put(SVGFEBlendElement.SVG_FEBLEND_MODE_LIGHTEN, "lighten");
	}
	
	@Override
	public SVGFEBlendElement readElement(Element element, ParsingState parsingState) {
		String id = ElementParser.read(element, Attributes.ID);
		String xmlBase = ElementParser.read(element, Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String xStr = ElementParser.readOrDefault(element, Attributes.X, "0");
		SVGLength x = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		x.setValueAsString(xStr);
		SVGAnimatedLength ax = new SVGAnimatedLength.Implementation(x, x);
		String yStr = ElementParser.readOrDefault(element, Attributes.Y, "0");
		SVGLength y = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		y.setValueAsString(yStr);
		SVGAnimatedLength ay = new SVGAnimatedLength.Implementation(y, y);
		String widthStr = ElementParser.readOrDefault(element, Attributes.WIDTH, "100%");
		SVGLength width = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		width.setValueAsString(widthStr);
		SVGAnimatedLength awidth = new SVGAnimatedLength.Implementation(width, width);
		String heightStr = ElementParser.readOrDefault(element, Attributes.HEIGHT, "100%");
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
		String modeStr = ElementParser.readOrDefault(element, Attributes.MODE, "normal");
		short modeEnum = mode_strToEnum.get(modeStr);
		SVGAnimatedEnumeration mode = new SVGAnimatedEnumeration.Implementation(modeEnum, modeEnum);
		return new SVGFEBlendElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement,
				ax, ay, awidth, aheight, result, className, style, in1, in2, mode);
	}

	@Override
	public Element writeElement(SVGFEBlendElement element, ElementFactory factory) {
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
		attributes.put(Attributes.IN2, element.getIn2().getBaseValue());
		attributes.put(Attributes.MODE, mode_enumToStr.get(element.getMode().getBaseValue()));
		return factory.createElement(Tags.FE_BLEND, attributes);
	}

}
