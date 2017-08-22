package org.w3c.dom.svg.parser;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGColorProfileElement;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGRenderingIntent;
import org.w3c.dom.svg.document.SVGSVGElement;

public class SVGColorProfileElementParser implements ElementParser<SVGColorProfileElement> {

	private HashMap<String, Short> strToEnum = new HashMap<>();
	private HashMap<Short, String> enumToStr = new HashMap<>();
	
	public SVGColorProfileElementParser() {
		register("auto", SVGRenderingIntent.RENDERING_INTENT_AUTO);
		register("perceptual", SVGRenderingIntent.RENDERING_INTENT_PERCEPTUAL);
		register("relative-colorimetric", SVGRenderingIntent.RENDERING_INTENT_RELATIVE_COLORIMETRIC);
		register("saturation", SVGRenderingIntent.RENDERING_INTENT_SATURATION);
		register("absolute-colorimetric", SVGRenderingIntent.RENDERING_INTENT_ABSOLUTE_COLORIMETRIC);
	}
	
	private void register(String str, short enumVal) {
		strToEnum.put(str, enumVal);
		enumToStr.put(enumVal, str);
	}
	
	@Override
	public SVGColorProfileElement readElement(Element element, ParsingState parsingState) {
		String href = element.getAttribute(Attributes.XLINK_HREF);
		SVGAnimatedString ahref = new SVGAnimatedString.Implementation(href, href);
		String local = element.getAttribute(Attributes.LOCAL);
		String name = element.getAttribute(Attributes.NAME);
		String renderingIntentStr = element.getAttribute(Attributes.RENDERING_INDENT);
		short renderingIntent = strToEnum.get(renderingIntentStr);
		// Get default values
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getOwnerSVGElement();
		return new SVGColorProfileElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement,
				ahref, local, name, renderingIntent);
	}

	@Override
	public Element writeElement(SVGColorProfileElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.XLINK_HREF, element.getHref().getBaseValue());
		attributes.put(Attributes.LOCAL, element.getLocal());
		attributes.put(Attributes.NAME, element.getName());
		attributes.put(Attributes.RENDERING_INDENT, enumToStr.get(element.getRenderingIntent()));
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		return factory.createElement(Tags.COLOR_PROFILE, attributes);
	}

}
