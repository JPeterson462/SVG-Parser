package org.w3c.dom.svg.text;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.SVGURIReference;
import org.w3c.dom.svg.document.SVGSVGElement;

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

	public static class Implementation extends SVGElement.Implementation implements SVGGlyphRefElement {

		private SVGAnimatedString href, className;
		
		private CSSStyleDeclaration style;
		
		private String glyphRef, format;
		
		private float x, y, dx, dy;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString href, SVGAnimatedString className, CSSStyleDeclaration style,
				String glyphRef, String format, float x, float y, float dx, float dy) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.href = href;
			this.className = className;
			this.style = style;
			this.glyphRef = glyphRef;
			this.format = format;
			this.x = x;
			this.y = y;
			this.dx = dx;
			this.dy = dy;
		}

		@Override
		public SVGAnimatedString getHref() {
			return href;
		}

		@Override
		public SVGAnimatedString getClassName() {
			return className;
		}

		@Override
		public CSSStyleDeclaration getStyle() {
			return style;
		}

		@Override
		public CSSValue getPresentationAttribute(String name) {
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "This method is deprecated");
		}

		@Override
		public String getGlyphRef() {
			return glyphRef;
		}

		@Override
		public void setGlyphRef(String glyphRef) throws DOMException {
			this.glyphRef = glyphRef;
		}

		@Override
		public String getFormat() {
			return format;
		}

		@Override
		public void setFormat(String format) throws DOMException {
			this.format = format;
		}

		@Override
		public float getX() {
			return x;
		}

		@Override
		public void setX(float x) throws DOMException {
			this.x = x;
		}

		@Override
		public float getY() {
			return y;
		}

		@Override
		public void setY(float y) throws DOMException {
			this.y = y;
		}

		@Override
		public float getDX() {
			return dx;
		}

		@Override
		public void setDX(float dx) throws DOMException {
			this.dx = dx;
		}

		@Override
		public float getDY() {
			return dy;
		}

		@Override
		public void setDY(float dy) throws DOMException {
			this.dy = dy;
		}
		
	}
	
}
