package org.w3c.dom.svg;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGStopElement extends SVGElement, SVGStylable {

	public SVGAnimatedNumber getOffset();
	
	public static class Implementation extends SVGElement.Implementation implements SVGStopElement {

		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		private SVGAnimatedNumber offset;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedNumber offset) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.className = className;
			this.style = style;
			this.offset = offset;
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
		public SVGAnimatedNumber getOffset() {
			return offset;
		}
		
	}
	
}
