package org.w3c.dom.svg.paths;

public interface SVGPathSeg {

	/** The unit type is not one of predefined types. It is invalid to attempt to define a new value of this type or to attempt to switch an existing value to this type. */
	public static final short PATHSEG_UNKNOWN = 0;
	/** Corresponds to a "closepath" (z) path data command. */
	public static final short PATHSEG_CLOSEPATH = 1;
	/** Corresponds to a "absolute moveto" (M) path data command. */
	public static final short PATHSEG_MOVETO_ABS = 2;
	/** Corresponds to a "relative moveto" (m) path data command. */
	public static final short PATHSEG_MOVETO_REL = 3;
	/** Corresponds to a "absolute lineto" (L) path data command. */
	public static final short PATHSEG_LINETO_ABS = 4;
	/** Corresponds to a "relative lineto" (l) path data command. */
	public static final short PATHSEG_LINETO_REL = 5;
	/** Corresponds to a "absolute cubic Bézier curveto" (C) path data command. */
	public static final short PATHSEG_CURVETO_CUBIC_ABS = 6;
	/** Corresponds to a "relative cubic Bézier curveto" (c) path data command. */
	public static final short PATHSEG_CURVETO_CUBIC_REL = 7;
	/** Corresponds to a "absolute quadratic Bézier curveto" (Q) path data command. */
	public static final short PATHSEG_CURVETO_QUADRATIC_ABS = 8;
	/** Corresponds to a "relative quadratic Bézier curveto" (q) path data command. */
	public static final short PATHSEG_CURVETO_QUADRATIC_REL = 9;
	/** Corresponds to a "absolute arcto" (A) path data command. */
	public static final short PATHSEG_ARC_ABS = 10;
	/** Corresponds to a "relative arcto" (a) path data command. */
	public static final short PATHSEG_ARC_REL = 11;
	/** Corresponds to a "absolute horizontal lineto" (H) path data command. */
	public static final short PATHSEG_LINETO_HORIZONTAL_ABS = 12;
	/** Corresponds to a "relative horizontal lineto" (h) path data command. */
	public static final short PATHSEG_LINETO_HORIZONTAL_REL = 13;
	/** Corresponds to a "absolute vertical lineto" (V) path data command. */
	public static final short PATHSEG_LINETO_VERTICAL_ABS = 14;
	/** Corresponds to a "relative vertical lineto" (v) path data command. */
	public static final short PATHSEG_LINETO_VERTICAL_REL = 15;
	/** Corresponds to a "absolute smooth cubic curveto" (S) path data command. */
	public static final short PATHSEG_CURVETO_CUBIC_SMOOTH_ABS = 16;
	/** Corresponds to a "relative smooth cubic curveto" (s) path data command. */
	public static final short PATHSEG_CURVETO_CUBIC_SMOOTH_REL = 17;
	/** Corresponds to a "absolute smooth quadratic curveto" (T) path data command. */
	public static final short PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS = 18;
	/** Corresponds to a "relative smooth quadratic curveto" (t) path data command. */
	public static final short PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL = 19;

	public short getPathSegType();
	
	public String getPathSegTypeAsLetter();
	
	public static class Implementation implements SVGPathSeg {

		private short pathSegType;
		
		private String pathSegTypeAsLetter;
		
		public Implementation(short pathSegType) {
			this.pathSegType = pathSegType;
			switch (pathSegType) {
				case PATHSEG_CLOSEPATH:
					pathSegTypeAsLetter = "z";
					break;
				case PATHSEG_MOVETO_ABS:
					pathSegTypeAsLetter = "M";
					break;
				case PATHSEG_MOVETO_REL:
					pathSegTypeAsLetter = "m";
					break;
				case PATHSEG_LINETO_ABS:
					pathSegTypeAsLetter = "L";
					break;
				case PATHSEG_LINETO_REL:
					pathSegTypeAsLetter = "l";
					break;
				case PATHSEG_CURVETO_CUBIC_ABS:
					pathSegTypeAsLetter = "C";
					break;
				case PATHSEG_CURVETO_CUBIC_REL:
					pathSegTypeAsLetter = "c";
					break;
				case PATHSEG_CURVETO_QUADRATIC_ABS:
					pathSegTypeAsLetter = "Q";
					break;
				case PATHSEG_CURVETO_QUADRATIC_REL:
					pathSegTypeAsLetter = "q";
					break;
				case PATHSEG_ARC_ABS:
					pathSegTypeAsLetter = "A";
					break;
				case PATHSEG_ARC_REL:
					pathSegTypeAsLetter = "a";
					break;
				case PATHSEG_LINETO_HORIZONTAL_ABS:
					pathSegTypeAsLetter = "H";
					break;
				case PATHSEG_LINETO_HORIZONTAL_REL:
					pathSegTypeAsLetter = "h";
					break;
				case PATHSEG_LINETO_VERTICAL_ABS:
					pathSegTypeAsLetter = "V";
					break;
				case PATHSEG_LINETO_VERTICAL_REL:
					pathSegTypeAsLetter = "v";
					break;
				case PATHSEG_CURVETO_CUBIC_SMOOTH_ABS:
					pathSegTypeAsLetter = "S";
					break;
				case PATHSEG_CURVETO_CUBIC_SMOOTH_REL:
					pathSegTypeAsLetter = "s";
					break;
				case PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS:
					pathSegTypeAsLetter = "T";
					break;
				case PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL:
					pathSegTypeAsLetter = "t";
					break;
			}
		}
		
		@Override
		public short getPathSegType() {
			return pathSegType;
		}

		@Override
		public String getPathSegTypeAsLetter() {
			return pathSegTypeAsLetter;
		}
		
	}
	
}
