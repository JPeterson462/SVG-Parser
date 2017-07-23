package org.w3c.dom.svg.parser.shapes;

import org.w3c.dom.Element;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGFeatures;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.shapes.SVGRectElement;

public class SVGRectElementParser implements ElementParser<SVGRectElement> {

	@Override
	public SVGRectElement readElement(Element element, ParsingState parsingState) {
		// Read and validate
		String xStr = ElementParser.readOrDefault(element, Attributes.X, "0");
		String yStr = ElementParser.readOrDefault(element, Attributes.Y, "0");
		String widthStr = element.getAttribute(Attributes.WIDTH);
		if (widthStr.startsWith("-")) {
			SVGErrors.error("Width must be >= 0");
		}
		String heightStr = element.getAttribute(Attributes.HEIGHT);
		if (heightStr.startsWith("-")) {
			SVGErrors.error("Height must be >= 0");
		}
		String rxStr = element.getAttribute(Attributes.RX);
		String ryStr = element.getAttribute(Attributes.RY);
		if (rxStr == null && ryStr != null) {
			rxStr = ryStr;
		}
		if (rxStr == null) {
			rxStr = "0";
		}
		if (rxStr.startsWith("-")) {
			SVGErrors.error("X Radius must be >= 0");
		}
		if (ryStr == null && rxStr != null) {
			ryStr = rxStr;
		}
		if (ryStr == null) {
			ryStr = "0";
		}
		if (ryStr.startsWith("-")) {
			SVGErrors.error("Y Radius must be >= 0");
		}
		// Convert
		SVGLength x = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		x.setValueAsString(xStr);
		SVGLength y = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		y.setValueAsString(yStr);
		SVGLength width = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		width.setValueAsString(widthStr);
		SVGLength height = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		height.setValueAsString(heightStr);
		SVGLength rx = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		rx.setValueAsString(rxStr);
		SVGLength ry = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		ry.setValueAsString(ryStr);
		if (rx.getValue() > 0.5f * width.getValue()) {
			rx.setValue(0.5f * width.getValue());
		}
		if (ry.getValue() > 0.5f * height.getValue()) {
			ry.setValue(0.5f * height.getValue());
		}
		// SVGLength -> SVGAnimatedLength
		SVGAnimatedLength ax = new SVGAnimatedLength.Implementation(x, x);
		SVGAnimatedLength ay = new SVGAnimatedLength.Implementation(y, y);
		SVGAnimatedLength awidth = new SVGAnimatedLength.Implementation(width, width);
		SVGAnimatedLength aheight = new SVGAnimatedLength.Implementation(height, height);
		SVGAnimatedLength arx = new SVGAnimatedLength.Implementation(rx, rx);
		SVGAnimatedLength ary = new SVGAnimatedLength.Implementation(ry, ry);
		// Get default values
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getOwnerSVGElement();
		String xmlLang = element.getAttribute(Attributes.XML_LANG);
		if (xmlLang == null) {
			xmlLang = "en";
		}
		String xmlSpace = element.getAttribute(Attributes.XML_SPACE);
		if (xmlSpace == null) {
			xmlSpace = "default";
		}
//		String className = element.getAttribute(Attributes.CLASS);
		SVGAnimatedString className = null;//TODO
		CSSStyleDeclaration style = null;//TODO
		SVGStringList requiredFeatures = null;//TODO
		SVGStringList requiredExtensions = null;//TODO
		SVGStringList systemLanguage = null;//TODO
		SVGAnimatedBoolean externalResourcesRequired = null;//TODO
		SVGElement nearestViewportElement = null;//TODO
		SVGElement farthestViewportElement = null;//TODO
		SVGAnimatedTransformList transform = ElementParser.parseTransforms(element);
		// Construct the implementation
		return new SVGRectElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, xmlLang, xmlSpace,
					className, style, requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired,
					ax, ay, awidth, aheight, arx, ary, nearestViewportElement, farthestViewportElement, transform);
	}

	@Override
	public Element writeElement(SVGRectElement element, ElementFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

}
