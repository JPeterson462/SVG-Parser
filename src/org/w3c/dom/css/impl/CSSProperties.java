package org.w3c.dom.css.impl;

import java.util.HashMap;

import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.impl.values.CSSEnumListValueImplementation;
import org.w3c.dom.css.impl.values.CSSEnumValueImplementation;
import org.w3c.dom.css.impl.values.CSSIRIValueImplementation;
import org.w3c.dom.css.impl.values.CSSLengthValueImplementation;
import org.w3c.dom.css.impl.values.CSSNumberValueImplementation;
import org.w3c.dom.css.impl.values.CSSPaintValueImplementation;
import org.w3c.dom.css.impl.values.CSSStringListValueImplementation;
import org.w3c.dom.svg.SVGErrors;

// https://www.w3.org/TR/SVG/propidx.html
public class CSSProperties {

	private static HashMap<String, CSSProperty> properties = new HashMap<>();
	
	public static CSSProperty getProperty(String name) {
		return properties.get(name);
	}
	
	public static void storeDefaults(CSSStyleDeclarationImplementation declaration) {
		declaration.storeValue(CSSPropertyNames.ALIGNMENT_BASELINE, createEnum(CSSEnums.ALIGNMENT_BASELINE_VALUES, "auto"));
		// baseline-shift
		// clip
		declaration.storeValue(CSSPropertyNames.CLIP_PATH, createIRI("none"));
		declaration.storeValue(CSSPropertyNames.CLIP_RULE, createEnum(CSSEnums.CLIP_RULE_VALUES, "nonzero"));
		declaration.storeValue(CSSPropertyNames.COLOR, new CSSColor("#000"));
		declaration.storeValue(CSSPropertyNames.COLOR_INTERPOLATION, createEnum(CSSEnums.COLOR_INTERPOLATION_VALUES, "sRGB"));
		declaration.storeValue(CSSPropertyNames.COLOR_INTERPOLATION_FILTERS, createEnum(CSSEnums.COLOR_INTERPOLATION_VALUES, "linearRGB"));
		declaration.storeValue(CSSPropertyNames.COLOR_PROFILE, new CSSColorProfile("auto"));
		declaration.storeValue(CSSPropertyNames.COLOR_RENDERING, createEnum(CSSEnums.COLOR_RENDERING_VALUES, "auto"));
		declaration.storeValue(CSSPropertyNames.CURSOR, new CSSCursor("auto"));
		declaration.storeValue(CSSPropertyNames.DIRECTION, createEnum(CSSEnums.DIRECTION_VALUES, "ltr"));
		declaration.storeValue(CSSPropertyNames.DISPLAY, createEnum(CSSEnums.DISPLAY_VALUES, "inline"));
		declaration.storeValue(CSSPropertyNames.DOMINANT_BASELINE, createEnum(CSSEnums.DOMINANT_BASELINE_VALUES, "auto"));
		// enable-background
		declaration.storeValue(CSSPropertyNames.STROKE, createPaint("black"));
		declaration.storeValue(CSSPropertyNames.FILL_OPACITY, createNumber("1"));
		declaration.storeValue(CSSPropertyNames.FILL_RULE, createEnum(CSSEnums.FILL_RULE_VALUES, "nonzero"));
		declaration.storeValue(CSSPropertyNames.FILTER, createIRI("none"));
		declaration.storeValue(CSSPropertyNames.FLOOD_COLOR, new CSSAdvancedColor("black"));
		declaration.storeValue(CSSPropertyNames.FLOOD_OPACITY, createNumber("1"));
		// font
		declaration.storeValue(CSSPropertyNames.FONT_FAMILY, createStringList("inherit"));
		// font-size
		// font-size-adjust
		declaration.storeValue(CSSPropertyNames.FONT_STRETCH, createEnum(CSSEnums.FONT_STRETCH_VALUES, "normal"));
		declaration.storeValue(CSSPropertyNames.FONT_STYLE, createEnum(CSSEnums.FONT_STYLE_VALUES, "normal"));
		declaration.storeValue(CSSPropertyNames.FONT_VARIANT, createEnum(CSSEnums.FONT_VARIANT_VALUES, "normal"));
		declaration.storeValue(CSSPropertyNames.FONT_WEIGHT, createEnum(CSSEnums.FONT_WEIGHT_VALUES, "normal"));
		// glyph-orientation-horizontal
		// glyph-orientation-vertical
		declaration.storeValue(CSSPropertyNames.IMAGE_RENDERING, createEnum(CSSEnums.IMAGE_RENDERING_VALUES, "auto"));
		declaration.storeValue(CSSPropertyNames.KERNING, new CSSLengthValueImplementation("auto", true));
		declaration.storeValue(CSSPropertyNames.LETTER_SPACING, new CSSLengthValueImplementation("normal", false));
		declaration.storeValue(CSSPropertyNames.LIGHTING_COLOR, new CSSAdvancedColor("white"));
		// !marker
		declaration.storeValue(CSSPropertyNames.MARKER_END, createIRI("none"));
		declaration.storeValue(CSSPropertyNames.MARKER_MID, createIRI("none"));
		declaration.storeValue(CSSPropertyNames.MARKER_START, createIRI("none"));
		declaration.storeValue(CSSPropertyNames.MASK, createIRI("none"));
		declaration.storeValue(CSSPropertyNames.OPACITY, createNumber("1"));
		declaration.storeValue(CSSPropertyNames.OVERFLOW, createEnum(CSSEnums.OVERFLOW_VALUES, "auto"));
		declaration.storeValue(CSSPropertyNames.POINTER_EVENTS, createEnum(CSSEnums.POINTER_EVENTS_VALUES, "visiblePainted"));
		declaration.storeValue(CSSPropertyNames.SHAPE_RENDERING, createEnum(CSSEnums.SHAPE_RENDERING_VALUES, "auto"));
		declaration.storeValue(CSSPropertyNames.STOP_COLOR, new CSSAdvancedColor("black"));
		declaration.storeValue(CSSPropertyNames.STOP_OPACITY, createNumber("1"));
		declaration.storeValue(CSSPropertyNames.STROKE, createPaint("none"));
		// stroke-dasharray
		// stroke-dashoffset
		declaration.storeValue(CSSPropertyNames.STROKE_LINECAP, createEnum(CSSEnums.STROKE_LINECAP_VALUES, "butt"));
		declaration.storeValue(CSSPropertyNames.STROKE_LINEJOIN, createEnum(CSSEnums.STROKE_LINEJOIN_VALUES, "miter"));
		declaration.storeValue(CSSPropertyNames.STROKE_MITERLIMIT, createNumber("4"));
		declaration.storeValue(CSSPropertyNames.STROKE_OPACITY, createNumber("1"));
		// stroke-width
		declaration.storeValue(CSSPropertyNames.TEXT_ANCHOR, createEnum(CSSEnums.TEXT_ANCHOR_VALUES, "start"));
		declaration.storeValue(CSSPropertyNames.TEXT_DECORATION, createEnumList(CSSEnums.TEXT_DECORATION_DEFAULT_VALUES, CSSEnums.TEXT_DECORATION_DEFAULT_VALUES, "none"));
		declaration.storeValue(CSSPropertyNames.TEXT_RENDERING, createEnum(CSSEnums.TEXT_RENDERING_VALUES, "auto"));
		declaration.storeValue(CSSPropertyNames.UNICODE_BIDI, createEnum(CSSEnums.FONT_STYLE_VALUES, "normal"));
		declaration.storeValue(CSSPropertyNames.VISIBILITY, createEnum(CSSEnums.VISIBILITY_VALUES, "visible"));
		declaration.storeValue(CSSPropertyNames.WORD_SPACING, new CSSLengthValueImplementation("normal", false));
		declaration.storeValue(CSSPropertyNames.WRITING_MODE, createEnum(CSSEnums.WRITING_MODE_VALUES, "writing-mode"));
	}
	
