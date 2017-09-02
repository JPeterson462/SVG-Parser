package org.w3c.dom.svg.parser.fonts;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGUnicodeRange;
import org.w3c.dom.svg.SVGUnicodeRangeList;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.fonts.SVGVKernElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGVKernElementParser implements ElementParser<SVGVKernElement> {

	@Override
	public SVGVKernElement readElement(Element element, ParsingState parsingState) {
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String u1Str = element.getAttribute(Attributes.U1);
		SVGUnicodeRangeList u1 = null;
		if (u1Str != null) {
			String[] u1Parts = u1Str.split(",");
			ArrayList<SVGUnicodeRange> u1List = new ArrayList<>();
			for (int i = 0; i < u1Parts.length; i++) {
				SVGUnicodeRange u = new SVGUnicodeRange.Implementation();
				String uVal = u1Parts[i].trim();
				if (uVal.length() == 1) {
					u.setValue("U+" + (int) uVal.charAt(0));
				} else {
					u.setValue(uVal);
				}
				u1List.add(u);
			}
			u1 = new SVGUnicodeRangeList.Implementation(u1List);
		}
		String g1Str = element.getAttribute(Attributes.G1);
		SVGStringList g1 = null;
		if (g1Str != null) {
			String[] g1Parts = g1Str.split(",");
			ArrayList<String> g1List = new ArrayList<>();
			for (int i = 0; i < g1Parts.length; i++) {
				g1List.add(g1Parts[i].trim());
			}
			g1 = new SVGStringList.Implementation(g1List);
		}
		String u2Str = element.getAttribute(Attributes.U2);
		SVGUnicodeRangeList u2 = null;
		if (u2Str != null) {
			String[] u2Parts = u2Str.split(",");
			ArrayList<SVGUnicodeRange> u2List = new ArrayList<>();
			for (int i = 0; i < u2Parts.length; i++) {
				SVGUnicodeRange u = new SVGUnicodeRange.Implementation();
				String uVal = u2Parts[i].trim();
				if (uVal.length() == 1) {
					u.setValue("U+" + (int) uVal.charAt(0));
				} else {
					u.setValue(uVal);
				}
				u2List.add(u);
			}
			u2 = new SVGUnicodeRangeList.Implementation(u2List);
		}
		String g2Str = element.getAttribute(Attributes.G2);
		SVGStringList g2 = null;
		if (g2Str != null) {
			String[] g2Parts = g2Str.split(",");
			ArrayList<String> g2List = new ArrayList<>();
			for (int i = 0; i < g2Parts.length; i++) {
				g2List.add(g2Parts[i].trim());
			}
			g2 = new SVGStringList.Implementation(g2List);
		}
		String kStr = element.getAttribute(Attributes.K);
		SVGNumber k = new SVGNumber.Implementation(Float.parseFloat(kStr));
		return new SVGVKernElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement,
				u1, g1, u2, g2, k);
	}

	@Override
	public Element writeElement(SVGVKernElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.U1, ElementParser.concatenate(element.getU1(), ", "));
		attributes.put(Attributes.G1, ElementParser.concatenate(element.getG1(), ", "));
		attributes.put(Attributes.U2, ElementParser.concatenate(element.getU2(), ", "));
		attributes.put(Attributes.G2, ElementParser.concatenate(element.getG2(), ", "));
		attributes.put(Attributes.K, Float.toString(element.getK().getValue()));
		return factory.createElement(Tags.VKERN, attributes);
	}

}
