package org.w3c.dom.svg.text;

import org.w3c.dom.DOMException;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.SVGURIReference;

public interface SVGGlyphRefElement extends SVGElement, SVGURIReference, SVGStylable {

	public String getGlyphRef();
	
	public void setGlyphRef(String glyphRef) throws DOMException;
	
	public String getFormat();
	
	public void setFormat(String format) throws DOMException;
	
	public float getX();
	
	public void setX(float x) throws DOMException;

	public float getY();
	
	public void setY(float y) throws DOMException;

	public float getDX();
	
	public void setDX(float dx) throws DOMException;

	public float getDY();
	
	public void setDY(float dy) throws DOMException;
	
	// TODO implementation
	
}