	public static void tryCreateProperties() {
		if (properties.size() == 0) {
			properties.put(CSSPropertyNames.ALIGNMENT_BASELINE, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.ALIGNMENT_BASELINE, createEnum(CSSEnums.ALIGNMENT_BASELINE_VALUES, cssText));
			});
			// baseline-shift
			// clip
			properties.put(CSSPropertyNames.CLIP_PATH, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.CLIP_PATH, createIRI(cssText));
			});
			properties.put(CSSPropertyNames.CLIP_RULE, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.CLIP_RULE, createEnum(CSSEnums.CLIP_RULE_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.COLOR, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.COLOR, new CSSColor(cssText));
			});
			properties.put(CSSPropertyNames.COLOR_INTERPOLATION, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.COLOR_INTERPOLATION, createEnum(CSSEnums.COLOR_INTERPOLATION_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.COLOR_INTERPOLATION_FILTERS, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.COLOR_INTERPOLATION_FILTERS, createEnum(CSSEnums.COLOR_INTERPOLATION_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.COLOR_PROFILE, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.COLOR_PROFILE, new CSSColorProfile(cssText));
			});
			properties.put(CSSPropertyNames.COLOR_RENDERING, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.COLOR_RENDERING, createEnum(CSSEnums.COLOR_RENDERING_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.CURSOR, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.CURSOR, new CSSCursor(cssText));
			});
			properties.put(CSSPropertyNames.DIRECTION, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.DIRECTION, createEnum(CSSEnums.DIRECTION_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.DISPLAY, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.DISPLAY, createEnum(CSSEnums.DISPLAY_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.DOMINANT_BASELINE, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.DOMINANT_BASELINE, createEnum(CSSEnums.DOMINANT_BASELINE_VALUES, cssText));
			});
			// enable-background
			properties.put(CSSPropertyNames.FILL, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.STROKE, createPaint(cssText));
			});
			properties.put(CSSPropertyNames.FILL_OPACITY, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FILL_OPACITY, createNumber(cssText));
			});
			properties.put(CSSPropertyNames.FILL_RULE, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FILL_RULE, createEnum(CSSEnums.FILL_RULE_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.FILTER, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FILTER, createIRI(cssText));
			});
			properties.put(CSSPropertyNames.FLOOD_COLOR, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FLOOD_COLOR, new CSSAdvancedColor("black"));
			});
			properties.put(CSSPropertyNames.FLOOD_OPACITY, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FLOOD_OPACITY, createNumber(cssText));
			});
			// font
			properties.put(CSSPropertyNames.FONT_FAMILY, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FONT_FAMILY, createStringList(cssText));
			});
			// font-size
			// font-size-adjust
			properties.put(CSSPropertyNames.FONT_STRETCH, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FONT_STRETCH, createEnum(CSSEnums.FONT_STRETCH_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.FONT_STYLE, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FONT_STYLE, createEnum(CSSEnums.FONT_STYLE_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.FONT_VARIANT, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FONT_VARIANT, createEnum(CSSEnums.FONT_VARIANT_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.FONT_WEIGHT, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FONT_WEIGHT, createEnum(CSSEnums.FONT_WEIGHT_VALUES, cssText));
			});
			// glyph-orientation-horizontal
			// glyph-orientation-vertical
			properties.put(CSSPropertyNames.IMAGE_RENDERING, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.IMAGE_RENDERING, createEnum(CSSEnums.IMAGE_RENDERING_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.KERNING, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.KERNING, new CSSLengthValueImplementation(cssText, true));
			});
			properties.put(CSSPropertyNames.LETTER_SPACING, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.LETTER_SPACING, new CSSLengthValueImplementation(cssText, false));
			});
			properties.put(CSSPropertyNames.LIGHTING_COLOR, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.LIGHTING_COLOR, new CSSAdvancedColor("white"));
			});
			// !marker
			properties.put(CSSPropertyNames.MARKER_END, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.MARKER_END, createIRI(cssText));
			});
			properties.put(CSSPropertyNames.MARKER_MID, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.MARKER_MID, createIRI(cssText));
			});
			properties.put(CSSPropertyNames.MARKER_START, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.MARKER_START, createIRI(cssText));
			});
			properties.put(CSSPropertyNames.MASK, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.MASK, createIRI(cssText));
			});
			properties.put(CSSPropertyNames.OPACITY, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.OPACITY, createNumber(cssText));
			});
			properties.put(CSSPropertyNames.OVERFLOW, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.OVERFLOW, createEnum(CSSEnums.OVERFLOW_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.POINTER_EVENTS, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.POINTER_EVENTS, createEnum(CSSEnums.POINTER_EVENTS_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.SHAPE_RENDERING, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.SHAPE_RENDERING, createEnum(CSSEnums.SHAPE_RENDERING_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.STOP_COLOR, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.STOP_COLOR, new CSSAdvancedColor("black"));
			});
			properties.put(CSSPropertyNames.STOP_OPACITY, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.STOP_OPACITY, createNumber(cssText));
			});
			properties.put(CSSPropertyNames.STROKE, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.STROKE, createPaint(cssText));
			});
			// stroke-dasharray
			// stroke-dashoffset
			properties.put(CSSPropertyNames.STROKE_LINECAP, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.STROKE_LINECAP, createEnum(CSSEnums.STROKE_LINECAP_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.STROKE_LINEJOIN, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.STROKE_LINEJOIN, createEnum(CSSEnums.STROKE_LINEJOIN_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.STROKE_MITERLIMIT, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.STROKE_MITERLIMIT, createNumber(cssText));
			});
			properties.put(CSSPropertyNames.STROKE_OPACITY, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.STROKE_OPACITY, createNumber(cssText));
			});
			// stroke-width
			properties.put(CSSPropertyNames.TEXT_ANCHOR, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.TEXT_ANCHOR, createEnum(CSSEnums.TEXT_ANCHOR_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.TEXT_DECORATION, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.TEXT_DECORATION, createEnumList(CSSEnums.TEXT_DECORATION_DEFAULT_VALUES, CSSEnums.TEXT_DECORATION_DEFAULT_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.TEXT_RENDERING, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.TEXT_RENDERING, createEnum(CSSEnums.TEXT_RENDERING_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.UNICODE_BIDI, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.UNICODE_BIDI, createEnum(CSSEnums.FONT_STYLE_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.VISIBILITY, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.VISIBILITY, createEnum(CSSEnums.VISIBILITY_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.WORD_SPACING, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.WORD_SPACING, new CSSLengthValueImplementation(cssText, false));
			});
			properties.put(CSSPropertyNames.WRITING_MODE, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.WRITING_MODE, createEnum(CSSEnums.WRITING_MODE_VALUES, cssText));
			});
		}
	}
	
	private static CSSValue createEnum(String[] values, String value) {
		CSSValue enumValue = new CSSEnumValueImplementation(values);
		enumValue.setCssText(value);
		return enumValue;
	}
	
	private static CSSValue createIRI(String cssText) {
		CSSValue value = new CSSIRIValueImplementation();
		value.setCssText(cssText);
		return value;
	}
	
	private static CSSValue createNumber(String cssText) {
		CSSValue value = new CSSNumberValueImplementation();
		value.setCssText(cssText);
		return value;
	}
	
	private static CSSValue createEnumList(String[] defaultValues, String[] listValues, String cssText) {
		CSSValue enumListValue = new CSSEnumListValueImplementation(defaultValues, listValues);
		enumListValue.setCssText(cssText);
		return enumListValue;
	}
	
	private static CSSValue createStringList(String cssText) {
		CSSValue stringListValue = new CSSStringListValueImplementation();
		stringListValue.setCssText(cssText);
		return stringListValue;
	}
	
	private static CSSValue createPaint(String cssText) {
		CSSValue paintValue = new CSSPaintValueImplementation();
		paintValue.setCssText(cssText);
		return paintValue;
	}
	
	public static void parseValue(String propertyName, String cssText, CSSStyleDeclarationImplementation declaration) {
		if (!properties.containsKey(propertyName)) {
			SVGErrors.error("Invalid CSS Property: " + propertyName);
		}
		properties.get(propertyName).parseValue(cssText, declaration);
	}
	
}
