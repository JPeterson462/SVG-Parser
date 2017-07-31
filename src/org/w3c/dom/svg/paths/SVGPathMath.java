package org.w3c.dom.svg.paths;

import org.w3c.dom.svg.SVGException;
import org.w3c.dom.svg.SVGMath;
import org.w3c.dom.svg.SVGPoint;

public class SVGPathMath {
	
	public static class State {

		public float[] lastControlPoint;
		
		public SVGPoint point, start;
		
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
				float closeDx = state.start.getX() - state.point.getX();
				float closeDy = state.start.getY() - state.point.getY();
				return SVGMath.sqrt(closeDx * closeDx + closeDy * closeDy);
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_ABS:
				SVGPathSegCurveToCubicAbs pathSegCurveToCubicAbs = (SVGPathSegCurveToCubicAbs) segment;
				state.lastControlPoint = new float[] { pathSegCurveToCubicAbs.getX1(), pathSegCurveToCubicAbs.getY1() };
				return BezierCurve.cubicBezierLength(state.point.getX(), state.point.getY(), pathSegCurveToCubicAbs.getX(), pathSegCurveToCubicAbs.getY(), 
						pathSegCurveToCubicAbs.getX1(), pathSegCurveToCubicAbs.getY1(), pathSegCurveToCubicAbs.getX2(), pathSegCurveToCubicAbs.getY2(), 1);
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_REL:
				SVGPathSegCurveToCubicRel pathSegCurveToCubicRel = (SVGPathSegCurveToCubicRel) segment;
				state.lastControlPoint = new float[] { pathSegCurveToCubicRel.getX() + state.point.getX(), pathSegCurveToCubicRel.getY() + state.point.getY() };
				return BezierCurve.cubicBezierLength(0, 0, pathSegCurveToCubicRel.getX(), pathSegCurveToCubicRel.getY(), 
						pathSegCurveToCubicRel.getX1(), pathSegCurveToCubicRel.getY1(), pathSegCurveToCubicRel.getX2(), pathSegCurveToCubicRel.getY2(), 1);
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_SMOOTH_ABS:
				SVGPathSegCurveToCubicSmoothAbs pathSegCurveToCubicSmoothAbs = (SVGPathSegCurveToCubicSmoothAbs) segment;
				if (state.lastControlPoint == null) {
					state.lastControlPoint = new float[] { state.point.getX(), state.point.getY() };
				}
				controlPoint = SVGMath.reflectPoint(state.lastControlPoint[0], state.lastControlPoint[1], state.point.getX(), state.point.getY());
				state.lastControlPoint = controlPoint;
				return BezierCurve.cubicBezierLength(state.point.getX(), state.point.getY(), pathSegCurveToCubicSmoothAbs.getX(), pathSegCurveToCubicSmoothAbs.getY(), 
						controlPoint[0], controlPoint[1], pathSegCurveToCubicSmoothAbs.getX2(), pathSegCurveToCubicSmoothAbs.getY2(), 1);
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_SMOOTH_REL:
				SVGPathSegCurveToCubicSmoothRel pathSegCurveToCubicSmoothRel = (SVGPathSegCurveToCubicSmoothRel) segment;
				
