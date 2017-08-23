package org.w3c.dom.svg.parser.fonts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.fonts.SVGGlyphElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
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
		String unicode = element.getAttribute(Attributes.UNICODE);
		String[] glyphNames = element.getAttribute(Attributes.GLYPH_NAME).split(",");
		ArrayList<String> glyphNameList = new ArrayList<>();
		for (int i = 0; i < glyphNames.length; i++) {
			glyphNameList.add(glyphNames[i].trim());
		}
		SVGStringList glyphName = new SVGStringList.Implementation(glyphNameList);
		SVGPathSegList pathData = ElementParser.parsePathSegList(element.getAttribute(Attributes.D));
		short orientation = orientation_strToEnum.get(element.getAttribute(Attributes.ORIENTATION));
		short arabicForm = arabicForm_strToEnum.get(element.getAttribute(Attributes.ARABIC_FORM));
		SVGStringList lang = new SVGStringList.Implementation(Arrays.asList(element.getAttribute(Attributes.LANG).split(",")));
		
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
		SVGElement nearestViewportElement = ElementParser.getNearestViewportElement(parsingState);
		SVGElement farthestViewportElement = ElementParser.getFarthestViewportElement(parsingState);
		SVGAnimatedTransformList transform = ElementParser.parseTransforms(element);
		return new SVGGlyphElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, className,
				style, unicode, glyphName, pathData, orientation, arabicForm, lang, horizontalAdvanceX,
				verticalOriginX, verticalOriginY, verticalAdvanceY);
	}

	@Override
	public Element writeElement(SVGGlyphElement element, ElementFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

}
