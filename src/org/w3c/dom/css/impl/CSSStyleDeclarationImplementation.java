package org.w3c.dom.css.impl;

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
	
	private CSSRule parentRule;
	
	private HashMap<String, CSSValue> values = new HashMap<>();

	public CSSStyleDeclarationImplementation(CSSRule parentRule) {
		this.parentRule = parentRule;
	}

	public CSSStyleDeclarationImplementation(CSSRule parentRule, CSSStyleDeclaration declaration) {
		this.parentRule = parentRule;
		for (int i = 0; i < declaration.getLength(); i++) {
			String propertyName = declaration.item(i);
			Property property = new Property();
			property.value = declaration.getPropertyValue(propertyName);
			property.priority = declaration.getPropertyPriority(propertyName);
			propertyNames.add(propertyName);
			properties.put(propertyName, property);
		}
	}
	
	@Override
	public String getCssText() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < propertyNames.size(); i++) {
			String propertyName = propertyNames.get(i);
			Property property = properties.get(propertyName);
			if (i > 0) {
				buffer.append('\n');
			}
			buffer.append(propertyName + ": " + property.value + (property.priority.length() > 0 ? (" !" + property.priority) : "") + ";");
		}
		return buffer.toString();
	}

	@Override
	public int getLength() {
		return properties.size();
	}

	@Override
	public CSSRule getParentRule() {
		return parentRule;
	}

	@Override
	public CSSValue getPropertyCSSValue(String propertyName) {
		return values.get(propertyName);
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
	public void setCssText(String text) throws DOMException {
		String[] lines = text.trim().split(";");
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i].trim();
			String[] keyValue = line.split(":");
			String key = keyValue[0];
			String value = line.substring(key.length());
			key = key.trim();
			value = value.trim();
			String priority = "";
			if (value.contains("!")) {
				String[] valuePriority = value.split("!");
				value = valuePriority[0];
				priority = valuePriority[1];
			}
			setProperty(key, value, priority);
		}
	}
	
	public void storeValue(String propertyName, CSSValue value) {
		values.put(propertyName, value);
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
		CSSProperties.tryCreateProperties();
		CSSProperties.parseValue(propertyName, value, this);
	}

}
