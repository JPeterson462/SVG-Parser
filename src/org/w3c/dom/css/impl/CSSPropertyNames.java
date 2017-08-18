package org.w3c.dom.css.impl;

// https://www.w3.org/TR/SVG/styling.html
public interface CSSPropertyNames {
	
	// Font Properties
	public static final String FONT = "font";
	public static final String FONT_FAMILY = "font-family";
	public static final String FONT_SIZE = "font-size";
	public static final String FONT_SIZE_ADJUST = "font-size-adjust";
	public static final String FONT_STRETCH = "font-stretch";
	public static final String FONT_STYLE = "font-style";
	public static final String FONT_VARIANT = "font-variant";
	public static final String FONT_WEIGHT = "font-weight";
	
	// Text Properties
	public static final String DIRECTION = "direction";
	public static final String LETTER_SPACING = "letter-spacing";
	public static final String TEXT_DECORATION = "text-decoration";
	public static final String UNICODE_BIDI = "unicode-bidi";
	public static final String WORD_SPACING = "word-spacing";
	
	// Visual Media Properties
	public static final String CLIP = "clip";
	public static final String COLOR = "color";
	public static final String CURSOR = "cursor";
	public static final String DISPLAY = "display";
	public static final String OVERFLOW = "overflow";
	public static final String VISIBILITY = "visibility";
	
	// Clipping, Masking and Compositing Properties
	public static final String CLIP_PATH = "clip-path";
	public static final String CLIP_RULE = "clip-rule";
	public static final String MASK = "mask";
	public static final String OPACITY = "opacity";
	
	// Filter Effects Properties
	public static final String ENABLE_BACKGROUND = "enable-background";
	public static final String FILTER = "filter";
	public static final String FLOOD_COLOR = "flood-color";
	public static final String FLOOD_OPACITY = "flood-opacity";
	public static final String LIGHTING_COLOR = "lighting-color";
	
	// Gradient Properties
	public static final String STOP_COLOR = "stop-color";
	public static final String STOP_OPACITY = "stop-opacity";
	
	// Interactivity Properties
	public static final String POINTER_EVENTS = "pointer-events";
	
	// Color and Painting Properties
	public static final String COLOR_INTERPOLATION = "color-interpolation";
	public static final String COLOR_INTERPOLATION_FILTERS = "color-interpolation-filters";
	public static final String COLOR_PROFILE = "color-profile";
	public static final String COLOR_RENDERING = "color-rendering";
	public static final String FILL = "fill";
	public static final String FILL_OPACITY = "fill-opacity";
	public static final String FILL_RULE = "fill-rule";
	public static final String IMAGE_RENDERING = "image-rendering";
	public static final String MARKER = "marker";
	public static final String MARKER_END = "marker-end";
	public static final String MARKER_MID = "marker-mid";
	public static final String MARKER_START = "marker-start";
	public static final String SHAPE_RENDERING = "shape-rendering";
	public static final String STROKE = "stroke";
	public static final String STROKE_DASHARRAY = "stroke-dasharray";
	public static final String STROKE_DASHOFFSET = "stroke-dashoffset";
	public static final String STROKE_LINECAP = "stroke-linecap";
	public static final String STROKE_LINEJOIN = "stroke-linejoin";
	public static final String STROKE_MITERLIMIT = "stroke-miterlimit";
	public static final String STROKE_OPACITY = "stroke-opacity";
	public static final String STROKE_WIDTH = "stroke-width";
	public static final String TEXT_RENDERING = "text-rendering";
	
	// Text Properties
	public static final String ALIGNMENT_BASELINE = "alignment-baseline";
	public static final String BASELINE_SHIFT = "baseline-shift";
	public static final String DOMINANT_BASELINE = "dominant-baseline";
	public static final String GLYPH_ORIENTATION_HORIZONTAL = "glyph-orientation-horizontal";
	public static final String GLYPH_ORIENTATION_VERTICAL = "glyph-orientation-vertical";
	public static final String KERNING = "kerning";
	public static final String TEXT_ANCHOR = "text-anchor";
	public static final String WRITING_MODE = "writing-mode";
	
	public static final String[] PROPERTIES = {
		FONT,
		FONT_FAMILY,
		FONT_SIZE,
		FONT_SIZE_ADJUST,
		FONT_STRETCH,
		FONT_STYLE,
		FONT_VARIANT,
		FONT_WEIGHT,
		
		DIRECTION,
		LETTER_SPACING,
		TEXT_DECORATION,
		UNICODE_BIDI,
		WORD_SPACING,
		
		CLIP,
		COLOR,
		CURSOR,
		DISPLAY,
		OVERFLOW,
		VISIBILITY,
		
		CLIP_PATH,
		CLIP_RULE,
		MASK,
		OPACITY,
		
		ENABLE_BACKGROUND,
		FILTER,
		FLOOD_COLOR,
		FLOOD_OPACITY,
		LIGHTING_COLOR,
		
		STOP_COLOR,
		STOP_OPACITY,
		
		POINTER_EVENTS,
		
		COLOR_INTERPOLATION,
		COLOR_INTERPOLATION_FILTERS,
		COLOR_PROFILE,
		COLOR_RENDERING,
		FILL,
		FILL_OPACITY,
		FILL_RULE,
		IMAGE_RENDERING,
		MARKER,
		MARKER_END,
		MARKER_MID,
		MARKER_START,
		SHAPE_RENDERING,
		STROKE,
		STROKE_DASHARRAY,
		STROKE_DASHOFFSET,
		STROKE_LINECAP,
		STROKE_LINEJOIN,
		STROKE_MITERLIMIT,
		STROKE_OPACITY,
		STROKE_WIDTH,
		TEXT_RENDERING,
		
		ALIGNMENT_BASELINE,
		BASELINE_SHIFT,
		DOMINANT_BASELINE,
		GLYPH_ORIENTATION_HORIZONTAL,
		GLYPH_ORIENTATION_VERTICAL,
		KERNING,
		TEXT_ANCHOR,
		WRITING_MODE
	};
	
}
