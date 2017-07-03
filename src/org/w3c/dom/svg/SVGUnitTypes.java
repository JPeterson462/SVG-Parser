package org.w3c.dom.svg;

public interface SVGUnitTypes {

	/** The type is not one of predefined types. It is invalid to attempt to define a new value of this type or to attempt to switch an existing value to this type. */
	public static final short SVG_UNIT_TYPE_UNKNOWN = 0;
	/** Corresponds to value 'userSpaceOnUse'. */
	public static final short SVG_UNIT_TYPE_USERSPACEONUSE = 1;
	/** Corresponds to value 'objectBoundingBox'. */
	public static final short SVG_UNIT_TYPE_OBJECTBOUNDINGBOX = 2;

}
