package org.w3c.dom.svg.paths;

import org.w3c.dom.DOMException;

public interface SVGPathSegLineToVerticalAbs extends SVGPathSeg {
	
	public float getY();
	
	public void setY(float y) throws DOMException;
	
	public static class Implementation extends SVGPathSeg.Implementation implements SVGPathSegLineToVerticalAbs {

		private float y;
		
		public Implementation(short pathSegType) {
			super(pathSegType);
		}

		@Override
		public float getY() {
			return y;
		}

		@Override
		public void setY(float y) throws DOMException {
			this.y = y;
		}
		
	}

}
