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
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.filters.SVGFilterElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;

public class SVGFilterElementParser implements ElementParser<SVGFilterElement> {

	private HashMap<String, Short> strToUnits = new HashMap<>();
	private HashMap<Short, String> unitsToStr = new HashMap<>();
	
	public SVGFilterElementParser() {
		register("userSpaceOnUse", SVGFilterElement.SVG_UNIT_TYPE_USERSPACEONUSE);
		register("objectBoundingBox", SVGFilterElement.SVG_UNIT_TYPE_OBJECTBOUNDINGBOX);
	}
	
	private void register(String str, short units) {
		strToUnits.put(str, units);
		unitsToStr.put(units, str);
	}
	
	@Override
	public SVGFilterElement readElement(Element element, ParsingState parsingState) {
		String hrefStr = element.getAttribute(Attributes.XLINK_HREF);
		SVGAnimatedString href = new SVGAnimatedString.Implementation(hrefStr, hrefStr);
		String filterUnitsStr = ElementParser.validate(element.getAttribute(Attributes.FILTER_UNITS), "userSpaceOnUse", "objectBoundingBox");
		short filterUnitsValue = strToUnits.get(filterUnitsStr);
		SVGAnimatedEnumeration filterUnits = new SVGAnimatedEnumeration.Implementation(filterUnitsValue, filterUnitsValue);
		String primitiveUnitsStr = ElementParser.validate(element.getAttribute(Attributes.PRIMITIVE_UNITS), "userSpaceOnUse", "objectBoundingBox");
		short primitiveUnitsValue = strToUnits.get(primitiveUnitsStr);
		SVGAnimatedEnumeration primitiveUnits = new SVGAnimatedEnumeration.Implementation(primitiveUnitsValue, primitiveUnitsValue);
		String xStr = ElementParser.readOrDefault(element, Attributes.X, "-10%");
		String yStr = ElementParser.readOrDefault(element, Attributes.Y, "-10%");
		String widthStr = ElementParser.readOrDefault(element, Attributes.WIDTH, "120%");
		String heightStr = ElementParser.readOrDefault(element, Attributes.HEIGHT, "120%");
		if (widthStr.startsWith("-")) {
			SVGErrors.error("Invalid Width: " + widthStr);
		}
		if (heightStr.startsWith("-")) {
			SVGErrors.error("Invalid Height: " + heightStr);
		}
		SVGLength x = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		x.setValueAsString(xStr);
		SVGLength y = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		y.setValueAsString(yStr);
		SVGLength width = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		width.setValueAsString(widthStr);
		SVGLength height = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		height.setValueAsString(heightStr);
		SVGAnimatedLength ax = new SVGAnimatedLength.Implementation(x, x);
		SVGAnimatedLength ay = new SVGAnimatedLength.Implementation(y, y);
		SVGAnimatedLength awidth = new SVGAnimatedLength.Implementation(width, width);
		SVGAnimatedLength aheight = new SVGAnimatedLength.Implementation(height, height);
		ArrayList<String> filterResStr = StringUtils.splitByWhitespace(element.getAttribute(Attributes.FILTER_RES));
		float filterResXRaw = 0, filterResYRaw = 0;
		if (filterResStr.size() == 1) {
			filterResXRaw = Float.parseFloat(filterResStr.get(0));
			filterResYRaw = Float.parseFloat(filterResStr.get(0));
		}
		else if (filterResStr.size() == 2) {
			filterResXRaw = Float.parseFloat(filterResStr.get(0));
			filterResYRaw = Float.parseFloat(filterResStr.get(1));
		}
		else if (filterResStr.size() == 3) {
			filterResXRaw = Float.parseFloat(filterResStr.get(0));
			filterResYRaw = Float.parseFloat(filterResStr.get(2));
		}
		else {
			SVGErrors.error("Invalid filterRes: " + element.getAttribute(Attributes.FILTER_RES));
		}
		SVGAnimatedInteger filterResX = new SVGAnimatedInteger.Implementation((int) filterResXRaw, (int) filterResXRaw);
		SVGAnimatedInteger filterResY = new SVGAnimatedInteger.Implementation((int) filterResYRaw, (int) filterResYRaw);
		// Get default values
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String xmlLang = element.getAttribute(Attributes.XML_LANG);
		if (xmlLang == null) {
			xmlLang = "en";
		}
		String xmlSpace = element.getAttribute(Attributes.XML_SPACE);
		if (xmlSpace == null) {
			xmlSpace = "default";
		}
		String classNameAsString = element.getAttribute(Attributes.CLASS);
		SVGAnimatedString className = new SVGAnimatedString.Implementation(classNameAsString, classNameAsString);
		CSSStyleDeclarationImplementation style = new CSSStyleDeclarationImplementation(parsingState.findParentRule());
		style.setCssText(ElementParser.readOrDefault(element, Attributes.STYLE, ""));
		ElementParser.parseStyleFromAttributes(element, style);
		boolean externalResourcesRequiredAsBoolean = Boolean.parseBoolean(ElementParser.readOrDefault(element, Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(false)));
		SVGAnimatedBoolean externalResourcesRequired = new SVGAnimatedBoolean.Implementation(externalResourcesRequiredAsBoolean, externalResourcesRequiredAsBoolean);
		return new SVGFilterElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, 
				href, xmlLang, xmlSpace, externalResourcesRequired, className, style, filterUnits, 
				primitiveUnits, ax, ay, awidth, aheight, filterResX, filterResY);
	}

	@Override
	public Element writeElement(SVGFilterElement element, ElementFactory factory) {

		return null;
	}

}
