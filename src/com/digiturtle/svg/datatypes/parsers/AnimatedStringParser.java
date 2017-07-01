package com.digiturtle.svg.datatypes.parsers;

import com.digiturtle.svg.BiDataParser;
import com.digiturtle.svg.datatypes.AnimatedString;

public class AnimatedStringParser implements BiDataParser<AnimatedString> {

	@Override
	public AnimatedString parse(String text1, String text2, boolean presentationAttribute) {
		AnimatedString string = new AnimatedString();
		if (text1 == null || text2 == null) {
			return null;
		}
		string.setBaseValue(text1);
		string.setAnimatedValue(text2);
		return string;		
	}

}
