package org.w3c.dom.svg.paths;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.PathIterator;

// https://github.com/apache/batik/blob/trunk/batik-svg-dom/src/main/java/org/apache/batik/dom/svg/AbstractSVGNormPathSegList.java
public class ArcNormalizer {

	public static Arc2D computeArc(double x0, double y0,
			double rx, double ry,
			double angle,
			boolean largeArcFlag,
			boolean sweepFlag,
			double x, double y) {
		//
		// Elliptical arc implementation based on the SVG specification notes
		//

		// Compute the half distance between the current and the final point
		double dx2 = (x0 - x) / 2.0;
		double dy2 = (y0 - y) / 2.0;
		// Convert angle from degrees to radians
		angle = Math.toRadians(angle % 360.0);
		double cosAngle = Math.cos(angle);
		double sinAngle = Math.sin(angle);

		//
		// Step 1 : Compute (x1, y1)
		//
		double x1 = (cosAngle * dx2 + sinAngle * dy2);
		double y1 = (-sinAngle * dx2 + cosAngle * dy2);
		// Ensure radii are large enough
		rx = Math.abs(rx);
		ry = Math.abs(ry);
		double Prx = rx * rx;
		double Pry = ry * ry;
		double Px1 = x1 * x1;
		double Py1 = y1 * y1;
		// check that radii are large enough
		double radiiCheck = Px1/Prx + Py1/Pry;
		if (radiiCheck > 0.99999) {  // don't cut it too close
			double radiiScale = Math.sqrt(radiiCheck) * 1.00001;
			rx = radiiScale * rx;
			ry = radiiScale * ry;
			Prx = rx * rx;
			Pry = ry * ry;
		}

		//
		// Step 2 : Compute (cx1, cy1)
		//
		double sign = (largeArcFlag == sweepFlag) ? -1 : 1;
		double sq = ((Prx*Pry)-(Prx*Py1)-(Pry*Px1)) / ((Prx*Py1)+(Pry*Px1));
		sq = (sq < 0) ? 0 : sq;
		double coef = (sign * Math.sqrt(sq));
		double cx1 = coef * ((rx * y1) / ry);
		double cy1 = coef * -((ry * x1) / rx);

		//
		// Step 3 : Compute (cx, cy) from (cx1, cy1)
		//
		double sx2 = (x0 + x) / 2.0;
		double sy2 = (y0 + y) / 2.0;
		double cx = sx2 + (cosAngle * cx1 - sinAngle * cy1);
		double cy = sy2 + (sinAngle * cx1 + cosAngle * cy1);

		//
		// Step 4 : Compute the angleStart (angle1) and the angleExtent (dangle)
		//
		double ux = (x1 - cx1) / rx;
		double uy = (y1 - cy1) / ry;
		double vx = (-x1 - cx1) / rx;
		double vy = (-y1 - cy1) / ry;
		double p, n;
		// Compute the angle start
		n = Math.sqrt((ux * ux) + (uy * uy));
		p = ux; // (1 * ux) + (0 * uy)
		sign = (uy < 0) ? -1.0 : 1.0;
		double angleStart = Math.toDegrees(sign * Math.acos(p / n));

		// Compute the angle extent
		n = Math.sqrt((ux * ux + uy * uy) * (vx * vx + vy * vy));
		p = ux * vx + uy * vy;
		sign = (ux * vy - uy * vx < 0) ? -1.0 : 1.0;
		double angleExtent = Math.toDegrees(sign * Math.acos(p / n));
		if(!sweepFlag && angleExtent > 0) {
			angleExtent -= 360f;
		} else if (sweepFlag && angleExtent < 0) {
			angleExtent += 360f;
		}
		angleExtent %= 360f;
		angleStart %= 360f;

		//
		// We can now build the resulting Arc2D in double precision
		//
		Arc2D.Double arc = new Arc2D.Double();
		arc.x = cx - rx;
		arc.y = cy - ry;
		arc.width = rx * 2.0;
		arc.height = ry * 2.0;
		arc.start = -angleStart;
		arc.extent = -angleExtent;

		return arc;
	}
	
	@FunctionalInterface
	public interface CurveBuilder {
		public void curveToCubicAbs(float x1, float y1, float x2, float y2, float x, float y);
	}
	
	public static void normalizeArc(CurveBuilder builder, float x0, float y0, float rx, float ry, float xAxisRotation, boolean largeArcFlag, boolean sweepFlag, float x, float y) {
		Arc2D arc = computeArc(x0, y0, rx, ry, xAxisRotation, largeArcFlag, sweepFlag, x, y);
		if (arc != null) {
			AffineTransform t = AffineTransform.getRotateInstance(Math.toRadians(xAxisRotation), arc.getCenterX(), arc.getCenterY());
			Shape s = t.createTransformedShape(arc);
			PathIterator pi = s.getPathIterator(new AffineTransform());
			float[] d = { 0, 0, 0, 0, 0, 0 };
			int i = -1;
			while (!pi.isDone()) {
				i = pi.currentSegment(d);
				switch (i) {
					case PathIterator.SEG_CUBICTO:
						builder.curveToCubicAbs(d[0], d[1], d[2], d[3], d[4], d[5]);
						break;
				}
				pi.next();
			}
		}
	}

}
