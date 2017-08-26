package org.w3c.dom.svg.paths;

public class PathSegDuplicator {
	
	public static SVGPathSeg duplicate(SVGPathSeg original) {
		if (original instanceof SVGPathSegArcAbs) {
			SVGPathSegArcAbs pathSeg = (SVGPathSegArcAbs) original;
			SVGPathSegArcAbs newSeg = new SVGPathSegArcAbs.Implementation();
			newSeg.setAngle(pathSeg.getAngle());
			newSeg.setLargeArcFlag(pathSeg.getLargeArcFlag());
			newSeg.setR1(pathSeg.getR1());
			newSeg.setR2(pathSeg.getR2());
			newSeg.setSweepFlag(pathSeg.getSweepFlag());
			newSeg.setX(pathSeg.getX());
			newSeg.setY(pathSeg.getY());
			return newSeg;
		}
		if (original instanceof SVGPathSegArcRel) {
			SVGPathSegArcRel pathSeg = (SVGPathSegArcRel) original;
			SVGPathSegArcRel newSeg = new SVGPathSegArcRel.Implementation();
			newSeg.setAngle(pathSeg.getAngle());
			newSeg.setLargeArcFlag(pathSeg.getLargeArcFlag());
			newSeg.setR1(pathSeg.getR1());
			newSeg.setR2(pathSeg.getR2());
			newSeg.setSweepFlag(pathSeg.getSweepFlag());
			newSeg.setX(pathSeg.getX());
			newSeg.setY(pathSeg.getY());
			return newSeg;
		}
		if (original instanceof SVGPathSegClosePath) {
			return new SVGPathSegClosePath.Implementation();
		}
		if (original instanceof SVGPathSegCurveToCubicAbs) {
			SVGPathSegCurveToCubicAbs pathSeg = (SVGPathSegCurveToCubicAbs) original;
			SVGPathSegCurveToCubicAbs newSeg = new SVGPathSegCurveToCubicAbs.Implementation();
			newSeg.setX(pathSeg.getX());
			newSeg.setY(pathSeg.getY());
			newSeg.setX1(pathSeg.getX1());
			newSeg.setY1(pathSeg.getY1());
			newSeg.setX2(pathSeg.getX2());
			newSeg.setY2(pathSeg.getY2());
			return newSeg;
		}
		if (original instanceof SVGPathSegCurveToCubicRel) {
			SVGPathSegCurveToCubicRel pathSeg = (SVGPathSegCurveToCubicRel) original;
			SVGPathSegCurveToCubicRel newSeg = new SVGPathSegCurveToCubicRel.Implementation();
			newSeg.setX(pathSeg.getX());
			newSeg.setY(pathSeg.getY());
			newSeg.setX1(pathSeg.getX1());
			newSeg.setY1(pathSeg.getY1());
			newSeg.setX2(pathSeg.getX2());
			newSeg.setY2(pathSeg.getY2());
			return newSeg;
		}
		if (original instanceof SVGPathSegCurveToCubicSmoothAbs) {
			SVGPathSegCurveToCubicSmoothAbs pathSeg = (SVGPathSegCurveToCubicSmoothAbs) original;
			SVGPathSegCurveToCubicSmoothAbs newSeg = new SVGPathSegCurveToCubicSmoothAbs.Implementation();
			newSeg.setX(pathSeg.getX());
			newSeg.setY(pathSeg.getY());
			newSeg.setX2(pathSeg.getX2());
			newSeg.setY2(pathSeg.getY2());
			return newSeg;
		}
		if (original instanceof SVGPathSegCurveToCubicSmoothRel) {
			SVGPathSegCurveToCubicSmoothRel pathSeg = (SVGPathSegCurveToCubicSmoothRel) original;
			SVGPathSegCurveToCubicSmoothRel newSeg = new SVGPathSegCurveToCubicSmoothRel.Implementation();
			newSeg.setX(pathSeg.getX());
			newSeg.setY(pathSeg.getY());
			newSeg.setX2(pathSeg.getX2());
			newSeg.setY2(pathSeg.getY2());
			return newSeg;
		}
		if (original instanceof SVGPathSegCurveToQuadraticAbs) {
			SVGPathSegCurveToQuadraticAbs pathSeg = (SVGPathSegCurveToQuadraticAbs) original;
			SVGPathSegCurveToQuadraticAbs newSeg = new SVGPathSegCurveToQuadraticAbs.Implementation();
			newSeg.setX(pathSeg.getX());
			newSeg.setY(pathSeg.getY());
			newSeg.setX1(pathSeg.getX1());
			newSeg.setY1(pathSeg.getY1());
			return newSeg;
		}
		if (original instanceof SVGPathSegCurveToQuadraticRel) {
			SVGPathSegCurveToQuadraticRel pathSeg = (SVGPathSegCurveToQuadraticRel) original;
			SVGPathSegCurveToQuadraticRel newSeg = new SVGPathSegCurveToQuadraticRel.Implementation();
			newSeg.setX(pathSeg.getX());
			newSeg.setY(pathSeg.getY());
			newSeg.setX1(pathSeg.getX1());
			newSeg.setY1(pathSeg.getY1());
			return newSeg;
		}
		if (original instanceof SVGPathSegCurveToQuadraticSmoothAbs) {
			SVGPathSegCurveToQuadraticSmoothAbs pathSeg = (SVGPathSegCurveToQuadraticSmoothAbs) original;
			SVGPathSegCurveToQuadraticSmoothAbs newSeg = new SVGPathSegCurveToQuadraticSmoothAbs.Implementation();
			newSeg.setX(pathSeg.getX());
			newSeg.setY(pathSeg.getY());
			return newSeg;
		}
		if (original instanceof SVGPathSegCurveToQuadraticSmoothRel) {
			SVGPathSegCurveToQuadraticSmoothRel pathSeg = (SVGPathSegCurveToQuadraticSmoothRel) original;
			SVGPathSegCurveToQuadraticSmoothRel newSeg = new SVGPathSegCurveToQuadraticSmoothRel.Implementation();
			newSeg.setX(pathSeg.getX());
			newSeg.setY(pathSeg.getY());
			return newSeg;
		}
		if (original instanceof SVGPathSegLineToAbs) {
			SVGPathSegLineToAbs pathSeg = (SVGPathSegLineToAbs) original;
			SVGPathSegLineToAbs newSeg = new SVGPathSegLineToAbs.Implementation();
			newSeg.setX(pathSeg.getX());
			newSeg.setY(pathSeg.getY());
			return newSeg;
		}
		if (original instanceof SVGPathSegLineToHorizontalAbs) {
			SVGPathSegLineToHorizontalAbs pathSeg = (SVGPathSegLineToHorizontalAbs) original;
			SVGPathSegLineToHorizontalAbs newSeg = new SVGPathSegLineToHorizontalAbs.Implementation();
			newSeg.setX(pathSeg.getX());
			return newSeg;
		}
		if (original instanceof SVGPathSegLineToVerticalAbs) {
			SVGPathSegLineToVerticalAbs pathSeg = (SVGPathSegLineToVerticalAbs) original;
			SVGPathSegLineToVerticalAbs newSeg = new SVGPathSegLineToVerticalAbs.Implementation();
			newSeg.setY(pathSeg.getY());
			return newSeg;
		}
		if (original instanceof SVGPathSegLineToRel) {
			SVGPathSegLineToRel pathSeg = (SVGPathSegLineToRel) original;
			SVGPathSegLineToRel newSeg = new SVGPathSegLineToRel.Implementation();
			newSeg.setX(pathSeg.getX());
			newSeg.setY(pathSeg.getY());
			return newSeg;
		}
		if (original instanceof SVGPathSegLineToHorizontalRel) {
			SVGPathSegLineToHorizontalRel pathSeg = (SVGPathSegLineToHorizontalRel) original;
			SVGPathSegLineToHorizontalRel newSeg = new SVGPathSegLineToHorizontalRel.Implementation();
			newSeg.setX(pathSeg.getX());
			return newSeg;
		}
		if (original instanceof SVGPathSegLineToVerticalRel) {
			SVGPathSegLineToVerticalRel pathSeg = (SVGPathSegLineToVerticalRel) original;
			SVGPathSegLineToVerticalRel newSeg = new SVGPathSegLineToVerticalRel.Implementation();
			newSeg.setY(pathSeg.getY());
			return newSeg;
		}
		if (original instanceof SVGPathSegMoveToAbs) {
			SVGPathSegMoveToAbs pathSeg = (SVGPathSegMoveToAbs) original;
			SVGPathSegMoveToAbs newSeg = new SVGPathSegMoveToAbs.Implementation();
			newSeg.setX(pathSeg.getX());
			newSeg.setY(pathSeg.getY());
			return newSeg;
		}
		if (original instanceof SVGPathSegMoveToRel) {
			SVGPathSegMoveToRel pathSeg = (SVGPathSegMoveToRel) original;
			SVGPathSegMoveToRel newSeg = new SVGPathSegMoveToRel.Implementation();
			newSeg.setX(pathSeg.getX());
			newSeg.setY(pathSeg.getY());
			return newSeg;
		}
		return null;
	}

}
