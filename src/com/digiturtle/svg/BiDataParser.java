package com.digiturtle.svg;

public interface BiDataParser<T> {

	public T parse(String text1, String text2, boolean presentationAttribute);

}
