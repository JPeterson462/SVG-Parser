package org.w3c.dom.svg;

public interface Animated<T> {
	
	public T getBaseValue();
	
	public void setBaseValue(T value);
	
	public T getAnimatedValue();

}
