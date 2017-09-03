package org.w3c.dom.svg.filters;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGDimensioned;
import org.w3c.dom.svg.SVGStylable;

public interface SVGFilterPrimitiveStandardAttributes extends SVGStylable, SVGDimensioned {

	public SVGAnimatedLength getX();
	
	public SVGAnimatedLength getY();
	
	public SVGAnimatedLength getWidth();
	
	public SVGAnimatedLength getHeight();
	
	public SVGAnimatedString getResult();
	
	public static class Implementation extends SVGStylable.Implementation implements SVGFilterPrimitiveStandardAttributes {

		private SVGAnimatedLength x, y, width, height;
		
		private SVGAnimatedString result;
		
		public Implementation(SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGAnimatedString result) {
			super(className, style);
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.result = result;
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
		
	}
	
}
