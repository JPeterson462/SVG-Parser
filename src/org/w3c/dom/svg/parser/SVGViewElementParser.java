package org.w3c.dom.svg.parser;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio;
import org.w3c.dom.svg.SVGAnimatedRect;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGPreserveAspectRatio;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGViewElement;
import org.w3c.dom.svg.SVGZoomAndPan;
import org.w3c.dom.svg.document.SVGSVGElement;

public class SVGViewElementParser implements ElementParser<SVGViewElement> {

	private HashMap<String, Short> strToEnum = new HashMap<>();
	private HashMap<Short, String> enumToStr = new HashMap<>();
	
	public SVGViewElementParser() {
		strToEnum.put("disable", SVGZoomAndPan.SVG_ZOOMANDPAN_DISABLE);
		strToEnum.put("magnify", SVGZoomAndPan.SVG_ZOOMANDPAN_MAGNIFY);
		enumToStr.put(SVGZoomAndPan.SVG_ZOOMANDPAN_DISABLE, "disable");
		enumToStr.put(SVGZoomAndPan.SVG_ZOOMANDPAN_MAGNIFY, "magnify");
	}
	
	@Override
	public SVGViewElement readElement(Element element, ParsingState parsingState) {
		String viewBoxStr = ElementParser.read(element, Attributes.VIEW_BOX);
		SVGAnimatedRect viewBox = null;
		if (viewBoxStr != null) {
			ArrayList<String> viewBoxStrValues = StringUtils.splitByWhitespace(viewBoxStr);
			SVGRect viewBoxValue = new SVGRect.Implementation(Float.parseFloat(viewBoxStrValues.get(0)), Float.parseFloat(viewBoxStrValues.get(1)),
					Float.parseFloat(viewBoxStrValues.get(2)), Float.parseFloat(viewBoxStrValues.get(3)));
			viewBox = new SVGAnimatedRect.Implementation(viewBoxValue, viewBoxValue);
		}
		SVGPreserveAspectRatio.Implementation preserveAspectRatioValue = new SVGPreserveAspectRatio.Implementation();
		ArrayList<String> preserveAspectRatioParts = StringUtils.splitByWhitespace(ElementParser.readOrDefault(element, Attributes.PRESERVE_ASPECT_RATIO, "xMidYMid meet"));
		preserveAspectRatioValue.setFromString(preserveAspectRatioParts.get(0), preserveAspectRatioParts.size() == 1 ? null : preserveAspectRatioParts.get(1));
		SVGAnimatedPreserveAspectRatio preserveAspectRatio = new SVGAnimatedPreserveAspectRatio.Implementation(preserveAspectRatioValue, preserveAspectRatioValue);
		SVGStringList viewTarget = new SVGStringList.Implementation(StringUtils.splitByWhitespace(ElementParser.read(element, Attributes.VIEW_TARGET)));
		String zoomAndPanStr = ElementParser.read(element, Attributes.ZOOM_AND_PAN);
		short zoomAndPan = strToEnum.get(zoomAndPanStr);
		// Get default values
		String id = ElementParser.read(element, Attributes.ID);
		String xmlBase = ElementParser.read(element, Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		boolean externalResourcesRequiredAsBoolean = Boolean.parseBoolean(ElementParser.readOrDefault(element, Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(false)));
		SVGAnimatedBoolean externalResourcesRequired = new SVGAnimatedBoolean.Implementation(externalResourcesRequiredAsBoolean, externalResourcesRequiredAsBoolean);
		return new SVGViewElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement,
				externalResourcesRequired, viewBox, preserveAspectRatio, zoomAndPan, viewTarget);
	}

	@Override
	public Element writeElement(SVGViewElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		SVGRect viewBox = element.getViewBox().getBaseValue();
		attributes.put(Attributes.VIEW_BOX, viewBox.getX() + " " + viewBox.getY() + " " + viewBox.getWidth() + " " + viewBox.getHeight());
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
		attributes.put(Attributes.VIEW_TARGET, ElementParser.join(element.getViewTarget(), " "));
		attributes.put(Attributes.ZOOM_AND_PAN, enumToStr.get(element.getZoomAndPan()));
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(element.getExternalResourcesRequired().getBaseValue()));
		return factory.createElement(Tags.VIEW, attributes);
	}

}
