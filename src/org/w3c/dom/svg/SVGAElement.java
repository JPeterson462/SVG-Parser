package org.w3c.dom.svg;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGAElement extends SVGElement, SVGURIReference, SVGTests, SVGLangSpace, SVGExternalResourcesRequired, SVGStylable, SVGTransformable {

	public SVGAnimatedString getTarget();
	
	public static class Implementation extends SVGElement.Implementation implements SVGAElement {

		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			
		}

		@Override
		public SVGAnimatedString getHref() {
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
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			// TODO Auto-generated method stub
			return null;
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
		public SVGAnimatedString getTarget() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
