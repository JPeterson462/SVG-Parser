package org.w3c.dom.svg.paths;

import org.w3c.dom.svg.SVGException;
import org.w3c.dom.svg.SVGMath;
import org.w3c.dom.svg.SVGPoint;

public class SVGPathMath {
	
	public static class State {

		public float[] lastControlPoint;
		
		public SVGPoint point = new SVGPoint.Implementation(0, 0), start;
		
		public short lastSegment = 0;
		
	}
	
	public static float getPathLength(SVGPathSegList list) {
		State state = new State();
		state.point = new SVGPoint.Implementation(0, 0);
		float length = 0;
		for (int i = 0; i < list.getNumberOfItems(); i++) {
			length += getSegmentLength(list.getItem(i), state);
			transformPoint(list.getItem(i), state);
			System.out.println(list.getItem(i).getPathSegTypeAsLetter() + " -> " + length);
		}
		return length;
	}
	
	public static float getSegmentLength(SVGPathSeg segment, State state) {
		float[] controlPoint;
		switch (segment.getPathSegType()) {
			case SVGPathSeg.PATHSEG_ARC_ABS:
				SVGPathSegArcAbs pathSegArcAbs = (SVGPathSegArcAbs) segment;
				return Arc.arcLength(state.point.getX(), state.point.getY(), pathSegArcAbs.getX(), pathSegArcAbs.getY(), pathSegArcAbs.getR1(), pathSegArcAbs.getR2(), 
						pathSegArcAbs.getAngle(), Arc.flag(pathSegArcAbs.getLargeArcFlag()), Arc.flag(pathSegArcAbs.getSweepFlag()), 1);
			case SVGPathSeg.PATHSEG_ARC_REL:
				SVGPathSegArcRel pathSegArcRel = (SVGPathSegArcRel) segment;
				return Arc.arcLength(0, 0, pathSegArcRel.getX(), pathSegArcRel.getY(), pathSegArcRel.getR1(), pathSegArcRel.getR2(), 
						pathSegArcRel.getAngle(), Arc.flag(pathSegArcRel.getLargeArcFlag()), Arc.flag(pathSegArcRel.getSweepFlag()), 1);
			case SVGPathSeg.PATHSEG_CLOSEPATH:
//				SVGPathSegClosePath pathSegClosePath = (SVGPathSegClosePath) segment;
				System.out.println(state.start + " " + state.point);
				float closeDx = state.start.getX() - state.point.getX();
				float closeDy = state.start.getY() - state.point.getY();
				return SVGMath.sqrt(closeDx * closeDx + closeDy * closeDy);
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_ABS:
				SVGPathSegCurveToCubicAbs pathSegCurveToCubicAbs = (SVGPathSegCurveToCubicAbs) segment;
				state.lastControlPoint = new float[] { pathSegCurveToCubicAbs.getX1(), pathSegCurveToCubicAbs.getY1() };
				return BezierCurve.cubicBezierLength(state.point.getX(), state.point.getY(), pathSegCurveToCubicAbs.getX1(), pathSegCurveToCubicAbs.getY1(), 
						pathSegCurveToCubicAbs.getX2(), pathSegCurveToCubicAbs.getY2(), pathSegCurveToCubicAbs.getX(), pathSegCurveToCubicAbs.getY(), 1);
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_REL:
				SVGPathSegCurveToCubicRel pathSegCurveToCubicRel = (SVGPathSegCurveToCubicRel) segment;
				state.lastControlPoint = new float[] { pathSegCurveToCubicRel.getX() + state.point.getX(), pathSegCurveToCubicRel.getY() + state.point.getY() };
				return BezierCurve.cubicBezierLength(0, 0, pathSegCurveToCubicRel.getX1(), pathSegCurveToCubicRel.getY1(), 
						pathSegCurveToCubicRel.getX2(), pathSegCurveToCubicRel.getY2(), pathSegCurveToCubicRel.getX(), pathSegCurveToCubicRel.getY(), 1);
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_SMOOTH_ABS:
				SVGPathSegCurveToCubicSmoothAbs pathSegCurveToCubicSmoothAbs = (SVGPathSegCurveToCubicSmoothAbs) segment;
				if (state.lastControlPoint == null) {
					state.lastControlPoint = new float[] { state.point.getX(), state.point.getY() };
				}
				controlPoint = SVGMath.reflectPoint(state.lastControlPoint[0], state.lastControlPoint[1], state.point.getX(), state.point.getY());
				state.lastControlPoint = controlPoint;
				return BezierCurve.cubicBezierLength(state.point.getX(), state.point.getY(), controlPoint[0], controlPoint[1],
						pathSegCurveToCubicSmoothAbs.getX2(), pathSegCurveToCubicSmoothAbs.getX2(), pathSegCurveToCubicSmoothAbs.getX(), pathSegCurveToCubicSmoothAbs.getY(), 1);
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_SMOOTH_REL:
				SVGPathSegCurveToCubicSmoothRel pathSegCurveToCubicSmoothRel = (SVGPathSegCurveToCubicSmoothRel) segment;
				if (state.lastControlPoint == null) {
					state.lastControlPoint = new float[] { state.point.getX(), state.point.getY() };
				}
				controlPoint = SVGMath.reflectPoint(state.lastControlPoint[0], state.lastControlPoint[1], state.point.getX(), state.point.getY());
				state.lastControlPoint = controlPoint;
				return BezierCurve.cubicBezierLength(0, 0, controlPoint[0] - state.point.getX(), controlPoint[1] - state.point.getY(), pathSegCurveToCubicSmoothRel.getX2(), pathSegCurveToCubicSmoothRel.getY2(),
						pathSegCurveToCubicSmoothRel.getX(), pathSegCurveToCubicSmoothRel.getY(), 1);
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_ABS:
				SVGPathSegCurveToQuadraticAbs pathSegCurveToQuadraticAbs = (SVGPathSegCurveToQuadraticAbs) segment;
				state.lastControlPoint = new float[] { pathSegCurveToQuadraticAbs.getX(), pathSegCurveToQuadraticAbs.getY() };
				return BezierCurve.quadraticBezierLength(state.point.getX(), state.point.getY(), pathSegCurveToQuadraticAbs.getX1(), pathSegCurveToQuadraticAbs.getY1(), 
						pathSegCurveToQuadraticAbs.getX(), pathSegCurveToQuadraticAbs.getY(), 1);
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_REL:
				SVGPathSegCurveToQuadraticRel pathSegCurveToQuadraticRel = (SVGPathSegCurveToQuadraticRel) segment;
				state.lastControlPoint = new float[] { pathSegCurveToQuadraticRel.getX() + state.point.getX(), pathSegCurveToQuadraticRel.getY() + state.point.getY() };
				return BezierCurve.quadraticBezierLength(0, 0, pathSegCurveToQuadraticRel.getX1(), pathSegCurveToQuadraticRel.getY1(), 
						pathSegCurveToQuadraticRel.getX(), pathSegCurveToQuadraticRel.getY(), 1);
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS:
				SVGPathSegCurveToQuadraticSmoothAbs pathSegCurveToQuadraticSmoothAbs = (SVGPathSegCurveToQuadraticSmoothAbs) segment;
				if (state.lastControlPoint == null) {
					state.lastControlPoint = new float[] { state.point.getX(), state.point.getY() };
				}
				controlPoint = SVGMath.reflectPoint(state.lastControlPoint[0], state.lastControlPoint[1], state.point.getX(), state.point.getY());
				state.lastControlPoint = controlPoint;
				return BezierCurve.quadraticBezierLength(state.point.getX(), state.point.getY(), controlPoint[0], controlPoint[1], 
						pathSegCurveToQuadraticSmoothAbs.getX(), pathSegCurveToQuadraticSmoothAbs.getY(), 1);
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL:
				SVGPathSegCurveToQuadraticSmoothRel pathSegCurveToQuadraticSmoothRel = (SVGPathSegCurveToQuadraticSmoothRel) segment;
				if (state.lastControlPoint == null) {
					state.lastControlPoint = new float[] { state.point.getX(), state.point.getY() };
				}
				controlPoint = SVGMath.reflectPoint(state.lastControlPoint[0], state.lastControlPoint[1], state.point.getX(), state.point.getY());
				state.lastControlPoint = controlPoint;
				return BezierCurve.quadraticBezierLength(0, 0, controlPoint[0] - state.point.getX(), controlPoint[1] - state.point.getY(), 
						pathSegCurveToQuadraticSmoothRel.getX(), pathSegCurveToQuadraticSmoothRel.getY(), 1);
			case SVGPathSeg.PATHSEG_LINETO_ABS:
				SVGPathSegLineToAbs pathSegLineToAbs = (SVGPathSegLineToAbs) segment;
				float dx = pathSegLineToAbs.getX() - state.point.getX();
				float dy = pathSegLineToAbs.getY() - state.point.getY();
				return SVGMath.sqrt(dx * dx + dy * dy);
			case SVGPathSeg.PATHSEG_LINETO_HORIZONTAL_ABS:
				SVGPathSegLineToHorizontalAbs pathSegLineToHorizontalAbs = (SVGPathSegLineToHorizontalAbs) segment;
				return pathSegLineToHorizontalAbs.getX() - state.point.getX();
			case SVGPathSeg.PATHSEG_LINETO_VERTICAL_ABS:
				SVGPathSegLineToVerticalAbs pathSegLineToVerticalAbs = (SVGPathSegLineToVerticalAbs) segment;
				return pathSegLineToVerticalAbs.getY() - state.point.getY();
			case SVGPathSeg.PATHSEG_LINETO_REL:
				SVGPathSegLineToRel pathSegLineToRel = (SVGPathSegLineToRel) segment;
				return SVGMath.sqrt(pathSegLineToRel.getX() * pathSegLineToRel.getX() + pathSegLineToRel.getY() * pathSegLineToRel.getY());
			case SVGPathSeg.PATHSEG_LINETO_HORIZONTAL_REL:
				SVGPathSegLineToHorizontalRel pathSegLineToHorizontalRel = (SVGPathSegLineToHorizontalRel) segment;
				return pathSegLineToHorizontalRel.getX();
			case SVGPathSeg.PATHSEG_LINETO_VERTICAL_REL:
				SVGPathSegLineToVerticalRel pathSegLineToVerticalRel = (SVGPathSegLineToVerticalRel) segment;
				return pathSegLineToVerticalRel.getY();
			case SVGPathSeg.PATHSEG_MOVETO_ABS:
				SVGPathSegMoveToAbs pathSegMoveToAbs = (SVGPathSegMoveToAbs) segment;
				if (state.start == null) {
					state.start = new SVGPoint.Implementation(pathSegMoveToAbs.getX(), pathSegMoveToAbs.getY());
				}
				return 0;
			case SVGPathSeg.PATHSEG_MOVETO_REL:
//				SVGPathSegMoveToRel pathSegMoveToRel = (SVGPathSegMoveToRel) segment;
				return 0;
			default:
				throw new SVGException(SVGException.SVG_WRONG_TYPE_ERR, "Invalid path segment type: " + segment);
		}
	}
	
