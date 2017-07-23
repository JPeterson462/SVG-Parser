package org.w3c.dom.svg.paths;

import org.w3c.dom.DOMException;

public interface SVGPathSegLineToHorizontalRel extends SVGPathSeg {
	
	public float getX();
	
	public void setX(float x) throws DOMException;
	
	public static class Implementation extends SVGPathSeg.Implementation implements SVGPathSegLineToHorizontalRel {

		private float x;
		
		public Implementation() {
			super(PATHSEG_LINETO_HORIZONTAL_REL);
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
