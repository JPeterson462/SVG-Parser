package org.w3c.dom.svg.text;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
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

		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			
		}

		@Override
		public String getXMLLang() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setXMLLang(String xmlLang) throws DOMException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getXMLSpace() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setXMLSpace(String xmlSpace) throws DOMException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public SVGAnimatedString getClassName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CSSStyleDeclaration getStyle() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CSSValue getPresentationAttribute(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGStringList getRequiredFeatures() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGStringList getRequiredExtensions() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGStringList getSystemLanguage() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasExtension(String extension) throws DOMException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGAnimatedLength getTextLength() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGAnimatedEnumeration getLengthAdjust() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getNumberOfChars() {
			// TODO Auto-generated method stub
			return 0;
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
