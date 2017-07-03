package org.w3c.dom.svg;

import org.joml.Matrix3f;
import org.w3c.dom.DOMException;

public interface SVGMatrix {
	
	public default void identity() {
		setA(1);
		setB(0);
		setC(0);
		setD(0);
		setE(1);
		setF(0);
	}
	
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
			return matrix.m10;
		}

		@Override
		public void setB(float b) throws DOMException {
			matrix.m10(b);
		}

		@Override
		public float getC() {
			return matrix.m20;
		}

		@Override
		public void setC(float c) throws DOMException {
			matrix.m20(c);
		}

		@Override
		public float getD() {
			return matrix.m01;
		}

		@Override
		public void setD(float d) throws DOMException {
			matrix.m01(d);
		}

		@Override
		public float getE() {
			return matrix.m11;
		}

		@Override
		public void setE(float e) throws DOMException {
			matrix.m11(e);
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
			matrix.m10(right.getB());
			matrix.m20(right.getC());
			matrix.m01(right.getD());
			matrix.m11(right.getE());
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
			matrix.m20(matrix.m00 * x + matrix.m10 * y);
			matrix.m21(matrix.m01 * x + matrix.m11 * y);
			return this;
		}

		@Override
		public SVGMatrix scale(float scaleFactor) {
			return scaleNonUniform(scaleFactor, scaleFactor);
		}

		@Override
		public SVGMatrix scaleNonUniform(float scaleFactorX, float scaleFactorY) {
			matrix.m00(matrix.m00 * scaleFactorX);
			matrix.m10(matrix.m10 * scaleFactorX);
			matrix.m01(matrix.m01 * scaleFactorY);
			matrix.m11(matrix.m11 * scaleFactorY);
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
		
	}

}
