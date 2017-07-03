package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGRect {
	
	public float getX();
	
	public void setX(float x) throws DOMException;

	public float getY();
	
	public void setY(float y) throws DOMException;

	public float getWidth();
	
	public void setWidth(float width) throws DOMException;

	public float getHeight();
	
	public void setHeight(float height) throws DOMException;

	public static class Implementation implements SVGRect {

		private float x, y, width, height;
		
		public Implementation(float x, float y, float width, float height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
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
		public float getWidth() {
			return width;
		}

		@Override
		public void setWidth(float width) throws DOMException {
			this.width = width;
		}

		@Override
		public float getHeight() {
			return height;
		}

		@Override
		public void setHeight(float height) throws DOMException {
			this.height = height;
		}
		
	}
	
}
