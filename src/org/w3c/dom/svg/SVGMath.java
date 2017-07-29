package org.w3c.dom.svg;

public class SVGMath {

	public static float sqrt(float value) {
		return (float) Math.sqrt(value);
	}
	
	public static float asinh(float value) {
		return (float) Math.log(value + sqrt(value * value + 1.0f));
	}
	
	public static float pow(float base, float power) {
		return (float) Math.pow(base, power);
	}
	
	public static float[] reflectPoint(float x1, float y1, float x, float y) {
		float dx  = x1 - x, dy = y1 - y;
		return new float[] { x - dx, y - dy };
	}

}
