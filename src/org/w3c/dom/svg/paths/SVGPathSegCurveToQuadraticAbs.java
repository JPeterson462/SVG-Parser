package org.w3c.dom.svg.paths;

import org.w3c.dom.DOMException;

public interface SVGPathSegCurveToQuadraticAbs extends SVGPathSeg {
	
	public float getX();
	
	public void setX(float x) throws DOMException;
	
	public float getY();
	
	public void setY(float y) throws DOMException;

	public float getX1();
	
	public void setX1(float x1) throws DOMException;
	
	public float getY1();
	
	public void setY1(float y1) throws DOMException;

	public static class Implementation extends SVGPathSeg.Implementation implements SVGPathSegCurveToQuadraticAbs {

		private float x, y, x1, y1;
		
		public Implementation() {
			super(PATHSEG_CURVETO_QUADRATIC_ABS);
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
		public float getX1() throws DOMException {
			return x1;
		}

		@Override
		public void setX1(float x1) throws DOMException {
			this.x1 = x1;
		}

		@Override
		public float getY1() throws DOMException {
			return y1;
		}

		@Override
		public void setY1(float y1) throws DOMException {
			this.y1 = y1;
		}

	}

}
