package org.w3c.dom.svg.animation;

public interface ElementTimeControl {
	
	public void beginElement();
	
	public void beginElementAt(float offset);
	
	public void endElement();
	
	public void endElementAt(float offset);

}
