package org.w3c.dom.svg.paths;

import org.w3c.dom.DOMException;

public interface SVGPathSegLineToHorizontalAbs extends SVGPathSeg {
	
	public float getX();
	
	public void setX(float x) throws DOMException;
	
	public static class Implementation extends SVGPathSeg.Implementation implements SVGPathSegLineToHorizontalAbs {

		private float x;
		
		public Implementation(short pathSegType) {
			super(pathSegType);
		}

		@Override
		public float getX() {
			return x;
		}

		@Override
		public void setX(float x) throws DOMException {
			this.x = x;
		}
		
	}

}
