package org.w3c.dom.svg.impl;

import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;

public class CharacterDataImplementation extends NodeImplementation implements CharacterData {

	private String text;
	
	public CharacterDataImplementation(String nodeName) {
		super(nodeName);
	}

	@Override
	public void appendData(String arg) throws DOMException {
		text += arg;
	}

	@Override
	public void deleteData(int offset, int count) throws DOMException {
		if (offset < 0 || offset >= text.length()) {
			throw new DOMException(DOMException.INDEX_SIZE_ERR, "Offset must be a valid position in data");
		}
		if (count < 0) { 
			throw new DOMException(DOMException.INDEX_SIZE_ERR, "count must be >= 0");
		}
		text = text.substring(0, offset) + text.substring(offset + count);
	}

	@Override
	public String getData() throws DOMException {
		return text;
	}

	@Override
	public int getLength() {
		return text.length();
	}

	@Override
	public void insertData(int offset, String arg) throws DOMException {
		if (offset < 0 || offset >= text.length()) {
			throw new DOMException(DOMException.INDEX_SIZE_ERR, "Offset must be a valid position in data");
		}
		text = text.substring(0, offset) + arg + text.substring(offset);
	}

	@Override
	public void replaceData(int offset, int count, String arg) throws DOMException {
		if (offset < 0 || offset >= text.length()) {
			throw new DOMException(DOMException.INDEX_SIZE_ERR, "Offset must be a valid position in data");
		}
		if (count < 0) { 
			throw new DOMException(DOMException.INDEX_SIZE_ERR, "count must be >= 0");
		}
		text = text.substring(0, offset) + arg.substring(0, count) + text.substring(offset + count);
	}

	@Override
	public void setData(String data) throws DOMException {
		text = data;
	}

	@Override
	public String substringData(int offset, int count) throws DOMException {
		return text.substring(offset, offset + count);
	}

}
