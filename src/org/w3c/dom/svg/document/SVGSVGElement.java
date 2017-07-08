package org.w3c.dom.svg.document;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.DocumentCSS;
import org.w3c.dom.css.ViewCSS;
import org.w3c.dom.events.DocumentEvent;
import org.w3c.dom.events.Event;
import org.w3c.dom.stylesheets.StyleSheetList;
import org.w3c.dom.svg.SVGAngle;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio;
import org.w3c.dom.svg.SVGAnimatedRect;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGExternalResourcesRequired;
import org.w3c.dom.svg.SVGFitToViewBox;
import org.w3c.dom.svg.SVGLangSpace;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGLocatable;
import org.w3c.dom.svg.SVGMatrix;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGPoint;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.SVGTests;
import org.w3c.dom.svg.SVGTransform;
import org.w3c.dom.svg.SVGViewSpec;
import org.w3c.dom.svg.SVGZoomAndPan;
import org.w3c.dom.views.DocumentView;

public interface SVGSVGElement extends SVGElement, SVGTests, SVGLangSpace, 
			SVGExternalResourcesRequired, SVGStylable, SVGLocatable, 
			SVGFitToViewBox, SVGZoomAndPan, DocumentEvent, ViewCSS, 
			DocumentCSS {
	
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

	public static class Implementation extends SVGElement.Implementation implements SVGSVGElement {

		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			// TODO Auto-generated constructor stub
		}

		@Override
		public SVGStringList getRequiredFeatures() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGStringList getRequiredExtensions() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGStringList getSystemLanguage() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasExtension(String extension) throws DOMException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String getXMLLang() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setXMLLang(String xmlLang) throws DOMException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getXMLSpace() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setXMLSpace(String xmlSpace) throws DOMException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGAnimatedString getClassName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CSSStyleDeclaration getStyle() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CSSValue getPresentationAttribute(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGElement getNearestViewportElement() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGElement getFarthestViewportElement() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGRect getBBox() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGMatrix getCTM() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGMatrix getScreenCTM() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGMatrix getTransformToElement(SVGElement element) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGAnimatedRect getViewBox() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public short getZoomAndPan() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setZoomAndPan(short zoomAndPan) throws DOMException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Event createEvent(String arg0) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CSSStyleDeclaration getComputedStyle(Element arg0, String arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DocumentView getDocument() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CSSStyleDeclaration getOverrideStyle(Element arg0, String arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public StyleSheetList getStyleSheets() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGAnimatedLength getX() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGAnimatedLength getY() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGAnimatedLength getWidth() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGAnimatedLength getHeight() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getContentScriptType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setContentScriptType(String contentScriptType) throws DOMException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getContentStyleType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setContentStyleType(String contentStyleType) throws DOMException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public SVGRect getViewport() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public float getPixelUnitToMillimeterX() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getPixelUnitToMillimeterY() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getScreenPixelToMillimeterX() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getScreenPixelToMillimeterY() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean useCurrentView() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public SVGViewSpec getCurrentView() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public float getCurrentScale() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setCurrentScale(float scale) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public SVGPoint getCurrentTranslate() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long suspendRedraw(long maxWaitMilliseconds) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void unsuspendRedraw(long suspendHandleID) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void unsuspendRedrawAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void forceRedraw() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void pauseAnimations() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void unpauseAnimations() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean animationsPaused() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public float getCurrentTime() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setCurrentTime(float seconds) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public NodeList getIntersectionList(SVGRect rect, SVGElement referenceElement) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public NodeList getEnclosureList(SVGRect rect, SVGElement referenceElement) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean checkIntersection(SVGElement element, SVGRect rect) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean checkEnclosure(SVGElement element, SVGRect rect) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void deselectAll() {
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
