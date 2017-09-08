package org.w3c.dom.svg.parser.filters;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumberList;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGNumberList;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.filters.SVGFEColorMatrixElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFEColorMatrixElementParser implements ElementParser<SVGFEColorMatrixElement> {

	private HashMap<String, Short> type_strToEnum = new HashMap<>();
	private HashMap<Short, String> type_enumToStr = new HashMap<>();
	
	public SVGFEColorMatrixElementParser() {
		type_strToEnum.put("matrix", SVGFEColorMatrixElement.SVG_FECOLORMATRIX_TYPE_MATRIX);
		type_strToEnum.put("saturate", SVGFEColorMatrixElement.SVG_FECOLORMATRIX_TYPE_SATURATE);
		type_strToEnum.put("hueRotate", SVGFEColorMatrixElement.SVG_FECOLORMATRIX_TYPE_HUEROTATE);
		type_strToEnum.put("luminanceToAlpha", SVGFEColorMatrixElement.SVG_FECOLORMATRIX_TYPE_LUMINANCETOALPHA);
		type_enumToStr.put(SVGFEColorMatrixElement.SVG_FECOLORMATRIX_TYPE_MATRIX, "matrix");
		type_enumToStr.put(SVGFEColorMatrixElement.SVG_FECOLORMATRIX_TYPE_SATURATE, "saturate");
		type_enumToStr.put(SVGFEColorMatrixElement.SVG_FECOLORMATRIX_TYPE_HUEROTATE, "hueRotate");
		type_enumToStr.put(SVGFEColorMatrixElement.SVG_FECOLORMATRIX_TYPE_LUMINANCETOALPHA, "luminanceToAlpha");
	}
	
	@Override
	public SVGFEColorMatrixElement readElement(Element element, ParsingState parsingState) {
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
		String typeStr = ElementParser.readOrDefault(element, Attributes.TYPE, "matrix");
		short typeEnum = type_strToEnum.get(typeStr);
		SVGAnimatedEnumeration type = new SVGAnimatedEnumeration.Implementation(typeEnum, typeEnum);
		ArrayList<String> valuesStr = StringUtils.splitByWhitespace(ElementParser.readOrDefault(element, Attributes.VALUES, ""));
		ArrayList<SVGNumber> valuesList = new ArrayList<>();
		for (int i = 0; i < valuesStr.size(); i++) {
			valuesList.add(new SVGNumber.Implementation(Float.parseFloat(valuesStr.get(i))));
		}
		SVGNumberList valuesBase = new SVGNumberList.Implementation(valuesList);
		SVGAnimatedNumberList values = new SVGAnimatedNumberList.Implementation(valuesBase, valuesBase);
		SVGFEColorMatrixElement feColorMatrix = new SVGFEColorMatrixElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement,
				ax, ay, awidth, aheight, result, className, style, in1, type, values);
		ElementParser.connectLengthRoots(feColorMatrix);
		return feColorMatrix;
	}

	@Override
	public Element writeElement(SVGFEColorMatrixElement element, ElementFactory factory) {
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
		attributes.put(Attributes.TYPE, type_enumToStr.get(element.getType().getBaseValue()));
		attributes.put(Attributes.VALUES, ElementParser.concatenate(element.getValues().getBaseValue(), " "));
		return factory.createElement(Tags.FE_COLORMATRIX, attributes);
	}
	
}
