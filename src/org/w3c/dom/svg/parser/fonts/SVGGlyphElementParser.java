package org.w3c.dom.svg.parser.fonts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.fonts.SVGFontElement;
import org.w3c.dom.svg.fonts.SVGGlyphElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;
import org.w3c.dom.svg.paths.SVGPathSegList;

public class SVGGlyphElementParser implements ElementParser<SVGGlyphElement> {

	private HashMap<String, Short> orientation_strToEnum = new HashMap<>();
	private HashMap<Short, String> orientation_enumToStr = new HashMap<>();
	private HashMap<String, Short> arabicForm_strToEnum = new HashMap<>();
	private HashMap<Short, String> arabicForm_enumToStr = new HashMap<>();
	
	public SVGGlyphElementParser() {
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
	public SVGGlyphElement readElement(Element element, ParsingState parsingState) {
		SVGFontElement fontElement = (SVGFontElement) parsingState.getCurrentParent();
		String unicode = ElementParser.read(element, Attributes.UNICODE);
		String[] glyphNames = ElementParser.read(element, Attributes.GLYPH_NAME).split(",");
		ArrayList<String> glyphNameList = new ArrayList<>();
		for (int i = 0; i < glyphNames.length; i++) {
			glyphNameList.add(glyphNames[i].trim());
		}
		SVGStringList glyphName = new SVGStringList.Implementation(glyphNameList);
		SVGPathSegList pathData = ElementParser.parsePathSegList(ElementParser.read(element, Attributes.D));
		short orientation = orientation_strToEnum.getOrDefault(ElementParser.read(element, Attributes.ORIENTATION), SVGGlyphElement.SVG_GLYPHORIENTATION_BOTH);
		short arabicForm = arabicForm_strToEnum.getOrDefault(ElementParser.read(element, Attributes.ARABIC_FORM), SVGGlyphElement.SVG_ARABICFORM_INITIAL);
		SVGStringList lang = new SVGStringList.Implementation(Arrays.asList(ElementParser.read(element, Attributes.LANG).split(",")));
		String horizontalAdvanceXStr = ElementParser.readOrDefault(element, Attributes.HORIZ_ADV_X, Float.toString(fontElement.getHorizontalAdvanceX().getValue()));
		SVGNumber horizontalAdvanceX = new SVGNumber.Implementation(Float.parseFloat(horizontalAdvanceXStr));
		String verticalOriginXStr = ElementParser.readOrDefault(element, Attributes.VERT_ORIGIN_X, Float.toString(fontElement.getVerticalOriginX().getValue()));
		SVGNumber verticalOriginX = new SVGNumber.Implementation(Float.parseFloat(verticalOriginXStr));
		String verticalOriginYStr = ElementParser.readOrDefault(element, Attributes.VERT_ORIGIN_Y, Float.toString(fontElement.getVerticalOriginY().getValue()));
		SVGNumber verticalOriginY = new SVGNumber.Implementation(Float.parseFloat(verticalOriginYStr));
		String verticalAdvanceYStr = ElementParser.readOrDefault(element, Attributes.VERT_ADV_Y, Float.toString(fontElement.getVerticalAdvanceY().getValue()));
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
		return new SVGGlyphElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, className,
				style, unicode, glyphName, pathData, orientation, arabicForm, lang, horizontalAdvanceX,
				verticalOriginX, verticalOriginY, verticalAdvanceY);
	}

	@Override
	public Element writeElement(SVGGlyphElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.UNICODE, element.getUnicode());
		attributes.put(Attributes.GLYPH_NAME, ElementParser.join(element.getGlyphName(), ","));
		attributes.put(Attributes.D, ElementParser.join(element.getPathData(), " "));
		attributes.put(Attributes.ORIENTATION, orientation_enumToStr.get(element.getOrientation()));
		attributes.put(Attributes.ARABIC_FORM, arabicForm_enumToStr.get(element.getArabicForm()));
		attributes.put(Attributes.LANG, ElementParser.join(element.getLang(), ","));
		attributes.put(Attributes.HORIZ_ADV_X, Float.toString(element.getHorizontalAdvanceX().getValue()));
		attributes.put(Attributes.VERT_ORIGIN_X, Float.toString(element.getVerticalOriginX().getValue()));
		attributes.put(Attributes.VERT_ORIGIN_Y, Float.toString(element.getVerticalOriginY().getValue()));
		attributes.put(Attributes.VERT_ADV_Y, Float.toString(element.getVerticalAdvanceY().getValue()));
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		attributes.put(Attributes.STYLE, element.getStyle().getCssText());
		return factory.createElement(Tags.GLYPH, attributes);
	}

}
