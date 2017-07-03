package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGAnimatedRect extends Animated<SVGRect> {

	public static class Implementation implements SVGAnimatedRect {

		private SVGRect baseValue, animatedValue;
		
		public Implementation(SVGRect baseValue, SVGRect animatedValue) {
			this.baseValue = baseValue;
			this.animatedValue = animatedValue;
		}
		
		@Override
		public SVGRect getBaseValue() {
			return baseValue;
		}

		@Override
		public void setBaseValue(SVGRect value) {
			throw new DOMException(DOMException.INVALID_MODIFICATION_ERR, "SVGAnimatedRect.animVal is readonly");
		}

		@Override
		public SVGRect getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
