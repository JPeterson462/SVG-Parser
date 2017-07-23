package org.w3c.dom.svg.parser.document;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;

public class SVGSVGElementParser implements ElementParser<SVGSVGElement> {

	@Override
	public SVGSVGElement readElement(Element element, ParsingState parsingState) {
		String version = element.getAttribute(Attributes.VERSION);
		String baseProfile = ElementParser.readOrDefault(element, Attributes.BASE_PROFILE, "none");
		String xStr = element.getAttribute(Attributes.X);
		//TODO
		return null;
	}

	@Override
	public Element writeElement(SVGSVGElement element, ElementFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

}
