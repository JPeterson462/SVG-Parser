package com.digiturtle.xml;

public class CharacterQueue {
	
	private char[] buffer;
	
	private int position;
	
	public CharacterQueue(char[] buffer) {
		this.buffer = buffer;
		position = 0;
	}
	
	public int getPosition() {
		return position;
	}
	
	public char getCharacter() {
		return buffer[position];
	}
	
	public void increment(int offset) {
		position += offset;
	}
	
	public void increment() {
		position++;
	}
	
	public void skip(char c) {
		while (position < buffer.length && buffer[position] == c) {
			position++;
		}
	}
	
	public String readUntil(char... next) {
		int start = position, end = position;
		while (end < buffer.length && !equals(buffer[end], next)) {
			end++;
		}
		char[] offset = new char[end - start];
		System.arraycopy(buffer, start, offset, 0, offset.length);
		return new String(offset);
	}
	
	public String readUntilIgnore(String ignore, char... next) {
		int start = position, end = position;
		while (!equals(buffer[end], next) && end < buffer.length) {
			if (match(end, ignore)) {
				end += ignore.length();
			}
			end++;
		}
		char[] offset = new char[end - start];
		System.arraycopy(buffer, start, offset, 0, offset.length);
		return new String(offset);
	}
	
	private boolean match(int position, String match) {
		char[] matchChars = match.toCharArray();
		for (int i = 0; i < matchChars.length; i++) {
			if (matchChars[i] != buffer[position + i]) {
				return false;
			}
		}
		return true;
	}
	
	private boolean equals(char c, char... matches) {
		for (int i = 0; i < matches.length; i++) {
			if (c == matches[i]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasNext() {
		return position < buffer.length;
	}

}
