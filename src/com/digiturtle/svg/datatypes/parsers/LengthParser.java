package com.digiturtle.svg.datatypes.parsers;

import com.digiturtle.svg.DataParser;
import com.digiturtle.svg.StringUtils;
import com.digiturtle.svg.datatypes.Length;

public class LengthParser implements DataParser<Length> {

	@Override
	public Length parse(String text, boolean presentationAttribute) {
		if (!presentationAttribute) {
			text = text.toLowerCase();
		}
		int unit; // 0 = em, 1 = ex, 2 = px, 3 = in, 4 = cm, 5 = mm, 6 = pt, 7 = pc, 8 = percent
		float value = 0;
		if (StringUtils.isNumber(text)) {
			value = Float.parseFloat(text);
			unit = 2;
		} else {
			if (text.endsWith("em")) {
				value = Float.parseFloat(text.substring(0, text.length() - 2));
				unit = 0;
			}
			else if (text.endsWith("ex")) {
				value = Float.parseFloat(text.substring(0, text.length() - 2));
				unit = 1;
			}
			else if (text.endsWith("px")) {
				value = Float.parseFloat(text.substring(0, text.length() - 2));
				unit = 2;
			}
			else if (text.endsWith("in")) {
				value = Float.parseFloat(text.substring(0, text.length() - 2));
				unit = 3;
			}
			else if (text.endsWith("cm")) {
				value = Float.parseFloat(text.substring(0, text.length() - 2));
				unit = 4;
			}
			else if (text.endsWith("mm")) {
				value = Float.parseFloat(text.substring(0, text.length() - 2));
				unit = 5;
			}
			else if (text.endsWith("pt")) {
				value = Float.parseFloat(text.substring(0, text.length() - 2));
				unit = 6;
			}
			else if (text.endsWith("pc")) {
				value = Float.parseFloat(text.substring(0, text.length() - 2));
				unit = 7;
			}
			else if (text.endsWith("%") && presentationAttribute) {
				value = Float.parseFloat(text.substring(0, text.length() - 1));
				unit = 8;
			}
			else {
				return null;
			}
		}
		Length length = new Length();
		if (unit == 0) {
			length.setLengthEm(value);
		}
		else if (unit == 1) {
			length.setLengthEx(value);
		}
		else if (unit == 2) {
			length.setLengthPx(value);
		}
		else if (unit == 3) {
			length.setLengthIn(value);
		}
		else if (unit == 4) {
			length.setLengthCm(value);
		}
		else if (unit == 5) {
			length.setLengthMm(value);
		}
		else if (unit == 6) {
			length.setLengthPt(value);
		}
		else if (unit == 7) {
			length.setLengthPc(value);
		}
		else if (unit == 8) {
			length.setLengthPercent(value);
		}
		return length;
	}

}
