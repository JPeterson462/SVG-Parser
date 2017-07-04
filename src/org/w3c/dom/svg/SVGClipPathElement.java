package org.w3c.dom.svg;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGClipPathElement extends SVGElement, SVGLangSpace, SVGStylable, SVGTests, SVGExternalResourcesRequired, SVGTransformable, SVGUnitTypes {

	public SVGAnimatedEnumeration getClipPathUnits();
	
	public static class Implementation extends SVGElement.Implementation implements SVGClipPathElement {

		private SVGStringList requiredFeatures;
		
		private SVGStringList requiredExtensions;
		
		private SVGStringList systemLanguage;
		
		private String xmlLang, xmlSpace;
		
		private SVGAnimatedBoolean externalResourcesRequired;
		
		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		private SVGAnimatedEnumeration clipPathUnits;

		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				String xmlLang, String xmlSpace,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedEnumeration clipPathUnits) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.requiredFeatures = requiredFeatures;
			this.requiredExtensions = requiredExtensions;
			this.systemLanguage = systemLanguage;
			this.xmlLang = xmlLang;
			this.xmlSpace = xmlSpace;
			this.externalResourcesRequired = externalResourcesRequired;
			this.className = className;
			this.style = style;
			this.clipPathUnits = clipPathUnits;
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
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
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
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
		}

		@Override
		public SVGAnimatedTransformList getTransform() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGElement getNearestViewportElement() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGElement getFarthestViewportElement() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGRect getBBox() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGMatrix getCTM() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGMatrix getScreenCTM() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGMatrix getTransformToElement(SVGElement element) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGAnimatedEnumeration getClipPathUnits() {
			return clipPathUnits;
		}
		
	}
	
}
