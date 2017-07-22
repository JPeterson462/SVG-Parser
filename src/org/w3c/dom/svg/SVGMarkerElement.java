package org.w3c.dom.svg;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGMarkerElement extends SVGElement, SVGLangSpace, SVGStylable, SVGExternalResourcesRequired, SVGFitToViewBox {

	// Marker Unit Types
	/** The marker unit type is not one of predefined types.
	 * 	It is invalid to attempt to define a new value of this
	 * 	type or to attempt to switch an existing value to this
	 * 	type. */
	public static final short SVG_MARKERUNITS_UNKNOWN = 0;
	/** The value of attribute ‘markerUnits’ is 'userSpaceOnUse'. */
	public static final short SVG_MARKERUNITS_USERSPACEONUSE = 1;
	/** The value of attribute ‘markerUnits’ is 'strokeWidth'. */
	public static final short SVG_MARKERUNITS_STROKEWIDTH = 2;

	// Marker Orientation Types
	/** The marker orientation is not one of predefined types. 
	 * 	It is invalid to attempt to define a new value of this
	 * 	type or to attempt to switch an existing value to this
	 * 	type. */
	public static final short SVG_MARKER_ORIENT_UNKNOWN = 0;
	/** Attribute ‘orient’ has value 'auto'. */
	public static final short SVG_MARKER_ORIENT_AUTO = 1;
	/** Attribute ‘orient’ has an angle value. */
	public static final short SVG_MARKER_ORIENT_ANGLE = 2;
	
	public SVGAnimatedLength getRefX();
	
	public SVGAnimatedLength getRefY();
	
	public SVGAnimatedEnumeration getMarkerUnits();
	
	public SVGAnimatedLength getMarkerWidth();
	
	public SVGAnimatedLength getMarkerHeight();
	
	public SVGAnimatedEnumeration getOrientType();
	
	public SVGAnimatedAngle getOrientAngle();
	
	public void setOrientToAuto() throws DOMException;
	
	public void setOrientToAngle(SVGAngle angle) throws DOMException;

	public static class Implementation extends SVGElement.Implementation implements SVGMarkerElement {

		private String xmlLang, xmlSpace;
		
		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		private SVGAnimatedBoolean externalResourcesRequired;
		
		private SVGAnimatedRect viewBox;
		
		private SVGAnimatedPreserveAspectRatio preserveAspectRatio;
		
		private SVGAnimatedLength refX, refY;
		
		private SVGAnimatedEnumeration markerUnits;
		
		private SVGAnimatedLength markerWidth, markerHeight;
		
		private SVGAnimatedEnumeration orientType;
		
		private SVGAnimatedAngle orientAngle;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				String xmlLang, String xmlSpace,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedRect viewBox,
				SVGAnimatedPreserveAspectRatio preserveAspectRatio,
				SVGAnimatedLength refX, SVGAnimatedLength refY, SVGAnimatedEnumeration markerUnits,
				SVGAnimatedLength markerWidth, SVGAnimatedLength markerHeight, SVGAnimatedEnumeration orientType, SVGAnimatedAngle orientAngle) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.xmlLang = xmlLang;
			this.xmlSpace = xmlSpace;
			this.className = className;
			this.style = style;
			this.externalResourcesRequired = externalResourcesRequired;
			this.viewBox = viewBox;
			this.preserveAspectRatio = preserveAspectRatio;
			this.refX = refX;
			this.refY = refY;
			this.markerUnits = markerUnits;
			this.markerWidth = markerWidth;
			this.markerHeight = markerHeight;
			this.orientType = orientType;
			this.orientAngle = orientAngle;
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
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			return externalResourcesRequired;
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
		public SVGAnimatedLength getRefX() {
			return refX;
		}

		@Override
		public SVGAnimatedLength getRefY() {
			return refY;
		}

		@Override
		public SVGAnimatedEnumeration getMarkerUnits() {
			return markerUnits;
		}

		@Override
		public SVGAnimatedLength getMarkerWidth() {
			return markerWidth;
		}

		@Override
		public SVGAnimatedLength getMarkerHeight() {
			return markerHeight;
		}

		@Override
		public SVGAnimatedEnumeration getOrientType() {
			return orientType;
		}

		@Override
		public SVGAnimatedAngle getOrientAngle() {
			return orientAngle;
		}

		@Override
		public void setOrientToAuto() throws DOMException {
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
		}

		@Override
		public void setOrientToAngle(SVGAngle angle) throws DOMException {
			orientAngle.setBaseValue(angle);
		}
		
	}
	
}
