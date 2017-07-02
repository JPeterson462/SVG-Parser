package com.digiturtle.svg.datatypes;

public class Color {
	
	private int red, green, blue;
	
	public Color(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public Color(Color oldColor) {
		red = oldColor.getRed();
		green = oldColor.getGreen();
		blue = oldColor.getBlue();
	}
	
	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}

}
