package org.w3c.dom.css;

public interface CSSEnumListValue extends CSSValue {

	public boolean isDefaultValue();
	
	public String getDefaultValue();
	
	public String[] getListValues();
	
	public String[] getPossibleDefaultValues();
	
	public String[] getPossibleListValues();
	
}
