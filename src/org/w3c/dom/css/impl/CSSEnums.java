package org.w3c.dom.css.impl;

public interface CSSEnums {

	public static final String[] BACKGROUND_ATTACHMENT_VALUES = {
		"scroll", "fixed", "local", "initial", "inherit"
	};
	
	public static final String[] BACKGROUND_BLEND_MODE_VALUES = {
		"normal", "multiply", "screen", "overlay", "darken", "lighten", 
		"color-dodge", "saturation", "color", "luminosity"
	};
	
	public static final String[] BACKGROUND_REPEAT_VALUES = {
		"repeat", "repeat-x", "repeat-y", "no-repeat", "initial", "inherit"
	};
	
	public static final String[] BACKGROUND_CLIP_VALUES = {
		"border-box", "padding-box", "content-box", "initial", "inherit"	
	};
	
	public static final String[] BACKGROUND_ORIGIN_VALUES = {
		"padding-box", "border-box", "content-box", "initial", "inherit"	
	};
	
	public static final String[] BORDER_STYLE_VALUES = {
		"none", "hidden", "dotted", "dashed", "solid", "double", "groove",
		"ridge", "inset", "outset", "initial", "inherit"
	};
	
	public static final String[] BORDER_IMAGE_REPEAT_VALUES = {
		"stretch", "repeat", "round", "initial", "inherit"
	};
	
	public static final String[] BOX_DECORATION_BREAK_VALUES = {
		"slice", "clone", "initial", "inherit", "unset"
	};
	
	public static final String[] CLEAR_VALUES = {
		"none", "left", "right", "both", "initial", "inherit"	
	};
	
	public static final String[] DISPLAY_VALUES = {
		"inline", "block", "flex", "inline-block", "inline-flex",
		"inline-table", "list-item", "run-in", "table", "table-caption",
		"table-column-group", "table-header-group", "table-footer-group",
		"table-row-group", "table-cell", "tabel-column", "table-row", "none",
		"initial", "inherit"
	};
	
	public static final String[] FLOAT_VALUES = {
		"none", "left", "right", "initial", "inherit"
	};
	
	public static final String[] OVERFLOW_VALUES = {
		"visible", "hidden", "scroll", "auto", "initial", "inherit"	
	};
	
	public static final String[] VISIBILITY_VALUES = {
		"visible", "hidden", "collapse", "initial", "inherit"
	};
	
	public static final String[] ALIGN_CONTENT_VALUES = {
		"stretch", "center", "flex-start", "flex-end", "space-between",
		"space-around", "initial", "inherit"
	};
	
	public static final String[] ALIGN_ITEMS_VALUES = {
		"stretch", "center", "flex-start", "flex-end", "baseline", 
		"initial", "inherit"
	};
	
	public static final String[] ALIGN_SELF_VALUES = {
		"auto", "stretch", "center", "flex-start", "flex-end", "baseline",
		"initial", "inherit"
	};
	
	public static final String[] FLEX_DIRECTION_VALUES = {
		"row", "row-reverse", "column", "column-reverse", "initial", "inherit"	
	};
	
	public static final String[] FLEX_WRAP_VALUES = {
		"nowrap", "wrap", "wrap-reverse", "initial", "inherit"	
	};
	
	public static final String[] JUSTIFY_CONTENT_VALUES = {
		"flex-start", "flex-end", "center", "space-between", "space-around", "initial", "inherit"	
	};
	
}
