package org.w3c.dom.svg.paths;

import org.w3c.dom.DOMException;

public interface SVGPathSegMoveToAbs extends SVGPathSeg {
	
	public float getX();
	
	public void setX(float x) throws DOMException;
	
	public float getY();
	
	public void setY(float y) throws DOMException;
	
	public static class Implementation extends SVGPathSeg.Implementation implements SVGPathSegMoveToAbs {

		private float x, y;
		
		public Implementation() {
			super(PATHSEG_MOVETO_ABS);
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
		
	}

}
