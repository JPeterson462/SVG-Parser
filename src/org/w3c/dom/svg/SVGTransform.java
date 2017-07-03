package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGTransform {

	/** The unit type is not one of predefined types. It is invalid to attempt to define a new value of this type or to attempt to switch an existing value to this type. */
	public static final short SVG_TRANSFORM_UNKNOWN = 0;
	/** A 'matrix(...)' transformation. */
	public static final short SVG_TRANSFORM_MATRIX = 1;
	/** A 'translate(...)' transformation. */
	public static final short SVG_TRANSFORM_TRANSLATE = 2;
	/** A 'scale(...)' transformation. */
	public static final short SVG_TRANSFORM_SCALE = 3;
	/** A 'rotate(...)' transformation. */
	public static final short SVG_TRANSFORM_ROTATE = 4;
	/** A 'skewX(...)' transformation. */
	public static final short SVG_TRANSFORM_SKEWX = 5;
	/** A 'skewY(...)' transformation. */
	public static final short SVG_TRANSFORM_SKEWY = 6;
	
	public short getType();
	
	public SVGMatrix getMatrix();
	
	public float getAngle();
	
	public void setMatrix(SVGMatrix matrix) throws DOMException;
	
	public void setTranslate(float tx, float ty) throws DOMException;
	
	public void setScale(float sx, float sy) throws DOMException;
	
	public void setRotate(float angle, float cx, float cy) throws DOMException;
	
	public void setSkewX(float angle) throws DOMException;
	
	public void setSkewY(float angle) throws DOMException;
	
	public static class Implementation implements SVGTransform {
		
		private short type = SVG_TRANSFORM_UNKNOWN;
		
		private SVGMatrix matrix;
		
		private float angle;

		@Override
		public short getType() {
			return type;
		}

		@Override
		public SVGMatrix getMatrix() {
			return matrix;
		}

		@Override
		public float getAngle() {
			return angle;
		}

		@Override
		public void setMatrix(SVGMatrix matrix) throws DOMException {
			type = SVG_TRANSFORM_MATRIX;
			angle = 0;
			matrix.setA(matrix.getA());
			matrix.setB(matrix.getB());
			matrix.setC(matrix.getC());
			matrix.setD(matrix.getD());
			matrix.setE(matrix.getE());
			matrix.setF(matrix.getF());
		}

		@Override
		public void setTranslate(float tx, float ty) throws DOMException {
			type = SVG_TRANSFORM_TRANSLATE;
			angle = 0;
			matrix.identity();
			matrix.translate(tx, ty);
		}

		@Override
		public void setScale(float sx, float sy) throws DOMException {
			type = SVG_TRANSFORM_SCALE;
			angle = 0;
			matrix.identity();
			matrix.scaleNonUniform(sx, sy);
		}

		@Override
		public void setRotate(float angle, float cx, float cy) throws DOMException {
			type = SVG_TRANSFORM_ROTATE;
			this.angle = angle;
			matrix.identity();
			matrix.translate(cx, cy);
			matrix.rotate(angle);
			matrix.translate(-cx, -cy);
		}

		@Override
		public void setSkewX(float angle) throws DOMException {
			this.angle = angle;
			matrix.identity();
			matrix.skewX(angle);
		}

		@Override
		public void setSkewY(float angle) throws DOMException {
			this.angle = angle;
			matrix.identity();
			matrix.skewY(angle);
		}
		
	}

}
