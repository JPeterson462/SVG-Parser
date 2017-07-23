package org.w3c.dom.svg.paths;

import org.w3c.dom.DOMException;

public interface SVGPathSegCurveToCubicRel extends SVGPathSeg {
	
	public float getX();
	
	public void setX(float x) throws DOMException;
	
	public float getY();
	
	public void setY(float y) throws DOMException;

	public float getX1();
	
	public void setX1(float x1) throws DOMException;
	
	public float getY1();
	
	public void setY1(float y1) throws DOMException;

	public float getX2();
	
	public void setX2(float x2) throws DOMException;
	
	public float getY2();
	
	public void setY2(float y2) throws DOMException;
	
	public static class Implementation extends SVGPathSeg.Implementation implements SVGPathSegCurveToCubicRel {

		private float x, y, x1, y1, x2, y2;
		
		public Implementation() {
			super(PATHSEG_CURVETO_CUBIC_REL);
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
