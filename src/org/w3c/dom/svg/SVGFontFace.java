package org.w3c.dom.svg;

import java.util.HashMap;

public interface SVGFontFace {

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
	
	public SVGStringList getFontFamily();
	
	public SVGEnumerationList getFontStyle();
	
	public SVGEnumerationList getFontVariant();
	
	public SVGEnumerationList getFontWeight();
	
	public SVGEnumerationList getFontStretch();
	
	public SVGLengthList getFontSize();
	
	public boolean isForAllFontSizes();
	
	public SVGUnicodeRangeList getUnicodeRange();
	
	public SVGNumber getUnitsPerEm();
	
	public SVGNumberList getPanose1();
	
	public SVGNumber getStemV();
	
	public SVGNumber getStemH();
	
	public SVGNumber getSlope();
	
	public SVGNumber getCapHeight();
	
	public SVGNumber getXHeight();
	
	public SVGNumber getAccentHeight();
	
	public SVGNumber getAscent();
	
	public SVGNumber getDescent();
	
	public HashMap<Integer, SVGNumber> getWidths();
	
	public void setWidthsString(String value);
	public String getWidthsString();
	
	public SVGRect getBBox();
	
	public SVGNumber getIdeographic();
	
	public SVGNumber getAlphabetic();
	
	public SVGNumber getMathematical();
	
	public SVGNumber getHanging();
	
	public SVGNumber getVIdeographic();
	
	public SVGNumber getVAlphabetic();
	
	public SVGNumber getVMathematical();
	
	public SVGNumber getVHanging();
	
	public SVGNumber getUnderlinePosition();
	
	public SVGNumber getUnderlineThickness();
	
	public SVGNumber getStrikethroughPosition();
	
	public SVGNumber getStrikethroughThickness();
	
	public SVGNumber getOverlinePosition();
	
	public SVGNumber getOverlineThickness();
	
	public HashMap<String, String> getFontSources();
	
	public static class Implementation implements SVGFontFace {
		
		private SVGStringList fontFamily;
		
		private SVGEnumerationList fontStyle, fontVariant, fontWeight, fontStretch;
		
		private SVGLengthList fontSize;
		
		private boolean forAllFontSizes;
		
		private SVGUnicodeRangeList unicodeRange;
		
		private SVGNumber unitsPerEm;
		
		private SVGNumberList panose1;
		
		private SVGNumber stemV, stemH, slope, capHeight, xHeight, accentHeight, ascent, descent;
		
		private HashMap<Integer, SVGNumber> widths;
		
		private String widthsString;
		
		private SVGRect bBox;

		private SVGNumber ideographic, alphabetic, mathematical, hanging, vIdeographic, 
				vAlphabetic, vMathematical, vHanging, underlinePosition, underlineThickness,
				strikethroughPosition, strikethroughThickness, overlinePosition, overlineThickness;
		
		private HashMap<String, String> sources;

