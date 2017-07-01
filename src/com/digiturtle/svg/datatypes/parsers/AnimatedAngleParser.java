package com.digiturtle.svg.datatypes.parsers;

import com.digiturtle.svg.BiDataParser;
import com.digiturtle.svg.datatypes.Angle;
import com.digiturtle.svg.datatypes.AnimatedAngle;

public class AnimatedAngleParser implements BiDataParser<AnimatedAngle> {

	private AngleParser angleParser = new AngleParser();
	
	@Override
	public AnimatedAngle parse(String text1, String text2, boolean presentationAttribute) {
		AnimatedAngle angle = new AnimatedAngle();
		if (text1 == null || text2 == null) {
			return null;
		}
		Angle baseValue = angleParser.parse(text1, presentationAttribute);
		Angle animatedValue = angleParser.parse(text2, presentationAttribute);
		if (baseValue == null || animatedValue == null) {
			return null;
		}
		angle.setAnimatedValue(animatedValue);
		angle.setBaseValue(baseValue);
		return angle;
	}
	
}
