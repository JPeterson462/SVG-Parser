package org.w3c.dom.svg.parser.filters;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.filters.SVGFEGaussianBlurElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFEGaussianBlurElementParser implements ElementParser<SVGFEGaussianBlurElement> {

	@Override
	public SVGFEGaussianBlurElement readElement(Element element, ParsingState parsingState) {
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
		String in = element.getAttribute(Attributes.IN);
		SVGAnimatedString in1 = new SVGAnimatedString.Implementation(in, in);
		String stdDeviationStr = ElementParser.readOrDefault(element, Attributes.STD_DEVIATION, "0");
		ArrayList<String> stdDeviationList = StringUtils.splitByWhitespace(stdDeviationStr);
		SVGAnimatedNumber stdDeviationX = null, stdDeviationY = null;
		if (stdDeviationList.size() < 2) {
			if (stdDeviationList.size() > 0) {
				float stdDeviationValue = Float.parseFloat(stdDeviationList.get(0));
				stdDeviationX = new SVGAnimatedNumber.Implementation(stdDeviationValue, stdDeviationValue);
				stdDeviationY = new SVGAnimatedNumber.Implementation(stdDeviationValue, stdDeviationValue);
			} else {
				SVGErrors.error("Invalid stdDeviation: " + stdDeviationStr);
			}
		}
		else {
			float stdDeviationXValue = Float.parseFloat(stdDeviationList.get(0));
			float stdDeviationYValue = Float.parseFloat(stdDeviationList.get(1));
			stdDeviationX = new SVGAnimatedNumber.Implementation(stdDeviationXValue, stdDeviationXValue);
			stdDeviationY = new SVGAnimatedNumber.Implementation(stdDeviationYValue, stdDeviationYValue);
		}
		return new SVGFEGaussianBlurElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement,
				ax, ay, awidth, aheight, result, className, style, in1, stdDeviationX, stdDeviationY);
	}

	@Override
	public Element writeElement(SVGFEGaussianBlurElement element, ElementFactory factory) {
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
		attributes.put(Attributes.STD_DEVIATION, element.getStdDeviationX().getBaseValue() + " " + element.getStdDeviationY().getBaseValue());
		return factory.createElement(Tags.FE_GAUSSIANBLUR, attributes);
	}

}
