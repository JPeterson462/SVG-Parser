package org.w3c.dom.css.impl;

import java.util.HashMap;

import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.SVGColor;
import org.w3c.dom.svg.SVGErrors;

public class CSSProperties {

	private static HashMap<String, CSSProperty> properties = new HashMap<>();
	
	public static void storeDefaults(CSSStyleDeclarationImplementation declaration) {
		SVGColor color = new SVGColor.Implementation();
		color.setRGBColor("#000");
		declaration.storeValue(CSSPropertyNames.COLOR, color);
		CSSValue opacity = new CSSNumberValueImplementation();
		opacity.setCssText("1");
		declaration.storeValue(CSSPropertyNames.OPACITY, opacity);
		// !background
		declaration.storeValue(CSSPropertyNames.BACKGROUND_ATTACHMENT, createEnum(CSSEnums.BACKGROUND_ATTACHMENT_VALUES, "scroll"));
		declaration.storeValue(CSSPropertyNames.BACKGROUND_BLEND_MODE, createEnum(CSSEnums.BACKGROUND_BLEND_MODE_VALUES, "normal"));
		SVGColor backgroundColor = new SVGColor.Implementation();
		backgroundColor.setRGBColor("#FFF");
		declaration.storeValue(CSSPropertyNames.BACKGROUND_COLOR, backgroundColor);
		// background-image
		// background-position
		declaration.storeValue(CSSPropertyNames.BACKGROUND_REPEAT, createEnum(CSSEnums.BACKGROUND_REPEAT_VALUES, "repeat"));
		declaration.storeValue(CSSPropertyNames.BACKGROUND_CLIP, createEnum(CSSEnums.BACKGROUND_CLIP_VALUES, "border-box"));
		declaration.storeValue(CSSPropertyNames.BACKGROUND_ORIGIN, createEnum(CSSEnums.BACKGROUND_ORIGIN_VALUES, "padding-box"));
		// background-size
		// !border
		// !border-bottom
		// border-bottom-color
		// border-bottom-left-radius
		// border-bottom-right-radius
		declaration.storeValue(CSSPropertyNames.BORDER_BOTTOM_STYLE, createEnum(CSSEnums.BORDER_STYLE_VALUES, "none"));
		// border-bottom-width
		// !border-color
		// border-image
		// border-image-outset
		declaration.storeValue(CSSPropertyNames.BORDER_IMAGE_REPEAT, createEnum(CSSEnums.BORDER_IMAGE_REPEAT_VALUES, "stretch"));
		// border-image-slice
		// border-image-source
		// border-image-width
		// !border-left
		// border-left-color
		declaration.storeValue(CSSPropertyNames.BORDER_LEFT_STYLE, createEnum(CSSEnums.BORDER_STYLE_VALUES, "none"));
		// border-left-width
		// border-radius
		// !border-right
		// border-right-color
		declaration.storeValue(CSSPropertyNames.BORDER_RIGHT_STYLE, createEnum(CSSEnums.BORDER_STYLE_VALUES, "none"));
		// border-right-width
		// !border-style
		// !border-top
		// border-top-color
		// border-top-left-radius
		// border-top-right-radius
		// border-top-style
		// border-top-width
		// !border-width
		declaration.storeValue(CSSPropertyNames.BOX_DECORATION_BREAK, createEnum(CSSEnums.BOX_DECORATION_BREAK_VALUES, "slice"));
		// box-shadow
		// bottom
		declaration.storeValue(CSSPropertyNames.CLEAR, createEnum(CSSEnums.CLEAR_VALUES, "none"));
		// clip
		declaration.storeValue(CSSPropertyNames.DISPLAY, createEnum(CSSEnums.DISPLAY_VALUES, "inline"));
		declaration.storeValue(CSSPropertyNames.FLOAT, createEnum(CSSEnums.FLOAT_VALUES, "none"));
		// height
		// left
		// !margin
		// margin-bottom
		// margin-left
		// margin-right
		// margin-top
		// max-height
		// max-width
		// min-height
		// min-width
		// !overflow
		declaration.storeValue(CSSPropertyNames.OVERFLOW_X, createEnum(CSSEnums.OVERFLOW_VALUES, "visible"));
		declaration.storeValue(CSSPropertyNames.OVERFLOW_Y, createEnum(CSSEnums.OVERFLOW_VALUES, "visible"));
		// !padding
		// padding-bottom
		// padding-left
		// padding-right
		// padding-top
		// position
		// right
		// top
		declaration.storeValue(CSSPropertyNames.VISIBLITY, createEnum(CSSEnums.VISIBILITY_VALUES, "visible"));
		// width
		// vertical-align
		// z-index
		declaration.storeValue(CSSPropertyNames.ALIGN_CONTENT, createEnum(CSSEnums.ALIGN_CONTENT_VALUES, "stretch"));
		declaration.storeValue(CSSPropertyNames.ALIGN_ITEMS, createEnum(CSSEnums.ALIGN_ITEMS_VALUES, "stretch"));
		declaration.storeValue(CSSPropertyNames.ALIGN_SELF, createEnum(CSSEnums.ALIGN_SELF_VALUES, "auto"));
		// flex
		// flex-basis
		declaration.storeValue(CSSPropertyNames.FLEX_DIRECTION, createEnum(CSSEnums.FLEX_DIRECTION_VALUES, "row"));
		// flex-flow
		// flex-grow
		// flex-shrink
		declaration.storeValue(CSSPropertyNames.FLEX_WRAP, createEnum(CSSEnums.FLEX_WRAP_VALUES, "nowrap"));
		declaration.storeValue(CSSPropertyNames.JUSTIFY_CONTENT, createEnum(CSSEnums.JUSTIFY_CONTENT_VALUES, "flex-start"));
		// order
		// -- Text Properties --
	}
	
