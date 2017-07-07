package org.w3c.dom.svg.document;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio;
import org.w3c.dom.svg.SVGAnimatedRect;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGExternalResourcesRequired;
import org.w3c.dom.svg.SVGFitToViewBox;
import org.w3c.dom.svg.SVGLangSpace;
import org.w3c.dom.svg.SVGStylable;

public interface SVGSymbolElement extends SVGElement, SVGLangSpace, SVGStylable, SVGExternalResourcesRequired, SVGFitToViewBox {

	public static class Implementation extends SVGElement.Implementation implements SVGSymbolElement {

		private String xmlLang, xmlSpace;
		
		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		private SVGAnimatedBoolean externalResourcesRequired;
		
		private SVGAnimatedRect viewBox;
		
		private SVGAnimatedPreserveAspectRatio preserveAspectRatio;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				String xmlLang, String xmlSpace,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedRect viewBox,
				SVGAnimatedPreserveAspectRatio preserveAspectRatio) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.xmlLang = xmlLang;
			this.xmlSpace = xmlSpace;
			this.className = className;
			this.style = style;
			this.externalResourcesRequired = externalResourcesRequired;
			this.viewBox = viewBox;
			this.preserveAspectRatio = preserveAspectRatio;
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
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "This method is deprecated");
		}

		@Override
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			return externalResourcesRequired;
		}

		@Override
		public SVGAnimatedRect getViewBox() {
			return viewBox;
		}

		@Override
		public SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
			return preserveAspectRatio;
		}
		
	}
	
}
