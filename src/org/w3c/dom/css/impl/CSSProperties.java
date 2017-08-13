package org.w3c.dom.css.impl;

import java.util.HashMap;

import org.w3c.dom.css.CSSValue;
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
		// color-profile
		declaration.storeValue(CSSPropertyNames.COLOR_RENDERING, createEnum(CSSEnums.COLOR_RENDERING_VALUES, "auto"));
		// cursor
		declaration.storeValue(CSSPropertyNames.DIRECTION, createEnum(CSSEnums.DIRECTION_VALUES, "ltr"));
		declaration.storeValue(CSSPropertyNames.DISPLAY, createEnum(CSSEnums.DISPLAY_VALUES, "inline"));
		declaration.storeValue(CSSPropertyNames.DOMINANT_BASELINE, createEnum(CSSEnums.DOMINANT_BASELINE_VALUES, "auto"));
		// enable-background
		// fill
		// fill-opacity
		declaration.storeValue(CSSPropertyNames.FILL_RULE, createEnum(CSSEnums.FILL_RULE_VALUES, "nonzero"));
		declaration.storeValue(CSSPropertyNames.FILTER, createIRI("none"));
		// flood-color
		// flood-opacity
		// font
		// font-family
		// font-size
		// font-size-adjust
		declaration.storeValue(CSSPropertyNames.FONT_STRETCH, createEnum(CSSEnums.FONT_STRETCH_VALUES, "normal"));
		// ...
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
			// color-profile
			properties.put(CSSPropertyNames.COLOR_RENDERING, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.COLOR_RENDERING, createEnum(CSSEnums.COLOR_RENDERING_VALUES, cssText));
			});
			// cursor
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
			// fill
			// fill-opacity
			properties.put(CSSPropertyNames.FILL_RULE, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FILL_RULE, createEnum(CSSEnums.FILL_RULE_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.FILTER, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FILTER, createIRI(cssText));
			});
			// flood-color
			// flood-opacity
			// font
			// font-family
			// font-size
			// font-size-adjust
			properties.put(CSSPropertyNames.FONT_STRETCH, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FONT_STRETCH, createEnum(CSSEnums.FONT_STRETCH_VALUES, cssText));
			});
			// ...
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
	
	public static void parseValue(String propertyName, String cssText, CSSStyleDeclarationImplementation declaration) {
		if (!properties.containsKey(propertyName)) {
			SVGErrors.error("Invalid CSS Property: " + propertyName);
		}
		properties.get(propertyName).parseValue(cssText, declaration);
	}
	
}
