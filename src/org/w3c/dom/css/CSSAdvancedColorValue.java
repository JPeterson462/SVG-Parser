package org.w3c.dom.css;

import java.util.ArrayList;

public interface CSSAdvancedColorValue extends CSSValue {

	public int getRed();
	
	public int getGreen();
	
	public int getBlue();
	
	public String getColorProfile();
	
	public ArrayList<Float> getICCNumbers();
	
	public boolean isCurrentColor();
	
}
