package org.w3c.dom.svg.paths;

import java.util.ArrayList;

public class NormalizedPathSegListBuilder {
	
	private ArrayList<SVGPathSeg> segList = new ArrayList<>();
	
	private SVGPathMath.State pathMathState = new SVGPathMath.State();
	
	private short lastSegment = 0;
	
	public NormalizedPathSegListBuilder() {
		
	}
	
	private void addSegment(SVGPathSeg segment) {
		segList.add(segment);
		lastSegment = segment.getPathSegType();
	}
	
	public SVGPathSegList process(SVGPathSegList pathSegList) {
		for (int i = 0; i < pathSegList.getNumberOfItems(); i++) {
			process(pathSegList.getItem(i));
		}
		return toList();
	}
	
	public void process(SVGPathSeg pathSeg) {
		if (pathSeg instanceof SVGPathSegMoveToRel) {
			SVGPathSegMoveToRel pathSegInstance = (SVGPathSegMoveToRel) pathSeg;
			moveToRel(pathSegInstance.getX(), pathSegInstance.getY());
		}
		else if (pathSeg instanceof SVGPathSegMoveToAbs) {
			SVGPathSegMoveToAbs pathSegInstance = (SVGPathSegMoveToAbs) pathSeg;
			moveToAbs(pathSegInstance.getX(), pathSegInstance.getY());
		}
		else if (pathSeg instanceof SVGPathSegClosePath) {
			segList.add(new SVGPathSegClosePath.Implementation());
		}
		else if (pathSeg instanceof SVGPathSegLineToRel) {
			SVGPathSegLineToRel pathSegInstance = (SVGPathSegLineToRel) pathSeg;
			lineToRel(pathSegInstance.getX(), pathSegInstance.getY());
		}
		else if (pathSeg instanceof SVGPathSegLineToAbs) {
			SVGPathSegLineToAbs pathSegInstance = (SVGPathSegLineToAbs) pathSeg;
			lineToAbs(pathSegInstance.getX(), pathSegInstance.getY());
		}
		else if (pathSeg instanceof SVGPathSegLineToHorizontalRel) {
			SVGPathSegLineToHorizontalRel pathSegInstance = (SVGPathSegLineToHorizontalRel) pathSeg;
			lineToHorizontalRel(pathSegInstance.getX());
		}
		else if (pathSeg instanceof SVGPathSegLineToHorizontalAbs) {
			SVGPathSegLineToHorizontalAbs pathSegInstance = (SVGPathSegLineToHorizontalAbs) pathSeg;
			lineToHorizontalAbs(pathSegInstance.getX());
		}
		else if (pathSeg instanceof SVGPathSegLineToVerticalRel) {
			SVGPathSegLineToVerticalRel pathSegInstance = (SVGPathSegLineToVerticalRel) pathSeg;
			lineToVerticalRel(pathSegInstance.getY());
		}
		else if (pathSeg instanceof SVGPathSegLineToVerticalAbs) {
			SVGPathSegLineToVerticalAbs pathSegInstance = (SVGPathSegLineToVerticalAbs) pathSeg;
			lineToVerticalAbs(pathSegInstance.getY());
		}
		else if (pathSeg instanceof SVGPathSegCurveToCubicRel) {
			SVGPathSegCurveToCubicRel pathSegInstance = (SVGPathSegCurveToCubicRel) pathSeg;
			curveToCubicRel(pathSegInstance.getX1(), pathSegInstance.getY1(), pathSegInstance.getX2(), pathSegInstance.getY2(), pathSegInstance.getX(), pathSegInstance.getY());
		}
		else if (pathSeg instanceof SVGPathSegCurveToCubicAbs) {
			SVGPathSegCurveToCubicAbs pathSegInstance = (SVGPathSegCurveToCubicAbs) pathSeg;
			curveToCubicAbs(pathSegInstance.getX1(), pathSegInstance.getY1(), pathSegInstance.getX2(), pathSegInstance.getY2(), pathSegInstance.getX(), pathSegInstance.getY());
		}
		else if (pathSeg instanceof SVGPathSegCurveToCubicSmoothRel) {
			SVGPathSegCurveToCubicSmoothRel pathSegInstance = (SVGPathSegCurveToCubicSmoothRel) pathSeg;
			curveToCubicSmoothRel(pathSegInstance.getX2(), pathSegInstance.getY2(), pathSegInstance.getX(), pathSegInstance.getY());
		}
		else if (pathSeg instanceof SVGPathSegCurveToCubicSmoothAbs) {
			SVGPathSegCurveToCubicSmoothAbs pathSegInstance = (SVGPathSegCurveToCubicSmoothAbs) pathSeg;
			curveToCubicSmoothAbs(pathSegInstance.getX2(), pathSegInstance.getY2(), pathSegInstance.getX(), pathSegInstance.getY());
		}
		else if (pathSeg instanceof SVGPathSegCurveToQuadraticRel) {
			SVGPathSegCurveToQuadraticRel pathSegInstance = (SVGPathSegCurveToQuadraticRel) pathSeg;
			curveToQuadraticRel(pathSegInstance.getX1(), pathSegInstance.getY1(), pathSegInstance.getX(), pathSegInstance.getY());
		}
		else if (pathSeg instanceof SVGPathSegCurveToQuadraticAbs) {
			SVGPathSegCurveToQuadraticAbs pathSegInstance = (SVGPathSegCurveToQuadraticAbs) pathSeg;
			curveToQuadraticAbs(pathSegInstance.getX1(), pathSegInstance.getY1(), pathSegInstance.getX(), pathSegInstance.getY());
		}
		else if (pathSeg instanceof SVGPathSegCurveToQuadraticSmoothRel) {
			SVGPathSegCurveToQuadraticSmoothRel pathSegInstance = (SVGPathSegCurveToQuadraticSmoothRel) pathSeg;
			curveToQuadraticSmoothRel(pathSegInstance.getX(), pathSegInstance.getY());
		}
		else if (pathSeg instanceof SVGPathSegCurveToQuadraticSmoothAbs) {
			SVGPathSegCurveToQuadraticSmoothRel pathSegInstance = (SVGPathSegCurveToQuadraticSmoothRel) pathSeg;
			curveToQuadraticSmoothAbs(pathSegInstance.getX(), pathSegInstance.getY());
		}
		else if (pathSeg instanceof SVGPathSegArcRel) {
			SVGPathSegArcRel pathSegInstance = (SVGPathSegArcRel) pathSeg;
			arcRel(pathSegInstance.getR1(), pathSegInstance.getR2(), pathSegInstance.getAngle(), 
					pathSegInstance.getLargeArcFlag(), pathSegInstance.getSweepFlag(), pathSegInstance.getX(), pathSegInstance.getY());
		}
		else if (pathSeg instanceof SVGPathSegArcAbs) {
			SVGPathSegArcAbs pathSegInstance = (SVGPathSegArcAbs) pathSeg;
			arcAbs(pathSegInstance.getR1(), pathSegInstance.getR2(), pathSegInstance.getAngle(), 
					pathSegInstance.getLargeArcFlag(), pathSegInstance.getSweepFlag(), pathSegInstance.getX(), pathSegInstance.getY());
		}
	}
	
