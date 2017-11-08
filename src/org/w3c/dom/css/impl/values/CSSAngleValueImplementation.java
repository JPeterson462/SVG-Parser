package org.w3c.dom.css.impl.values;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSAngleValue;
import org.w3c.dom.css.CSSTypedValue;
import org.w3c.dom.css.CSSValueType;
import org.w3c.dom.svg.SVGAngle;

public class CSSAngleValueImplementation implements CSSAngleValue, CSSTypedValue {
	
	private static final int STATE_INHERIT = 0, STATE_AUTO = 1, STATE_VALUE = 2;
	
	private boolean canBeAuto;
	
	private int state;
	
	private SVGAngle angle;
	
	private String cssText;
	
	public CSSAngleValueImplementation(boolean canBeAuto) {
		this.canBeAuto = canBeAuto;
		state = canBeAuto ? STATE_AUTO : STATE_VALUE;
		angle = new SVGAngle.Implementation(SVGAngle.SVG_ANGLETYPE_DEG, 0);
	}

	@Override
	public String getCssText() {
		return cssText;
	}

	@Override
	public short getCssValueType() {
		return state == STATE_INHERIT ? CSS_INHERIT : CSS_PRIMITIVE_VALUE;
	}

	@Override
	public void setCssText(String text) throws DOMException {
		text = text.trim();
		cssText = text;
		if (canBeAuto && text.equals("auto")) {
			state = STATE_AUTO;
		}
		else if (text.equals("inherit")) {
			state = STATE_INHERIT;
		}
		else if (!canBeAuto && text.equals("auto")) {
			DOMErrors.invalidValue();
		}
		else {
			angle.setValueAsString(text);
		}
	}

	@Override
	public SVGAngle getAngle() {
		return angle;
	}

	@Override
	public boolean isAuto() {
		return state == STATE_AUTO;
	}

	@Override
	public boolean isInherit() {
		return state == STATE_INHERIT;
	}

	@Override
	public CSSValueType getType() {
		return CSSValueType.ANGLE;
	}

}
