package org.w3c.dom.css.impl.values;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSShapeValue;
import org.w3c.dom.css.CSSTypedValue;
import org.w3c.dom.css.CSSValueType;
import org.w3c.dom.css.Connected;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGLength;

// The only supported shape is a rectangle
public class CSSShapeValueImplementation implements CSSShapeValue, Connected, CSSTypedValue {
	
	private String cssText;
	
	private boolean topAuto, leftAuto, rightAuto, bottomAuto;
	
	private SVGLength top, left, right, bottom;
	
	public void connect(SVGElement element) {
		if (top != null) {
			((SVGLength.Implementation) top).setElement(element);
		}
		if (right != null) {
			((SVGLength.Implementation) right).setElement(element);
		}
		if (bottom != null) {
			((SVGLength.Implementation) bottom).setElement(element);
		}
		if (left != null) {
			((SVGLength.Implementation) left).setElement(element);
		}
	}

	@Override
	public String getCssText() {
		return cssText;
	}

	@Override
	public short getCssValueType() {
		return cssText.equals("inherit") ? CSS_INHERIT : CSS_PRIMITIVE_VALUE;
	}

	@Override
	public void setCssText(String text) throws DOMException {
		text = text.trim();
		cssText = text;
		if (text.equals("auto")) {
			top = null;
			right = null;
			bottom = null;
			left = null;
			topAuto = true;
			rightAuto = true;
			bottomAuto = true;
			leftAuto = true;
		}
		else if (text.equals("inherit")) {
			top = null;
			right = null;
			bottom = null;
			left = null;
			topAuto = false;
			rightAuto = false;
			bottomAuto = false;
			leftAuto = false;
		}
		else {
			if (text.startsWith("rect(")) {
				text = text.substring(5, text.length() - 1);
				String[] parts = text.split(",");
				if (parts.length < 4) {
					DOMErrors.invalidValue();
				}
				top = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, null);
				parts[0] = parts[0].trim();
				if (parts[0].equals("auto")) {
					topAuto = true;
					top = null;
				} else {
					topAuto = false;
					top.setValueAsString(parts[0]);
				}
				right = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, null);
				parts[1] = parts[1].trim();
				if (parts[1].equals("auto")) {
					rightAuto = true;
					right = null;
				} else {
					rightAuto = false;
					right.setValueAsString(parts[1]);
				}
				bottom = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, null);
				parts[2] = parts[2].trim();
				if (parts[2].equals("auto")) {
					bottomAuto = true;
					bottom = null;
				} else {
					bottomAuto = false;
					bottom.setValueAsString(parts[2]);
				}
				left = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, null);
				parts[3] = parts[3].trim();
				if (parts[3].equals("auto")) {
					leftAuto = true;
					left = null;
				} else {
					leftAuto = false;
					left.setValueAsString(parts[3]);
				}
			} else {
				DOMErrors.invalidValue();
			}
		}
	}

	@Override
	public SVGLength getTop() {
		return top;
	}

	@Override
	public SVGLength getRight() {
		return right;
	}

	@Override
	public SVGLength getBottom() {
		return bottom;
	}

	@Override
	public SVGLength getLeft() {
		return left;
	}

	@Override
	public boolean isTopAuto() {
		return topAuto;
	}

	@Override
	public boolean isRightAuto() {
		return rightAuto;
	}

	@Override
	public boolean isBottomAuto() {
		return bottomAuto;
	}

	@Override
	public boolean isLeftAuto() {
		return leftAuto;
	}

	@Override
	public CSSValueType getType() {
		return CSSValueType.SHAPE;
	}

}
