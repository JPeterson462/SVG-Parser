package org.w3c.dom.svg;

import org.w3c.dom.DOMErrors;

public interface SVGAnimatedPreserveAspectRatio extends Animated<SVGPreserveAspectRatio> {

	public static class Implementation implements SVGAnimatedPreserveAspectRatio {

		private SVGPreserveAspectRatio baseValue, animatedValue;
		
		public Implementation(SVGPreserveAspectRatio baseValue, SVGPreserveAspectRatio animatedValue) {
			this.baseValue = baseValue;
			if (baseValue == animatedValue) {
				this.animatedValue = new SVGPreserveAspectRatio.Implementation();
				this.animatedValue.setAlign(baseValue.getAlign());
				this.animatedValue.setMeetOrSlice(baseValue.getMeetOrSlice());
			} else {
				this.animatedValue = animatedValue;
			}
		}
		
		@Override
		public SVGPreserveAspectRatio getBaseValue() {
			return baseValue;
		}

		@Override
		public void setBaseValue(SVGPreserveAspectRatio value) {
			DOMErrors.readonly(getClass());
		}

		@Override
		public SVGPreserveAspectRatio getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
