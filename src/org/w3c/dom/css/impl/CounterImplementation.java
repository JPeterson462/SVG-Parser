package org.w3c.dom.css.impl;

import org.w3c.dom.css.Counter;
import org.w3c.dom.svg.DOMErrors;

public class CounterImplementation implements Counter {

	public CounterImplementation(String text) {
		DOMErrors.notSupported();
	}
	
	@Override
	public String getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getListStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSeparator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getCssText() {
		// TODO
		return null;
	}

}
