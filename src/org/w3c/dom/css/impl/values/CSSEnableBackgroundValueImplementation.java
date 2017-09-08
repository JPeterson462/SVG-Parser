package org.w3c.dom.css.impl.values;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSEnableBackgroundValue;
import org.w3c.dom.svg.parser.ElementParser;

public class CSSEnableBackgroundValueImplementation implements CSSEnableBackgroundValue {

	private String cssText;
	
	private boolean auto;
	
	private float x, y, width, height;
	
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
		x = CSSEnableBackgroundValue.UNSET_VALUE;
		y = CSSEnableBackgroundValue.UNSET_VALUE;
		width = CSSEnableBackgroundValue.UNSET_VALUE;
		height = CSSEnableBackgroundValue.UNSET_VALUE;
		auto = false;
		if (isInherit() || isAccumulate()) {
			// Fixed value
		} else {
			ElementParser.ValueTokenizer tokenizer = new ElementParser.ValueTokenizer(text.toCharArray());
			String value = tokenizer.readString();
			if (value.equals("new")) {
				if (tokenizer.moreData()) {
					x = tokenizer.readValue();
					y = tokenizer.readValue();
					width = tokenizer.readValue();
					height = tokenizer.readValue();
				} else {
					auto = true;
				}
			} else {
				DOMErrors.invalidValue();
			}
		}
	}

	@Override
	public boolean isAccumulate() {
		return cssText.equals("accumulate");
	}

	@Override
	public boolean isInherit() {
		return cssText.equals("inherit");
	}

	@Override
	public boolean isAuto() {
		return auto;
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public float getWidth() {
		return width;
	}

	@Override
	public float getHeight() {
		return height;
	}

}
