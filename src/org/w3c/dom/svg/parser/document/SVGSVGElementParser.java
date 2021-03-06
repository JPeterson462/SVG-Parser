package org.w3c.dom.svg.parser.document;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio;
import org.w3c.dom.svg.SVGAnimatedRect;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGPreserveAspectRatio;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGZoomAndPan;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.document.SVGState;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGSVGElementParser implements ElementParser<SVGSVGElement> {

	private HashMap<String, Short> strToEnum;
	private HashMap<Short, String> enumToStr;
	
	public SVGSVGElementParser() {
		strToEnum = new HashMap<>();
		enumToStr = new HashMap<>();
		strToEnum.put("disable", SVGZoomAndPan.SVG_ZOOMANDPAN_DISABLE);
		strToEnum.put("magnify", SVGZoomAndPan.SVG_ZOOMANDPAN_MAGNIFY);
		enumToStr.put(SVGZoomAndPan.SVG_ZOOMANDPAN_DISABLE, "disable");
		enumToStr.put(SVGZoomAndPan.SVG_ZOOMANDPAN_MAGNIFY, "magnify");
	}
	
	@Override
	public SVGSVGElement readElement(Element element, ParsingState parsingState) {
		String xStr = ElementParser.readOrDefault(element, Attributes.X, "0");
		String yStr = ElementParser.readOrDefault(element, Attributes.Y, "0");
		String widthStr = ElementParser.readOrDefault(element, Attributes.WIDTH, "100%");
		String heightStr = ElementParser.readOrDefault(element, Attributes.HEIGHT, "100%");
		if (widthStr.startsWith("-")) {
			SVGErrors.error("Invalid Width: " + widthStr);
		}
		if (heightStr.startsWith("-")) {
			SVGErrors.error("Invalid Height: " + heightStr);
		}
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
		SVGPreserveAspectRatio.Implementation preserveAspectRatioValue = new SVGPreserveAspectRatio.Implementation();
		ArrayList<String> preserveAspectRatioParts = StringUtils.splitByWhitespace(ElementParser.readOrDefault(element, Attributes.PRESERVE_ASPECT_RATIO, "xMidYMid meet"));
		preserveAspectRatioValue.setFromString(preserveAspectRatioParts.get(0), preserveAspectRatioParts.size() == 1 ? null : preserveAspectRatioParts.get(1));
		SVGAnimatedPreserveAspectRatio preserveAspectRatio = new SVGAnimatedPreserveAspectRatio.Implementation(preserveAspectRatioValue, preserveAspectRatioValue);
		// Get default values
		String id = ElementParser.read(element, Attributes.ID);
		String xmlBase = ElementParser.read(element, Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		String xmlLang = ElementParser.read(element, Attributes.XML_LANG);
		if (xmlLang == null) {
			xmlLang = "en";
		}
		String xmlSpace = ElementParser.read(element, Attributes.XML_SPACE);
		if (xmlSpace == null) {
			xmlSpace = "default";
		}
		String classNameAsString = ElementParser.read(element, Attributes.CLASS);
		SVGAnimatedString className = new SVGAnimatedString.Implementation(classNameAsString, classNameAsString);
		CSSStyleDeclarationImplementation style = new CSSStyleDeclarationImplementation(parsingState.findParentRule());
		style.setCssText(ElementParser.readOrDefault(element, Attributes.STYLE, ""));
		ElementParser.parseStyleFromAttributes(element, style);
		boolean externalResourcesRequiredAsBoolean = Boolean.parseBoolean(ElementParser.readOrDefault(element, Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(false)));
		SVGAnimatedBoolean externalResourcesRequired = new SVGAnimatedBoolean.Implementation(externalResourcesRequiredAsBoolean, externalResourcesRequiredAsBoolean);
		SVGAnimatedTransformList transform = ElementParser.parseTransforms(element);
		float versionValue = Float.parseFloat(ElementParser.readOrDefault(element, Attributes.VERSION, "1.1"));
		SVGNumber version = new SVGNumber.Implementation(versionValue);
		String baseProfile = ElementParser.readOrDefault(element, Attributes.BASE_PROFILE, "none");
		String contentScriptType = ElementParser.readOrDefault(element, Attributes.CONTENT_SCRIPT_TYPE, "application/ecmascript");
		String contentStyleType = ElementParser.readOrDefault(element, Attributes.CONTENT_STYLE_TYPE, "text/css");
		SVGState state = new SVGState.Implementation();
		String zoomAndPanStr = ElementParser.readOrDefault(element, Attributes.ZOOM_AND_PAN, "magnify");
		short zoomAndPan = strToEnum.get(zoomAndPanStr);
		String viewBoxStr = ElementParser.read(element, Attributes.VIEW_BOX);
		SVGRect viewBoxBase = null;
		if (viewBoxStr.contains(",")) {
			String[] viewBoxParts = viewBoxStr.split(",");
			if (viewBoxParts.length > 0) {
				float xValue = Float.parseFloat(viewBoxParts[0].trim());
				float yValue = Float.parseFloat(viewBoxParts[1].trim());
				float widthValue = Float.parseFloat(viewBoxParts[2].trim());
				float heightValue = Float.parseFloat(viewBoxParts[3].trim());
				if (widthValue < 0 || heightValue < 0) {
					SVGErrors.error("Invalid viewBox: " + viewBoxStr);
				}
				viewBoxBase = new SVGRect.Implementation(xValue, yValue, widthValue, heightValue);
			}
		} else {
			ArrayList<String> viewBoxParts = StringUtils.splitByWhitespace(viewBoxStr);
			if (viewBoxParts.size() > 0) {
				float xValue = Float.parseFloat(viewBoxParts.get(0).trim());
				float yValue = Float.parseFloat(viewBoxParts.get(1).trim());
				float widthValue = Float.parseFloat(viewBoxParts.get(2).trim());
				float heightValue = Float.parseFloat(viewBoxParts.get(3).trim());
				if (widthValue < 0 || heightValue < 0) {
					SVGErrors.error("Invalid viewBox: " + viewBoxStr);
				}
				viewBoxBase = new SVGRect.Implementation(xValue, yValue, widthValue, heightValue);
			}
		}
		SVGAnimatedRect viewBox = new SVGAnimatedRect.Implementation(viewBoxBase, viewBoxBase);
		SVGSVGElement svgElement = new SVGSVGElement.Implementation(parsingState.getRenderingState().getPixelsPerInch(), id, xmlBase, ownerSVGElement,
				viewportElement, className, style, xmlLang, xmlSpace, transform, externalResourcesRequired, 
				ax, ay, awidth, aheight, viewBox, preserveAspectRatio, zoomAndPan, version, baseProfile,
				contentScriptType, contentStyleType, state, parsingState.getRenderingState());
		String onLoad = ElementParser.read(element, Attributes.ON_LOAD);
		String onAbort = ElementParser.read(element, Attributes.ON_ABORT);
		String onError = ElementParser.read(element, Attributes.ON_ERROR);
		String onResize = ElementParser.read(element, Attributes.ON_RESIZE);
		String onScroll = ElementParser.read(element, Attributes.ON_SCROLL);
		String onUnload = ElementParser.read(element, Attributes.ON_UNLOAD);
		String onZoom = ElementParser.read(element, Attributes.ON_ZOOM);
		svgElement.connectDocumentEventListeners(onLoad, onAbort, onError, onResize, onScroll, onUnload, onZoom);
		ElementParser.connectLengthRoots(svgElement);
		return svgElement;
	}

	@Override
	public Element writeElement(SVGSVGElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
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
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.XML_LANG, element.getXMLLang());
		attributes.put(Attributes.XML_SPACE, element.getXMLSpace());
		attributes.put(Attributes.CLASS, element.getClassName().getBaseValue());
		ElementParser.storeStyleFromAttributes(attributes, element.getStyle());
		attributes.put(Attributes.X, element.getX().getBaseValue().getValueAsString());
		attributes.put(Attributes.Y, element.getY().getBaseValue().getValueAsString());
		attributes.put(Attributes.WIDTH, element.getWidth().getBaseValue().getValueAsString());
		attributes.put(Attributes.HEIGHT, element.getHeight().getBaseValue().getValueAsString());
		attributes.put(Attributes.REQUIRED_FEATURES, ElementParser.join(element.getRequiredFeatures(), " "));
		attributes.put(Attributes.REQUIRED_EXTENSIONS, ElementParser.join(element.getRequiredExtensions(), " "));
		attributes.put(Attributes.SYSTEM_LANGUAGE, ElementParser.join(element.getSystemLanguage(), " "));
		attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, element.getExternalResourcesRequired().getBaseValue().toString());
		SVGRect viewBox = element.getViewBox().getBaseValue();
		attributes.put(Attributes.VERSION, Float.toString(element.getVersion().getValue()));
		attributes.put(Attributes.BASE_PROFILE, element.getBaseProfile());
		attributes.put(Attributes.CONTENT_SCRIPT_TYPE, element.getContentScriptType());
		attributes.put(Attributes.CONTENT_STYLE_TYPE, element.getContentStyleType());
		attributes.put(Attributes.ZOOM_AND_PAN, enumToStr.get(element.getZoomAndPan()));
		if (viewBox != null) {
			attributes.put(Attributes.VIEW_BOX, viewBox.getX() + " " + viewBox.getY() + " " + viewBox.getWidth() + " " + viewBox.getHeight());	
		}
		attributes.put("xmlns", "http://www.w3.org/2000/svg");
		attributes.put("xmlns:xlink", "https://www.w3.org/1999/xlink");
		attributes.put(Attributes.ON_ABORT, element.getOnAbort());
		attributes.put(Attributes.ON_LOAD, element.getOnLoad());
		attributes.put(Attributes.ON_ERROR, element.getOnError());
		attributes.put(Attributes.ON_RESIZE, element.getOnResize());
		attributes.put(Attributes.ON_SCROLL, element.getOnScroll());
		attributes.put(Attributes.ON_UNLOAD, element.getOnUnload());
		attributes.put(Attributes.ON_ZOOM, element.getOnZoom());
		return factory.createElement(Tags.SVG, attributes);
	}

}
