package org.w3c.dom.svg.document;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.css.CSSAdvancedColorValue;
import org.w3c.dom.css.CSSAngleValue;
import org.w3c.dom.css.CSSColorValue;
import org.w3c.dom.css.CSSEnumListValue;
import org.w3c.dom.css.CSSEnumValue;
import org.w3c.dom.css.CSSIRIValue;
import org.w3c.dom.css.CSSLengthValue;
import org.w3c.dom.css.CSSNumberValue;
import org.w3c.dom.css.CSSPaintValue;
import org.w3c.dom.css.CSSStringListValue;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.DocumentCSS;
import org.w3c.dom.css.ViewCSS;
import org.w3c.dom.css.impl.CSSProperties;
import org.w3c.dom.css.impl.CSSPropertyNames;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.events.DocumentEvent;
import org.w3c.dom.events.Event;
import org.w3c.dom.stylesheets.StyleSheetList;
import org.w3c.dom.DOMErrors;
import org.w3c.dom.svg.SVGAngle;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio;
import org.w3c.dom.svg.SVGAnimatedRect;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGDimensioned;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGExtensionManager;
import org.w3c.dom.svg.SVGExternalResourcesRequired;
import org.w3c.dom.svg.SVGFitToViewBox;
import org.w3c.dom.svg.SVGLangSpace;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGLocatable;
import org.w3c.dom.svg.SVGMatrix;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGPoint;
import org.w3c.dom.svg.SVGPointList;
import org.w3c.dom.svg.SVGPositioned;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.SVGTests;
import org.w3c.dom.svg.SVGTransform;
import org.w3c.dom.svg.SVGTransformList;
import org.w3c.dom.svg.SVGTransformable;
import org.w3c.dom.svg.SVGViewSpec;
import org.w3c.dom.svg.SVGZoomAndPan;
import org.w3c.dom.svg.paths.SVGPathElement;
import org.w3c.dom.svg.paths.SVGPathMath;
import org.w3c.dom.svg.shapes.SVGCircleElement;
import org.w3c.dom.svg.shapes.SVGEllipseElement;
import org.w3c.dom.svg.shapes.SVGLineElement;
import org.w3c.dom.svg.shapes.SVGPolygonElement;
import org.w3c.dom.svg.shapes.SVGPolylineElement;
import org.w3c.dom.svg.shapes.SVGRectElement;
import org.w3c.dom.views.DocumentView;