	public static void tryCreateProperties() {
		if (properties.size() == 0) {
			properties.put(CSSPropertyNames.COLOR, (cssText, declaration) -> {
				SVGColor color = new SVGColor.Implementation();
				color.setCssText(cssText);
				declaration.storeValue(CSSPropertyNames.COLOR, color);
			});
			properties.put(CSSPropertyNames.OPACITY, (cssText, declaration) -> {
				CSSValue value = new CSSNumberValueImplementation();
				value.setCssText(cssText);
				declaration.storeValue(CSSPropertyNames.OPACITY, value);
			});
			// background
			properties.put(CSSPropertyNames.BACKGROUND_ATTACHMENT, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.BACKGROUND_ATTACHMENT, createEnum(CSSEnums.BACKGROUND_ATTACHMENT_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.BACKGROUND_BLEND_MODE, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.BACKGROUND_BLEND_MODE, createEnum(CSSEnums.BACKGROUND_BLEND_MODE_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.BACKGROUND_COLOR, (cssText, declaration) -> {
				SVGColor color = new SVGColor.Implementation();
				color.setCssText(cssText);
				declaration.storeValue(CSSPropertyNames.BACKGROUND_COLOR, color);
			});
			// background-image
			// background-position
			properties.put(CSSPropertyNames.BACKGROUND_REPEAT, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.BACKGROUND_REPEAT, createEnum(CSSEnums.BACKGROUND_REPEAT_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.BACKGROUND_CLIP, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.BACKGROUND_CLIP, createEnum(CSSEnums.BACKGROUND_CLIP_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.BACKGROUND_ORIGIN, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.BACKGROUND_ORIGIN, createEnum(CSSEnums.BACKGROUND_ORIGIN_VALUES, cssText));
			});
			// background-size
			// border
			// border-bottom
			properties.put(CSSPropertyNames.BORDER_BOTTOM_COLOR, (cssText, declaration) -> {
				SVGColor color = new SVGColor.Implementation();
				color.setCssText(cssText);
				declaration.storeValue(CSSPropertyNames.BORDER_BOTTOM_COLOR, color);
			});
			// border-bottom-left-radius
			// border-bottom-right-radius
			properties.put(CSSPropertyNames.BORDER_BOTTOM_STYLE, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.BORDER_BOTTOM_STYLE, createEnum(CSSEnums.BORDER_STYLE_VALUES, cssText));
			});
			// border-bottom-width
			// border-color
			// border-image
			// border-image-outset
			properties.put(CSSPropertyNames.BORDER_IMAGE_REPEAT, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.BORDER_IMAGE_REPEAT, createEnum(CSSEnums.BORDER_IMAGE_REPEAT_VALUES, cssText));
			});
			// border-image-slice
			// border-image-source
			// border-image-width
			// border-left
			// border-left-color
			properties.put(CSSPropertyNames.BORDER_LEFT_STYLE, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.BORDER_LEFT_STYLE, createEnum(CSSEnums.BORDER_STYLE_VALUES, cssText));
			});
			// border-left-width
			// border-radius
			// border-right
			// border-right-color
			properties.put(CSSPropertyNames.BORDER_RIGHT_STYLE, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.BORDER_RIGHT_STYLE, createEnum(CSSEnums.BORDER_STYLE_VALUES, cssText));
			});
			// border-right-width
			properties.put(CSSPropertyNames.BORDER_STYLE, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.BORDER_TOP_STYLE, createEnum(CSSEnums.BORDER_STYLE_VALUES, cssText));
				declaration.storeValue(CSSPropertyNames.BORDER_RIGHT_STYLE, createEnum(CSSEnums.BORDER_STYLE_VALUES, cssText));
				declaration.storeValue(CSSPropertyNames.BORDER_BOTTOM_STYLE, createEnum(CSSEnums.BORDER_STYLE_VALUES, cssText));
				declaration.storeValue(CSSPropertyNames.BORDER_LEFT_STYLE, createEnum(CSSEnums.BORDER_STYLE_VALUES, cssText));
			});
			// border-top
			// border-top-color
			// border-top-left-radius
			// border-top-right-radius
			properties.put(CSSPropertyNames.BORDER_TOP_STYLE, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.BORDER_TOP_STYLE, createEnum(CSSEnums.BORDER_STYLE_VALUES, cssText));
			});
			// border-top-width
			// border-width
			properties.put(CSSPropertyNames.BOX_DECORATION_BREAK, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.BOX_DECORATION_BREAK, createEnum(CSSEnums.BOX_DECORATION_BREAK_VALUES, cssText));
			});
			// box-shadow
			// bottom
			properties.put(CSSPropertyNames.CLEAR, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.CLEAR, createEnum(CSSEnums.CLEAR_VALUES, cssText));
			});
			// clip
			properties.put(CSSPropertyNames.DISPLAY, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.DISPLAY, createEnum(CSSEnums.DISPLAY_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.FLOAT, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FLOAT, createEnum(CSSEnums.FLOAT_VALUES, cssText));
			});
			// height
			// left
			// !margin
			// margin-bottom
			// margin-left
			// margin-right
			// margin-top
			// max-height
			// max-width
			// min-height
			// min-width
			properties.put(CSSPropertyNames.OVERFLOW, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.OVERFLOW_X, createEnum(CSSEnums.OVERFLOW_VALUES, cssText));
				declaration.storeValue(CSSPropertyNames.OVERFLOW_Y, createEnum(CSSEnums.OVERFLOW_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.OVERFLOW_X, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.OVERFLOW_X, createEnum(CSSEnums.OVERFLOW_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.OVERFLOW_Y, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.OVERFLOW_Y, createEnum(CSSEnums.OVERFLOW_VALUES, cssText));
			});
			// padding
			// padding-bottom
			// padding-left
			// padding-right
			// padding-top
			// position
			// right
			// top
			properties.put(CSSPropertyNames.VISIBLITY, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.VISIBLITY, createEnum(CSSEnums.VISIBILITY_VALUES, cssText));
			});
			// width
			// vertical-align
			// z-index
			properties.put(CSSPropertyNames.ALIGN_CONTENT, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.ALIGN_CONTENT, createEnum(CSSEnums.ALIGN_CONTENT_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.ALIGN_ITEMS, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.ALIGN_ITEMS, createEnum(CSSEnums.ALIGN_ITEMS_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.ALIGN_SELF, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.ALIGN_SELF, createEnum(CSSEnums.ALIGN_SELF_VALUES, cssText));
			});
			// flex
			// flex-basis
			properties.put(CSSPropertyNames.FLEX_DIRECTION, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FLEX_DIRECTION, createEnum(CSSEnums.FLEX_DIRECTION_VALUES, cssText));
			});
			// flex-flow
			// flex-grow
			// flex-shrink
			properties.put(CSSPropertyNames.FLEX_WRAP, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.FLEX_WRAP, createEnum(CSSEnums.FLEX_WRAP_VALUES, cssText));
			});
			properties.put(CSSPropertyNames.JUSTIFY_CONTENT, (cssText, declaration) -> {
				declaration.storeValue(CSSPropertyNames.JUSTIFY_CONTENT, createEnum(CSSEnums.JUSTIFY_CONTENT_VALUES, cssText));
			});
			// order
			// -- Text Properties --
		}
	}
	
	private static CSSValue createEnum(String[] values, String value) {
		CSSValue enumValue = new CSSEnumValueImplementation(values);
		enumValue.setCssText(value);
		return enumValue;
	}
	
	public static void parseValue(String propertyName, String cssText, CSSStyleDeclarationImplementation declaration) {
		if (!properties.containsKey(propertyName)) {
			SVGErrors.error("Invalid CSS Property: " + propertyName);
		}
		properties.get(propertyName).parseValue(cssText, declaration);
	}
	
}
