package com.digiturtle.svg.datatypes.parsers;

import com.digiturtle.svg.BiDataParser;
import com.digiturtle.svg.datatypes.animated.AnimatedLength;

public class AnimatedLengthParser implements BiDataParser<AnimatedLength> {

	private LengthParser lengthParser = new LengthParser();
	
	@Override
	public AnimatedLength parse(String text1, String text2, boolean presentationAttribute) {
		if (text1 == null || text2 == null) {
			return null;
		}
		AnimatedLength length = new AnimatedLength(lengthParser.parse(text1, presentationAttribute), lengthParser.parse(text2, presentationAttribute));
		if (length.getBaseValue() == null || length.getAnimatedValue() == null) {
			return null;
		}
		return length;
	}

}