	public SVGPathSegList toList() {
		return new SVGPathSegList.Implementation(segList);
	}
	
	// Internal methods
	
	private void moveToRel(float x, float y) {
		moveToAbs(pathMathState.point.getX() + x, pathMathState.point.getY());
	}
	
	private void moveToAbs(float x, float y) {
		SVGPathSegMoveToAbs moveToAbs = new SVGPathSegMoveToAbs.Implementation();
		moveToAbs.setX(x);
		moveToAbs.setY(y);
		SVGPathMath.transformPoint(moveToAbs, pathMathState);
		addSegment(moveToAbs);
	}
	
	private void lineToRel(float x, float y) {
		lineToAbs(pathMathState.point.getX() + x, pathMathState.point.getY() + y);
	}
	
	private void lineToAbs(float x, float y) {
		SVGPathSegLineToAbs lineToAbs = new SVGPathSegLineToAbs.Implementation();
		lineToAbs.setX(x);
		lineToAbs.setY(y);
		SVGPathMath.transformPoint(lineToAbs, pathMathState);
		addSegment(lineToAbs);
	}
	
	private void lineToHorizontalRel(float x) {
		lineToAbs(pathMathState.point.getX() + x, pathMathState.point.getY());
	}

	private void lineToHorizontalAbs(float x) {
		lineToAbs(x, pathMathState.point.getY());
	}
	
	private void lineToVerticalRel(float y) {
		lineToAbs(pathMathState.point.getX(), pathMathState.point.getY() + y);
	}

