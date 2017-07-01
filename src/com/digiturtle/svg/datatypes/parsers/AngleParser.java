package com.digiturtle.svg.datatypes.parsers;

import com.digiturtle.svg.DataParser;
import com.digiturtle.svg.StringUtils;
import com.digiturtle.svg.datatypes.Angle;

public class AngleParser implements DataParser<Angle> {
	
	public Angle parse(String text, boolean presentationAttribute) {
		if (!presentationAttribute) {
			text = text.toLowerCase();
		}
		int unit; // 0 = degrees, 1 = radians, 2 = gradians
		float value = 0;
		if (StringUtils.isNumber(text)) {
			value = Float.parseFloat(text);
			unit = 0;
		} else {
			if (text.endsWith("deg")) {
				value = Float.parseFloat(text.substring(0, text.length() - 3));
				unit = 0;
			}
			else if (text.endsWith("grad")) {
				value = Float.parseFloat(text.substring(0, text.length() - 4));
				unit = 2;
			}
			else if (text.endsWith("rad")) {
				value = Float.parseFloat(text.substring(0, text.length() - 3));
				unit = 1;
			}
			else {
				return null;
			}
		}
		Angle angle = new Angle();
		if (unit == 0) {
			angle.setValueDegrees(value);
		}
		else if (unit == 1) {
			angle.setValueRadians(value);
		}
		else if (unit == 2) {
			angle.setValueGradians(value);
		}
		return angle;
	}

}
