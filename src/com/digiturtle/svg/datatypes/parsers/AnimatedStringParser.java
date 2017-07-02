package com.digiturtle.svg.datatypes.parsers;

import com.digiturtle.svg.BiDataParser;
import com.digiturtle.svg.datatypes.animated.AnimatedString;

public class AnimatedStringParser implements BiDataParser<AnimatedString> {

	@Override
	public AnimatedString parse(String text1, String text2, boolean presentationAttribute) {
		AnimatedString string = new AnimatedString(text2);
		if (text1 == null || text2 == null) {
			return null;
		}
		string.setBaseValue(text1);
		return string;		
	}

}
