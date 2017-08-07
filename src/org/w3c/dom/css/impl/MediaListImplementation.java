package org.w3c.dom.css.impl;

import java.util.ArrayList;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.DOMException;
import org.w3c.dom.stylesheets.MediaList;

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
		DOMErrors.notSupported();
		return buffer.toString();
	}

	@Override
	public String item(int index) {
		return media.get(index);
	}

	@Override
	public void setMediaText(String text) throws DOMException {
		DOMErrors.notSupported();
	}

}
