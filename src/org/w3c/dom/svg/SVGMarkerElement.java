package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

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

	// TODO implementation
	
}
