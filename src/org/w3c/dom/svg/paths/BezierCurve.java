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
	
//	private static final float TOLERANCE = 0.0000001f;

	private static float simpson(Function f, float a, float b, int nLimit, final float TOLERANCE) {
		int n = 1;
		float multiplier = (b - a) / 6f;
		float endsum = f.eval(a) + f.eval(b);
		float interval = (b - a) / 2f;
		float aSum = 0, bSum = f.eval(a + interval);
		float est1 = multiplier * (endsum + 2 * aSum + 4 * bSum);
		float est0 = 2 * est1;
		while (n < nLimit && Math.abs(est1) > 0 && Math.abs((est1 - est0) / est1) > TOLERANCE) {
			n *= 2;
			multiplier /= 2;
			interval /= 2;
			aSum += bSum;
			bSum = 0;
			est0 = est1;
			float intervalDiv2n = interval / (2f * n);
			for (int i = 1; i < 2 * n; i += 2) {
				bSum += f.eval(a + i * intervalDiv2n);
			}
			est1 = multiplier * (endsum + 2 * aSum + 4 * bSum);
		}
		return est1;
	}
	
	@FunctionalInterface
	private interface Function {
		public float eval(float x);
	}
	
	// http://steve.hollasch.net/cgindex/curves/cbezarclen.html
	public static float cubicBezierLength(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, float u) {
		float k1_x = -x1 + 3 * (x2 - x3) + x4, k1_y = -y1 + 3 * (y2 - y3) + y4;
		float k2_x = 3 * (x1 + x3) - 6 * x2, k2_y = 3 * (y1 + y3) - 6 * y2;
		float k3_x = 3 * (x2 - x1), k3_y = 3 * (y2 - y1);
//		float k4_x = x1, k4_y = y1;
		float q1 = 9f * (SVGMath.sqrt(k1_x) + SVGMath.sqrt(k1_y));
		float q2 = 12f * (k1_x * k2_x + k1_y * k2_y);
		float q3 = 3f * (k1_x * k3_x + k1_y * k3_y) + 4f * (SVGMath.sqrt(k2_x) + SVGMath.sqrt(k2_y));
		float q4 = 4f * (k2_x * k3_x + k2_y * k3_y);
		float q5 = SVGMath.sqrt(k3_x) + SVGMath.sqrt(k3_y);
		Function balf = (t) -> SVGMath.sqrt(q5 + t * (q4 + t * (q3 + t * (q2 + t * q1))));
		return simpson(balf, 0, u, 1024, 0.001f);
	}
	
}
