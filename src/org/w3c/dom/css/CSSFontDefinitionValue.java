package org.w3c.dom.css;

public interface CSSFontDefinitionValue extends CSSValue {
	
	public boolean isDefinition();

	public boolean isCaption();

	public boolean isIcon();

	public boolean isMenu();

	public boolean isMessageBox();

	public boolean isSmallCaption();

	public boolean isStatusBar();

	public boolean isInherit();
	
	public String getFontStyle();
	
	public String getFontVariant();
	
	public String getFontWeight();
	
	public CSSSizeValue getFontSize();
	
	public CSSLengthValue getLineHeight();
	
	public CSSStringListValue getFontFamily();

}
