package org.w3c.dom.svg.parser.filters;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.filters.SVGFESpecularLightingElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFESpecularLightingElementParser implements ElementParser<SVGFESpecularLightingElement> {

	@Override
	public SVGFESpecularLightingElement readElement(Element element, ParsingState parsingState) {
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
		String surfaceScaleStr = ElementParser.readOrDefault(element, Attributes.SURFACE_SCALE, "1");
		SVGAnimatedNumber surfaceScale = new SVGAnimatedNumber.Implementation(Float.parseFloat(surfaceScaleStr), Float.parseFloat(surfaceScaleStr));
		String specularConstantStr = ElementParser.readOrDefault(element, Attributes.SPECULAR_CONSTANT, "1");
		SVGAnimatedNumber specularConstant = new SVGAnimatedNumber.Implementation(Float.parseFloat(specularConstantStr), Float.parseFloat(specularConstantStr));
		String specularExponentStr = ElementParser.readOrDefault(element, Attributes.SPECULAR_EXPONENT, "1");
		SVGAnimatedNumber specularExponent = new SVGAnimatedNumber.Implementation(Float.parseFloat(specularExponentStr), Float.parseFloat(specularExponentStr));
		String kernelUnitLengthStr = ElementParser.readOrDefault(element, Attributes.KERNEL_UNIT_LENGTH, "1");
		String[] kernelUnitLengthParts = kernelUnitLengthStr.split(",");
		SVGAnimatedNumber kernelUnitLengthX = null, kernelUnitLengthY = null;
		if (kernelUnitLengthParts.length == 1) {
			float kernelUnitLengthValue = Float.parseFloat(kernelUnitLengthParts[0].trim());
			kernelUnitLengthX = new SVGAnimatedNumber.Implementation(kernelUnitLengthValue, kernelUnitLengthValue);
			kernelUnitLengthY = new SVGAnimatedNumber.Implementation(kernelUnitLengthValue, kernelUnitLengthValue);
		}
		else if (kernelUnitLengthParts.length == 2) {
			float kernelUnitLengthXValue = Float.parseFloat(kernelUnitLengthParts[0].trim());
			float kernelUnitLengthYValue = Float.parseFloat(kernelUnitLengthParts[1].trim());
			kernelUnitLengthX = new SVGAnimatedNumber.Implementation(kernelUnitLengthXValue, kernelUnitLengthXValue);
			kernelUnitLengthY = new SVGAnimatedNumber.Implementation(kernelUnitLengthYValue, kernelUnitLengthYValue);
		}
		else {
			SVGErrors.error("Invalid kernelUnitLength: " + kernelUnitLengthStr);
		}
		return new SVGFESpecularLightingElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, 
				ax, ay, awidth, aheight, result, className, style, in1, surfaceScale, specularConstant, 
				specularExponent, kernelUnitLengthX, kernelUnitLengthY);
	}

	@Override
	public Element writeElement(SVGFESpecularLightingElement element, ElementFactory factory) {
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
		attributes.put(Attributes.SURFACE_SCALE, Float.toString(element.getSurfaceScale().getBaseValue()));
		attributes.put(Attributes.SPECULAR_CONSTANT, Float.toString(element.getSpecularConstant().getBaseValue()));
		attributes.put(Attributes.SPECULAR_EXPONENT, Float.toString(element.getSpecularExponent().getBaseValue()));
		attributes.put(Attributes.KERNEL_UNIT_LENGTH, Float.toString(element.getKernelUnitLengthX().getBaseValue()) + " " + Float.toString(element.getKernelUnitLengthY().getBaseValue()));
		return factory.createElement(Tags.FE_SPECULARLIGHTING, attributes);
	}

}
