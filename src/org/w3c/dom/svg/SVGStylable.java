package org.w3c.dom.svg;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;

public interface SVGStylable {

	public SVGAnimatedString getClassName();
	
	public CSSStyleDeclaration getStyle();
	
	public CSSValue getPresentationAttribute(String name);
	
	public static class Implementation implements SVGStylable {
		
		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		public Implementation(SVGAnimatedString className, CSSStyleDeclaration style) {
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
