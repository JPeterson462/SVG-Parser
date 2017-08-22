package org.w3c.dom.svg.parser.text;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;
import org.w3c.dom.svg.text.SVGGlyphRefElement;

public class SVGGlyphRefElementParser implements ElementParser<SVGGlyphRefElement> {

	@Override
	public SVGGlyphRefElement readElement(Element element, ParsingState parsingState) {
		String href = element.getAttribute(Attributes.XLINK_HREF);
		SVGAnimatedString ahref = new SVGAnimatedString.Implementation(href, href);
		String glyphRef = element.getAttribute(Attributes.GLYPH_REF);
		String format = element.getAttribute(Attributes.FORMAT);
		String xStr = ElementParser.readOrDefault(element, Attributes.X, "0");
		String yStr = ElementParser.readOrDefault(element, Attributes.Y, "0");
		String dxStr = ElementParser.readOrDefault(element, Attributes.DX, "");
		String dyStr = ElementParser.readOrDefault(element, Attributes.DY, "");
		float x = Float.parseFloat(xStr);
		float y = Float.parseFloat(yStr);
		float dx = Float.parseFloat(dxStr);
		float dy = Float.parseFloat(dyStr);
		// Get default values
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getOwnerSVGElement();
		String classNameAsString = element.getAttribute(Attributes.CLASS);
		SVGAnimatedString className = new SVGAnimatedString.Implementation(classNameAsString, classNameAsString);
		CSSStyleDeclarationImplementation style = new CSSStyleDeclarationImplementation(parsingState.findParentRule());
		style.setCssText(ElementParser.readOrDefault(element, Attributes.STYLE, ""));
		ElementParser.parseStyleFromAttributes(element, style);
		return new SVGGlyphRefElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement,
				ahref, className, style, glyphRef, format, x, y, dx, dy);
	}

	@Override
	public Element writeElement(SVGGlyphRefElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.XLINK_HREF, element.getHref().getBaseValue());
		attributes.put(Attributes.GLYPH_REF, element.getGlyphRef());
		attributes.put(Attributes.FORMAT, element.getFormat());
		attributes.put(Attributes.X, Float.toString(element.getX()));
		attributes.put(Attributes.Y, Float.toString(element.getY()));
		attributes.put(Attributes.DX, Float.toString(element.getDX()));
		attributes.put(Attributes.DY, Float.toString(element.getDY()));
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		attributes.put(Attributes.STYLE, element.getStyle().getCssText());
		return factory.createElement(Tags.GLYPH_REF, attributes);
	}

}
