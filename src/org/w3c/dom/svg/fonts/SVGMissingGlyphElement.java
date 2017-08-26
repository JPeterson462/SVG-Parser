package org.w3c.dom.svg.fonts;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.DOMErrors;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.paths.SVGPathSegList;

public interface SVGMissingGlyphElement extends SVGElement, SVGStylable {

	public SVGPathSegList getPathData();

	public SVGNumber getHorizontalAdvanceX();

	public SVGNumber getVerticalOriginX();

	public SVGNumber getVerticalOriginY();

	public SVGNumber getVerticalAdvanceY();

	public static class Implementation extends SVGElement.Implementation implements SVGMissingGlyphElement {

		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;

		private SVGPathSegList pathData;
		
		private SVGNumber horizontalAdvanceX, verticalOriginX, verticalOriginY, verticalAdvanceY;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGPathSegList pathData, SVGNumber horizontalAdvanceX,
				SVGNumber verticalOriginX, SVGNumber verticalOriginY, SVGNumber verticalAdvanceY) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.className = className;
			this.style = style;
			this.pathData = pathData;
			this.horizontalAdvanceX = horizontalAdvanceX;
			this.verticalOriginX = verticalOriginX;
			this.verticalOriginY = verticalOriginY;
			this.verticalAdvanceY = verticalAdvanceY;
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
		public SVGPathSegList getPathData() {
			return pathData;
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
