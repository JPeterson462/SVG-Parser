package org.w3c.dom.svg.filters;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedInteger;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGExternalResourcesRequired;
import org.w3c.dom.svg.SVGLangSpace;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.SVGURIReference;
import org.w3c.dom.svg.SVGUnitTypes;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFilterElement extends SVGElement, SVGURIReference, SVGLangSpace, SVGExternalResourcesRequired, SVGStylable, SVGUnitTypes {

	public SVGAnimatedEnumeration getFilterUnits();
	
	public SVGAnimatedEnumeration getPrimitiveUnits();
	
	public SVGAnimatedLength getX();

	public SVGAnimatedLength getY();

	public SVGAnimatedLength getWidth();

	public SVGAnimatedLength getHeight();
	
	public SVGAnimatedInteger getFilterResX();

	public SVGAnimatedInteger getFilterResY();
	
	public void setFilterRes(long filterResX, long filterResY) throws DOMException;

	public static class Implementation extends SVGElement.Implementation implements SVGFilterElement {

		private SVGAnimatedString href;
		
		private String xmlLang, xmlSpace;
		
		private SVGAnimatedBoolean externalResourcesRequired;
		
		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		private SVGAnimatedEnumeration filterUnits, primitiveUnits;
		
		private SVGAnimatedLength x, y, width, height;
		
		private SVGAnimatedInteger filterResX, filterResY;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString href,
				String xmlLang, String xmlSpace,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedEnumeration filterUnits, SVGAnimatedEnumeration primitiveUnits,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGAnimatedInteger filterResX, SVGAnimatedInteger filterResY) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.href = href;
			this.xmlLang = xmlLang;
			this.xmlSpace = xmlSpace;
			this.externalResourcesRequired = externalResourcesRequired;
			this.className = className;
			this.style = style;
			this.filterUnits = filterUnits;
			this.primitiveUnits = primitiveUnits;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.filterResX = filterResX;
			this.filterResY = filterResY;
		}

		@Override
		public SVGAnimatedString getHref() {
			return href;
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
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "This method is deprecated");
		}

		@Override
		public SVGAnimatedEnumeration getFilterUnits() {
			return filterUnits;
		}

		@Override
		public SVGAnimatedEnumeration getPrimitiveUnits() {
			return primitiveUnits;
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

		@Override
		public SVGAnimatedInteger getFilterResX() {
			return filterResX;
		}

		@Override
		public SVGAnimatedInteger getFilterResY() {
			return filterResY;
		}

		@Override
		public void setFilterRes(long filterResX, long filterResY) throws DOMException {
			this.filterResX.setBaseValue(filterResX);
			this.filterResY.setBaseValue(filterResY);
		}
		
	}
	
}
