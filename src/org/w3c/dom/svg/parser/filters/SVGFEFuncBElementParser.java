package org.w3c.dom.svg.parser.filters;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedNumberList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGNumberList;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.filters.SVGFEFuncBElement;
import org.w3c.dom.svg.filters.SVGFEFuncRElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFEFuncBElementParser implements ElementParser<SVGFEFuncBElement> {

	private HashMap<String, Short> type_strToEnum = new HashMap<>();
	private HashMap<Short, String> type_enumToStr = new HashMap<>();
	
	public SVGFEFuncBElementParser() {
		type_strToEnum.put("identity", SVGFEFuncRElement.SVG_FECOMPONENTTRANSFER_TYPE_IDENTITY);
		type_strToEnum.put("table", SVGFEFuncRElement.SVG_FECOMPONENTTRANSFER_TYPE_TABLE);
		type_strToEnum.put("discrete", SVGFEFuncRElement.SVG_FECOMPONENTTRANSFER_TYPE_DISCRETE);
		type_strToEnum.put("linear", SVGFEFuncRElement.SVG_FECOMPONENTTRANSFER_TYPE_LINEAR);
		type_strToEnum.put("gamma", SVGFEFuncRElement.SVG_FECOMPONENTTRANSFER_TYPE_GAMMA);
		type_enumToStr.put(SVGFEFuncRElement.SVG_FECOMPONENTTRANSFER_TYPE_IDENTITY, "identity");
		type_enumToStr.put(SVGFEFuncRElement.SVG_FECOMPONENTTRANSFER_TYPE_TABLE, "table");
		type_enumToStr.put(SVGFEFuncRElement.SVG_FECOMPONENTTRANSFER_TYPE_DISCRETE, "discrete");
		type_enumToStr.put(SVGFEFuncRElement.SVG_FECOMPONENTTRANSFER_TYPE_LINEAR, "linear");
		type_enumToStr.put(SVGFEFuncRElement.SVG_FECOMPONENTTRANSFER_TYPE_GAMMA, "gamma");
	}
	
	@Override
	public SVGFEFuncBElement readElement(Element element, ParsingState parsingState) {
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String typeStr = element.getAttribute(Attributes.TYPE);
		short typeEnum = type_strToEnum.get(typeStr);
		SVGAnimatedEnumeration type = new SVGAnimatedEnumeration.Implementation(typeEnum, typeEnum);
		ArrayList<String> tableValuesStrList = StringUtils.splitByWhitespace(ElementParser.readOrDefault(element, Attributes.TABLE_VALUES, ""));
		ArrayList<SVGNumber> tableValuesList = new ArrayList<>();
		for (int i = 0; i < tableValuesStrList.size(); i++) {
			tableValuesList.add(new SVGNumber.Implementation(Float.parseFloat(tableValuesStrList.get(i))));
		}
		SVGNumberList tableValuesBase = new SVGNumberList.Implementation(tableValuesList);
		SVGAnimatedNumberList tableValues = new SVGAnimatedNumberList.Implementation(tableValuesBase, tableValuesBase);
		float slopeBase = Float.parseFloat(ElementParser.readOrDefault(element, Attributes.SLOPE, "1"));
		SVGAnimatedNumber slope = new SVGAnimatedNumber.Implementation(slopeBase, slopeBase);
		float interceptBase = Float.parseFloat(ElementParser.readOrDefault(element, Attributes.INTERCEPT, "0")); 
		SVGAnimatedNumber intercept = new SVGAnimatedNumber.Implementation(interceptBase, interceptBase);
		float amplitudeBase = Float.parseFloat(ElementParser.readOrDefault(element, Attributes.AMPLITUDE, "1"));
		SVGAnimatedNumber amplitude = new SVGAnimatedNumber.Implementation(amplitudeBase, amplitudeBase);
		float exponentBase = Float.parseFloat(ElementParser.readOrDefault(element, Attributes.EXPONENT, "1"));
		SVGAnimatedNumber exponent = new SVGAnimatedNumber.Implementation(exponentBase, exponentBase);
		float offsetBase = Float.parseFloat(ElementParser.readOrDefault(element, Attributes.OFFSET, "0"));
		SVGAnimatedNumber offset = new SVGAnimatedNumber.Implementation(offsetBase, offsetBase);
		return new SVGFEFuncBElement.Implementatation(id, xmlBase, ownerSVGElement, viewportElement,
				type, tableValues, slope, intercept, amplitude, exponent, offset);
	}

	@Override
	public Element writeElement(SVGFEFuncBElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.TYPE, type_enumToStr.get(element.getType().getBaseValue()));
		attributes.put(Attributes.VALUES, join(element.getTableValues().getBaseValue(), " "));
		attributes.put(Attributes.SLOPE, Float.toString(element.getSlope().getBaseValue()));
		attributes.put(Attributes.INTERCEPT, Float.toString(element.getIntercept().getBaseValue()));
		attributes.put(Attributes.AMPLITUDE, Float.toString(element.getAmplitude().getBaseValue()));
		attributes.put(Attributes.EXPONENT, Float.toString(element.getExponent().getBaseValue()));
		attributes.put(Attributes.OFFSET, Float.toString(element.getOffset().getBaseValue()));
		return factory.createElement(Tags.FE_FUNCR, attributes);
	}
	
	private String join(SVGNumberList list, String joinBy) {
		String result = "";
		for (int i = 0; i < list.getNumberOfItems(); i++) {
			if (i > 0) {
				result += joinBy;
			}
			result += Float.toString(list.getItem(i).getValue());
		}
		return result;
	}

}
