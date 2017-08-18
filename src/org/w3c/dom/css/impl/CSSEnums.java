package org.w3c.dom.css.impl;

public interface CSSEnums {

	public static final String[] ALIGNMENT_BASELINE_VALUES = {
		"auto", "baseline", "before-edge", "text-before-edge",
		"middle", "central", "after-edge", "text-after-edge",
		"ideographic", "alphabetic", "hanging", "mathematical", "inherit"
	};
	
	public static final String[] CLIP_RULE_VALUES = {
		"nonzero", "evenodd", "inherit"	
	};
	
	public static final String[] COLOR_INTERPOLATION_VALUES = {
		"auto", "sRGB", "linearRGB", "inherit"	
	};
	
	public static final String[] COLOR_RENDERING_VALUES = {
		"auto", "optimizeSpeed", "optimizeQuality", "inherit"
	};
	
	public static final String[] DIRECTION_VALUES = {
		"ltr", "rtl", "inherit"	
	};
	
	public static final String[] DISPLAY_VALUES = {
		"inline", "block", "list-item", "run-in", "compact", "marker", "table",
		"inline-table", "table-row-group", "table-header-group", "table-footer-group",
		"table-row", "table-column-group", "table-column", "table-cell",
		"table-caption", "none", "inherit"
	};
	
	public static final String[] DOMINANT_BASELINE_VALUES = {
		"auto", "use-script", "no-change", "reset-size", "ideographic", "alphabetic",
		"hanging", "mathematical", "central", "middle", "text-after-edge",
		"text-before-edge", "inherit"
	};

	public static final String[] FILL_RULE_VALUES = {
		"nonzero", "evenodd", "inherit"	
	};
	
	public static final String[] FONT_STRETCH_VALUES = {
		"normal", "wider", "narrower", "ultra-condensed", "extra-condensed",
		"condensed", "semi-condensed", "semi-expanded", "expanded", "extra-expanded",
		"ultra-expanded", "inherit"
	};
	
	public static final String[] FONT_STYLE_VALUES = {
		"normal", "italic", "oblique", "inherit"	
	};
	
	public static final String[] FONT_VARIANT_VALUES = {
		"normal", "small-caps", "inherit"	
	};
	
	public static final String[] FONT_WEIGHT_VALUES = {
		"normal", "bold", "bolder", "lighter", "100", "200", "300", "400",
		"500", "600", "700", "800", "900", "inherit"
	};
	
	public static final String[] IMAGE_RENDERING_VALUES = {
		"auto", "optimizeSpeed", "optimizeQuality", "inherit"	
	};
	
	public static final String[] OVERFLOW_VALUES = {
		"visible", "hidden", "scroll", "auto", "inherit"
	};
	
	public static final String[] POINTER_EVENTS_VALUES = {
		"visiblePainted", "visibleFill", "visibleStroke", "visible",
		"painted", "fill", "stroke", "all", "none", "inherit"
	};
	
	public static final String[] SHAPE_RENDERING_VALUES = {
		"auto", "optimizeSpeed", "crispEdges", "geometricPrecision", "inherit"	
	};
	
	public static final String[] STROKE_LINECAP_VALUES = {
		"butt", "round", "square", "inherit"	
	};
	
	public static final String[] STROKE_LINEJOIN_VALUES = {
		"miter", "round", "bevel", "inherit"	
	};
	
	public static final String[] TEXT_ANCHOR_VALUES = {
		"start", "middle", "end", "inherit"
	};

	public static final String[] TEXT_RENDERING_VALUES = {
		"auto", "optimizeSpeed", "optimizeLegibility", "geometricPrecision", "inherit"	
	};
	
	public static final String[] UNICODE_BIDI_VALUES = {
		"normal", "embed", "bidi-override", "inherit"	
	};
	
	public static final String[] VISIBILITY_VALUES = {
		"visible", "hidden", "collapse", "inherit"	
	};
	
	public static final String[] WRITING_MODE_VALUES = {
		"lr-tb", "rl-tb", "tb-rl", "lr", "rl", "tb", "inherit"	
	};
	
}
