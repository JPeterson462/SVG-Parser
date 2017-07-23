package org.w3c.dom.svg;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGPatternElement extends SVGElement, SVGURIReference, SVGTests, 
		SVGLangSpace, SVGExternalResourcesRequired, SVGStylable, SVGFitToViewBox, SVGUnitTypes {

	public SVGAnimatedEnumeration getPatternUnits();
	
	public SVGAnimatedEnumeration getPatternContentUnits();
	
	public SVGAnimatedTransformList getPatternTransform();
	
	public SVGAnimatedLength getX();

	public SVGAnimatedLength getY();

	public SVGAnimatedLength getWidth();

	public SVGAnimatedLength getHeight();
	
	public static class Implementation extends SVGElement.Implementation implements SVGPatternElement {

		private SVGAnimatedString href;
		
		private SVGStringList requiredFeatures;
		
		private SVGStringList requiredExtensions;
		
		private SVGStringList systemLanguage;
		
		private String xmlLang, xmlSpace;
		
		private SVGAnimatedBoolean externalResourcesRequired;
		
		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		private SVGAnimatedRect viewBox;
		
		private SVGAnimatedPreserveAspectRatio preserveAspectRatio;
		
		private SVGAnimatedEnumeration patternUnits;
		
		private SVGAnimatedEnumeration patternContentUnits;
		
		private SVGAnimatedTransformList patternTransform;
		
		private SVGAnimatedLength x;
		
		private SVGAnimatedLength y;
		
		private SVGAnimatedLength width;
		
		private SVGAnimatedLength height;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString href,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				String xmlLang, String xmlSpace,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedRect viewBox, SVGAnimatedPreserveAspectRatio preserveAspectRatio,
				SVGAnimatedEnumeration patternUnits, SVGAnimatedEnumeration patternContentUnits, SVGAnimatedTransformList patternTransform,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.href = href;
			this.requiredFeatures = requiredFeatures;
			this.requiredExtensions = requiredExtensions;
			this.systemLanguage = systemLanguage;
			this.xmlLang = xmlLang;
			this.xmlSpace = xmlSpace;
			this.externalResourcesRequired = externalResourcesRequired;
			this.className = className;
			this.style = style;
			this.viewBox = viewBox;
			this.preserveAspectRatio = preserveAspectRatio;
			this.patternUnits = patternUnits;
			this.patternContentUnits = patternContentUnits;
			this.patternTransform = patternTransform;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}

		@Override
		public SVGAnimatedString getHref() {
			return href;
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
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			return externalResourcesRequired;
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
		public SVGAnimatedRect getViewBox() {
			return viewBox;
		}

		@Override
		public SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
			return preserveAspectRatio;
		}

		@Override
		public SVGAnimatedEnumeration getPatternUnits() {
			return patternUnits;
		}

		@Override
		public SVGAnimatedEnumeration getPatternContentUnits() {
			return patternContentUnits;
		}

		@Override
		public SVGAnimatedTransformList getPatternTransform() {
			return patternTransform;
		}

		@Override
		public SVGAnimatedLength getX() {
			return x;
		}

		@Override
		public SVGAnimatedLength getY() {
			return y;
		}

		@Override
		public SVGAnimatedLength getWidth() {
			return width;
		}

		@Override
		public SVGAnimatedLength getHeight() {
			return height;
		}
		
	}
	
}
