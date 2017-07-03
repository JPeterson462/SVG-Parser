package org.w3c.dom.svg.paths;

import org.w3c.dom.DOMException;

public interface SVGPathSegArcAbs extends SVGPathSeg {
	
	public float getX();
	
	public void setX(float x) throws DOMException;
	
	public float getY();
	
	public void setY(float y) throws DOMException;

	public float getR1();
	
	public void setR1(float r1) throws DOMException;
	
	public float getR2();
	
	public void setR2(float r2) throws DOMException;

	public float getAngle();
	
	public void setAngle(float angle) throws DOMException;
	
	public boolean getLargeArcFlag();

	public void setLargeArcFlag(boolean largeArcFlag) throws DOMException;
	
	public boolean getSweepFlag();

	public void setSweepFlag(boolean sweepFlag) throws DOMException;
	
	public static class Implementation extends SVGPathSeg.Implementation implements SVGPathSegArcAbs {

		private float x, y, r1, r2, angle;
		
		private boolean largeArcFlag, sweepFlag;
		
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

		@Override
		public float getY() {
			return y;
		}

		@Override
		public void setY(float y) throws DOMException {
			this.y = y;
		}

		@Override
		public float getR1() {
			return r1;
		}

		@Override
		public void setR1(float r1) throws DOMException {
			this.r1 = r1;
		}

		@Override
		public float getR2() {
			return r2;
		}

		@Override
		public void setR2(float r2) throws DOMException {
			this.r2 = r2;
		}

		@Override
		public float getAngle() {
			return angle;
		}

		@Override
		public void setAngle(float angle) throws DOMException {
			this.angle = angle;
		}

		@Override
		public boolean getLargeArcFlag() {
			return largeArcFlag;
		}

		@Override
		public void setLargeArcFlag(boolean largeArcFlag) throws DOMException {
			this.largeArcFlag = largeArcFlag;
		}

		@Override
		public boolean getSweepFlag() {
			return sweepFlag;
		}

		@Override
		public void setSweepFlag(boolean sweepFlag) throws DOMException {
			this.sweepFlag = sweepFlag;
		}

	}

}
