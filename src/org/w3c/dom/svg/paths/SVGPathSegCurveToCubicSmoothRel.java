package org.w3c.dom.svg.paths;

import org.w3c.dom.DOMException;

public interface SVGPathSegCurveToCubicSmoothRel extends SVGPathSeg {
	
	public float getX();
	
	public void setX(float x) throws DOMException;
	
	public float getY();
	
	public void setY(float y) throws DOMException;

	public float getX2();
	
	public void setX2(float x2) throws DOMException;
	
	public float getY2();
	
	public void setY2(float y2) throws DOMException;
	
	public static class Implementation extends SVGPathSeg.Implementation implements SVGPathSegCurveToCubicSmoothRel {

		private float x, y, x2, y2;
		
		public Implementation() {
			super(PATHSEG_CURVETO_CUBIC_SMOOTH_REL);
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
		public float getX2() throws DOMException {
			return x2;
		}

		@Override
		public void setX2(float x2) throws DOMException {
			this.x2 = x2;
		}

		@Override
		public float getY2() throws DOMException {
			return y2;
		}

		@Override
		public void setY2(float y2) throws DOMException {
			this.y2 = y2;
		}
		
	}

}
