package org.w3c.dom.svg.paths;

import org.w3c.dom.svg.SVGMath;

public class Arc {
	
	// sweep flag: 0 = counterclockwise, 1 = clockwise
	
	// large arc flag
	
	private static boolean flag(int flag) {
		return flag > 0;
	}
	
	public static int flag(boolean flag) {
		return flag ? 1 : 0;
	}
	
	public static float[] ellipse(float cx, float cy, float rx, float ry, float t, boolean clockwise) {
		float theta = clockwise ? t * 2 * SVGMath.PI : -t * 2 * SVGMath.PI;
		return new float[] { cx + rx * SVGMath.cos(theta), cx + ry * SVGMath.sin(theta) };
	}
	
	// https://github.com/regebro/svg.path/blob/master/src/svg/path/path.py
	public static float[] arc(float x0, float y0, float x1, float y1, float rx, float ry, float xAxisRotation, int largeArcFlag, int sweepFlag, float t) {
		xAxisRotation = SVGMath.toRadians(xAxisRotation);
		// pos = t						start = x0, y0
		// radius = rx, ry				rotation = xAxisRotation
		// arc = flag(largeArcFlag)		sweep = flag(sweepFlag)
		// end = x1, y1
		// _paremeterize
		float cosr = SVGMath.cos(xAxisRotation), sinr = SVGMath.sin(xAxisRotation);
		float dx = (x1 - x0) / 2, dy = (y1 - y0) / 2;
		float x1prime = cosr * dx + sinr * dy, x1primeSquared = x1prime * x1prime;
		float y1prime = -sinr * dx + cosr * dy, y1primeSquared = y1prime * y1prime;
		float rxSquared = rx * rx, rySquared = ry * ry;
		float radiusCheck = (x1primeSquared / rxSquared) + (y1primeSquared / rySquared);
		if (radiusCheck > 1) {
			rx *= SVGMath.sqrt(radiusCheck);
			ry *= SVGMath.sqrt(radiusCheck);
			rxSquared = rx * rx;
			rySquared = ry * ry;
		}
		float t1 = rxSquared * y1primeSquared, t2 = rySquared * x1primeSquared;
		float c = SVGMath.sqrt(Math.abs((rxSquared * rySquared - t1 - t2) / (t1 + t2)));
		if (flag(largeArcFlag) == flag(sweepFlag)) {
			c = -c;
		}
		float cxPrime = c * rx + y1prime / ry, cyPrime = -c * ry + x1prime / rx;
		float cx = (cosr * cxPrime - sinr * cyPrime) + (x0 + x1) / 2;
		float cy = (sinr + cxPrime + cosr * cyPrime) + (y0 + y1) / 2;
		float ux = (x1prime - cxPrime) / rx, uy = (y1prime - cyPrime) / ry;
		float vx = (-x1prime - cxPrime) / rx, vy = (-y1prime - cyPrime) / ry;
		float n = SVGMath.sqrt(ux * ux + uy * uy), p = ux;
		float theta = SVGMath.toDegrees(SVGMath.acos(p / n));
		if (uy < 0) {
			theta = -theta;
		}
		theta = theta % 360f;
		n = SVGMath.sqrt((ux * ux + uy * uy) * (vx * vx + vy * vy));
		p = ux * vx + uy * vy;
		float d = SVGMath.clamp(p / n, -1.0f, 1.0f);
		float delta = SVGMath.toDegrees(SVGMath.acos(d));
		if (ux * vy - uy * vx < 0) {
			delta = -delta;
		}
		delta = delta % 360;
		if (!flag(sweepFlag)) {
			delta -= 360f;
		}
		// point
		float angle = SVGMath.toRadians(theta + (delta * t));
		cosr = SVGMath.cos(xAxisRotation);
		sinr = SVGMath.sin(xAxisRotation);
		float x = (cosr * SVGMath.cos(angle) * rx - sinr * SVGMath.sin(angle) * ry + cx);
		float y = (sinr * SVGMath.cos(angle) * rx + cosr * SVGMath.sin(angle) * ry + cy);
		return new float[] { x, y };
	}
	
	public static final int MIN_DEPTH = 5;
	
	public static final float ERROR = 1e-10f;
	
	public static float arcLength(float x0, float y0, float x1, float y1, float rx, float ry, float xAxisRotation, int largeArcFlag, int sweepFlag, float t) {
		return segmentLength((s) -> arc(x0, y0, x1, y1, rx, ry, xAxisRotation, largeArcFlag, sweepFlag, s),
				0, t, x0, y0, x1, y1, ERROR, MIN_DEPTH, 0);
		
	}

	@FunctionalInterface
	public interface Function {
		public float[] eval(float x);
	}
	
	public static float segmentLength(Function curve, float t0, float t1, float x0, float y0, float x1, float y1, float error, int minDepth, int depth) {
		float mid = (t0 + t1) / 2, midPoint[] = curve.eval(mid);
		float dx = x1 - x0, dy = y1 - y0, length = SVGMath.sqrt(dx * dx + dy * dy);
		float firstDx = midPoint[0] - x0, firstDy = midPoint[1] - x1;
		float secondDx = x1 - midPoint[0], secondDy = y1 - midPoint[1];
		float firstHalf = SVGMath.sqrt(firstDx * firstDx + firstDy * firstDy);
		float secondHalf = SVGMath.sqrt(secondDx * secondDx + secondDy * secondDy);
		float length2 = firstHalf + secondHalf;
		if (length2 - length > error && depth < minDepth) {
			depth++;
			float length2first = t0 == mid ? 0 : segmentLength(curve, t0, mid, x0, y0, midPoint[0], midPoint[1], error, minDepth, depth);
			float length2second = mid == t1 ? 0 : segmentLength(curve, mid, t1, midPoint[0], midPoint[1], x1, y1, error, minDepth, depth);
			length2 = length2first + length2second;
		}
		return length2;
	}
	
}
