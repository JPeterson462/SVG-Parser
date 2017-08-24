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
import org.w3c.dom.svg.filters.SVGFEDisplacementMapElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFEDisplacementMapElementParser implements ElementParser<SVGFEDisplacementMapElement> {

	private HashMap<String, Short> channelSelector_strToEnum = new HashMap<>();
	private HashMap<Short, String> channelSelector_enumToStr = new HashMap<>();
	
	public SVGFEDisplacementMapElementParser() {
		channelSelector_strToEnum.put("R", SVGFEDisplacementMapElement.SVG_CHANNEL_R);
		channelSelector_strToEnum.put("G", SVGFEDisplacementMapElement.SVG_CHANNEL_G);
		channelSelector_strToEnum.put("B", SVGFEDisplacementMapElement.SVG_CHANNEL_B);
		channelSelector_strToEnum.put("A", SVGFEDisplacementMapElement.SVG_CHANNEL_A);
		channelSelector_enumToStr.put(SVGFEDisplacementMapElement.SVG_CHANNEL_R, "R");
		channelSelector_enumToStr.put(SVGFEDisplacementMapElement.SVG_CHANNEL_G, "G");
		channelSelector_enumToStr.put(SVGFEDisplacementMapElement.SVG_CHANNEL_B, "B");
		channelSelector_enumToStr.put(SVGFEDisplacementMapElement.SVG_CHANNEL_A, "A");
	}
	
	@Override
	public SVGFEDisplacementMapElement readElement(Element element, ParsingState parsingState) {
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
		String in2Str = element.getAttribute(Attributes.IN2);
		SVGAnimatedString in2 = new SVGAnimatedString.Implementation(in2Str, in2Str);
		String scaleStr = ElementParser.readOrDefault(element, Attributes.SCALE, "0");
		SVGAnimatedNumber scale = new SVGAnimatedNumber.Implementation(Float.parseFloat(scaleStr), Float.parseFloat(scaleStr));
		String xChannelSelectorStr = ElementParser.readOrDefault(element, Attributes.X_CHANNEL_SELECTOR, "A");
		short xChannelSelectorEnum = channelSelector_strToEnum.get(xChannelSelectorStr);
		SVGAnimatedEnumeration xChannelSelector = new SVGAnimatedEnumeration.Implementation(xChannelSelectorEnum, xChannelSelectorEnum);
		String yChannelSelectorStr = ElementParser.readOrDefault(element, Attributes.Y_CHANNEL_SELECTOR, "A");
		short yChannelSelectorEnum = channelSelector_strToEnum.get(yChannelSelectorStr);
		SVGAnimatedEnumeration yChannelSelector = new SVGAnimatedEnumeration.Implementation(yChannelSelectorEnum, yChannelSelectorEnum);
		return new SVGFEDisplacementMapElement.Implementation(id, xmlBase, ownerSVGElement,
				viewportElement, ax, ay, awidth, aheight, result, className, style, in1, in2,
				scale, xChannelSelector, yChannelSelector);
	}

	@Override
	public Element writeElement(SVGFEDisplacementMapElement element, ElementFactory factory) {
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
		attributes.put(Attributes.SCALE, Float.toString(element.getScale().getBaseValue()));
		attributes.put(Attributes.X_CHANNEL_SELECTOR, channelSelector_enumToStr.get(element.getXChannelSelector().getBaseValue()));
		attributes.put(Attributes.Y_CHANNEL_SELECTOR, channelSelector_enumToStr.get(element.getYChannelSelector().getBaseValue()));
		return factory.createElement(Tags.FE_DISPLACEMENTMAP, attributes);
	}

}
