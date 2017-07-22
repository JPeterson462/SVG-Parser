package org.w3c.dom.svg.filters;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.DOMErrors;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFEElement extends SVGElement, SVGFilterPrimitiveStandardAttributes {

	public static class Implementation extends SVGElement.Implementation implements SVGFEElement {

		private SVGAnimatedLength x, y, width, height;
		
		private SVGAnimatedString result;

		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGAnimatedString result,
				SVGAnimatedString className, CSSStyleDeclaration style) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.result = result;
			this.className = className;
			this.style = style;
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
		public SVGAnimatedString getResult() {
			return result;
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
