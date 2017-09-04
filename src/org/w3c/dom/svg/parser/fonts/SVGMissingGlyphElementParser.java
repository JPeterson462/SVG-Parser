package org.w3c.dom.svg.parser.fonts;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.fonts.SVGGlyphElement;
import org.w3c.dom.svg.fonts.SVGMissingGlyphElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;
import org.w3c.dom.svg.paths.SVGPathSegList;

public class SVGMissingGlyphElementParser implements ElementParser<SVGMissingGlyphElement> {

	private HashMap<String, Short> orientation_strToEnum = new HashMap<>();
	private HashMap<Short, String> orientation_enumToStr = new HashMap<>();
	private HashMap<String, Short> arabicForm_strToEnum = new HashMap<>();
	private HashMap<Short, String> arabicForm_enumToStr = new HashMap<>();
	
	public SVGMissingGlyphElementParser() {
		orientation_strToEnum.put("h", SVGGlyphElement.SVG_GLYPHORIENTATION_H);
		orientation_strToEnum.put("v", SVGGlyphElement.SVG_GLYPHORIENTATION_V);
		orientation_enumToStr.put(SVGGlyphElement.SVG_GLYPHORIENTATION_H, "h");
		orientation_enumToStr.put(SVGGlyphElement.SVG_GLYPHORIENTATION_V, "v");
		arabicForm_strToEnum.put("initial", SVGGlyphElement.SVG_ARABICFORM_INITIAL);
		arabicForm_strToEnum.put("medial", SVGGlyphElement.SVG_ARABICFORM_MEDIAL);
		arabicForm_strToEnum.put("terminal", SVGGlyphElement.SVG_ARABICFORM_TERMINAL);
		arabicForm_strToEnum.put("isolated", SVGGlyphElement.SVG_ARABICFORM_ISOLATED);
		arabicForm_enumToStr.put(SVGGlyphElement.SVG_ARABICFORM_INITIAL, "initial");
		arabicForm_enumToStr.put(SVGGlyphElement.SVG_ARABICFORM_MEDIAL, "medial");
		arabicForm_enumToStr.put(SVGGlyphElement.SVG_ARABICFORM_TERMINAL, "terminal");
		arabicForm_enumToStr.put(SVGGlyphElement.SVG_ARABICFORM_ISOLATED, "isolated");
	}
	
	@Override
	public SVGMissingGlyphElement readElement(Element element, ParsingState parsingState) {
		SVGPathSegList pathData = ElementParser.parsePathSegList(ElementParser.read(element, Attributes.D));
		String horizontalAdvanceXStr = ElementParser.read(element, Attributes.HORIZ_ADV_X);
		SVGNumber horizontalAdvanceX = new SVGNumber.Implementation(Float.parseFloat(horizontalAdvanceXStr));
		String verticalOriginXStr = ElementParser.read(element, Attributes.VERT_ORIGIN_X);
		SVGNumber verticalOriginX = new SVGNumber.Implementation(Float.parseFloat(verticalOriginXStr));
		String verticalOriginYStr = ElementParser.read(element, Attributes.VERT_ORIGIN_Y);
		SVGNumber verticalOriginY = new SVGNumber.Implementation(Float.parseFloat(verticalOriginYStr));
		String verticalAdvanceYStr = ElementParser.read(element, Attributes.VERT_ADV_Y);
		SVGNumber verticalAdvanceY = new SVGNumber.Implementation(Float.parseFloat(verticalAdvanceYStr));
		// Get default values
		String id = ElementParser.read(element, Attributes.ID);
		String xmlBase = ElementParser.read(element, Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String classNameAsString = ElementParser.read(element, Attributes.CLASS);
		SVGAnimatedString className = new SVGAnimatedString.Implementation(classNameAsString, classNameAsString);
		CSSStyleDeclarationImplementation style = new CSSStyleDeclarationImplementation(parsingState.findParentRule());
		style.setCssText(ElementParser.readOrDefault(element, Attributes.STYLE, ""));
		ElementParser.parseStyleFromAttributes(element, style);
		return new SVGMissingGlyphElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, className,
				style, pathData, horizontalAdvanceX, verticalOriginX, verticalOriginY, verticalAdvanceY);
	}

	@Override
	public Element writeElement(SVGMissingGlyphElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.D, ElementParser.join(element.getPathData(), " "));
		attributes.put(Attributes.HORIZ_ADV_X, Float.toString(element.getHorizontalAdvanceX().getValue()));
		attributes.put(Attributes.VERT_ORIGIN_X, Float.toString(element.getVerticalOriginX().getValue()));
		attributes.put(Attributes.VERT_ORIGIN_Y, Float.toString(element.getVerticalOriginY().getValue()));
		attributes.put(Attributes.VERT_ADV_Y, Float.toString(element.getVerticalAdvanceY().getValue()));
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		attributes.put(Attributes.STYLE, element.getStyle().getCssText());
		return factory.createElement(Tags.MISSING_GLYPH, attributes);
	}

}
