package org.w3c.dom.svg.fonts;

import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGEnumerationList;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFontFaceElement extends SVGElement {
	
	public static final short FONTSTYLE_ALL = 0;//default
	public static final short FONTSTYLE_NORMAL = 1;
	public static final short FONTSTYLE_ITALIC = 2;
	public static final short FONTSTYLE_OBLIQUE = 3;
	
	public static final short FONTVARIANT_NORMAL = 0;//default
	public static final short FONTVARIANT_SMALLCAPS = 1;
	
	public static final short FONTWEIGHT_ALL = 0;//default
	public static final short FONTWEIGHT_NORMAL = 1;
	public static final short FONTWEIGHT_BOLD = 2;
	public static final short FONTWEIGHT_100 = 3;
	public static final short FONTWEIGHT_200 = 4;
	public static final short FONTWEIGHT_300 = 5;
	public static final short FONTWEIGHT_400 = 6;
	public static final short FONTWEIGHT_500 = 7;
	public static final short FONTWEIGHT_600 = 8;
	public static final short FONTWEIGHT_700 = 9;
	public static final short FONTWEIGHT_800 = 10;
	public static final short FONTWEIGHT_900 = 11;
	
	public static final short FONTSTRETCH_ALL = 0;
	public static final short FONTSTRETCH_NORMAL = 1;//default
	public static final short FONTSTRETCH_ULTRACONDENSED = 2;
	public static final short FONTSTRETCH_EXTRACONDENSED = 3;
	public static final short FONTSTRETCH_CONDENSED = 4;
	public static final short FONTSTRETCH_SEMICONDENSED = 5;
	public static final short FONTSTRETCH_SEMIEXPANDED = 6;
	public static final short FONTSTRETCH_EXPANDED = 7;
	public static final short FONTSTRETCH_EXTRAEXPANDED = 8;
	public static final short FONTSTRETCH_ULTRAEXPANDED = 9;
	
	public String getFontFamily();
	
	public SVGEnumerationList getFontStyle();
	
	public SVGEnumerationList getFontVariant();
	
	public SVGEnumerationList getFontWeight();
	
	public SVGEnumerationList getFontStretch();
	
	public SVGLength getFontSize();

	public static class Implementation extends SVGElement.Implementation implements SVGFontFaceElement {

		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
		}
		
	}
	
}
