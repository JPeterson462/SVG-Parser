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
	
}
