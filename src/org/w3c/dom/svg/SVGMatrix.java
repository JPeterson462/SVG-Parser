package org.w3c.dom.svg;

import org.joml.Matrix3f;
import org.w3c.dom.DOMException;

public interface SVGMatrix {
	
	public default void identity() {
		setA(1);
		setB(0);
		setC(0);
		setD(1);
		setE(0);
		setF(0);
	}
	
	public void set(float a, float b, float c, float d, float e, float f) throws DOMException;
	
	public float getA();
	
	public void setA(float a) throws DOMException;
	
	public float getB();
	
	public void setB(float b) throws DOMException;

	public float getC();
	
	public void setC(float c) throws DOMException;
	
	public float getD();
	
	public void setD(float d) throws DOMException;

	public float getE();
	
	public void setE(float e) throws DOMException;
	
	public float getF();
	
	public void setF(float f) throws DOMException;
	
	public SVGMatrix multiply(SVGMatrix right);
	
	public SVGMatrix inverse() throws SVGException;
	
	public SVGMatrix translate(float x, float y);
	
	public SVGMatrix scale(float scaleFactor);
	
	public SVGMatrix scaleNonUniform(float scaleFactorX, float scaleFactorY);
	
	public SVGMatrix rotate(float angle);
	
	public SVGMatrix rotateFromVector(float x, float y) throws SVGException;
	
	public SVGMatrix flipX();
	
	public SVGMatrix flipY();
	
	public SVGMatrix skewX(float angle);
	
	public SVGMatrix skewY(float angle);
	
	public static class Implementation implements SVGMatrix {

		private Matrix3f matrix = new Matrix3f().identity();
		
		@Override
		public float getA() {
			return matrix.m00;
		}

		@Override
		public void setA(float a) throws DOMException {
			matrix.m00(a);
		}

		@Override
		public float getB() {
			return matrix.m01;
		}

		@Override
		public void setB(float b) throws DOMException {
			matrix.m01(b);
		}

		@Override
		public float getC() {
			return matrix.m10;
		}

		@Override
		public void setC(float c) throws DOMException {
			matrix.m10(c);
		}

		@Override
		public float getD() {
			return matrix.m11;
		}

		@Override
		public void setD(float d) throws DOMException {
			matrix.m11(d);
		}

		@Override
		public float getE() {
			return matrix.m20;
		}

		@Override
		public void setE(float e) throws DOMException {
			matrix.m20(e);
		}

		@Override
		public float getF() {
			return matrix.m21;
		}

		@Override
		public void setF(float f) throws DOMException {
			matrix.m21(f);
		}

		@Override
		public SVGMatrix multiply(SVGMatrix right) {
			Matrix3f matrix = new Matrix3f();
			matrix.m00(right.getA());
			matrix.m01(right.getB());
			matrix.m10(right.getC());
			matrix.m11(right.getD());
			matrix.m20(right.getE());
			matrix.m21(right.getF());
			this.matrix.mul(matrix);
			return this;
		}

		@Override
		public SVGMatrix inverse() throws SVGException {
			Implementation inverseMatrix = new Implementation();
			matrix.invert(inverseMatrix.matrix);
			return inverseMatrix;
		}

		@Override
		public SVGMatrix translate(float x, float y) {
			Matrix3f transformation = new Matrix3f().identity();
			transformation.m20(x);
			transformation.m21(y);
			matrix.mul(transformation);
			return this;
		}

		@Override
		public SVGMatrix scale(float scaleFactor) {
			return scaleNonUniform(scaleFactor, scaleFactor);
		}

		@Override
		public SVGMatrix scaleNonUniform(float scaleFactorX, float scaleFactorY) {
			Matrix3f transformation = new Matrix3f().identity();
			transformation.scale(scaleFactorX, scaleFactorY, 1);
			matrix.mul(transformation);
			return this;
		}

		@Override
		public SVGMatrix rotate(float angle) {
			matrix.rotateZ(angle);
			return this;
		}

		@Override
		public SVGMatrix rotateFromVector(float x, float y) throws SVGException {
			return rotate((float) Math.atan2(y, x));
		}

		@Override
		public SVGMatrix flipX() {
			Matrix3f transformation = new Matrix3f().scale(-1, 1, 1);
			matrix.mul(transformation);
			return this;
		}

		@Override
		public SVGMatrix flipY() {
			Matrix3f transformation = new Matrix3f().scale(1, -1, 1);
			matrix.mul(transformation);
			return this;
		}

		@Override
		public SVGMatrix skewX(float angle) {
			Matrix3f transformation = new Matrix3f().identity();
			transformation.m10((float) Math.tan(angle));
			matrix.mul(transformation);
			return this;
		}

		@Override
		public SVGMatrix skewY(float angle) {
			Matrix3f transformation = new Matrix3f().identity();
			transformation.m01((float) Math.tan(angle));
			matrix.mul(transformation);
			return this;
		}

		@Override
		public void set(float a, float b, float c, float d, float e, float f) throws DOMException {
			setA(a);
			setB(b);
			setC(c);
			setD(d);
			setE(e);
			setF(f);
		}
		
	}

}
