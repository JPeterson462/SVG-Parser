package org.w3c.dom.svg.parser.text;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedLengthList;
import org.w3c.dom.svg.SVGAnimatedNumberList;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGLengthList;
import org.w3c.dom.svg.SVGNumberList;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;
import org.w3c.dom.svg.text.SVGAltGlyphElement;
import org.w3c.dom.svg.text.SVGTextContentElement;

public class SVGAltGlyphElementParser implements ElementParser<SVGAltGlyphElement> {

	private HashMap<Short, String> enumToStr = new HashMap<>();
	private HashMap<String, Short> strToEnum = new HashMap<>();
	
	public SVGAltGlyphElementParser() {
		enumToStr.put(SVGTextContentElement.LENGTHADJUST_SPACING, "spacing");
		strToEnum.put("spacing", SVGTextContentElement.LENGTHADJUST_SPACING);
		enumToStr.put(SVGTextContentElement.LENGTHADJUST_SPACINGANDGLYPHS, "spacingAndGlyphs");
		strToEnum.put("spacingAndGlyphs", SVGTextContentElement.LENGTHADJUST_SPACINGANDGLYPHS);
	}
	
	@Override
	public SVGAltGlyphElement readElement(Element element, ParsingState parsingState) {
		String href = element.getAttribute(Attributes.XLINK_HREF);
		SVGAnimatedString ahref = new SVGAnimatedString.Implementation(href, href);
		String glyphRef = element.getAttribute(Attributes.GLYPH_REF);
		String format = element.getAttribute(Attributes.FORMAT);
		String xStr = ElementParser.readOrDefault(element, Attributes.X, "0");
		SVGLengthList x = ElementParser.parseLengthList(xStr, parsingState);
		SVGAnimatedLengthList ax = new SVGAnimatedLengthList.Implementation(x, x);
		String yStr = ElementParser.readOrDefault(element, Attributes.Y, "0");
		SVGLengthList y = ElementParser.parseLengthList(yStr, parsingState);
		SVGAnimatedLengthList ay = new SVGAnimatedLengthList.Implementation(y, y);
		String dxStr = ElementParser.readOrDefault(element, Attributes.DX, "");
		SVGLengthList dx = ElementParser.parseLengthList(dxStr, parsingState);
		SVGAnimatedLengthList adx = new SVGAnimatedLengthList.Implementation(dx, dx);
		String dyStr = ElementParser.readOrDefault(element, Attributes.DY, "");
		SVGLengthList dy = ElementParser.parseLengthList(dyStr, parsingState);
		SVGAnimatedLengthList ady = new SVGAnimatedLengthList.Implementation(dy, dy);
		String rotateStr = ElementParser.readOrDefault(element, Attributes.ROTATE, "");
		SVGNumberList rotate = ElementParser.parseNumberList(rotateStr);
		SVGAnimatedNumberList arotate = new SVGAnimatedNumberList.Implementation(rotate, rotate);
		String textLengthStr = ElementParser.readOrDefault(element, Attributes.TEXT_LENGTH, "0");
		if (textLengthStr.startsWith("-")) {
			SVGErrors.error("Invalid Length: " + textLengthStr);
		}
		SVGLength textLength = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		textLength.setValueAsString(textLengthStr);
		SVGAnimatedLength atextLength = new SVGAnimatedLength.Implementation(textLength, textLength);
		String lengthAdjustStr = ElementParser.readOrDefault(element, Attributes.LENGTH_ADJUST, "spacing");
		short lengthAdjustEnum = strToEnum.get(lengthAdjustStr);
		SVGAnimatedEnumeration lengthAdjust = new SVGAnimatedEnumeration.Implementation(lengthAdjustEnum, lengthAdjustEnum);
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
		String classNameAsString = element.getAttribute(Attributes.CLASS);
		SVGAnimatedString className = new SVGAnimatedString.Implementation(classNameAsString, classNameAsString);
		CSSStyleDeclarationImplementation style = new CSSStyleDeclarationImplementation(parsingState.findParentRule());
		style.setCssText(ElementParser.readOrDefault(element, Attributes.STYLE, ""));
		ElementParser.parseStyleFromAttributes(element, style);
		SVGStringList requiredFeatures = ElementParser.concatenate(element.getAttribute(Attributes.REQUIRED_FEATURES).split(" "));
		SVGStringList requiredExtensions = ElementParser.concatenate(element.getAttribute(Attributes.REQUIRED_EXTENSIONS).split(" "));
		SVGStringList systemLanguage = ElementParser.concatenate(element.getAttribute(Attributes.SYSTEM_LANGUAGE).split(" "));
		boolean externalResourcesRequiredAsBoolean = Boolean.parseBoolean(ElementParser.readOrDefault(element, Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(false)));
		SVGAnimatedBoolean externalResourcesRequired = new SVGAnimatedBoolean.Implementation(externalResourcesRequiredAsBoolean, externalResourcesRequiredAsBoolean);
		return new SVGAltGlyphElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, ax,
				ay, adx, ady, arotate, ahref, glyphRef, format, xmlLang, xmlSpace, className, style,
				requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired, atextLength, lengthAdjust);
	}

	@Override
	public Element writeElement(SVGAltGlyphElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<String, String>();
		attributes.put(Attributes.X, ElementParser.convertLengthList(element.getX().getBaseValue()));
		attributes.put(Attributes.Y, ElementParser.convertLengthList(element.getY().getBaseValue()));
		attributes.put(Attributes.DX, ElementParser.convertLengthList(element.getDX().getBaseValue()));
		attributes.put(Attributes.DY, ElementParser.convertLengthList(element.getDY().getBaseValue()));
		attributes.put(Attributes.ROTATE, ElementParser.convertNumberList(element.getRotate().getBaseValue()));
		attributes.put(Attributes.TEXT_LENGTH, element.getTextLength().getBaseValue().getValueAsString());
		attributes.put(Attributes.LENGTH_ADJUST, enumToStr.get(element.getLengthAdjust().getBaseValue()));
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.XML_LANG, element.getXMLLang());
		attributes.put(Attributes.XML_SPACE, element.getXMLSpace());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		attributes.put(Attributes.STYLE, element.getStyle().getCssText());
		attributes.put(Attributes.REQUIRED_FEATURES, ElementParser.join(element.getRequiredFeatures(), " "));
		attributes.put(Attributes.REQUIRED_EXTENSIONS, ElementParser.join(element.getRequiredExtensions(), " "));
		attributes.put(Attributes.SYSTEM_LANGUAGE, ElementParser.join(element.getSystemLanguage(), " "));
		attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(element.getExternalResourcesRequired().getBaseValue()));
		attributes.put(Attributes.GLYPH_REF, element.getGlyphRef());
		attributes.put(Attributes.FORMAT, element.getFormat());
		attributes.put(Attributes.XLINK_HREF, element.getHref().getBaseValue());
		return factory.createElement(Tags.ALT_GLYPH, attributes);
	}

}
