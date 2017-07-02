package com.digiturtle.svg.datatypes.parsers;

import com.digiturtle.svg.BiDataParser;
import com.digiturtle.svg.datatypes.animated.AnimatedAngle;

public class AnimatedAngleParser implements BiDataParser<AnimatedAngle> {

	private AngleParser angleParser = new AngleParser();
	
	@Override
	public AnimatedAngle parse(String text1, String text2, boolean presentationAttribute) {
		if (text1 == null || text2 == null) {
			return null;
		}
		AnimatedAngle angle = new AnimatedAngle(angleParser.parse(text1, presentationAttribute), angleParser.parse(text2, presentationAttribute));
		if (angle.getBaseValue() == null || angle.getAnimatedValue() == null) {
			return null;
		}
		return angle;
	}
	
}