				if (state.lastControlPoint == null) {
					state.lastControlPoint = new float[] { state.point.getX(), state.point.getY() };
				}
				controlPoint = SVGMath.reflectPoint(state.lastControlPoint[0], state.lastControlPoint[1], state.point.getX(), state.point.getY());
				state.lastControlPoint = controlPoint;
				return BezierCurve.cubicBezierLength(0, 0, pathSegCurveToCubicSmoothRel.getX(), pathSegCurveToCubicSmoothRel.getY(), 
						controlPoint[0], controlPoint[1], pathSegCurveToCubicSmoothRel.getX2(), pathSegCurveToCubicSmoothRel.getY2(), 1);
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_ABS:
				SVGPathSegCurveToQuadraticAbs pathSegCurveToQuadraticAbs = (SVGPathSegCurveToQuadraticAbs) segment;
				state.lastControlPoint = new float[] { pathSegCurveToQuadraticAbs.getX(), pathSegCurveToQuadraticAbs.getY() };
				return BezierCurve.quadraticBezierLength(state.point.getX(), state.point.getY(), pathSegCurveToQuadraticAbs.getX(), pathSegCurveToQuadraticAbs.getY(), 
						pathSegCurveToQuadraticAbs.getX1(), pathSegCurveToQuadraticAbs.getY1(), 1);
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_REL:
				SVGPathSegCurveToQuadraticRel pathSegCurveToQuadraticRel = (SVGPathSegCurveToQuadraticRel) segment;
				state.lastControlPoint = new float[] { pathSegCurveToQuadraticRel.getX() + state.point.getX(), pathSegCurveToQuadraticRel.getY() + state.point.getY() };
				return BezierCurve.quadraticBezierLength(0, 0, pathSegCurveToQuadraticRel.getX(), pathSegCurveToQuadraticRel.getY(), 
						pathSegCurveToQuadraticRel.getX1(), pathSegCurveToQuadraticRel.getY1(), 1);
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
				return BezierCurve.quadraticBezierLength(0, 0, controlPoint[0], controlPoint[1], 
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
//				SVGPathSegMoveToAbs pathSegMoveToAbs = (SVGPathSegMoveToAbs) segment;
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
		float[] controlPoint;
		switch (segment.getPathSegType()) {
			case SVGPathSeg.PATHSEG_ARC_ABS:
				SVGPathSegArcAbs pathSegArcAbs = (SVGPathSegArcAbs) segment;
				float[] arcAbsPoint = Arc.arc(state.point.getX(), state.point.getY(), pathSegArcAbs.getX(), pathSegArcAbs.getY(), 
						pathSegArcAbs.getR1(), pathSegArcAbs.getR2(), pathSegArcAbs.getAngle(), Arc.flag(pathSegArcAbs.getLargeArcFlag()), 
						Arc.flag(pathSegArcAbs.getSweepFlag()), distance / segmentLength);
				state.point.setX(arcAbsPoint[0]);
				state.point.setY(arcAbsPoint[1]);
				break;
			case SVGPathSeg.PATHSEG_ARC_REL:
				SVGPathSegArcRel pathSegArcRel = (SVGPathSegArcRel) segment;
				float[] arcRelPoint = Arc.arc(0, 0, pathSegArcRel.getX(), pathSegArcRel.getY(), 
						pathSegArcRel.getR1(), pathSegArcRel.getR2(), pathSegArcRel.getAngle(), Arc.flag(pathSegArcRel.getLargeArcFlag()), 
						Arc.flag(pathSegArcRel.getSweepFlag()), distance / segmentLength);
				state.point.setX(state.point.getX() + arcRelPoint[0]);
				state.point.setY(state.point.getY() + arcRelPoint[1]);
				break;
			case SVGPathSeg.PATHSEG_CLOSEPATH:
//				SVGPathSegClosePath pathSegClosePath = (SVGPathSegClosePath) segment;
				state.point.setX(state.start.getX());
				state.point.setY(state.start.getY());
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_ABS:
				SVGPathSegCurveToCubicAbs pathSegCurveToCubicAbs = (SVGPathSegCurveToCubicAbs) segment;
				state.point.setX(BezierCurve.cubicBezier(state.point.getX(), pathSegCurveToCubicAbs.getX(), pathSegCurveToCubicAbs.getX1(), pathSegCurveToCubicAbs.getX2(), distance / segmentLength));
				state.point.setY(BezierCurve.cubicBezier(state.point.getY(), pathSegCurveToCubicAbs.getY(), pathSegCurveToCubicAbs.getY1(), pathSegCurveToCubicAbs.getY2(), distance / segmentLength));
				state.lastControlPoint = new float[] { pathSegCurveToCubicAbs.getX1(), pathSegCurveToCubicAbs.getY1() };
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_REL:
				SVGPathSegCurveToCubicRel pathSegCurveToCubicRel = (SVGPathSegCurveToCubicRel) segment;
				state.point.setX(state.point.getX() + BezierCurve.cubicBezier(0, pathSegCurveToCubicRel.getX(), pathSegCurveToCubicRel.getX1(), pathSegCurveToCubicRel.getX2(), distance / segmentLength));
				state.point.setY(state.point.getY() + BezierCurve.cubicBezier(0, pathSegCurveToCubicRel.getY(), pathSegCurveToCubicRel.getY1(), pathSegCurveToCubicRel.getY2(), distance / segmentLength));
				state.lastControlPoint = new float[] { pathSegCurveToCubicRel.getX1() + state.point.getX(), pathSegCurveToCubicRel.getY1() + state.point.getY() };
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_SMOOTH_ABS:
				SVGPathSegCurveToCubicSmoothAbs pathSegCurveToCubicSmoothAbs = (SVGPathSegCurveToCubicSmoothAbs) segment;
				if (state.lastControlPoint == null) {
					state.lastControlPoint = new float[] { state.point.getX(), state.point.getY() };
				}
				controlPoint = SVGMath.reflectPoint(state.lastControlPoint[0], state.lastControlPoint[1], state.point.getX(), state.point.getY());
				state.point.setX(BezierCurve.cubicBezier(state.point.getX(), pathSegCurveToCubicSmoothAbs.getX(), controlPoint[0], pathSegCurveToCubicSmoothAbs.getX2(), distance / segmentLength));
				state.point.setY(BezierCurve.cubicBezier(state.point.getY(), pathSegCurveToCubicSmoothAbs.getY(), controlPoint[1], pathSegCurveToCubicSmoothAbs.getY2(), distance / segmentLength));
				state.lastControlPoint = controlPoint;
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_SMOOTH_REL:
				SVGPathSegCurveToCubicSmoothRel pathSegCurveToCubicSmoothRel = (SVGPathSegCurveToCubicSmoothRel) segment;
				if (state.lastControlPoint == null) {
					state.lastControlPoint = new float[] { state.point.getX(), state.point.getY() };
				}
				controlPoint = SVGMath.reflectPoint(state.lastControlPoint[0], state.lastControlPoint[1], state.point.getX(), state.point.getY());
				state.point.setX(state.point.getX() + BezierCurve.cubicBezier(0, pathSegCurveToCubicSmoothRel.getX(), controlPoint[0], pathSegCurveToCubicSmoothRel.getX2(), distance / segmentLength));
				state.point.setY(state.point.getY() + BezierCurve.cubicBezier(0, pathSegCurveToCubicSmoothRel.getY(), controlPoint[1], pathSegCurveToCubicSmoothRel.getY2(), distance / segmentLength));
				state.lastControlPoint = controlPoint;
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_ABS:
				SVGPathSegCurveToQuadraticAbs pathSegCurveToQuadraticAbs = (SVGPathSegCurveToQuadraticAbs) segment;
				state.point.setX(BezierCurve.quadraticBezier(state.point.getX(), pathSegCurveToQuadraticAbs.getX(), pathSegCurveToQuadraticAbs.getX1(), distance / segmentLength));
				state.point.setY(BezierCurve.quadraticBezier(state.point.getY(), pathSegCurveToQuadraticAbs.getY(), pathSegCurveToQuadraticAbs.getY1(), distance / segmentLength));
				state.lastControlPoint = new float[] { pathSegCurveToQuadraticAbs.getX(), pathSegCurveToQuadraticAbs.getY() };
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_REL:
				SVGPathSegCurveToQuadraticRel pathSegCurveToQuadraticRel = (SVGPathSegCurveToQuadraticRel) segment;
				state.point.setX(state.point.getX() + BezierCurve.quadraticBezier(0, pathSegCurveToQuadraticRel.getX(), pathSegCurveToQuadraticRel.getX1(), distance / segmentLength));
				state.point.setY(state.point.getY() + BezierCurve.quadraticBezier(0, pathSegCurveToQuadraticRel.getY(), pathSegCurveToQuadraticRel.getY1(), distance / segmentLength));
				state.lastControlPoint = new float[] { pathSegCurveToQuadraticRel.getX() + state.point.getX(), pathSegCurveToQuadraticRel.getY() + state.point.getY() };
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS:
				SVGPathSegCurveToQuadraticSmoothAbs pathSegCurveToQuadraticSmoothAbs = (SVGPathSegCurveToQuadraticSmoothAbs) segment;
				if (state.lastControlPoint == null) {
					state.lastControlPoint = new float[] { state.point.getX(), state.point.getY() };
				}
				controlPoint = SVGMath.reflectPoint(state.lastControlPoint[0], state.lastControlPoint[1], state.point.getX(), state.point.getY());
				state.point.setX(BezierCurve.quadraticBezier(state.point.getX(), controlPoint[0], pathSegCurveToQuadraticSmoothAbs.getX(), distance / segmentLength));
				state.point.setY(BezierCurve.quadraticBezier(state.point.getY(), controlPoint[1], pathSegCurveToQuadraticSmoothAbs.getY(), distance / segmentLength));
				state.lastControlPoint = controlPoint;
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL:
				SVGPathSegCurveToQuadraticSmoothRel pathSegCurveToQuadraticSmoothRel = (SVGPathSegCurveToQuadraticSmoothRel) segment;
				if (state.lastControlPoint == null) {
					state.lastControlPoint = new float[] { state.point.getX(), state.point.getY() };
				}
				controlPoint = SVGMath.reflectPoint(state.lastControlPoint[0], state.lastControlPoint[1], state.point.getX(), state.point.getY());
				state.point.setX(state.point.getX() + BezierCurve.quadraticBezier(0, controlPoint[0], pathSegCurveToQuadraticSmoothRel.getX(), distance / segmentLength));
				state.point.setY(state.point.getY() + BezierCurve.quadraticBezier(0, controlPoint[1], pathSegCurveToQuadraticSmoothRel.getY(), distance / segmentLength));
				state.lastControlPoint = controlPoint;
				break;
			case SVGPathSeg.PATHSEG_LINETO_ABS:
				SVGPathSegLineToAbs pathSegLineToAbs = (SVGPathSegLineToAbs) segment;
				state.point.setX(lerp(state.point.getX(), pathSegLineToAbs.getX(), distance / segmentLength));
				state.point.setY(lerp(state.point.getY(), pathSegLineToAbs.getY(), distance / segmentLength));
				break;
			case SVGPathSeg.PATHSEG_LINETO_HORIZONTAL_ABS:
				SVGPathSegLineToHorizontalAbs pathSegLineToHorizontalAbs = (SVGPathSegLineToHorizontalAbs) segment;
				state.point.setX(lerp(state.point.getX(), pathSegLineToHorizontalAbs.getX(), distance / segmentLength));
				break;
			case SVGPathSeg.PATHSEG_LINETO_VERTICAL_ABS:
				SVGPathSegLineToVerticalAbs pathSegLineToVerticalAbs = (SVGPathSegLineToVerticalAbs) segment;
				state.point.setY(lerp(state.point.getY(), pathSegLineToVerticalAbs.getY(), distance / segmentLength));
				break;
			case SVGPathSeg.PATHSEG_LINETO_REL:
				SVGPathSegLineToRel pathSegLineToRel = (SVGPathSegLineToRel) segment;
				state.point.setX(pathSegLineToRel.getX() * distance / segmentLength + state.point.getX());
				state.point.setY(pathSegLineToRel.getY() * distance / segmentLength + state.point.getY());
				break;
			case SVGPathSeg.PATHSEG_LINETO_HORIZONTAL_REL:
				SVGPathSegLineToHorizontalRel pathSegLineToHorizontalRel = (SVGPathSegLineToHorizontalRel) segment;
				state.point.setX(lerp(state.point.getX(), state.point.getX() + pathSegLineToHorizontalRel.getX(), distance / segmentLength));
				break;
			case SVGPathSeg.PATHSEG_LINETO_VERTICAL_REL:
				SVGPathSegLineToVerticalRel pathSegLineToVerticalRel = (SVGPathSegLineToVerticalRel) segment;
				state.point.setY(lerp(state.point.getY(), state.point.getY() + pathSegLineToVerticalRel.getY(), distance / segmentLength));
				break;
			case SVGPathSeg.PATHSEG_MOVETO_ABS:
				SVGPathSegMoveToAbs pathSegMoveToAbs = (SVGPathSegMoveToAbs) segment;
				state.point.setX(lerp(state.point.getX(), pathSegMoveToAbs.getX(), distance / segmentLength));
				state.point.setY(lerp(state.point.getY(), pathSegMoveToAbs.getY(), distance / segmentLength));
				break;
			case SVGPathSeg.PATHSEG_MOVETO_REL:
				SVGPathSegMoveToRel pathSegMoveToRel = (SVGPathSegMoveToRel) segment;
				state.point.setX(pathSegMoveToRel.getX() * distance / segmentLength + state.point.getX());
				state.point.setY(pathSegMoveToRel.getY() * distance / segmentLength + state.point.getY());
				break;
			default:
				throw new SVGException(SVGException.SVG_WRONG_TYPE_ERR, "Invalid path segment type: " + segment);
		}
	}
	
	public static float lerp(float a, float b, float t) {
		return t * (b - a) + a;
	}

}
