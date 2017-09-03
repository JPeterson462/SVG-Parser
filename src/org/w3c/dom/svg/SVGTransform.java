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
		
		public float[] rotateValues;
		
		public Implementation() {
			matrix = new SVGMatrix.Implementation();
		}

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
			this.matrix.setA(matrix.getA());
			this.matrix.setB(matrix.getB());
			this.matrix.setC(matrix.getC());
			this.matrix.setD(matrix.getD());
			this.matrix.setE(matrix.getE());
			this.matrix.setF(matrix.getF());
		}

		@Override
		public void setTranslate(float tx, float ty) throws DOMException {
			type = SVG_TRANSFORM_TRANSLATE;
			angle = 0;
			matrix.set(1, 0, 0, 1, tx, ty);
		}

		@Override
		public void setScale(float sx, float sy) throws DOMException {
			type = SVG_TRANSFORM_SCALE;
			angle = 0;
			matrix.set(sx, 0, 0, sy, 0, 0);
		}

		@Override
		public void setRotate(float angle, float cx, float cy) throws DOMException {
			type = SVG_TRANSFORM_ROTATE;
			this.angle = angle;
			matrix.identity();
			matrix.translate(cx, cy);
			matrix.rotate(angle);
			matrix.translate(-cx, -cy);
			rotateValues = new float[] { angle, cx, cy };
		}

		@Override
		public void setSkewX(float angle) throws DOMException {
			type = SVG_TRANSFORM_SKEWX;
			this.angle = angle;
			matrix.set(1, 0, (float) Math.tan(angle), 1, 0, 0);;
		}

		@Override
		public void setSkewY(float angle) throws DOMException {
			type = SVG_TRANSFORM_SKEWY;
			this.angle = angle;
			matrix.set(1, (float) Math.tan(angle), 0, 1, 0, 0);
		}

	}

}
