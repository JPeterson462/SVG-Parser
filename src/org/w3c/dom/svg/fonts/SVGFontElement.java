package org.w3c.dom.svg.fonts;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.DOMErrors;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGExternalResourcesRequired;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFontElement extends SVGElement, SVGExternalResourcesRequired, SVGStylable {

	public SVGNumber getHorizontalOriginX();

	public SVGNumber getHorizontalOriginY();

	public SVGNumber getHorizontalAdvanceX();

	public SVGNumber getVerticalOriginX();

	public SVGNumber getVerticalOriginY();

	public SVGNumber getVerticalAdvanceY();
	
	public static class Implementation extends SVGElement.Implementation implements SVGFontElement {

		private SVGAnimatedBoolean externalResourcesRequired;
		
		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		private SVGNumber horizontalOriginX, horizontalOriginY, horizontalAdvanceX, 
			verticalOriginX, verticalOriginY, verticalAdvanceY;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedBoolean externalResourcesRequired, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGNumber horizontalOriginX, SVGNumber horizontalOriginY, SVGNumber horizontalAdvanceX,
				SVGNumber verticalOriginX, SVGNumber verticalOriginY, SVGNumber verticalAdvanceY) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.externalResourcesRequired = externalResourcesRequired;
			this.className = className;
			this.style = style;
			this.horizontalOriginX = horizontalOriginX;
			this.horizontalOriginY = horizontalOriginY;
			this.horizontalAdvanceX = horizontalAdvanceX;
			this.verticalOriginX = verticalOriginX;
			this.verticalOriginY = verticalOriginY;
			this.verticalAdvanceY = verticalAdvanceY;
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
		public SVGNumber getHorizontalOriginX() {
			return horizontalOriginX;
		}

		@Override
		public SVGNumber getHorizontalOriginY() {
			return horizontalOriginY;
		}

		@Override
		public SVGNumber getHorizontalAdvanceX() {
			return horizontalAdvanceX;
		}

		@Override
		public SVGNumber getVerticalOriginX() {
			return verticalOriginX;
		}

		@Override
		public SVGNumber getVerticalOriginY() {
			return verticalOriginY;
		}

		@Override
		public SVGNumber getVerticalAdvanceY() {
			return verticalAdvanceY;
		}
		
	}
	
}
