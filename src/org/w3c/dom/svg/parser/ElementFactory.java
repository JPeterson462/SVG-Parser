package org.w3c.dom.svg.parser;

import java.util.HashMap;

import org.w3c.dom.Element;

public interface ElementFactory {

	public Element createElement(String tagName, HashMap<String, String> attributes);
	
}
