package org.w3c.dom.svg.text;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.DOMErrors;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGExternalResourcesRequired;
import org.w3c.dom.svg.SVGLangSpace;
import org.w3c.dom.svg.SVGPoint;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.SVGTests;
import org.w3c.dom.svg.document.SVGSVGElement;

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
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getSubStringLength(long charnum, long nchars) throws DOMException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public SVGPoint getStartPositionOfChar(long charnum) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPoint getEndPositionOfChar(long charnum) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGRect getExtentOfChar(long charnum) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public float getRotationOfChar(long charnum) throws DOMException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long getCharNumAtPosition(SVGPoint point) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void selectSubString(long charnum, long nchars) throws DOMException {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