		public Implementation(SVGStringList fontFamily, SVGEnumerationList fontStyle, SVGEnumerationList fontVariant,
				SVGEnumerationList fontWeight, SVGEnumerationList fontStretch, SVGLengthList fontSize, boolean forAllFontSizes,
				SVGUnicodeRangeList unicodeRange, SVGNumber unitsPerEm, SVGNumberList panose1, SVGNumber stemV,
				SVGNumber stemH, SVGNumber slope, SVGNumber capHeight, SVGNumber xHeight, SVGNumber accentHeight,
				SVGNumber ascent, SVGNumber descent, HashMap<Integer, SVGNumber> widths, String widthsString, SVGRect bBox,
				SVGNumber ideographic, SVGNumber alphabetic, SVGNumber mathematical, SVGNumber hanging,
				SVGNumber vIdeographic, SVGNumber vAlphabetic, SVGNumber vMathematical, SVGNumber vHanging,
				SVGNumber underlinePosition, SVGNumber underlineThickness, SVGNumber strikethroughPosition,
				SVGNumber strikethroughThickness, SVGNumber overlinePosition, SVGNumber overlineThickness,
				HashMap<String, String> sources) {
			this.fontFamily = fontFamily;
			this.fontStyle = fontStyle;
			this.fontVariant = fontVariant;
			this.fontWeight = fontWeight;
			this.fontStretch = fontStretch;
			this.fontSize = fontSize;
			this.forAllFontSizes = forAllFontSizes;
			this.unicodeRange = unicodeRange;
			this.unitsPerEm = unitsPerEm;
			this.panose1 = panose1;
			this.stemV = stemV;
			this.stemH = stemH;
			this.slope = slope;
			this.capHeight = capHeight;
			this.xHeight = xHeight;
			this.accentHeight = accentHeight;
			this.ascent = ascent;
			this.descent = descent;
			this.widths = widths;
			this.widthsString = widthsString;
			this.bBox = bBox;
			this.ideographic = ideographic;
			this.alphabetic = alphabetic;
			this.mathematical = mathematical;
			this.hanging = hanging;
			this.vIdeographic = vIdeographic;
			this.vAlphabetic = vAlphabetic;
			this.vMathematical = vMathematical;
			this.vHanging = vHanging;
			this.underlinePosition = underlinePosition;
			this.underlineThickness = underlineThickness;
			this.strikethroughPosition = strikethroughPosition;
			this.strikethroughThickness = strikethroughThickness;
			this.overlinePosition = overlinePosition;
			this.overlineThickness = overlineThickness;
			this.sources = sources;
		}

		public SVGStringList getFontFamily() {
			return fontFamily;
		}

		public SVGEnumerationList getFontStyle() {
			return fontStyle;
		}

		public SVGEnumerationList getFontVariant() {
			return fontVariant;
		}

		public SVGEnumerationList getFontWeight() {
			return fontWeight;
		}

		public SVGEnumerationList getFontStretch() {
			return fontStretch;
		}

		public SVGLengthList getFontSize() {
			return fontSize;
		}
		
		public boolean isForAllFontSizes() {
			return forAllFontSizes;
		}

		public SVGUnicodeRangeList getUnicodeRange() {
			return unicodeRange;
		}

		public SVGNumber getUnitsPerEm() {
			return unitsPerEm;
		}

		public SVGNumberList getPanose1() {
			return panose1;
		}

		public SVGNumber getStemV() {
			return stemV;
		}

		public SVGNumber getStemH() {
			return stemH;
		}

		public SVGNumber getSlope() {
			return slope;
		}

		public SVGNumber getCapHeight() {
			return capHeight;
		}

		public SVGNumber getXHeight() {
			return xHeight;
		}

		public SVGNumber getAccentHeight() {
			return accentHeight;
		}

		public SVGNumber getAscent() {
			return ascent;
		}

		public SVGNumber getDescent() {
			return descent;
		}

		public HashMap<Integer, SVGNumber> getWidths() {
			return widths;
		}

		public SVGRect getBBox() {
			return bBox;
		}

		public SVGNumber getIdeographic() {
			return ideographic;
		}

		public SVGNumber getAlphabetic() {
			return alphabetic;
		}

		public SVGNumber getMathematical() {
			return mathematical;
		}

		public SVGNumber getHanging() {
			return hanging;
		}

		public SVGNumber getVIdeographic() {
			return vIdeographic;
		}

		public SVGNumber getVAlphabetic() {
			return vAlphabetic;
		}

		public SVGNumber getVMathematical() {
			return vMathematical;
		}

		public SVGNumber getVHanging() {
			return vHanging;
		}

		public SVGNumber getUnderlinePosition() {
			return underlinePosition;
		}

		public SVGNumber getUnderlineThickness() {
			return underlineThickness;
		}

		public SVGNumber getStrikethroughPosition() {
			return strikethroughPosition;
		}

		public SVGNumber getStrikethroughThickness() {
			return strikethroughThickness;
		}

		public SVGNumber getOverlinePosition() {
			return overlinePosition;
		}

		public SVGNumber getOverlineThickness() {
			return overlineThickness;
		}

		@Override
		public void setWidthsString(String value) {
			widthsString = value;
		}

		@Override
		public String getWidthsString() {
			return widthsString;
		}

		@Override
		public HashMap<String, String> getFontSources() {
			return sources;
		}
		
	}
	
}
