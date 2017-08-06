package org.w3c.dom.css.impl;

import java.util.ArrayList;

import org.w3c.dom.DOMException;
import org.w3c.dom.stylesheets.MediaList;
import org.w3c.dom.svg.SVGRegex;

public class MediaListImplementation implements MediaList {
	
	private ArrayList<String> media;
	
	public MediaListImplementation() {
		media = new ArrayList<>();
	}
	
	public MediaListImplementation(ArrayList<String> media) {
		this.media = media;
	}

	@Override
	public void appendMedium(String medium) throws DOMException {
		media.add(medium);
	}

	@Override
	public void deleteMedium(String medium) throws DOMException {
		media.remove(medium);
	}

	@Override
	public int getLength() {
		return media.size();
	}

	@Override
	public String getMediaText() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < media.size(); i++) {
			if (i > 0) {
				buffer.append(" and");
			}
			buffer.append(" " + media.get(i));
		}
		return buffer.toString();
	}

	@Override
	public String item(int index) {
		return media.get(index);
	}

	@Override
	public void setMediaText(String text) throws DOMException {
		String[] data = text.trim().split(SVGRegex.WHITESPACE);
		media.clear();
		for (int i = 0; i < data.length; i++) {
			if (!data[i].equals("and")) {
				media.add(data[i]);
			}
		}
	}

}