	private void lineToVerticalAbs(float y) {
		lineToAbs(pathMathState.point.getX(), y);
	}
	
	private void curveToCubicRel(float x1, float y1, float x2, float y2, float x, float y) {
		curveToCubicAbs(pathMathState.point.getX() + x1, pathMathState.point.getY() + y1, 
				pathMathState.point.getX() + x2, pathMathState.point.getY() + y2, pathMathState.point.getX() + x, pathMathState.point.getY() + y);
	}
	
	private void curveToCubicAbs(float x1, float y1, float x2, float y2, float x, float y) {
		SVGPathSegCurveToCubicAbs curveToCubicAbs = new SVGPathSegCurveToCubicAbs.Implementation();
		curveToCubicAbs.setX(x);
		curveToCubicAbs.setY(y);
		curveToCubicAbs.setX1(x1);
		curveToCubicAbs.setY1(y1);
		curveToCubicAbs.setX2(x2);
		curveToCubicAbs.setY2(y2);
		SVGPathMath.transformPoint(curveToCubicAbs, pathMathState);
		addSegment(curveToCubicAbs);
	}
	
	private void curveToCubicSmoothRel(float x2, float y2, float x, float y) {
		curveToCubicSmoothAbs(pathMathState.point.getX() + x2, pathMathState.point.getY() + y2, pathMathState.point.getX() + x, pathMathState.point.getY() + y);
	}
	
	private void curveToCubicSmoothAbs(float x2, float y2, float x, float y) {
		SVGPathSegCurveToCubicSmoothAbs curveToCubicSmoothAbs = new SVGPathSegCurveToCubicSmoothAbs.Implementation();
		curveToCubicSmoothAbs.setX(x);
		curveToCubicSmoothAbs.setY(y);
		curveToCubicSmoothAbs.setX2(x2);
		curveToCubicSmoothAbs.setY2(y2);
		SVGPathMath.transformPoint(curveToCubicSmoothAbs, pathMathState);
		addSegment(curveToCubicSmoothAbs);
	}
	
	private void curveToQuadraticRel(float x1, float y1, float x, float y) {
		curveToQuadraticAbs(pathMathState.point.getX() + x1, pathMathState.point.getY() + y1, pathMathState.point.getX() + x, pathMathState.point.getY() + y);
	}
	
	private void curveToQuadraticAbs(float x1, float y1, float x, float y) {
		curveToCubicAbs(pathMathState.point.getX() + 2 * (x1 - pathMathState.point.getX()) / 3,
				pathMathState.point.getY() + 2 * (y1 - pathMathState.point.getY()) / 3,
				x + 2 * (x1 - x) / 3,
				y + 2 * (y1 - y) / 3,
				x, y);
	}
	
	private void curveToQuadraticSmoothRel(float x, float y) {
		curveToQuadraticSmoothAbs(pathMathState.point.getX() + x, pathMathState.point.getY() + y);
	}
	
	private void curveToQuadraticSmoothAbs(float x, float y) {
		if (lastSegment == SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_ABS) {
			curveToQuadraticAbs(pathMathState.point.getX() + (pathMathState.point.getX() - pathMathState.lastControlPoint[0]),
					pathMathState.point.getY() + (pathMathState.point.getY() - pathMathState.lastControlPoint[1]),
					x, y);
		} else {
			curveToQuadraticAbs(pathMathState.point.getX(), pathMathState.point.getY(), x, y);
		}
	}
	
	private void arcRel(float rx, float ry, float xAxisRotation, boolean largeArcFlag, boolean sweepFlag, float x, float y) {
		arcAbs(rx, ry, xAxisRotation, largeArcFlag, sweepFlag, pathMathState.point.getX() + x, pathMathState.point.getY());
	}
	
	private void arcAbs(float rx, float ry, float xAxisRotation, boolean largeArcFlag, boolean sweepFlag, float x, float y) {
		if (rx == 0 || ry == 0) {
			lineToAbs(x, y);
		} 
		else if (pathMathState.point.getX() == x && pathMathState.point.getY() == y) {
			// Unnecessary
		}
		else {
			ArcNormalizer.normalizeArc(this::curveToCubicAbs, pathMathState.point.getX(), pathMathState.point.getY(), 
					rx, ry, xAxisRotation, largeArcFlag, sweepFlag, x, y);
		}
	}

}
