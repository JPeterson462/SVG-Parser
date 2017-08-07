package org.w3c.dom.css.impl;

import org.w3c.dom.css.Counter;
import org.w3c.dom.DOMErrors;

public class CounterImplementation implements Counter {

	public CounterImplementation(String text) {
		DOMErrors.notSupported();
	}
	
	@Override
	public String getIdentifier() {
		return DOMErrors.notSupported();
	}

	@Override
	public String getListStyle() {
		return DOMErrors.notSupported();
	}

	@Override
	public String getSeparator() {
		return DOMErrors.notSupported();
	}
	
	public String getCssText() {
		return DOMErrors.notSupported();
	}

}
