package org.w3c.dom.svg;

import org.w3c.dom.DOMErrors;

public interface SVGAnimatedRect extends Animated<SVGRect> {

	public static class Implementation implements SVGAnimatedRect {

		private SVGRect baseValue, animatedValue;
		
		public Implementation(SVGRect baseValue, SVGRect animatedValue) {
			this.baseValue = baseValue;
			if (baseValue != null) {
				if (baseValue == animatedValue) {
					this.animatedValue = new SVGRect.Implementation(baseValue.getX(), baseValue.getY(), baseValue.getWidth(), baseValue.getHeight());
				} else {
					this.animatedValue = animatedValue;
				}
			} else {
				this.animatedValue = animatedValue;
			}
		}
		
		@Override
		public SVGRect getBaseValue() {
			return baseValue;
		}

		@Override
		public void setBaseValue(SVGRect value) {
			DOMErrors.readonly(getClass());
		}

		@Override
		public SVGRect getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
