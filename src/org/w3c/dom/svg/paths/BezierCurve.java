package org.w3c.dom.svg.paths;

import org.w3c.dom.svg.SVGMath;

public class BezierCurve {
	
	// Quadratic Bezier Curve
	// B(t) = (1-t)^2 * P0 + 2(1-t)t * P1 + t^2 * P2, 0 <= t <= 1
	// B'(t) = 2(1-t)(P1 - P0) + 2t(P2 - P1)
	// B''(t) = 2(P2 - 2 * P1 + P0)
	
	public static float quadraticBezier(float p0, float p1, float p2, float t) {
		return (1 - t) * (1 - t) * p0 + 2 * (1 - t) * t * p1 + t * t * p2; 
	}
	
	// https://math.stackexchange.com/questions/12186/arc-length-of-b%C3%A9zier-curves
	public static float quadraticBezierLength(float x1, float y1, float x2, float y2, float x3, float y3, float t) {
		float dx1 = x2 - x1, dx2 = x3 - x2, dy1 = y2 - y1, dy2 = y3 - y2;
		float c = dx1 * dx1 + dy1 * dy1;
		float b = dx1 * (dx2 - dx1) + dy1 * (dy2 - dy1);
		float a = (dx2 - dx1) * (dx2 - dx1) + (dy2 - dy1) * (dy2 - dy1);
		float term0 = (t + b / a) * SVGMath.sqrt(c + 2 * b * t + a * t * t);
		float term1 = ((a * c - b * b) / (SVGMath.pow(a, 1.5f))) * SVGMath.asinh((a * t + b) / SVGMath.sqrt(a * c - b * b));
		return term0 + term1;
	}
	
	// Cubic Bezier Curve
	// B(t) = ((1-t)^3) * P0 + (3(1-t)^2(t)) * P1 + (3(1-t)t^2) * P2 + (t^3) * P3, 0 <= t <= 1
	// B'(t) = 3(1-t)^2(P1 - P0) + 6(1-t)t(P2 - P1) + 3t^2(P3 - P2)
	// B''(t) = 6(1-t)(P2 + 2 * P1 + P0) + 6t(P3 - 2 * P2 + P1)
	
	public static float cubicBezier(float p0, float p1, float p2, float p3, float t) {
		return (1 - t) * (1 - t) * (1 - t) * p0 + 3 * (1 - t) * (1 - t) * t * p1 + 3 * (1 - t) * t * t * p2 + t * t * t * p3;
	}
	
}
