package org.w3c.dom.svg.text;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSLengthValue;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.impl.CSSPropertyNames;
import org.w3c.dom.fonts.SVGFont;
import org.w3c.dom.fonts.SVGFontAttributes;

import java.util.HashMap;

import com.digiturtle.util.Rect;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.svg.DelayedInstantiation;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGExternalResourcesRequired;
import org.w3c.dom.svg.SVGLangSpace;
import org.w3c.dom.svg.SVGLengthList;
import org.w3c.dom.svg.SVGLocatable;
import org.w3c.dom.svg.SVGMath;
import org.w3c.dom.svg.SVGPoint;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.SVGTests;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.paths.SVGPathMath;

public interface SVGTextContentElement extends SVGElement, SVGLangSpace, SVGStylable, SVGTests, SVGExternalResourcesRequired {

	/** The enumeration was set to a value that is not one of predefined types. It is invalid to attempt to define a new value of this type or to attempt to switch an existing value to this type. */
	public static final short LENGTHADJUST_UNKNOWN = 0;
	/** Corresponds to value 'spacing'. */
	public static final short LENGTHADJUST_SPACING = 1;
	/** Corresponds to value 'spacingAndGlyphs'. */
	public static final short LENGTHADJUST_SPACINGANDGLYPHS = 2;
	
	public SVGAnimatedLength getTextLength();
	
	public SVGAnimatedEnumeration getLengthAdjust();
	
	public long getNumberOfChars();
	
	public float getComputedTextLength();
	
	public float getSubStringLength(long charnum, long nchars) throws DOMException;
	
	public SVGPoint getStartPositionOfChar(long charnum) throws DOMException;
	
	public SVGPoint getEndPositionOfChar(long charnum) throws DOMException;
	
	public SVGRect getExtentOfChar(long charnum) throws DOMException;
	
	public float getRotationOfChar(long charnum) throws DOMException;
	
	public long getCharNumAtPosition(SVGPoint point);
	
	public void selectSubString(long charnum, long nchars) throws DOMException;
	
	@SuppressWarnings("rawtypes")
	public SVGFont getFontInUse();
	
	@DelayedInstantiation
	public static class Implementation extends SVGElement.Implementation implements SVGTextContentElement {

		private String xmlLang, xmlSpace;
		
		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		private SVGStringList requiredFeatures, requiredExtensions, systemLanguage;
		
		private SVGAnimatedBoolean externalResourcesRequired;
		
		private SVGAnimatedLength textLength;
		
