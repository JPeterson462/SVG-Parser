package org.w3c.dom.svg.text;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.DelayedInstantiation;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGURIReference;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.paths.SVGPathElement;

public interface SVGTextPathElement extends SVGTextContentElement, SVGURIReference {
	
	// textPath Method Types
	/** The enumeration was set to a value that is not one of
	 * 	predefined types. It is invalid to attempt to define 
	 * 	a new value of this type or to attempt to switch an
	 * 	existing value to this type. */
	public static final short TEXTPATH_METHODTYPE_UNKNOWN = 0;
	/** Corresponds to value 'align'. */
	public static final short TEXTPATH_METHODTYPE_ALIGN = 1;
	/** Corresponds to value 'stretch'. */
	public static final short TEXTPATH_METHODTYPE_STRETCH = 2;

	// textPath Spacing Types
	/** The enumeration was set to a value that is not one of
	 * 	predefined types. It is invalid to attempt to define
	 * 	a new value of this type or to attempt to switch an
	 * 	existing value to this type. */
	public static final short TEXTPATH_SPACINGTYPE_UNKNOWN = 0;
	/** Corresponds to value 'auto'. */
	public static final short TEXTPATH_SPACINGTYPE_AUTO = 1;
	/** Corresponds to value 'exact'. */
	public static final short TEXTPATH_SPACINGTYPE_EXACT = 2;

	public SVGAnimatedLength getStartOffset();
	
	public SVGAnimatedEnumeration getMethod();
	
	public SVGAnimatedEnumeration getSpacing();
	
	public SVGPathElement getPath();
	
	@DelayedInstantiation
	public static class Implementation extends SVGTextContentElement.Implementation implements SVGTextPathElement {

		private SVGAnimatedString href;
		
		private SVGAnimatedLength startOffset;
		
		private SVGAnimatedEnumeration method, spacing;
		
		private SVGPathElement path;

		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString href, SVGPathElement path,
				SVGAnimatedLength startOffset, SVGAnimatedEnumeration method, SVGAnimatedEnumeration spacing,
				String xmlLang, String xmlSpace,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedLength textLength, SVGAnimatedEnumeration lengthAdjust) {
			super(id, xmlBase, ownerSVGElement, viewportElement, xmlLang, xmlSpace, className, style, requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired, textLength, lengthAdjust);
			this.href = href;
			this.path = path;
			this.startOffset = startOffset;
			this.method = method;
			this.spacing = spacing;
		}
		
		public Implementation(String id) {
			super(id);
		}
		
		public void instantiateTextPath(String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString href, SVGPathElement path,
				SVGAnimatedLength startOffset, SVGAnimatedEnumeration method, SVGAnimatedEnumeration spacing,
				String xmlLang, String xmlSpace,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedLength textLength, SVGAnimatedEnumeration lengthAdjust) {
			instantiateTextContent(xmlSpace, ownerSVGElement, viewportElement,
					xmlLang, xmlSpace, className, style, requiredFeatures,
					requiredExtensions, systemLanguage, externalResourcesRequired, 
					textLength, lengthAdjust);
			this.href = href;
			this.path = path;
			this.startOffset = startOffset;
			this.method = method;
			this.spacing = spacing;
		}

		@Override
		public SVGAnimatedString getHref() {
			return href;
		}

		@Override
		public SVGAnimatedLength getStartOffset() {
			return startOffset;
		}

		@Override
		public SVGAnimatedEnumeration getMethod() {
			return method;
		}

		@Override
		public SVGAnimatedEnumeration getSpacing() {
			return spacing;
		}

		@Override
		public SVGPathElement getPath() {
			return path;
		}

	}

}