	public static void transformPoint(SVGPathSeg segment, State state) {
		float segmentLength = getSegmentLength(segment, state);
		transformPoint(segment, segmentLength, segmentLength, state);
	}
	
	public static void transformPoint(SVGPathSeg segment, float distance, float segmentLength, State state) {
		float t = segmentLength > 0 ? distance / segmentLength : 1;
		float[] controlPoint;
		switch (segment.getPathSegType()) {
			case SVGPathSeg.PATHSEG_ARC_ABS:
				SVGPathSegArcAbs pathSegArcAbs = (SVGPathSegArcAbs) segment;
				float[] arcAbsPoint = Arc.arc(state.point.getX(), state.point.getY(), pathSegArcAbs.getX(), pathSegArcAbs.getY(), 
						pathSegArcAbs.getR1(), pathSegArcAbs.getR2(), pathSegArcAbs.getAngle(), Arc.flag(pathSegArcAbs.getLargeArcFlag()), 
						Arc.flag(pathSegArcAbs.getSweepFlag()), t);
				state.point.setX(arcAbsPoint[0]);
				state.point.setY(arcAbsPoint[1]);
				break;
			case SVGPathSeg.PATHSEG_ARC_REL:
				SVGPathSegArcRel pathSegArcRel = (SVGPathSegArcRel) segment;
				float[] arcRelPoint = Arc.arc(0, 0, pathSegArcRel.getX(), pathSegArcRel.getY(), 
						pathSegArcRel.getR1(), pathSegArcRel.getR2(), pathSegArcRel.getAngle(), Arc.flag(pathSegArcRel.getLargeArcFlag()), 
						Arc.flag(pathSegArcRel.getSweepFlag()), t);
				state.point.setX(state.point.getX() + arcRelPoint[0]);
				state.point.setY(state.point.getY() + arcRelPoint[1]);
				break;
			case SVGPathSeg.PATHSEG_CLOSEPATH:
//				SVGPathSegClosePath pathSegClosePath = (SVGPathSegClosePath) segment;
				float endDx = state.start.getX() - state.point.getX();
				float endDy = state.start.getY() - state.point.getY();
				state.point.setX(state.point.getX() + t * endDx);
				state.point.setY(state.point.getY() + t * endDy);
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_ABS:
				SVGPathSegCurveToCubicAbs pathSegCurveToCubicAbs = (SVGPathSegCurveToCubicAbs) segment;
				state.point.setX(BezierCurve.cubicBezier(state.point.getX(), pathSegCurveToCubicAbs.getX1(), pathSegCurveToCubicAbs.getX2(), pathSegCurveToCubicAbs.getX(), t));
				state.point.setY(BezierCurve.cubicBezier(state.point.getY(), pathSegCurveToCubicAbs.getY1(), pathSegCurveToCubicAbs.getY2(), pathSegCurveToCubicAbs.getY(), t));
				state.lastControlPoint = new float[] { pathSegCurveToCubicAbs.getX1(), pathSegCurveToCubicAbs.getY1() };
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_REL:
				SVGPathSegCurveToCubicRel pathSegCurveToCubicRel = (SVGPathSegCurveToCubicRel) segment;
				state.point.setX(state.point.getX() + BezierCurve.cubicBezier(0, pathSegCurveToCubicRel.getX1(), pathSegCurveToCubicRel.getX2(), pathSegCurveToCubicRel.getX(), t));
				state.point.setY(state.point.getY() + BezierCurve.cubicBezier(0, pathSegCurveToCubicRel.getY1(), pathSegCurveToCubicRel.getY2(), pathSegCurveToCubicRel.getY(), t));
				state.lastControlPoint = new float[] { pathSegCurveToCubicRel.getX1() + state.point.getX(), pathSegCurveToCubicRel.getY1() + state.point.getY() };
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_SMOOTH_ABS:
				SVGPathSegCurveToCubicSmoothAbs pathSegCurveToCubicSmoothAbs = (SVGPathSegCurveToCubicSmoothAbs) segment;
				if (state.lastControlPoint == null) {
					state.lastControlPoint = new float[] { state.point.getX(), state.point.getY() };
				}
				controlPoint = SVGMath.reflectPoint(state.lastControlPoint[0], state.lastControlPoint[1], state.point.getX(), state.point.getY());
				state.point.setX(BezierCurve.cubicBezier(state.point.getX(), controlPoint[0], pathSegCurveToCubicSmoothAbs.getX2(), pathSegCurveToCubicSmoothAbs.getX(), t));
				state.point.setY(BezierCurve.cubicBezier(state.point.getY(),controlPoint[1], pathSegCurveToCubicSmoothAbs.getY2(), pathSegCurveToCubicSmoothAbs.getY(), t));
				state.lastControlPoint = controlPoint;
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_SMOOTH_REL:
				SVGPathSegCurveToCubicSmoothRel pathSegCurveToCubicSmoothRel = (SVGPathSegCurveToCubicSmoothRel) segment;
				if (state.lastControlPoint == null) {
					state.lastControlPoint = new float[] { state.point.getX(), state.point.getY() };
				}
				controlPoint = SVGMath.reflectPoint(state.lastControlPoint[0], state.lastControlPoint[1], state.point.getX(), state.point.getY());
				state.point.setX(state.point.getX() + BezierCurve.cubicBezier(0, controlPoint[0] - state.point.getX(), pathSegCurveToCubicSmoothRel.getX2(), pathSegCurveToCubicSmoothRel.getX(), t));
				state.point.setY(state.point.getY() + BezierCurve.cubicBezier(0, controlPoint[1] - state.point.getY(), pathSegCurveToCubicSmoothRel.getY2(), pathSegCurveToCubicSmoothRel.getY(), t));
				state.lastControlPoint = controlPoint;
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_ABS:
				SVGPathSegCurveToQuadraticAbs pathSegCurveToQuadraticAbs = (SVGPathSegCurveToQuadraticAbs) segment;
				state.point.setX(BezierCurve.quadraticBezier(state.point.getX(), pathSegCurveToQuadraticAbs.getX1(), pathSegCurveToQuadraticAbs.getX(), t));
				state.point.setY(BezierCurve.quadraticBezier(state.point.getY(), pathSegCurveToQuadraticAbs.getY1(), pathSegCurveToQuadraticAbs.getY(), t));
				state.lastControlPoint = new float[] { pathSegCurveToQuadraticAbs.getX(), pathSegCurveToQuadraticAbs.getY() };
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_REL:
				SVGPathSegCurveToQuadraticRel pathSegCurveToQuadraticRel = (SVGPathSegCurveToQuadraticRel) segment;
				state.point.setX(state.point.getX() + BezierCurve.quadraticBezier(0, pathSegCurveToQuadraticRel.getX1(), pathSegCurveToQuadraticRel.getX(), t));
				state.point.setY(state.point.getY() + BezierCurve.quadraticBezier(0, pathSegCurveToQuadraticRel.getY1(), pathSegCurveToQuadraticRel.getY(), t));
				state.lastControlPoint = new float[] { pathSegCurveToQuadraticRel.getX() + state.point.getX(), pathSegCurveToQuadraticRel.getY() + state.point.getY() };
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS:
				SVGPathSegCurveToQuadraticSmoothAbs pathSegCurveToQuadraticSmoothAbs = (SVGPathSegCurveToQuadraticSmoothAbs) segment;
				if (state.lastControlPoint == null) {
					state.lastControlPoint = new float[] { state.point.getX(), state.point.getY() };
				}
				controlPoint = SVGMath.reflectPoint(state.lastControlPoint[0], state.lastControlPoint[1], state.point.getX(), state.point.getY());
				state.point.setX(BezierCurve.quadraticBezier(state.point.getX(), controlPoint[0], pathSegCurveToQuadraticSmoothAbs.getX(), t));
				state.point.setY(BezierCurve.quadraticBezier(state.point.getY(), controlPoint[1], pathSegCurveToQuadraticSmoothAbs.getY(), t));
				state.lastControlPoint = controlPoint;
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL:
				SVGPathSegCurveToQuadraticSmoothRel pathSegCurveToQuadraticSmoothRel = (SVGPathSegCurveToQuadraticSmoothRel) segment;
				if (state.lastControlPoint == null) {
					state.lastControlPoint = new float[] { state.point.getX(), state.point.getY() };
				}
				controlPoint = SVGMath.reflectPoint(state.lastControlPoint[0], state.lastControlPoint[1], state.point.getX(), state.point.getY());
				state.point.setX(state.point.getX() + BezierCurve.quadraticBezier(0, controlPoint[0] - state.point.getX(), pathSegCurveToQuadraticSmoothRel.getX(), t));
				state.point.setY(state.point.getY() + BezierCurve.quadraticBezier(0, controlPoint[1] - state.point.getY(), pathSegCurveToQuadraticSmoothRel.getY(), t));
				state.lastControlPoint = controlPoint;
				break;
			case SVGPathSeg.PATHSEG_LINETO_ABS:
				SVGPathSegLineToAbs pathSegLineToAbs = (SVGPathSegLineToAbs) segment;
				state.point.setX(lerp(state.point.getX(), pathSegLineToAbs.getX(), t));
				state.point.setY(lerp(state.point.getY(), pathSegLineToAbs.getY(), t));
				break;
			case SVGPathSeg.PATHSEG_LINETO_HORIZONTAL_ABS:
				SVGPathSegLineToHorizontalAbs pathSegLineToHorizontalAbs = (SVGPathSegLineToHorizontalAbs) segment;
				state.point.setX(lerp(state.point.getX(), pathSegLineToHorizontalAbs.getX(), t));
				break;
			case SVGPathSeg.PATHSEG_LINETO_VERTICAL_ABS:
				SVGPathSegLineToVerticalAbs pathSegLineToVerticalAbs = (SVGPathSegLineToVerticalAbs) segment;
				state.point.setY(lerp(state.point.getY(), pathSegLineToVerticalAbs.getY(), t));
				break;
			case SVGPathSeg.PATHSEG_LINETO_REL:
				SVGPathSegLineToRel pathSegLineToRel = (SVGPathSegLineToRel) segment;
				state.point.setX(pathSegLineToRel.getX() * t + state.point.getX());
				state.point.setY(pathSegLineToRel.getY() * t + state.point.getY());
				break;
			case SVGPathSeg.PATHSEG_LINETO_HORIZONTAL_REL:
				SVGPathSegLineToHorizontalRel pathSegLineToHorizontalRel = (SVGPathSegLineToHorizontalRel) segment;
				state.point.setX(state.point.getX() + pathSegLineToHorizontalRel.getX() * t);
				break;
			case SVGPathSeg.PATHSEG_LINETO_VERTICAL_REL:
				SVGPathSegLineToVerticalRel pathSegLineToVerticalRel = (SVGPathSegLineToVerticalRel) segment;
				state.point.setY(state.point.getY() + pathSegLineToVerticalRel.getY() * t);
				break;
			case SVGPathSeg.PATHSEG_MOVETO_ABS:
				SVGPathSegMoveToAbs pathSegMoveToAbs = (SVGPathSegMoveToAbs) segment;
				state.point.setX(pathSegMoveToAbs.getX());
				state.point.setY(pathSegMoveToAbs.getY());
				if (state.lastSegment == SVGPathSeg.PATHSEG_CLOSEPATH) {
					state.start = new SVGPoint.Implementation(state.point.getX(), state.point.getY());
				}
				return;
			case SVGPathSeg.PATHSEG_MOVETO_REL:
				SVGPathSegMoveToRel pathSegMoveToRel = (SVGPathSegMoveToRel) segment;
				state.point.setX(pathSegMoveToRel.getX() + state.point.getX());
				state.point.setY(pathSegMoveToRel.getY() + state.point.getX());
				if (state.lastSegment == 0) {
					state.start = new SVGPoint.Implementation(state.point.getX(), state.point.getY());
				}
				return;
			default:
				throw new SVGException(SVGException.SVG_WRONG_TYPE_ERR, "Invalid path segment type: " + segment);
		}
		state.lastSegment = segment.getPathSegType();
	}
	
	public static float lerp(float a, float b, float t) {
		return t * (b - a) + a;
	}

}
