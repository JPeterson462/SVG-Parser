package com.digiturtle.svg;

public interface DataParser<T> {
	
	public T parse(String text, boolean presentationAttribute);

}
