package org.w3c.dom.css.impl.values;

import java.util.ArrayList;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSFontDefinitionValue;
import org.w3c.dom.css.CSSLengthValue;
import org.w3c.dom.css.CSSSizeValue;
import org.w3c.dom.css.CSSStringListValue;
import org.w3c.dom.css.CSSTypedValue;
import org.w3c.dom.css.CSSValueType;
import org.w3c.dom.css.impl.CSSEnums;
import org.w3c.dom.css.impl.StringUtils;

public class CSSFontDefinitionValueImplementation implements CSSFontDefinitionValue, CSSTypedValue {

	private String cssText;
	
	private String fontStyle, fontVariant, fontWeight;
	
	private CSSSizeValue fontSize;
	
	private CSSLengthValue lineHeight;
	
	private CSSStringListValue fontFamily;
	
	@Override
	public String getCssText() {
		return cssText;
	}

	@Override
	public short getCssValueType() {
		return isInherit() ? CSS_INHERIT : CSS_PRIMITIVE_VALUE;
	}

	@Override
	public void setCssText(String text) throws DOMException {
		text = text.trim();
		cssText = text;
		fontStyle = null;
		fontVariant = null;
		fontWeight = null;
		fontSize = null;
		lineHeight = null;
		fontFamily = null;
		if (isDefinition()) {
			ArrayList<String> values = StringUtils.splitByWhitespace(text);
			String[] fontStyles = CSSEnums.FONT_STYLE_VALUES;
			String[] fontVariants = CSSEnums.FONT_VARIANT_VALUES;
			String[] fontWeights = CSSEnums.FONT_WEIGHT_VALUES;
			int offset = 0;
			if (contains(values.get(offset), fontStyles)) {
				fontStyle = values.get(offset);
				offset++;
			}
			if (contains(values.get(offset), fontVariants)) {
				fontVariant = values.get(offset);
				offset++;
			}
			if (contains(values.get(offset), fontWeights)) {
				fontWeight = values.get(offset);
				offset++;
			}
			fontSize = new CSSSizeValueImplementation();
			fontSize.setCssText(values.get(offset));
			offset++;
			if (offset < values.size() && values.get(offset).equals("/")) {
				offset++;
				lineHeight = new CSSLengthValueImplementation(values.get(offset), CSSLengthValueImplementation.VALUE_NORMAL | CSSLengthValueImplementation.VALUE_INHERIT);
				lineHeight.setCssText(values.get(offset));
				offset++;
			}
			if (offset < values.size()) {
				String remainingText = "";
				for (int i = offset; i < values.size(); i++) {
					remainingText += values.get(i) + (i < values.size() - 1 ? " " : "");
				}
				fontFamily = new CSSStringListValueImplementation();
				fontFamily.setCssText(remainingText);
			}
		}
	}
	
	private boolean contains(String value, String[] possible) {
		for (int i = 0; i < possible.length; i++) {
			if (possible[i].equals(value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isDefinition() {
		return !(isCaption() || isIcon() || isMenu() || isMessageBox() || isSmallCaption() || isStatusBar() || isInherit());
	}

	@Override
	public boolean isCaption() {
		return cssText.equals("caption");
	}

	@Override
	public boolean isIcon() {
		return cssText.equals("icon");
	}

	@Override
	public boolean isMenu() {
		return cssText.equals("menu");
	}

	@Override
	public boolean isMessageBox() {
		return cssText.equals("message-box");
	}

	@Override
	public boolean isSmallCaption() {
		return cssText.equals("small-caption");
	}

	@Override
	public boolean isStatusBar() {
		return cssText.equals("status-bar");
	}

	@Override
	public boolean isInherit() {
		return cssText.equals("inherit");
	}

	@Override
	public String getFontStyle() {
		return fontStyle;
	}

	@Override
	public String getFontVariant() {
		return fontVariant;
	}

	@Override
	public String getFontWeight() {
		return fontWeight;
	}

	@Override
	public CSSSizeValue getFontSize() {
		return fontSize;
	}

	@Override
	public CSSLengthValue getLineHeight() {
		return lineHeight;
	}

	@Override
	public CSSStringListValue getFontFamily() {
		return fontFamily;
	}

	@Override
	public CSSValueType getType() {
		return CSSValueType.FONT_DEFINITION;
	}

}
