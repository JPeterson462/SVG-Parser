package org.w3c.dom.svg.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;

public class CSSStyleDeclarationImplementation implements CSSStyleDeclaration {
	
	private class Property {
		public String value, priority;
	}
	
	private HashMap<String, Property> properties = new HashMap<>();
	
	private ArrayList<String> propertyNames = new ArrayList<>();

	public CSSStyleDeclarationImplementation() {
		
	}

	public CSSStyleDeclarationImplementation(CSSStyleDeclaration declaration) {
		//TODO
	}
	
	@Override
	public String getCssText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLength() {
		return properties.size();
	}

	@Override
	public CSSRule getParentRule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CSSValue getPropertyCSSValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPropertyPriority(String propertyName) {
		return properties.get(propertyName).priority;
	}

	@Override
	public String getPropertyValue(String propertyName) {
		return properties.get(propertyName).value;
	}

	@Override
	public String item(int index) {
		return propertyNames.get(index);
	}

	@Override
	public String removeProperty(String propertyName) throws DOMException {
		propertyNames.remove(propertyName);
		return properties.remove(propertyName).value;
	}

	@Override
	public void setCssText(String arg0) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProperty(String propertyName, String value, String priority) throws DOMException {
		Property property = new Property();
		property.value = value;
		property.priority = priority;
		properties.put(propertyName, property);
		if (!propertyNames.contains(propertyName)) {
			propertyNames.add(propertyName);
		}
	}

}
