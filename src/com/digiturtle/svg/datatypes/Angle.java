package com.digiturtle.svg.datatypes;

public class Angle {
	
	private static final float RADIANS_TO_DEGREES = 180f / (2 * (float) Math.PI);
	
	private static final float DEGREES_TO_RADIANS = 1f / RADIANS_TO_DEGREES;
	
	private static final float DEGREES_TO_GRADIANS = 0.9f;
	
	private static final float GRADIANS_TO_DEGREES = 1f / DEGREES_TO_RADIANS;
	
	private static final float RADIANS_TO_GRADIANS = RADIANS_TO_DEGREES * DEGREES_TO_GRADIANS;
	
	private static final float GRADIANS_TO_RADIANS = 1f / RADIANS_TO_GRADIANS;
	
	private float valueRadians, valueDegrees, valueGradians;

	public float getValueRadians() {
		return valueRadians;
	}

	public void setValueRadians(float valueRadians) {
		this.valueRadians = valueRadians;
		valueDegrees = valueRadians * RADIANS_TO_DEGREES;
		valueGradians = valueRadians * RADIANS_TO_GRADIANS;
	}

	public float getValueDegrees() {
		return valueDegrees;
	}

	public void setValueDegrees(float valueDegrees) {
		valueRadians = valueDegrees * DEGREES_TO_RADIANS;
		this.valueDegrees = valueDegrees;
		valueGradians = valueDegrees * DEGREES_TO_GRADIANS;
	}

	public float getValueGradians() {
		return valueGradians;
	}

	public void setValueGradians(float valueGradians) {
		valueRadians = valueGradians * GRADIANS_TO_RADIANS;
		valueDegrees = valueGradians * GRADIANS_TO_DEGREES;
		this.valueGradians = valueGradians;
	}
	

}
