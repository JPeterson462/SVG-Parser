package org.w3c.dom.svg.parser.filters;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedInteger;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedNumberList;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGNumberList;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.filters.SVGFEConvolveMatrixElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFEConvolveMatrixElementParser implements ElementParser<SVGFEConvolveMatrixElement> {

	private HashMap<String, Short> edgeMode_strToEnum = new HashMap<>();
	private HashMap<Short, String> edgeMode_enumToStr = new HashMap<>();
	
	public SVGFEConvolveMatrixElementParser() {
		edgeMode_strToEnum.put("duplicate", SVGFEConvolveMatrixElement.SVG_EDGEMODE_DUPLICATE);
		edgeMode_strToEnum.put("wrap", SVGFEConvolveMatrixElement.SVG_EDGEMODE_WRAP);
		edgeMode_strToEnum.put("none", SVGFEConvolveMatrixElement.SVG_EDGEMODE_NONE);	
		edgeMode_enumToStr.put(SVGFEConvolveMatrixElement.SVG_EDGEMODE_DUPLICATE, "duplicate");
		edgeMode_enumToStr.put(SVGFEConvolveMatrixElement.SVG_EDGEMODE_WRAP, "wrap");
		edgeMode_enumToStr.put(SVGFEConvolveMatrixElement.SVG_EDGEMODE_NONE, "none");	
	}
	
	@Override
	public SVGFEConvolveMatrixElement readElement(Element element, ParsingState parsingState) {
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
		String orderStr = ElementParser.readOrDefault(element, Attributes.ORDER, "3");
		String[] orderParts = orderStr.split(",");
		SVGAnimatedInteger orderX = null, orderY = null;
		if (orderParts.length == 1) {
			int orderValue = Integer.parseInt(orderParts[0].trim());
			orderX = new SVGAnimatedInteger.Implementation(orderValue, orderValue);
			orderY = new SVGAnimatedInteger.Implementation(orderValue, orderValue);
		}
		else if (orderParts.length == 2) {
			int orderValueX = Integer.parseInt(orderParts[0].trim());
			int orderValueY = Integer.parseInt(orderParts[1].trim());
			orderX = new SVGAnimatedInteger.Implementation(orderValueX, orderValueX);
			orderY = new SVGAnimatedInteger.Implementation(orderValueY, orderValueY);
		}
		else {
			SVGErrors.error("Invalid order: " + orderStr);
		}
		String kernelMatrixStr = ElementParser.read(element, Attributes.KERNEL_MATRIX);
		ArrayList<String> kernelMatrixStrList = StringUtils.splitByWhitespace(kernelMatrixStr);
		ArrayList<SVGNumber> kernelMatrixList = new ArrayList<>();
		float kernelMatrixSum = 0;
		for (int i = 0; i < kernelMatrixStrList.size(); i++) {
			float value = Float.parseFloat(kernelMatrixStrList.get(i));
			kernelMatrixSum += value;
			kernelMatrixList.add(new SVGNumber.Implementation(value));
		}
		SVGNumberList kernelMatrixBase = new SVGNumberList.Implementation(kernelMatrixList);
		SVGAnimatedNumberList kernelMatrix = new SVGAnimatedNumberList.Implementation(kernelMatrixBase, kernelMatrixBase);
		float divisorDefault = kernelMatrixSum > 0 ? kernelMatrixSum : 1;
		String divisorStr = ElementParser.readOrDefault(element, Attributes.DIVISOR, Float.toString(divisorDefault));
		SVGAnimatedNumber divisor = new SVGAnimatedNumber.Implementation(Float.parseFloat(divisorStr), Float.parseFloat(divisorStr));
		String biasStr = ElementParser.readOrDefault(element, Attributes.BIAS, "0");
		SVGAnimatedNumber bias = new SVGAnimatedNumber.Implementation(Float.parseFloat(biasStr), Float.parseFloat(biasStr));
		String targetXStr = ElementParser.readOrDefault(element, Attributes.TARGET_X, Integer.toString((int) Math.floor(orderX.getBaseValue() / 2)));
		SVGAnimatedInteger targetX = new SVGAnimatedInteger.Implementation(Integer.parseInt(targetXStr), Integer.parseInt(targetXStr));
		String targetYStr = ElementParser.readOrDefault(element, Attributes.TARGET_Y, Integer.toString((int) Math.floor(orderY.getBaseValue() / 2)));
		SVGAnimatedInteger targetY = new SVGAnimatedInteger.Implementation(Integer.parseInt(targetYStr), Integer.parseInt(targetYStr));
		String edgeModeStr = ElementParser.readOrDefault(element, Attributes.EDGE_MODE, "duplicate");
		short edgeModeEnum = edgeMode_strToEnum.get(edgeModeStr);
		SVGAnimatedEnumeration edgeMode = new SVGAnimatedEnumeration.Implementation(edgeModeEnum, edgeModeEnum);
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
		boolean preserveAlphaBase = Boolean.parseBoolean(ElementParser.readOrDefault(element, Attributes.PRESERVE_ALPHA, Boolean.toString(false)));
		SVGAnimatedBoolean preserveAlpha = new SVGAnimatedBoolean.Implementation(preserveAlphaBase, preserveAlphaBase);
		SVGFEConvolveMatrixElement feConvolveMatrix = new SVGFEConvolveMatrixElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement,
				ax, ay, awidth, aheight, result, className, style, in1, orderX, orderY, kernelMatrix, divisor,
				bias, targetX, targetY, edgeMode, kernelUnitLengthX, kernelUnitLengthY, preserveAlpha);
		ElementParser.connectLengthRoots(feConvolveMatrix);
		return feConvolveMatrix;
	}

	@Override
	public Element writeElement(SVGFEConvolveMatrixElement element, ElementFactory factory) {
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
		attributes.put(Attributes.ORDER, Long.toString(element.getOrderX().getBaseValue()) + " " + Long.toString(element.getOrderY().getBaseValue()));
		attributes.put(Attributes.KERNEL_MATRIX, ElementParser.concatenate(element.getKernelMatrix().getBaseValue(), " "));
		attributes.put(Attributes.DIVISOR, Float.toString(element.getDivisor().getBaseValue()));
		attributes.put(Attributes.BIAS, Float.toString(element.getBias().getBaseValue()));
		attributes.put(Attributes.TARGET_X, Float.toString(element.getTargetX().getBaseValue()));
		attributes.put(Attributes.TARGET_Y, Float.toString(element.getTargetY().getBaseValue()));
		attributes.put(Attributes.EDGE_MODE, edgeMode_enumToStr.get(element.getEdgeMode().getBaseValue()));
		attributes.put(Attributes.KERNEL_UNIT_LENGTH, Float.toString(element.getKernelUnitLengthX().getBaseValue()) + " " + Float.toString(element.getKernelUnitLengthY().getBaseValue()));
		attributes.put(Attributes.PRESERVE_ALPHA, Boolean.toString(element.getPreserveAlpha().getBaseValue()));
		return factory.createElement(Tags.FE_CONVOLVEMATRIX, attributes);
	}

}
