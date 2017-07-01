package com.digiturtle.svg.datatypes.parsers;

import com.digiturtle.svg.BiDataParser;
import com.digiturtle.svg.datatypes.AnimatedLength;
import com.digiturtle.svg.datatypes.Length;

public class AnimatedLengthParser implements BiDataParser<AnimatedLength> {

	private LengthParser lengthParser = new LengthParser();
	
	@Override
	public AnimatedLength parse(String text1, String text2, boolean presentationAttribute) {
		AnimatedLength length = new AnimatedLength();
		if (text1 == null || text2 == null) {
			return null;
		}
		Length baseValue = lengthParser.parse(text1, presentationAttribute);
		Length animatedValue = lengthParser.parse(text2, presentationAttribute);
		if (baseValue == null || animatedValue == null) {
			return null;
		}
		length.setAnimatedValue(animatedValue);
		length.setBaseValue(baseValue);
		return length;
	}

}
