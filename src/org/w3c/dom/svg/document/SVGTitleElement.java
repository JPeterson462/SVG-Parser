package org.w3c.dom.svg.document;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.DOMErrors;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGLangSpace;
import org.w3c.dom.svg.SVGStylable;

public interface SVGTitleElement extends SVGElement, SVGLangSpace, SVGStylable {

	public static class Implementation extends SVGElement.Implementation implements SVGTitleElement {

		private String xmlLang, xmlSpace;
		
		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				String xmlLang, String xmlSpace,
				SVGAnimatedString className, CSSStyleDeclaration style) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.xmlLang = xmlLang;
			this.xmlSpace = xmlSpace;
			this.className = className;
			this.style = style;
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
		
	}
	
}
