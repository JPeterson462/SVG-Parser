package org.w3c.dom.svg;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGAElement extends SVGElement, SVGURIReference, SVGTests, SVGLangSpace, SVGExternalResourcesRequired, SVGStylable, SVGTransformable {

	public SVGAnimatedString getTarget();
	
	public static class Implementation extends SVGElement.Implementation implements SVGAElement {

		private SVGTransformable transformableBase;
		
		private SVGAnimatedString href;
		
		private SVGStringList requiredFeatures, requiredExtensions, systemLanguage;
		
		private String xmlLang, xmlSpace;
		
		private SVGAnimatedBoolean externalResourcesRequired;
		
		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		private SVGAnimatedString target;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString href,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				String xmlLang, String xmlSpace,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGElement nearestViewportElement, SVGElement farthestViewportElement, SVGAnimatedTransformList transform,
				SVGAnimatedString target) {
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
			transformableBase = new SVGTransformable.Implementation(nearestViewportElement, farthestViewportElement, transform);
			this.target = target;
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
			return DOMErrors.deprecatedMethod();
		}

		@Override
		public SVGAnimatedTransformList getTransform() {
			return transformableBase.getTransform();
		}

		@Override
		public SVGElement getNearestViewportElement() {
			return transformableBase.getNearestViewportElement();
		}

		@Override
		public SVGElement getFarthestViewportElement() {
			return transformableBase.getFarthestViewportElement();
		}

		@Override
		public SVGRect getBBox() {
			return transformableBase.getBBox();
		}

		@Override
		public SVGMatrix getCTM() {
			return transformableBase.getCTM();
		}

		@Override
		public SVGMatrix getScreenCTM() {
			return transformableBase.getScreenCTM();
		}

		@Override
		public SVGMatrix getTransformToElement(SVGElement element) throws DOMException {
			return transformableBase.getTransformToElement(element);
		}

		@Override
		public SVGAnimatedString getTarget() {
			return target;
		}
		
	}
	
}
