package org.w3c.dom.svg.parser.filters;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.filters.SVGFESpotLightElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGFESpotLightElementParser implements ElementParser<SVGFESpotLightElement> {

	@Override
	public SVGFESpotLightElement readElement(Element element, ParsingState parsingState) {
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		float xBase = Float.parseFloat(element.getAttribute(Attributes.X));
		float yBase = Float.parseFloat(element.getAttribute(Attributes.Y));
		float zBase = Float.parseFloat(element.getAttribute(Attributes.Z));
		SVGAnimatedNumber x = new SVGAnimatedNumber.Implementation(xBase, xBase);
		SVGAnimatedNumber y = new SVGAnimatedNumber.Implementation(yBase, yBase);
		SVGAnimatedNumber z = new SVGAnimatedNumber.Implementation(zBase, zBase);
		float pointsxBase = Float.parseFloat(element.getAttribute(Attributes.POINTSATX));
		float pointsyBase = Float.parseFloat(element.getAttribute(Attributes.POINTSATY));
		float pointszBase = Float.parseFloat(element.getAttribute(Attributes.POINTSATZ));
		SVGAnimatedNumber pointsAtX = new SVGAnimatedNumber.Implementation(pointsxBase, pointsxBase);
		SVGAnimatedNumber pointsAtY = new SVGAnimatedNumber.Implementation(pointsyBase, pointsyBase);
		SVGAnimatedNumber pointsAtZ = new SVGAnimatedNumber.Implementation(pointszBase, pointszBase);
		float specularExponentBase = Float.parseFloat(element.getAttribute(Attributes.SPECULAR_EXPONENT));
		float limitingConeAngleBase = Float.parseFloat(element.getAttribute(Attributes.LIMITING_CONE_ANGLE));
		SVGAnimatedNumber specularExponent = new SVGAnimatedNumber.Implementation(specularExponentBase, specularExponentBase);
		SVGAnimatedNumber limitingConeAngle = new SVGAnimatedNumber.Implementation(limitingConeAngleBase, limitingConeAngleBase);
		return new SVGFESpotLightElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement,
				x, y, z, pointsAtX, pointsAtY, pointsAtZ, specularExponent, limitingConeAngle);
	}

	@Override
	public Element writeElement(SVGFESpotLightElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.X, Float.toString(element.getX().getBaseValue()));
		attributes.put(Attributes.Y, Float.toString(element.getY().getBaseValue()));
		attributes.put(Attributes.Z, Float.toString(element.getZ().getBaseValue()));
		attributes.put(Attributes.POINTSATX, Float.toString(element.getPointsAtX().getBaseValue()));
		attributes.put(Attributes.POINTSATY, Float.toString(element.getPointsAtY().getBaseValue()));
		attributes.put(Attributes.POINTSATZ, Float.toString(element.getPointsAtZ().getBaseValue()));
		attributes.put(Attributes.SPECULAR_EXPONENT, Float.toString(element.getSpecularExponent().getBaseValue()));
		attributes.put(Attributes.LIMITING_CONE_ANGLE, Float.toString(element.getLimitingConeAngle().getBaseValue()));
		return factory.createElement(Tags.FE_SPOTLIGHT, attributes);
	}

}