public interface SVGSVGElement extends SVGElement, SVGTests, SVGLangSpace, 
			SVGExternalResourcesRequired, SVGStylable, SVGLocatable, 
			SVGFitToViewBox, SVGZoomAndPan, DocumentEvent, ViewCSS, 
			DocumentCSS, SVGDimensioned, SVGPositioned {
	
	public SVGNumber getVersion();
	
	public String getBaseProfile();
	
	public SVGAnimatedLength getX();
	
	public SVGAnimatedLength getY();
	
	public SVGAnimatedLength getWidth();
	
	public SVGAnimatedLength getHeight();
	
	public String getContentScriptType();
	
	public void setContentScriptType(String contentScriptType) throws DOMException;
	
	public String getContentStyleType();
	
	public void setContentStyleType(String contentStyleType) throws DOMException;
	
	public SVGRect getViewport();
	
	public float getPixelUnitToMillimeterX();
	
	public float getPixelUnitToMillimeterY();
	
	public float getScreenPixelToMillimeterX();
	
	public float getScreenPixelToMillimeterY();
	
	public boolean useCurrentView();
	
	public SVGViewSpec getCurrentView();
	
	public float getCurrentScale();
	
	public void setCurrentScale(float scale);

	public SVGPoint getCurrentTranslate();
	
	public long suspendRedraw(long maxWaitMilliseconds);
	
	public void unsuspendRedraw(long suspendHandleID);
	
	public void unsuspendRedrawAll();
	
	public void forceRedraw();
	
	public void pauseAnimations();
	
	public void unpauseAnimations();
	
	public boolean animationsPaused();
	
	public float getCurrentTime();
	
	public void setCurrentTime(float seconds);
	
	public NodeList getIntersectionList(SVGRect rect, SVGElement referenceElement);
	
	public NodeList getEnclosureList(SVGRect rect, SVGElement referenceElement);
	
	public boolean checkIntersection(SVGElement element, SVGRect rect);
	
	public boolean checkEnclosure(SVGElement element, SVGRect rect);
	
	public void deselectAll();
	
	public SVGNumber createSVGNumber();
	
	public SVGLength createSVGLength();
	
	public SVGAngle createSVGAngle();
	
	public SVGPoint createSVGPoint();
	
	public SVGMatrix createSVGMatrix();
	
	public SVGRect createSVGRect();
	
	public SVGTransform createSVGTransform();
	
	public SVGTransform createSVGTransformFromMatrix(SVGMatrix matrix);
	
	public Element getElementById(String elementId);

	public void setStyleSheets(StyleSheetList stylesheets);
	
	public SVGState getState();
	
	public SVGRenderingState getRenderingState();
	
	public void connectDocumentEventListeners(String onLoad, String onAbort, String onError, String onResize, 
			String onScroll, String onUnload, String onZoom);
	
	public String getOnLoad();
	
	public String getOnAbort();
	
	public String getOnError();
	
	public String getOnResize();
	
	public String getOnScroll();
	
	public String getOnUnload();
	
	public String getOnZoom();

	public void computeBoundingBoxes();
	
	public static class Implementation extends SVGElement.Implementation implements SVGSVGElement {
		
		private SVGStringList requiredFeatures, requiredExtensions, systemLanguage;
		
		private String xmlLang, xmlSpace;
		
		private SVGAnimatedBoolean externalResourcesRequired;
		
		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		private SVGTransformable transformableBase;
		
		private SVGAnimatedRect viewBox;
		
		private SVGAnimatedPreserveAspectRatio preserveAspectRatio;
		
		private short zoomAndPan;
		
		private SVGAnimatedLength x, y, width, height;
		
		private String contentScriptType, contentStyleType;
		
		private SVGRect viewport;
		
		private float pixelUnitToMillimeterX, pixelUnitToMillimeterY;
		
		private float screenPixelToMillimeterX, screenPixelToMillimeterY;
		
		private boolean useCurrentView;
		
		private SVGViewSpec currentView;

		private float currentScale;
		
		private SVGPoint currentTranslate;
		
		private SVGNumber version;
		
		private String baseProfile;
		
		private StyleSheetList stylesheetList;
		
		private SVGState state;
		
		private SVGRenderingState renderingState;
		
		private String onLoad, onAbort, onError, onResize, onScroll, onUnload, onZoom;
		
		public Implementation(float pixelsPerInch, String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString className, CSSStyleDeclaration style, String xmlLang, String xmlSpace, SVGAnimatedTransformList transform,
				SVGAnimatedBoolean externalResourcesRequired, SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width,
				SVGAnimatedLength height, SVGAnimatedRect viewBox, SVGAnimatedPreserveAspectRatio preserveAspectRatio,
				short zoomAndPan, SVGNumber version, String baseProfile, String contentScriptType, String contentStyleType,
				SVGState state, SVGRenderingState renderingState) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.state = state;
			this.renderingState = renderingState;
			final float inchesPerCentimeter = 1f / 2.54f;
			final float centimetersPerMillimeter = 1f / 10f;
			float pixelsPerMillimeter = pixelsPerInch * inchesPerCentimeter * centimetersPerMillimeter;
			pixelUnitToMillimeterX = pixelsPerMillimeter;
			pixelUnitToMillimeterY = pixelsPerMillimeter;
			screenPixelToMillimeterX = pixelsPerMillimeter;
			screenPixelToMillimeterY = pixelsPerMillimeter;
			this.className = className;
			this.style = style;
			this.xmlLang = xmlLang;
			this.xmlSpace = xmlSpace;
			this.externalResourcesRequired = externalResourcesRequired;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.viewBox = viewBox;
			this.preserveAspectRatio = preserveAspectRatio;
			this.zoomAndPan = zoomAndPan;
			this.version = version;
			this.baseProfile = baseProfile;
			this.contentScriptType = contentScriptType;
			this.contentStyleType = contentStyleType;
			transformableBase = new SVGTransformable.Implementation(this, transform);
			currentTranslate = new SVGPoint.Implementation(0, 0);
			currentScale = 1;
			viewport = new SVGRect.Implementation(x.getBaseValue().getValue(), y.getBaseValue().getValue(),
					width.getBaseValue().getValue(), height.getBaseValue().getValue());
		}
		
		@Override
		public SVGNumber getVersion() {
			return version;
		}
		
		@Override
		public String getBaseProfile() {
			return baseProfile;
		}

		@Override
		public SVGStringList getRequiredFeatures() {
			return requiredFeatures;
		}

		@Override
		public SVGStringList getRequiredExtensions() {
			return requiredExtensions;
		}

		@Override
		public SVGStringList getSystemLanguage() {
			return systemLanguage;
		}

		@Override
		public boolean hasExtension(String extension) throws DOMException {
			return SVGExtensionManager.getInstance(SVGExtensionManager.DEFAULT_MANAGER).hasExtension(extension);
		}

		@Override
		public String getXMLLang() {
			return xmlLang;
		}

		@Override
		public void setXMLLang(String xmlLang) throws DOMException {
			this.xmlLang = xmlLang;
		}

		@Override
		public String getXMLSpace() {
			return xmlSpace;
		}

		@Override
		public void setXMLSpace(String xmlSpace) throws DOMException {
			this.xmlSpace = xmlSpace;
		}

		@Override
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			return externalResourcesRequired;
		}

		@Override
		public SVGAnimatedString getClassName() {
			return className;
		}

		@Override
		public CSSStyleDeclaration getStyle() {
			return style;
		}

		@Override
		public CSSValue getPresentationAttribute(String name) {
			return DOMErrors.deprecatedMethod();
		}

		@Override
		public SVGElement getNearestViewportElement() {
			return transformableBase.getNearestViewportElement();
		}

		@Override
		public SVGElement getFarthestViewportElement() {
			return transformableBase.getFarthestViewportElement();
		}

		@Override
		public SVGRect getBBox() {
			return transformableBase.getBBox();
		}

		@Override
		public SVGMatrix getCTM() {
			return transformableBase.getCTM();
		}

		@Override
		public SVGMatrix getScreenCTM() {
			return transformableBase.getScreenCTM();
		}

		@Override
		public SVGMatrix getTransformToElement(SVGElement element) throws DOMException {
			return transformableBase.getTransformToElement(element);
		}

		@Override
		public SVGAnimatedRect getViewBox() {
			return viewBox;
		}

		@Override
		public SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
			return preserveAspectRatio;
		}

		@Override
		public short getZoomAndPan() {
			return zoomAndPan;
		}

		@Override
		public void setZoomAndPan(short zoomAndPan) throws DOMException {
			this.zoomAndPan = zoomAndPan;
		}

		@Override
		public Event createEvent(String type) throws DOMException {
//			if (type.equals("UIEvents")) {
//			
//			}
//			return null;
			return DOMErrors.notSupported();
		}

		@Override
		public CSSStyleDeclaration getComputedStyle(Element element, String pseudoElement) {
			CSSStyleDeclarationImplementation defaultValues = new CSSStyleDeclarationImplementation(null);
			CSSProperties.storeDefaults(defaultValues);
			CSSStyleDeclaration inlineValues = element instanceof SVGStylable ? ((SVGStylable) element).getStyle() : null;
			CSSStyleDeclarationImplementation computeValues = new CSSStyleDeclarationImplementation(inlineValues.getParentRule());
			final String INITIAL = "initial";
			// 1. Use absolute values in inlineValues or from defaultValues for 'initial' values
			for (int i = 0; i < defaultValues.getLength(); i++) {
				String propertyName = defaultValues.item(i);
				CSSValue value = inlineValues.getPropertyCSSValue(propertyName);
				if (value != null) {
					if (value instanceof CSSEnumListValue || value instanceof CSSEnumValue || value instanceof CSSIRIValue ||
							value instanceof CSSStringListValue || value instanceof CSSAngleValue) {
						if (value.getCssText().equals(INITIAL)) {
							computeValues.storeValue(propertyName, defaultValues.getPropertyCSSValue(propertyName));
						} else {
							computeValues.storeValue(propertyName, value);			
						}
					}
					else if (value instanceof CSSColorValue || value instanceof CSSAdvancedColorValue) {
						if (value.getCssText().equals(INITIAL)) {
							computeValues.storeValue(propertyName, defaultValues.getPropertyCSSValue(propertyName));
						} else {
							computeValues.storeValue(propertyName, value);			
						}
					}					
					else if (value instanceof CSSPaintValue) {
						if (value.getCssText().equals(INITIAL)) {
							computeValues.storeValue(propertyName, defaultValues.getPropertyCSSValue(propertyName));
						} else {
							computeValues.storeValue(propertyName, value);
						}
					}
					else if (value instanceof CSSLengthValue) {
						if (value.getCssText().equals(INITIAL)) {
							computeValues.storeValue(propertyName, defaultValues.getPropertyCSSValue(propertyName));
						} else {
							CSSLengthValue lengthValue = (CSSLengthValue) value;
							SVGLength length = lengthValue.getValue();
							if (length.getUnitType() == SVGLength.SVG_LENGTHTYPE_PERCENTAGE) {
								computeValues.storeValue(propertyName, value);
							} else {
								computeValues.storeValue(propertyName, value);
							}
						}
					}
					else if (value instanceof CSSNumberValue) {
						if (value.getCssText().equals(INITIAL)) {
							computeValues.storeValue(propertyName, defaultValues.getPropertyCSSValue(propertyName));
						} else {
							computeValues.storeValue(propertyName, value);
						}
					}
				}
			}
			// 2. Handle Inheritance
			for (int i = 0; i < defaultValues.getLength(); i++) {
				String propertyName = defaultValues.item(i);
				CSSValue value = inlineValues.getPropertyCSSValue(propertyName);
				if (value != null && value.getCssValueType() == CSSValue.CSS_INHERIT && isInheritedProperty(propertyName)) {
					SVGElement parentNode = (SVGElement) element.getParentNode();
					String targetCssText = null;
					while (parentNode != null && targetCssText == null) {
						if (parentNode instanceof SVGStylable) {
							CSSStyleDeclaration style = ((SVGStylable) parentNode).getStyle();
							CSSValue parentValue = style.getPropertyCSSValue(propertyName);
							if (parentValue != null && value.getCssValueType() != CSSValue.CSS_INHERIT) {
								targetCssText = parentValue.getCssText();
							}
						}
						parentNode = (SVGElement) parentNode.getParentNode();
					}
					value.setCssText(targetCssText);
				}
			}
			// 3. Add in default values for unspecified values
			for (int i = 0; i < defaultValues.getLength(); i++) {
				String propertyName = defaultValues.item(i);
				CSSValue value = defaultValues.getPropertyCSSValue(propertyName);
				if (computeValues.getPropertyCSSValue(propertyName) == null) {
					computeValues.storeValue(propertyName, value);
				}
			}
			return computeValues;
		}
		
		private boolean isInheritedProperty(String propertyName) {
			for (int i = 0; i < CSSPropertyNames.INHERITED_PROPERTIES.length; i++) {
				if (propertyName.equals(CSSPropertyNames.INHERITED_PROPERTIES[i])) {
					return true;
				}
			}
			return false;
		}

		@Override
		public DocumentView getDocument() {
			return DOMErrors.notSupported();
		}

		@Override
		public CSSStyleDeclaration getOverrideStyle(Element element, String pseudoElement) {
			return DOMErrors.notSupported();
		}

		@Override
		public StyleSheetList getStyleSheets() {
			return stylesheetList;
		}

		@Override
		public SVGAnimatedLength getX() {
			return x;
		}

		@Override
		public SVGAnimatedLength getY() {
			return y;
		}

		@Override
		public SVGAnimatedLength getWidth() {
			return width;
		}

		@Override
		public SVGAnimatedLength getHeight() {
			return height;
		}

		@Override
		public String getContentScriptType() {
			return contentScriptType;
		}

		@Override
		public void setContentScriptType(String contentScriptType) throws DOMException {
			this.contentScriptType = contentScriptType;
		}

		@Override
		public String getContentStyleType() {
			return contentStyleType;
		}

		@Override
		public void setContentStyleType(String contentStyleType) throws DOMException {
			this.contentStyleType = contentStyleType;
		}

		@Override
		public SVGRect getViewport() {
			return viewport;
		}

		@Override
		public float getPixelUnitToMillimeterX() {
			return pixelUnitToMillimeterX;
		}

		@Override
		public float getPixelUnitToMillimeterY() {
			return pixelUnitToMillimeterY;
		}

		@Override
		public float getScreenPixelToMillimeterX() {
			return screenPixelToMillimeterX;
		}

		@Override
		public float getScreenPixelToMillimeterY() {
			return screenPixelToMillimeterY;
		}

		@Override
		public boolean useCurrentView() {
			DOMErrors.notSupported();
			return useCurrentView;
		}

		@Override
		public SVGViewSpec getCurrentView() {
			DOMErrors.notSupported();
			return currentView;
		}

		@Override
		public float getCurrentScale() {
			return currentScale;
		}

		@Override
		public void setCurrentScale(float scale) {
			currentScale = scale;
		}

		@Override
		public SVGPoint getCurrentTranslate() {
			return currentTranslate;
		}

		@Override
		public long suspendRedraw(long maxWaitMilliseconds) {
			return state.suspendRedraw(maxWaitMilliseconds);
		}

		@Override
		public void unsuspendRedraw(long suspendHandleID) {
			state.unsuspendRedraw(suspendHandleID);
		}

		@Override
		public void unsuspendRedrawAll() {
			state.unsuspendRedrawAll();
		}

		@Override
		public void forceRedraw() {
			state.forceRedraw();
		}

		@Override
		public void pauseAnimations() {
			state.pauseAnimations();
		}

		@Override
		public void unpauseAnimations() {
			state.unpauseAnimations();
		}

		@Override
		public boolean animationsPaused() {
			return state.animationsPaused();
		}

		@Override
		public float getCurrentTime() {
			return state.getCurrentTime();
		}

		@Override
		public void setCurrentTime(float seconds) {
			state.setCurrentTime(seconds);
		}

		@Override
		public NodeList getIntersectionList(SVGRect rect, SVGElement referenceElement) {
			return renderingState.getIntersectionList(rect, referenceElement);
		}

		@Override
		public NodeList getEnclosureList(SVGRect rect, SVGElement referenceElement) {
			return renderingState.getEnclosureList(rect, referenceElement);
		}

		@Override
		public boolean checkIntersection(SVGElement element, SVGRect rect) {
			return renderingState.checkIntersection(element, rect);
		}

		@Override
		public boolean checkEnclosure(SVGElement element, SVGRect rect) {
			return renderingState.checkEnclosure(element, rect);
		}

		@Override
		public void deselectAll() {
			renderingState.deselectAll();
		}

		@Override
		public SVGNumber createSVGNumber() {
			return new SVGNumber.Implementation(0);
		}

		@Override
		public SVGLength createSVGLength() {
			return new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, null);
		}

		@Override
		public SVGAngle createSVGAngle() {
			return new SVGAngle.Implementation(SVGAngle.SVG_ANGLETYPE_UNSPECIFIED, 0);
		}

		@Override
		public SVGPoint createSVGPoint() {
			return new SVGPoint.Implementation(0, 0);
		}

		@Override
		public SVGMatrix createSVGMatrix() {
			return new SVGMatrix.Implementation();
		}

		@Override
		public SVGRect createSVGRect() {
			return new SVGRect.Implementation(0, 0, 0, 0);
		}

		@Override
		public SVGTransform createSVGTransform() {
			return new SVGTransform.Implementation();
		}

		@Override
		public SVGTransform createSVGTransformFromMatrix(SVGMatrix matrix) {
			SVGTransform transform = createSVGTransform();
			transform.setMatrix(matrix);
			return transform;
		}

		@Override
		public Element getElementById(String elementId) {
			return getElementById(this, elementId);
		}
		
		private Element getElementById(Element element, String elementId) {
			NodeList children = element.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node node = children.item(i);
				if (!(node instanceof Element)) {
					continue;
				}
				if (((Element) node).getAttribute("id").equals(elementId)) {
					return (Element) node;
				}
				Element recursive = getElementById((Element) node, elementId);
				if (recursive != null) {
					return recursive;
				}
			}
			return null;
		}
		
		@Override
		public void setStyleSheets(StyleSheetList stylesheets) {
			stylesheetList = stylesheets;
		}

		@Override
		public SVGState getState() {
			return state;
		}

		@Override
		public SVGRenderingState getRenderingState() {
			return renderingState;
		}

		@Override
		public void connectDocumentEventListeners(String onLoad, String onAbort, String onError, String onResize,
				String onScroll, String onUnload, String onZoom) {
			this.onLoad = onLoad;
			this.onAbort = onAbort;
			this.onError = onError;
			this.onResize = onResize;
			this.onScroll = onScroll;
			this.onUnload = onUnload;
			this.onZoom = onZoom;
		}

		@Override
		public String getOnLoad() {
			return onLoad;
		}

		@Override
		public String getOnAbort() {
			return onAbort;
		}

		@Override
		public String getOnError() {
			return onError;
		}

		@Override
		public String getOnResize() {
			return onResize;
		}

		@Override
		public String getOnScroll() {
			return onScroll;
		}

		@Override
		public String getOnUnload() {
			return onUnload;
		}

		@Override
		public String getOnZoom() {
			return onZoom;
		}

		@Override
		public void computeBoundingBoxes() {
			computeBoundingBoxes(this);
		}
		
		private void computeBoundingBoxes(SVGElement element) {
			NodeList children = element.getChildNodes();
			// Recurse
			for (int i = 0; i < children.getLength(); i++) {
				Node child = children.item(i);
				if (child instanceof SVGElement) {
					computeBoundingBoxes((SVGElement) child);
				}
			}
			if (element instanceof SVGLocatable) {
				float x = 0, y = 0, width = 0, height = 0;
				boolean computedX = true, computedY = true, computedWidth = true, computedHeight = true;
				// Compute the bounding box for defined shapes
				if (element instanceof SVGDimensioned) {
					SVGDimensioned dimensioned = (SVGDimensioned) element;
					SVGLength widthValue = dimensioned.getWidth() != null ? dimensioned.getWidth().getBaseValue() : null;
					SVGLength heightValue = dimensioned.getHeight() != null ? dimensioned.getHeight().getBaseValue() : null;
					if (widthValue != null) {
						width = widthValue.getValue();
						computedWidth = false;
					}
					if (heightValue != null) {
						height = heightValue.getValue();
						computedHeight = false;
					}
				}
				if (element instanceof SVGPositioned) {
					SVGPositioned positioned = (SVGPositioned) element;
					SVGLength xValue = positioned.getX() != null ? positioned.getX().getBaseValue() : null;
					SVGLength yValue = positioned.getY() != null ? positioned.getY().getBaseValue() : null;
					if (xValue != null) {
						x = xValue.getValue();
						computedX = false;
					}
					if (yValue != null) {
						y = yValue.getValue();
						computedY = false;
					}
				}
				if (computedWidth || computedHeight || computedX || computedY) {
					for (int i = 0; i < children.getLength(); i++) {
						Node child = children.item(i);
						if (child instanceof SVGPathElement) {
							SVGPoint min = new SVGPoint.Implementation(Float.MAX_VALUE, Float.MAX_VALUE);
							SVGPoint max = new SVGPoint.Implementation(-Float.MAX_VALUE, -Float.MAX_VALUE);
							SVGPathMath.getPathBounds(((SVGPathElement) element).getPathSegList(), min, max);
							x = min.getX();
							y = min.getY();
							width = max.getX() - min.getX();
							height = max.getY() - min.getY();
						}
						else if (child instanceof SVGCircleElement) {
							SVGCircleElement circle = (SVGCircleElement) child;
							width = circle.getRadius().getBaseValue().getValue() * 2;
							height = circle.getRadius().getBaseValue().getValue() * 2;
							x = circle.getCX().getBaseValue().getValue() - circle.getRadius().getBaseValue().getValue();
							y = circle.getCY().getBaseValue().getValue() - circle.getRadius().getBaseValue().getValue();
						}
						else if (child instanceof SVGEllipseElement) {
							SVGEllipseElement ellipse = (SVGEllipseElement) child;
							width = ellipse.getRadiusX().getBaseValue().getValue() * 2;
							height = ellipse.getRadiusY().getBaseValue().getValue() * 2;
							x = ellipse.getCX().getBaseValue().getValue() - ellipse.getRadiusX().getBaseValue().getValue();
							y = ellipse.getCY().getBaseValue().getValue() - ellipse.getRadiusY().getBaseValue().getValue();
						}
						else if (child instanceof SVGLineElement) {
							SVGLineElement line = (SVGLineElement) child;
							x = Math.min(line.getX1().getBaseValue().getValue(), line.getX2().getBaseValue().getValue());
							width = Math.max(line.getX1().getBaseValue().getValue(), line.getX2().getBaseValue().getValue()) - x;
							y = Math.min(line.getY1().getBaseValue().getValue(), line.getY2().getBaseValue().getValue());
							height = Math.max(line.getY1().getBaseValue().getValue(), line.getY2().getBaseValue().getValue()) - y;
						}
						else if (child instanceof SVGPolygonElement) {
							float[] bounds = findRegion(((SVGPolygonElement) element).getPoints().getBaseValue());
							x = bounds[0];
							y = bounds[1];
							width = bounds[2];
							height = bounds[3];
						}
						else if (child instanceof SVGPolylineElement) {
							float[] bounds = findRegion(((SVGPolylineElement) element).getPoints().getBaseValue());
							x = bounds[0];
							y = bounds[1];
							width = bounds[2];
							height = bounds[3];
						}
						else if (child instanceof SVGRectElement) {
							// Already computed
						}
						// TODO text elements
					}
					// Adjust the bounding box to fit children
					for (int i = 0; i < children.getLength(); i++) {
						Node child = children.item(i);
						if (child instanceof SVGLocatable) {
							SVGRect bBox = ((SVGLocatable) child).getBBox();
							if (bBox != null) {
								x = Math.min(x, bBox.getX());
								y = Math.min(y, bBox.getY());
								width = Math.max(x + width, bBox.getX() + bBox.getWidth()) - x;
								height = Math.max(y + height, bBox.getY() + bBox.getHeight()) - y;
							}
						}
					}
				}
				// Store the result
				float x0 = x, y0 = y, x1 = x + width, y1 = y + height;
				if (element instanceof SVGTransformable) {
					SVGTransformList transforms = ((SVGTransformable) element).getTransform().getBaseValue();
					SVGMatrix matrix = new SVGMatrix.Implementation();
					matrix.identity();
					transforms.applyTo(matrix);
					SVGPoint p0 = new SVGPoint.Implementation(x0, y0);
					SVGPoint p1 = new SVGPoint.Implementation(x1, y1);
					p0.matrixTransform(matrix);
					p1.matrixTransform(matrix);
					x0 = p0.getX();
					y0 = p0.getY();
					x1 = p1.getX();
					y1 = p1.getY();
				}
				((SVGLocatable) element).getBBox().setX(Math.min(x0, x1));
				((SVGLocatable) element).getBBox().setY(Math.min(y0, y1));
				((SVGLocatable) element).getBBox().setWidth(Math.abs(x1 - x0));
				((SVGLocatable) element).getBBox().setHeight(Math.abs(y1 - y0));
			}
		}
		
		private float[] findRegion(SVGPointList points) {
			float minX = Float.MAX_VALUE, minY = Float.MAX_VALUE, maxX = -Float.MAX_VALUE, maxY = -Float.MAX_VALUE;
			for (int i = 0; i < points.getNumberOfItems(); i++) {
				SVGPoint point = points.getItem(i);
				minX = Math.min(minX, point.getX());
				maxX = Math.max(maxX, point.getX());
				minY = Math.min(minY, point.getY());
				maxY = Math.max(maxY, point.getY());
			}
			
			return new float[] { minX, minY, maxX - minX, maxY - minY };
		}

	}
	
}
