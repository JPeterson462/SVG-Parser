package org.w3c.dom.svg;

public interface SVGPaint extends SVGColor {

	/** The paint type is not one of predefined types.
	 * 	It is invalid to attempt to define a new value
	 * 	of this type or to attempt to switch an existing
	 * 	value to this type. */
	public static final short SVG_PAINTTYPE_UNKNOWN = 0;
	/** An sRGB color has been specified without an alternative
	 * 	ICC color specification. */
	public static final short SVG_PAINTTYPE_RGBCOLOR = 1;
	/** An sRGB color has been specified along with an
	 * 	alternative ICC color specification. */
	public static final short SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR = 2;
	/** Corresponds to a none value on a <paint> specification. */
	public static final short SVG_PAINTTYPE_NONE = 101;
	/** Corresponds to a currentColor value on a <paint> specification. */
	public static final short SVG_PAINTTYPE_CURRENTCOLOR = 102;
	/** A URI has been specified, along with an explicit none
	 * 	as the backup paint method in case the URI is unavailable or invalid. */
	public static final short SVG_PAINTTYPE_URI_NONE = 103;
	/** A URI has been specified, along with an sRGB color as
	 * 	the backup paint method in case the URI is unavailable
	 * 	or invalid. */
	public static final short SVG_PAINTTYPE_URI_CURRENTCOLOR = 104;
	/** A URI has been specified, along with an sRGB color as
	 * 	the backup paint method in case the URI is unavailable
	 * 	or invalid. */
	public static final short SVG_PAINTTYPE_URI_RGBCOLOR = 105;
	/** A URI has been specified, along with both an sRGB color
	 * 	and alternate ICC color as the backup paint method in
	 * 	case the URI is unavailable or invalid. */
	public static final short SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR = 106;
	/** Only a URI has been specified. */
	public static final short SVG_PAINTTYPE_URI = 107;
	
	public short getPaintType();
	
	public String getURI();
	
	public void setURI(String uri);
	
	public void setPaint(short paintType, String uri, String rgbColor, String iccColor) throws SVGException;

	// TODO implementation
	
}
