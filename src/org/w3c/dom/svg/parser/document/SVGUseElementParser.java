package org.w3c.dom.svg.parser.document;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGDimensioned;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGLocatable;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGElementInstance;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.document.SVGUseElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGUseElementParser implements ElementParser<SVGUseElement> {

	private float[] computeBounds(Element element, SVGElementInstance instanceRoot) {
		SVGElement svgElement = instanceRoot.getCorrespondingElement();
		if (svgElement instanceof SVGLocatable) {
			SVGRect bounds = ((SVGLocatable) svgElement).getBBox();
			return new float[] { bounds.getWidth(), bounds.getHeight() };
		}
		if (svgElement instanceof SVGDimensioned) {
			SVGDimensioned dimensioned = (SVGDimensioned) svgElement;
			return new float[] { dimensioned.getWidth().getBaseValue().getValue(), dimensioned.getHeight().getBaseValue().getValue() };
		}
		return new float[] { 0, 0 }; // TODO
	}
	
	@Override
	public SVGUseElement readElement(Element element, ParsingState parsingState) {
		// Attributes
		String hrefStr = element.getAttribute(Attributes.XLINK_HREF);
		SVGAnimatedString href = new SVGAnimatedString.Implementation(hrefStr, hrefStr);
		SVGElementInstance instanceRoot = parsingState.getElement(hrefStr).createInstance();
		String xStr = ElementParser.readOrDefault(element, Attributes.X, "0");
		String yStr = ElementParser.readOrDefault(element, Attributes.Y, "0");
		float[] bounds = computeBounds(element, instanceRoot);
		String widthStr = ElementParser.readOrDefault(element, Attributes.WIDTH, Float.toString(bounds[0]));
		String heightStr = ElementParser.readOrDefault(element, Attributes.HEIGHT, Float.toString(bounds[1]));
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
		SVGStringList requiredFeatures = ElementParser.readOrNull(element, Attributes.REQUIRED_FEATURES, " ", true);
		SVGStringList requiredExtensions = ElementParser.readOrNull(element, Attributes.REQUIRED_EXTENSIONS, " ", true);
		SVGStringList systemLanguage = ElementParser.readOrNull(element, Attributes.SYSTEM_LANGUAGE, " ", true);
		boolean externalResourcesRequiredAsBoolean = Boolean.parseBoolean(ElementParser.readOrDefault(element, Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(false)));
		SVGAnimatedBoolean externalResourcesRequired = new SVGAnimatedBoolean.Implementation(externalResourcesRequiredAsBoolean, externalResourcesRequiredAsBoolean);
		SVGElement nearestViewportElement = ElementParser.getNearestViewportElement(parsingState);
		SVGElement farthestViewportElement = ElementParser.getFarthestViewportElement(parsingState);
		SVGAnimatedTransformList transform = ElementParser.parseTransforms(element);
		SVGUseElement useElement = new SVGUseElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement,
				xmlLang, xmlSpace, className, style, requiredFeatures, requiredExtensions,
				systemLanguage, externalResourcesRequired, nearestViewportElement, 
				farthestViewportElement, transform, href, ax, ay, awidth, aheight,
				instanceRoot, instanceRoot);
		useElement.getInstanceRoot().connect(useElement);
		useElement.getAnimatedInstanceRoot().connect(useElement);
		return useElement;
	}

	@Override
	public Element writeElement(SVGUseElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.XLINK_HREF, element.getHref().getBaseValue());
//		attributes.put(Attributes.X, element.getX().getBaseValue().getValueAsString());
//		attributes.put(Attributes.Y, element.getY().getBaseValue().getValueAsString());
//		attributes.put(Attributes.WIDTH, element.getWidth().getBaseValue().getValueAsString());
//		attributes.put(Attributes.HEIGHT, element.getHeight().getBaseValue().getValueAsString());
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.XML_LANG, element.getXMLLang());
		attributes.put(Attributes.XML_SPACE, element.getXMLSpace());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		attributes.put(Attributes.STYLE, element.getStyle().getCssText());
		attributes.put(Attributes.REQUIRED_FEATURES, ElementParser.join(element.getRequiredFeatures(), " "));
		attributes.put(Attributes.REQUIRED_EXTENSIONS, ElementParser.join(element.getRequiredExtensions(), " "));
		attributes.put(Attributes.SYSTEM_LANGUAGE, ElementParser.join(element.getSystemLanguage(), " "));
		attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, element.getExternalResourcesRequired().getBaseValue().toString());
		attributes.put(Attributes.TRANSFORM, ElementParser.getTransforms(element.getTransform()));
		return factory.createElement(Tags.USE, attributes);
	}

}
