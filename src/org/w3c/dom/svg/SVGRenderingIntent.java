package org.w3c.dom.svg;

public interface SVGRenderingIntent {

	/** The type is not one of predefined types. It is
	 * 	invalid to attempt to define a new value of this
	 * 	type or to attempt to switch an existing value to this type. */
	public static final short RENDERING_INTENT_UNKNOWN = 0;
	/** Corresponds to a value of 'auto'. */
	public static final short RENDERING_INTENT_AUTO = 1;
	/** Corresponds to a value of 'perceptual'. */
	public static final short RENDERING_INTENT_PERCEPTUAL = 2;
	/** Corresponds to a value of 'relative-colorimetric'. */
	public static final short RENDERING_INTENT_RELATIVE_COLORIMETRIC = 3;
	/** Corresponds to a value of 'saturation'. */
	public static final short RENDERING_INTENT_SATURATION = 4;
	/** Corresponds to a value of 'absolute-colorimetric'. */
	public static final short RENDERING_INTENT_ABSOLUTE_COLORIMETRIC = 5;

}