		private SVGAnimatedEnumeration lengthAdjust;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				String xmlLang, String xmlSpace,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedLength textLength, SVGAnimatedEnumeration lengthAdjust) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.xmlLang = xmlLang;
			this.xmlSpace = xmlSpace;
			this.className = className;
			this.style = style;
			this.requiredFeatures = requiredFeatures;
			this.requiredExtensions = requiredExtensions;
			this.systemLanguage = systemLanguage;
			this.externalResourcesRequired = externalResourcesRequired;
			this.textLength = textLength;
			this.lengthAdjust = lengthAdjust;
		}
		
		public Implementation(String id) {
			super(id);
		}
		
		public void instantiateTextContent(String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				String xmlLang, String xmlSpace,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedLength textLength, SVGAnimatedEnumeration lengthAdjust) {
			instantiateBase(xmlBase, ownerSVGElement, viewportElement);
			this.xmlLang = xmlLang;
			this.xmlSpace = xmlSpace;
			this.className = className;
			this.style = style;
			this.requiredFeatures = requiredFeatures;
			this.requiredExtensions = requiredExtensions;
			this.systemLanguage = systemLanguage;
			this.externalResourcesRequired = externalResourcesRequired;
			this.textLength = textLength;
			this.lengthAdjust = lengthAdjust;
		}

		@Override
		public String getXMLLang() {
			return xmlLang;
		}

		@Override
		public void setXMLLang(String xmlLang) throws DOMException {
			this.xmlLang = xmlLang;
		}

		@Override
		public String getXMLSpace() {
			return xmlSpace;
		}

		@Override
		public void setXMLSpace(String xmlSpace) throws DOMException {
			this.xmlSpace = xmlSpace;
		}

		@Override
		public SVGAnimatedString getClassName() {
			return className;
		}

		@Override
		public CSSStyleDeclaration getStyle() {
			return style;
		}

		@Override
		public CSSValue getPresentationAttribute(String name) {
			return DOMErrors.deprecatedMethod();
		}

		@Override
		public SVGStringList getRequiredFeatures() {
			return requiredFeatures;
		}

		@Override
		public SVGStringList getRequiredExtensions() {
			return requiredExtensions;
		}

		@Override
		public SVGStringList getSystemLanguage() {
			return systemLanguage;
		}

		@Override
		public boolean hasExtension(String extension) throws DOMException {
			return DOMErrors.notSupported();
		}

		@Override
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			return externalResourcesRequired;
		}

		@Override
		public SVGAnimatedLength getTextLength() {
			return textLength;
		}

		@Override
		public SVGAnimatedEnumeration getLengthAdjust() {
			return lengthAdjust;
		}

		@Override
		public long getNumberOfChars() {
			return getTextContent().length();
		}

		@Override
		public float getComputedTextLength() {
			return getSubStringLength(0, getNumberOfChars());
		}
		
		@SuppressWarnings({ "rawtypes", "unused" })
		@Override
		public float getSubStringLength(long charnum, long nchars) throws DOMException {
			float length = 0;
			SVGFont font = getFontInUse();
			boolean tSpanElement = this instanceof SVGTSpanElement;
			CSSStyleDeclaration style = getStyle();
			float kerningForced = 0, letterSpacingForced = 0, wordSpacingForced = 0;
			boolean setKerning = false, setLetterSpacing = false, setWordSpacing = false;
			boolean usingSpacing = getLengthAdjust().getBaseValue() == LENGTHADJUST_SPACING || getLengthAdjust().getBaseValue() == LENGTHADJUST_SPACINGANDGLYPHS;
			boolean usingGlyphs = getLengthAdjust().getBaseValue() == LENGTHADJUST_SPACINGANDGLYPHS;
			float boundsWidth = getTextLength().getBaseValue().getValue();
			SVGLengthList dx = null, dy = null;
			if (style != null) {
				CSSLengthValue kerning = ((CSSLengthValue) style.getPropertyCSSValue(CSSPropertyNames.KERNING));
				if (kerning != null && !kerning.isAuto() && !kerning.isInherit()) {
					kerningForced = kerning.getValue().getValue();
					setKerning = true;
				}
				CSSLengthValue letterSpacing = ((CSSLengthValue) style.getPropertyCSSValue(CSSPropertyNames.LETTER_SPACING));
				if (letterSpacing != null && !letterSpacing.isNormal() && !letterSpacing.isInherit()) {
					letterSpacingForced = letterSpacing.getValue().getValue() + kerningForced;
					setLetterSpacing = true;
				}
				CSSLengthValue wordSpacing = ((CSSLengthValue) style.getPropertyCSSValue(CSSPropertyNames.WORD_SPACING));
				if (wordSpacing != null && !wordSpacing.isNormal() && !wordSpacing.isInherit()) {
					wordSpacingForced = wordSpacing.getValue().getValue();
					setWordSpacing = true;
				}
			}
			if (tSpanElement) {
				dx = ((SVGTSpanElement) this).getDX().getBaseValue();
				dy = ((SVGTSpanElement) this).getDY().getBaseValue();
			}
			if (usingSpacing) {
				if (usingGlyphs) {
					float originalLength = 0;
					char lastChar = 0;
					for (long charval = 0; charval < getNumberOfChars(); charval++) {
						char c = getTextContent().charAt((int) charval);
						Rect bounds = (Rect) font.getCharacterBounds().get(c);
						if (c == ' ' && setWordSpacing) {
							length += wordSpacingForced;
							lastChar = c;
							continue;
						}
						if (lastChar == 0) {
							originalLength += bounds.getWidth();
						} else {
							originalLength += bounds.getWidth() + (setLetterSpacing ? letterSpacingForced : ((Rect) font.getCharacterBounds().get(lastChar)).getAdvance().get(c));
						}
						lastChar = c;
					}
					float ratio = boundsWidth / originalLength;
					for (long charval = charnum; charval < (charnum + nchars); charval++) {
						char c = getTextContent().charAt((int) charval);
						Rect bounds = (Rect) font.getCharacterBounds().get(c);
						if (c == ' ' && setWordSpacing) {
							length += wordSpacingForced;
							lastChar = c;
							continue;
						}
						if (lastChar == 0) {
							length += bounds.getWidth();
						} else {
							length += bounds.getWidth() + (setLetterSpacing ? letterSpacingForced : ((Rect) font.getCharacterBounds().get(lastChar)).getAdvance().get(c));
						}
						lastChar = c;
					}
					length *= ratio;
				} else {
					float perSpaceWidth = 0;
					if (getNumberOfChars() > 0) {
						float glyphWidth = 0;
						for (long charval = 0; charval < getNumberOfChars(); charval++) {
							char c = getTextContent().charAt((int) charval);
							Rect bounds = (Rect) font.getCharacterBounds().get(c);
							glyphWidth += bounds.getWidth();
						}
						float totalSpacingWidth = boundsWidth - glyphWidth;
						perSpaceWidth = totalSpacingWidth / (getNumberOfChars() - 1);
					}
					char lastChar = 0;
					for (long charval = charnum; charval < (charnum + nchars); charval++) {
						char c = getTextContent().charAt((int) charval);
						Rect bounds = (Rect) font.getCharacterBounds().get(c);
						if (c == ' ' && setWordSpacing) {
							length += wordSpacingForced;
							lastChar = c;
							continue;
						}
						if (lastChar == 0) {
							length += bounds.getWidth();
						} else {
							length += bounds.getWidth() + perSpaceWidth;
						}
						lastChar = c;
					}
				}
			} else {
				char lastChar = 0;
				for (long charval = charnum; charval < (charnum + nchars); charval++) {
					char c = getTextContent().charAt((int) charval);
					Rect bounds = (Rect) font.getCharacterBounds().get(c);
					if (c == ' ' && setWordSpacing) {
						length += wordSpacingForced;
						lastChar = c;
						continue;
					}
					if (lastChar == 0) {
						length += bounds.getWidth();
					} else {
						length += bounds.getWidth() + (setLetterSpacing ? letterSpacingForced : ((Rect) font.getCharacterBounds().get(lastChar)).getAdvance().get(c));
					}
					lastChar = c;
				}
			}
			return length;
		}

		@SuppressWarnings("rawtypes")
		private SVGPoint getCenterOfChar(long charnum) {//TODO wrapping text
			SVGFont font = getFontInUse();
			if (this instanceof SVGTextPathElement) {
				float substringLength = getSubStringLength(0, charnum) - ((Rect) font.getCharacterBounds().get(getTextContent().charAt((int) charnum))).getWidth() / 2;
				return SVGPathMath.getPointAtLength(substringLength, ((SVGTextPathElement) this).getPath().getPathSegList());
			} else {
				SVGRect bounds = ((SVGLocatable) this.getParentNode()).getBBox();
				float substringLength = getSubStringLength(0, charnum) - ((Rect) font.getCharacterBounds().get(getTextContent().charAt((int) charnum))).getWidth() / 2;
				float y = ((Rect) font.getCharacterBounds().get(getTextContent().charAt((int) charnum))).getHeight() / 2;
				return new SVGPoint.Implementation(substringLength + bounds.getX(), y + bounds.getY());
			}
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public SVGPoint getStartPositionOfChar(long charnum) throws DOMException {
			SVGFont font = getFontInUse();
			SVGPoint midpoint = getCenterOfChar(charnum);
			HashMap<Character, Rect> bounds = font.getCharacterBounds();
			Rect charBounds = bounds.get(getTextContent().charAt((int) charnum));
			float length = SVGMath.sqrt(charBounds.getWidth() * charBounds.getWidth() + charBounds.getHeight() * charBounds.getHeight()) / 2;
			float baseAngle = SVGMath.acos(charBounds.getHeight() / length), newAngle = -baseAngle + getRotationOfChar(charnum);
			return new SVGPoint.Implementation(midpoint.getX() + SVGMath.cos(newAngle) * length, midpoint.getY() + SVGMath.sin(newAngle) * length);
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public SVGPoint getEndPositionOfChar(long charnum) throws DOMException {
			SVGFont font = getFontInUse();
			SVGPoint midpoint = getCenterOfChar(charnum);
			HashMap<Character, Rect> bounds = font.getCharacterBounds();
			Rect charBounds = bounds.get(getTextContent().charAt((int) charnum));
			float length = SVGMath.sqrt(charBounds.getWidth() * charBounds.getWidth() + charBounds.getHeight() * charBounds.getHeight()) / 2;
			float baseAngle = SVGMath.acos(charBounds.getHeight() / length), newAngle = baseAngle + getRotationOfChar(charnum);
			return new SVGPoint.Implementation(midpoint.getX() + SVGMath.cos(newAngle) * length, midpoint.getY() + SVGMath.sin(newAngle) * length);
		}

		@Override
		public SVGRect getExtentOfChar(long charnum) throws DOMException {
			SVGPoint start = getStartPositionOfChar(charnum);
			SVGPoint end = getEndPositionOfChar(charnum);
			float x0 = Math.min(start.getX(), end.getX());
			float x1 = Math.max(start.getX(), end.getX());
			float y0 = Math.min(start.getY(), end.getY());
			float y1 = Math.max(start.getY(), end.getY());
			return new SVGRect.Implementation(x0, y0, x1 - x0, y1 - y0);
		}

		@SuppressWarnings("rawtypes")
		@Override
		public float getRotationOfChar(long charnum) throws DOMException {
			if (this instanceof SVGTextPathElement) {
				SVGFont font = getFontInUse();
				float substringLength = getSubStringLength(0, charnum) - ((Rect) font.getCharacterBounds().get(getTextContent().charAt((int) charnum))).getWidth() / 2;
				SVGPathMath.State state = new SVGPathMath.State();
				SVGPoint pathSegAndLength = SVGPathMath.getPathSegAtLength(substringLength, ((SVGTextPathElement) this).getPath().getPathSegList(), state);
				state.point.setX(0);
				state.point.setY(0);
				int current = (int) pathSegAndLength.getX();
				for (int i = 0; i < current; i++) {
					SVGPathMath.transformPoint(((SVGTextPathElement) this).getPath().getPathSegList().getItem(i), state);
				}
				return SVGPathMath.getRotationAtLength(pathSegAndLength.getY(), ((SVGTextPathElement) this).getPath().getPathSegList().getItem((long) (int) pathSegAndLength.getX()), state);
			}
			return 0;
		}

		@Override
		public long getCharNumAtPosition(SVGPoint point) {
			if (point == null) {
				return -1;
			}
			for (long charnum = 0; charnum < getNumberOfChars(); charnum++) {
				SVGRect bounds = getExtentOfChar(charnum);
				if (bounds.contains(point)) {
					return charnum;
				}
			}
			return -1;
		}

		@Override
		public void selectSubString(long charnum, long nchars) throws DOMException {
			SVGErrors.error("Not supported: selectSubString()");
		}

		@SuppressWarnings("rawtypes")
		@Override
		public SVGFont getFontInUse() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
