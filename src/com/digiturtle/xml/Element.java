package com.digiturtle.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Element {
	
	private String tag;
	
	private HashMap<String, String> attributes = new HashMap<>();
	
	private ArrayList<Element> children = new ArrayList<>();
	
	public Element(String tag) {
		this.tag = tag;
	}
	
	public void addChild(Element child) {
		children.add(child);
	}
	
	public ArrayList<Element> getChildren() {
		return children;
	}
	
	public void setAttribute(String id, String value) {
		attributes.put(id, value);
	}
	
	public String getAttribute(String id) {
		return attributes.get(id);
	}
	
	public String toString() {
		return toString(0);
	}
	
	private String toString(int tabs) {
		String opening = indent(tabs) + "<";
		opening += tag;
		for(Map.Entry<String, String> attribute : attributes.entrySet()) {
			if (attribute.getValue() == null) {
				opening += " " + attribute.getKey();
			} else {
				opening += " " + attribute.getKey() + "=\"" + attribute.getValue() + "\"";
			}
		}
		opening += ">\n";
		String children = "";
		for (Element child : this.children) {
			children += child.toString(tabs + 1);
		}
		return opening + children + (indent(tabs) + "</" + tag + ">\n");
	}
	
	private String indent(int tabs) {
		char[] text = new char[tabs];
		for (int i = 0; i < text.length; i++) {
			text[i] = '\t';
		}
		return new String(text);
	}

}
