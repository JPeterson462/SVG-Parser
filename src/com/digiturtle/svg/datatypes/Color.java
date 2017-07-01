package com.digiturtle.svg.datatypes;

public class Color {
	
	private int red, green, blue;
	
	public void set(Color color) {
		setRed(color.getRed());
		setGreen(color.getGreen());
		setBlue(color.getBlue());
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

}
