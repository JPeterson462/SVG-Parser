package org.w3c.dom.svg.parser.filters;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedInteger;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.filters.SVGFETurbulenceElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFETurbulenceElementParser implements ElementParser<SVGFETurbulenceElement> {

	private HashMap<String, Short> stitchTiles_strToEnum = new HashMap<>();
	private HashMap<Short, String> stitchTiles_enumToStr = new HashMap<>();
	
	private HashMap<String, Short> type_strToEnum = new HashMap<>();
	private HashMap<Short, String> type_enumToStr = new HashMap<>();
	
	public SVGFETurbulenceElementParser() {
		stitchTiles_strToEnum.put("stitch", SVGFETurbulenceElement.SVG_STITCHTYPE_STITCH);
		stitchTiles_strToEnum.put("nostitch", SVGFETurbulenceElement.SVG_STITCHTYPE_NOSTITCH);
		stitchTiles_enumToStr.put(SVGFETurbulenceElement.SVG_STITCHTYPE_STITCH, "stitch");
		stitchTiles_enumToStr.put(SVGFETurbulenceElement.SVG_STITCHTYPE_NOSTITCH, "nostitch");
		type_strToEnum.put("fractalNoise", SVGFETurbulenceElement.SVG_TURBULENCE_TYPE_FRACTALNOISE);
		type_strToEnum.put("turbulence", SVGFETurbulenceElement.SVG_TURBULENCE_TYPE_TURBULENCE);
		type_enumToStr.put(SVGFETurbulenceElement.SVG_TURBULENCE_TYPE_FRACTALNOISE, "fractalNoise");
		type_enumToStr.put(SVGFETurbulenceElement.SVG_TURBULENCE_TYPE_TURBULENCE, "turbulence");
	}
	
	@Override
	public SVGFETurbulenceElement readElement(Element element, ParsingState parsingState) {
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
		String baseFrequencyStr = ElementParser.readOrDefault(element, Attributes.BASE_FREQUENCY, "0");
		ArrayList<String> baseFrequencyList = StringUtils.splitByWhitespace(baseFrequencyStr);
		SVGAnimatedNumber baseFrequencyX = null, baseFrequencyY = null;
		if (baseFrequencyList.size() < 2) {
			if (baseFrequencyList.size() > 0) {
				float baseFrequencyValue = Float.parseFloat(baseFrequencyList.get(0));
				baseFrequencyX = new SVGAnimatedNumber.Implementation(baseFrequencyValue, baseFrequencyValue);
				baseFrequencyY = new SVGAnimatedNumber.Implementation(baseFrequencyValue, baseFrequencyValue);
			} else {
				SVGErrors.error("Invalid baseFrequency: " + baseFrequencyStr);
			}
		}
		else {
			float baseFrequencyXValue = Float.parseFloat(baseFrequencyList.get(0));
			float baseFrequencyYValue = Float.parseFloat(baseFrequencyList.get(1));
			baseFrequencyX = new SVGAnimatedNumber.Implementation(baseFrequencyXValue, baseFrequencyXValue);
			baseFrequencyY = new SVGAnimatedNumber.Implementation(baseFrequencyYValue, baseFrequencyYValue);
		}
		String numOctavesStr = ElementParser.readOrDefault(element, Attributes.NUM_OCTAVES, "1");
		SVGAnimatedInteger numOctaves = new SVGAnimatedInteger.Implementation(Long.parseLong(numOctavesStr), Long.parseLong(numOctavesStr));
		String seedStr = ElementParser.readOrDefault(element, Attributes.SEED, "0");
		SVGAnimatedNumber seed = new SVGAnimatedNumber.Implementation(Float.parseFloat(seedStr), Float.parseFloat(seedStr));
		String stitchTilesStr = ElementParser.readOrDefault(element, Attributes.STITCH_TILES, "noStitch");
		short stitchTilesValue = stitchTiles_strToEnum.get(stitchTilesStr);
		SVGAnimatedEnumeration stitchTiles = new SVGAnimatedEnumeration.Implementation(stitchTilesValue, stitchTilesValue);
		String typeStr = ElementParser.readOrDefault(element, Attributes.TYPE, "turbulence");
		short typeValue = type_strToEnum.get(typeStr);
		SVGAnimatedEnumeration type = new SVGAnimatedEnumeration.Implementation(typeValue, typeValue);
		return new SVGFETurbulenceElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, 
				ax, ay, awidth, aheight, result, className, style, baseFrequencyX, baseFrequencyY, 
				numOctaves, seed, stitchTiles, type);
	}

	@Override
	public Element writeElement(SVGFETurbulenceElement element, ElementFactory factory) {
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
		attributes.put(Attributes.BASE_FREQUENCY, element.getBaseFrequencyX().getBaseValue() + " " + element.getBaseFrequencyY().getBaseValue());
		attributes.put(Attributes.NUM_OCTAVES, Long.toString(element.getNumOctaves().getBaseValue()));
		attributes.put(Attributes.SEED, Float.toString(element.getSeed().getBaseValue()));
		attributes.put(Attributes.STITCH_TILES, stitchTiles_enumToStr.get(element.getStitchTiles().getBaseValue()));
		attributes.put(Attributes.TYPE, type_enumToStr.get(element.getType().getBaseValue()));
		return factory.createElement(Tags.FE_TURBULENCE, attributes);
	}

}
