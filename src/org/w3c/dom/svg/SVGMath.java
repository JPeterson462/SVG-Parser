package org.w3c.dom.svg;

public class SVGMath {
	
	public static final float PI = (float) Math.PI;

	public static float sqrt(float value) {
		return (float) Math.sqrt(value);
	}
	
	public static float asinh(float value) {
		return (float) Math.log(value + sqrt(value * value + 1.0f));
	}
	
	public static float acos(float value) {
		return (float) Math.acos(value);
	}
	
	public static float pow(float base, float power) {
		return (float) Math.pow(base, power);
	}
	
	public static float[] reflectPoint(float x1, float y1, float x, float y) {
		float dx  = x1 - x, dy = y1 - y;
		return new float[] { x - dx, y - dy };
	}
	
	public static float sin(float theta) {
		return (float) Math.sin(theta);
	}
	
	public static float cos(float theta) {
		return (float) Math.cos(theta);
	}
	
	public static float clamp(float value, float min, float max) {
		if (value < min)
			return min;
		if (value > max)
			return max;
		return value;
	}
	
	public static float toDegrees(float radians) {
		return (float) Math.toDegrees(radians);
	}
	
	public static float toRadians(float degrees) {
		return (float) Math.toRadians(degrees);
	}

	public static float atan2(float y, float x) {
		return (float) Math.atan2(y, x);
	}

}
