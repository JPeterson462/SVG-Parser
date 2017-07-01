package com.digiturtle.svg.datatypes.parsers;

import com.digiturtle.svg.DataParser;
import com.digiturtle.svg.datatypes.Anything;

public class AnythingParser implements DataParser<Anything> {

	@Override
	public Anything parse(String text, boolean presentationAttribute) {
		Anything anything = new Anything();
		anything.setData(text);
		return anything;
	}

}
