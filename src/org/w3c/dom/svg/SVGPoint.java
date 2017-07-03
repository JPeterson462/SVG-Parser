package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGPoint {
	
	public float getX();
	
	public void setX(float x) throws DOMException;
	
	public float getY();
	
	public void setY(float y) throws DOMException;
	
	public SVGPoint matrixTransform(SVGMatrix matrix);
	
	public static class Implementation implements SVGPoint {
		
		private float x, y;
		
		public Implementation(float x, float y) {
			this.x = x;
			this.y = y;
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
		public SVGPoint matrixTransform(SVGMatrix matrix) {
			float x = matrix.getA() * this.x + matrix.getB() * this.y + matrix.getC();
			float y = matrix.getD() * this.x + matrix.getE() * this.y + matrix.getF();
			return new Implementation(x, y);
		}
		
	}

}
