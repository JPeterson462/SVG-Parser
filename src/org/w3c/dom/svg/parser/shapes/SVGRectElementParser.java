package org.w3c.dom.svg.parser.shapes;

import org.w3c.dom.Element;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGFeatures;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.shapes.SVGRectElement;

public class SVGRectElementParser implements ElementParser {

	@Override
	public SVGElement readElement(Element element) {
		if (!element.getTagName().equalsIgnoreCase("rect")) {
			throw new IllegalStateException("Invalid <rect> element");
		}
		// Read and validate
		String xStr = ElementParser.readOrDefault(element, "x", "0");
		String yStr = ElementParser.readOrDefault(element, "y", "0");
		String widthStr = element.getAttribute("width");
		if (widthStr.startsWith("-")) {
			SVGErrors.error("Width must be >= 0");
		}
		String heightStr = element.getAttribute("height");
		if (heightStr.startsWith("-")) {
			SVGErrors.error("Height must be >= 0");
		}
		String rxStr = element.getAttribute("rx");
		String ryStr = element.getAttribute("ry");
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
		// TODO pass parent element
		// Convert
		SVGLength x = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, null);
		x.setValueAsString(xStr);
		SVGLength y = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, null);
		y.setValueAsString(yStr);
		SVGLength width = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, null);
		width.setValueAsString(widthStr);
		SVGLength height = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, null);
		height.setValueAsString(heightStr);
		SVGLength rx = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, null);
		rx.setValueAsString(rxStr);
		SVGLength ry = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, null);
		ry.setValueAsString(ryStr);
		if (rx.getValue() > 0.5f * width.getValue()) {
			rx.setValue(0.5f * width.getValue());
		}
		if (ry.getValue() > 0.5f * height.getValue()) {
			ry.setValue(0.5f * height.getValue());
		}
		// Get default values
		String id = element.getAttribute("id");
		String xmlBase = null;//TODO
		SVGSVGElement ownerSVGElement = null;//TODO
		SVGElement viewportElement = null;//TODO
		String xmlLang = element.getAttribute("xml:lang");
		if (xmlLang == null) {
			xmlLang = "en";
		}
		String xmlSpace = element.getAttribute("xml:space");
		if (xmlSpace == null) {
			xmlSpace = "default";
		}
//		String className = element.getAttribute("class");
		SVGAnimatedString className;
		CSSStyleDeclaration style = null;//TODO
		SVGStringList requiredFeatures = ElementParser.concatenate(SVGFeatures.SHAPE);
		SVGStringList requiredExtensions = null;//TODO
		SVGStringList systemLanguage = null;//TODO
		SVGAnimatedBoolean externalResourcesRequired = null;//TODO
		SVGElement nearestViewportElement = null;//TODO
		SVGElement farthestViewportElement = null;//TODO
		SVGAnimatedTransformList transform = ElementParser.parseTransforms(element);
		// Construct the implementation
//		return new SVGRectElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, xmlLang, xmlSpace,
//					className, style, requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired,
//					x, y, width, height, rx, ry, nearestViewportElement, farthestViewportElement, transform);
		return null;
	}

	@Override
	public Element writeElement(SVGElement element, ElementFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

}
