package org.w3c.dom.svg.parser;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.SVGAngle;
import org.w3c.dom.svg.SVGAnimatedAngle;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio;
import org.w3c.dom.svg.SVGAnimatedRect;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGMarkerElement;
import org.w3c.dom.svg.SVGPreserveAspectRatio;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.document.SVGSVGElement;

public class SVGMarkerElementParser implements ElementParser<SVGMarkerElement> {

	private HashMap<String, Short> strToEnum = new HashMap<>();
	private HashMap<Short, String> enumToStr = new HashMap<>();
	
	public SVGMarkerElementParser() {
		strToEnum.put("strokeWidth", SVGMarkerElement.SVG_MARKERUNITS_STROKEWIDTH);
		strToEnum.put("userSpaceOnuse", SVGMarkerElement.SVG_MARKERUNITS_USERSPACEONUSE);
		enumToStr.put(SVGMarkerElement.SVG_MARKERUNITS_STROKEWIDTH, "strokeWidth");
		enumToStr.put(SVGMarkerElement.SVG_MARKERUNITS_USERSPACEONUSE, "userSpaceOnuse");
	}
	
	@Override
	public SVGMarkerElement readElement(Element element, ParsingState parsingState) {
		String viewBoxStr = element.getAttribute(Attributes.VIEW_BOX);
		SVGAnimatedRect viewBox = null;
		if (viewBoxStr != null) {
			ArrayList<String> viewBoxStrValues = StringUtils.splitByWhitespace(viewBoxStr);
			SVGRect viewBoxValue = new SVGRect.Implementation(Float.parseFloat(viewBoxStrValues.get(0)), Float.parseFloat(viewBoxStrValues.get(1)),
					Float.parseFloat(viewBoxStrValues.get(2)), Float.parseFloat(viewBoxStrValues.get(3)));
			viewBox = new SVGAnimatedRect.Implementation(viewBoxValue, viewBoxValue);
		}
		String refXStr = ElementParser.readOrDefault(element, Attributes.REF_X, "0");
		SVGLength refX = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		refX.setValueAsString(refXStr);
		SVGAnimatedLength arefX = new SVGAnimatedLength.Implementation(refX, refX);
		String refYStr = ElementParser.readOrDefault(element, Attributes.REF_Y, "0");
		SVGLength refY = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		refY.setValueAsString(refYStr);
		SVGAnimatedLength arefY = new SVGAnimatedLength.Implementation(refY, refY);
		String markerWidthStr = ElementParser.readOrDefault(element, Attributes.MARKER_WIDTH, "3");
		if (markerWidthStr.startsWith("-")) {
			SVGErrors.error("Invalid markerWidth: " + markerWidthStr);
		}
		SVGLength markerWidth = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		markerWidth.setValueAsString(markerWidthStr);
		SVGAnimatedLength amarkerWidth = new SVGAnimatedLength.Implementation(markerWidth, markerWidth);
		String markerHeightStr = ElementParser.readOrDefault(element, Attributes.MARKER_HEIGHT, "3");
		if (markerHeightStr.startsWith("-")) {
			SVGErrors.error("Invalid markerHeight: " + markerHeightStr);
		}
		SVGLength markerHeight = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
		markerHeight.setValueAsString(markerHeightStr);
		SVGAnimatedLength amarkerHeight = new SVGAnimatedLength.Implementation(markerHeight, markerHeight);
		String orientStr = element.getAttribute(Attributes.ORIENT);
		SVGAnimatedAngle aorientAngle = null;
		short orientTypeEnum;
		if (orientStr.equals("auto")) {
			orientTypeEnum = SVGMarkerElement.SVG_MARKER_ORIENT_AUTO;
		} else {
			orientTypeEnum = SVGMarkerElement.SVG_MARKER_ORIENT_ANGLE;
			SVGAngle orientAngle = new SVGAngle.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0);
			orientAngle.setValueAsString(orientStr);
			aorientAngle = new SVGAnimatedAngle.Implementation(orientAngle, orientAngle);
		}
		SVGAnimatedEnumeration orientType = new SVGAnimatedEnumeration.Implementation(orientTypeEnum, orientTypeEnum);
		String markerUnitsStr = ElementParser.readOrDefault(element, Attributes.MARKER_UNITS, "strokeWidth");
		short markerUnitsEnum = strToEnum.get(markerUnitsStr);
		SVGAnimatedEnumeration markerUnits = new SVGAnimatedEnumeration.Implementation(markerUnitsEnum, markerUnitsEnum);
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
		boolean externalResourcesRequiredAsBoolean = Boolean.parseBoolean(ElementParser.readOrDefault(element, Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(false)));
		SVGAnimatedBoolean externalResourcesRequired = new SVGAnimatedBoolean.Implementation(externalResourcesRequiredAsBoolean, externalResourcesRequiredAsBoolean);
		SVGPreserveAspectRatio.Implementation preserveAspectRatioValue = new SVGPreserveAspectRatio.Implementation();
		ArrayList<String> preserveAspectRatioParts = StringUtils.splitByWhitespace(element.getAttribute(Attributes.PRESERVE_ASPECT_RATIO));
		preserveAspectRatioValue.setFromString(preserveAspectRatioParts.get(0), preserveAspectRatioParts.size() > 1 ? null : preserveAspectRatioParts.get(1));
		SVGAnimatedPreserveAspectRatio preserveAspectRatio = new SVGAnimatedPreserveAspectRatio.Implementation(preserveAspectRatioValue, preserveAspectRatioValue);
		return new SVGMarkerElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement,
				xmlLang, xmlSpace, className, style, externalResourcesRequired, 
				viewBox, preserveAspectRatio, arefX, arefY, markerUnits, amarkerWidth, 
				amarkerHeight, orientType, aorientAngle);
	}

	@Override
	public Element writeElement(SVGMarkerElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.MARKER_UNITS, enumToStr.get(element.getMarkerUnits().getBaseValue()));
		attributes.put(Attributes.REF_X, element.getRefX().getBaseValue().getValueAsString());
		attributes.put(Attributes.REF_Y, element.getRefY().getBaseValue().getValueAsString());
		attributes.put(Attributes.MARKER_WIDTH, element.getMarkerWidth().getBaseValue().getValueAsString());
		attributes.put(Attributes.MARKER_HEIGHT, element.getMarkerHeight().getBaseValue().getValueAsString());
		attributes.put(Attributes.ORIENT, element.getOrientType().getBaseValue().equals(SVGMarkerElement.SVG_MARKER_ORIENT_AUTO) ? 
				enumToStr.get(SVGMarkerElement.SVG_MARKER_ORIENT_AUTO) : element.getOrientAngle().getBaseValue().getValueAsString());
		attributes.put(Attributes.VIEW_BOX, element.getViewBox().getBaseValue().getX() + " " + element.getViewBox().getBaseValue().getY() + " " + 
				element.getViewBox().getBaseValue().getWidth() + " " + element.getViewBox().getBaseValue().getHeight());
		SVGPreserveAspectRatio preserveAspectRatio = element.getPreserveAspectRatio().getBaseValue();
		SVGPreserveAspectRatio.Implementation preserveAspectRatioImpl = null;
		if (preserveAspectRatio instanceof SVGPreserveAspectRatio.Implementation) {
			preserveAspectRatioImpl = (SVGPreserveAspectRatio.Implementation) preserveAspectRatio;
		} else {
			preserveAspectRatioImpl = new SVGPreserveAspectRatio.Implementation();
			preserveAspectRatioImpl.setAlign(preserveAspectRatio.getAlign());
			preserveAspectRatioImpl.setMeetOrSlice(preserveAspectRatio.getMeetOrSlice());
		}
		attributes.put(Attributes.PRESERVE_ASPECT_RATIO, preserveAspectRatioImpl.getAsString());
		attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(element.getExternalResourcesRequired().getBaseValue()));
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		attributes.put(Attributes.STYLE, element.getStyle().getCssText());
		return factory.createElement(Tags.MARKER, attributes);
	}

}
