package org.w3c.dom.svg.paths;

import org.w3c.dom.DOMException;

public interface SVGPathSegCurveToQuadraticSmoothRel extends SVGPathSeg {
	
	public float getX();
	
	public void setX(float x) throws DOMException;
	
	public float getY();
	
	public void setY(float y) throws DOMException;

	public static class Implementation extends SVGPathSeg.Implementation implements SVGPathSegCurveToQuadraticSmoothRel {

		private float x, y;
		
		public Implementation() {
			super(PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL);
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
