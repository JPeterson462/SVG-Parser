package com.digiturtle.svg.datatypes;

public interface Animated<T> {
	
	public T getBaseValue();
	
	public void setAnimatedValue(T value);
	
	public T getAnimatedValue();

}
