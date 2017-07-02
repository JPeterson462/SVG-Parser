package com.digiturtle.svg.datatypes.parsers;

import com.digiturtle.svg.BiDataParser;
import com.digiturtle.svg.datatypes.animated.AnimatedBoolean;

public class AnimatedBooleanParser implements BiDataParser<AnimatedBoolean> {

	@Override
	public AnimatedBoolean parse(String text1, String text2, boolean presentationAttribute) {
		AnimatedBoolean bool = new AnimatedBoolean(Boolean.parseBoolean(text2));
		if (text1 == null || text2 == null) {
			return null;
		}
		bool.setBaseValue(Boolean.parseBoolean(text1));
		return bool;		
	}

}
