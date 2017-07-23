package org.w3c.dom.svg.paths;

import org.w3c.dom.svg.SVGException;
import org.w3c.dom.svg.SVGPoint;

public class SVGPathMath {
	
	private static float sqrt(float value) {
		return (float) Math.sqrt(value);
	}
	
	public static float getSegmentLength(SVGPathSeg segment, SVGPoint point) {
		switch (segment.getPathSegType()) {
			case SVGPathSeg.PATHSEG_ARC_ABS:
				SVGPathSegArcAbs pathSegArcAbs = (SVGPathSegArcAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_ARC_REL:
				SVGPathSegArcRel pathSegArcRel = (SVGPathSegArcRel) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CLOSEPATH:
				SVGPathSegClosePath pathSegClosePath = (SVGPathSegClosePath) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_ABS:
				SVGPathSegCurveToCubicAbs pathSegCurveToCubicAbs = (SVGPathSegCurveToCubicAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_REL:
				SVGPathSegCurveToCubicRel pathSegCurveToCubicRel = (SVGPathSegCurveToCubicRel) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_SMOOTH_ABS:
				SVGPathSegCurveToCubicSmoothAbs pathSegCurveToCubicSmoothAbs = (SVGPathSegCurveToCubicSmoothAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_SMOOTH_REL:
				SVGPathSegCurveToCubicSmoothRel pathSegCurveToCubicSmoothRel = (SVGPathSegCurveToCubicSmoothRel) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_ABS:
				SVGPathSegCurveToQuadraticAbs pathSegCurveToQuadraticAbs = (SVGPathSegCurveToQuadraticAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_REL:
				SVGPathSegCurveToQuadraticRel pathSegCurveToQuadraticRel = (SVGPathSegCurveToQuadraticRel) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS:
				SVGPathSegCurveToQuadraticSmoothAbs pathSegCurveToQuadraticSmoothAbs = (SVGPathSegCurveToQuadraticSmoothAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL:
				SVGPathSegCurveToQuadraticSmoothRel pathSegCurveToQuadraticSmoothRel = (SVGPathSegCurveToQuadraticSmoothRel) segment;
				
				break;
			case SVGPathSeg.PATHSEG_LINETO_ABS:
				SVGPathSegLineToAbs pathSegLineToAbs = (SVGPathSegLineToAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_LINETO_HORIZONTAL_ABS:
				SVGPathSegLineToHorizontalAbs pathSegLineToHorizontalAbs = (SVGPathSegLineToHorizontalAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_LINETO_VERTICAL_ABS:
				SVGPathSegLineToVerticalAbs pathSegLineToVerticalAbs = (SVGPathSegLineToVerticalAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_LINETO_REL:
				SVGPathSegLineToRel pathSegLineToRel = (SVGPathSegLineToRel) segment;
				
				break;
			case SVGPathSeg.PATHSEG_LINETO_HORIZONTAL_REL:
				SVGPathSegLineToHorizontalRel pathSegLineToHorizontalRel = (SVGPathSegLineToHorizontalRel) segment;
				return pathSegLineToHorizontalRel.getX();
			case SVGPathSeg.PATHSEG_LINETO_VERTICAL_REL:
				SVGPathSegLineToVerticalRel pathSegLineToVerticalRel = (SVGPathSegLineToVerticalRel) segment;
				return pathSegLineToVerticalRel.getY();
			case SVGPathSeg.PATHSEG_MOVETO_ABS:
				SVGPathSegMoveToAbs pathSegMoveToAbs = (SVGPathSegMoveToAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_MOVETO_REL:
				SVGPathSegMoveToRel pathSegMoveToRel = (SVGPathSegMoveToRel) segment;
				return sqrt(pathSegMoveToRel.getX() * pathSegMoveToRel.getX() + pathSegMoveToRel.getY() * pathSegMoveToRel.getY());
			default:
				throw new SVGException(SVGException.SVG_WRONG_TYPE_ERR, "Invalid path segment type: " + segment);
		}
		//TODO
		return 0;
	}
	
	public static void transformPoint(SVGPathSeg segment, SVGPoint point) {
		float segmentLength = getSegmentLength(segment, point);
		transformPoint(segment, point, segmentLength, segmentLength);
	}
	
	public static void transformPoint(SVGPathSeg segment, SVGPoint point, float distance, float segmentLength) {
		switch (segment.getPathSegType()) {
			case SVGPathSeg.PATHSEG_ARC_ABS:
				SVGPathSegArcAbs pathSegArcAbs = (SVGPathSegArcAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_ARC_REL:
				SVGPathSegArcRel pathSegArcRel = (SVGPathSegArcRel) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CLOSEPATH:
				SVGPathSegClosePath pathSegClosePath = (SVGPathSegClosePath) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_ABS:
				SVGPathSegCurveToCubicAbs pathSegCurveToCubicAbs = (SVGPathSegCurveToCubicAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_REL:
				SVGPathSegCurveToCubicRel pathSegCurveToCubicRel = (SVGPathSegCurveToCubicRel) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_SMOOTH_ABS:
				SVGPathSegCurveToCubicSmoothAbs pathSegCurveToCubicSmoothAbs = (SVGPathSegCurveToCubicSmoothAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_CUBIC_SMOOTH_REL:
				SVGPathSegCurveToCubicSmoothRel pathSegCurveToCubicSmoothRel = (SVGPathSegCurveToCubicSmoothRel) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_ABS:
				SVGPathSegCurveToQuadraticAbs pathSegCurveToQuadraticAbs = (SVGPathSegCurveToQuadraticAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_REL:
				SVGPathSegCurveToQuadraticRel pathSegCurveToQuadraticRel = (SVGPathSegCurveToQuadraticRel) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS:
				SVGPathSegCurveToQuadraticSmoothAbs pathSegCurveToQuadraticSmoothAbs = (SVGPathSegCurveToQuadraticSmoothAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL:
				SVGPathSegCurveToQuadraticSmoothRel pathSegCurveToQuadraticSmoothRel = (SVGPathSegCurveToQuadraticSmoothRel) segment;
				
				break;
			case SVGPathSeg.PATHSEG_LINETO_ABS:
				SVGPathSegLineToAbs pathSegLineToAbs = (SVGPathSegLineToAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_LINETO_HORIZONTAL_ABS:
				SVGPathSegLineToHorizontalAbs pathSegLineToHorizontalAbs = (SVGPathSegLineToHorizontalAbs) segment;
				break;
			case SVGPathSeg.PATHSEG_LINETO_VERTICAL_ABS:
				SVGPathSegLineToVerticalAbs pathSegLineToVerticalAbs = (SVGPathSegLineToVerticalAbs) segment;
				break;
			case SVGPathSeg.PATHSEG_LINETO_REL:
				SVGPathSegLineToRel pathSegLineToRel = (SVGPathSegLineToRel) segment;
				point.setX(pathSegLineToRel.getX() * distance / segmentLength + point.getX());
				point.setY(pathSegLineToRel.getY() * distance / segmentLength + point.getY());
				break;
			case SVGPathSeg.PATHSEG_LINETO_HORIZONTAL_REL:
				SVGPathSegLineToHorizontalRel pathSegLineToHorizontalRel = (SVGPathSegLineToHorizontalRel) segment;
				point.setX(pathSegLineToHorizontalRel.getX() * distance / segmentLength + point.getX());
				break;
			case SVGPathSeg.PATHSEG_LINETO_VERTICAL_REL:
				SVGPathSegLineToVerticalRel pathSegLineToVerticalRel = (SVGPathSegLineToVerticalRel) segment;
				point.setY(pathSegLineToVerticalRel.getY() * distance / segmentLength + point.getY());
				break;
			case SVGPathSeg.PATHSEG_MOVETO_ABS:
				SVGPathSegMoveToAbs pathSegMoveToAbs = (SVGPathSegMoveToAbs) segment;
				
				break;
			case SVGPathSeg.PATHSEG_MOVETO_REL:
				SVGPathSegMoveToRel pathSegMoveToRel = (SVGPathSegMoveToRel) segment;
				point.setX(pathSegMoveToRel.getX() * distance / segmentLength + point.getX());
				point.setY(pathSegMoveToRel.getY() * distance / segmentLength + point.getY());
				break;
			default:
				throw new SVGException(SVGException.SVG_WRONG_TYPE_ERR, "Invalid path segment type: " + segment);
		}
		//TODO
	}

}
