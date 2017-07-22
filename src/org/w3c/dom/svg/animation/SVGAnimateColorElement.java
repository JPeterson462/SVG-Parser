package org.w3c.dom.svg.animation;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.DOMErrors;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGAnimateColorElement extends SVGAnimationElement, SVGStylable {

	public static class Implementation extends SVGAnimationElement.Implementation implements SVGAnimateColorElement {

		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString className, CSSStyleDeclaration style) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.className = className;
			this.style = style;
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
