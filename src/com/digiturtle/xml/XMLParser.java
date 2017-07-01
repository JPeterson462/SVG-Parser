package com.digiturtle.xml;

import java.io.BufferedReader;
import java.io.IOException;

public class XMLParser {
	
	public Element parseTree(BufferedReader reader) throws IOException {
		String file = "";
		for (String line = reader.readLine(); line != null; line = reader.readLine()) {
			file += line + " ";
		}
		CharacterQueue queue = new CharacterQueue(file.toCharArray());
		return parseElement(queue);
	}
	
	private Element parseElement(CharacterQueue queue) {
		queue.skip(' ');
		if (queue.getCharacter() != '<') {
			throw new IllegalStateException("Invalid XML Source: Invalid Opening Tag -> '" + queue.getCharacter() + "' " + queue.getPosition());
		}
		queue.increment();
		String tag = queue.readUntil(' ', '>', '=');
		Element element = new Element(tag);
		queue.increment(tag.length());
		readAttributes(queue, element);
		if (queue.getCharacter() == '/') {
			queue.increment();
			if (queue.getCharacter() == '>') {
				queue.increment();
				return element;
			} else {
				throw new IllegalStateException("Invalid XML Source: Invalid Opening Tag [" + tag + "]");
			}
		}
		if (queue.getCharacter() != '>') {
			throw new IllegalStateException("Invalid XML Source: Invalid Opening Tag [" + tag + "]");
		}
		queue.increment();
		while (!isEndTag(queue)) {
			element.addChild(parseElement(queue));
		}
		String endTag = queue.readUntil('>');
		if (!endTag.equalsIgnoreCase("</" + tag)) {
			throw new IllegalStateException("Invalid XML Source: Invalid Closing Tag [" + tag + "] -> " + endTag);
		}
		queue.increment(endTag.length() + 1);
		return element;
	}
	
	
	private boolean isEndTag(CharacterQueue queue) {
		queue.skip(' ');
		char c = queue.getCharacter();
		if (c != '<') {
			return false;
		}
		queue.increment();
		if (queue.getCharacter() != '/') {
			queue.increment(-1);
			return false;
		}
		queue.increment(-1);
		return true;
	}
	
	private void readAttributes(CharacterQueue queue, Element element) {
		String data = queue.readUntil('>');
		queue.increment(data.length());
		data = data.trim();
		CharacterQueue subqueue = new CharacterQueue(data.toCharArray());
		while (subqueue.hasNext() && subqueue.getCharacter() != '/') {
			String name = subqueue.readUntil('=');
			subqueue.increment(name.length());
			name = name.trim();
			if (subqueue.getCharacter() == '=') {
				subqueue.increment();
				boolean invalidAttribute = false;
				if (subqueue.getCharacter() == '"') {
					subqueue.increment();
					String value = subqueue.readUntilIgnore("\\\"", '"');
					subqueue.increment(value.length());
					if (subqueue.getCharacter() != '"') {
						invalidAttribute = true;
					} else {
						subqueue.increment();
						element.setAttribute(name, value);
					}
				} else {
					invalidAttribute = true;
				}
				if (invalidAttribute) {
					throw new IllegalStateException("Invalid XML Source: Invalid Attribute [" + name + "]");
				}
			}
			else if (!subqueue.hasNext()) {
				element.setAttribute(name, null);
			}
			else {
				throw new IllegalStateException("Invalid XML Source: Invalid Attribute [" + name + "]");
			}
			subqueue.skip(' ');
		}
		if (data.endsWith("/")) {
			queue.increment(-1);
		}
	}

}
