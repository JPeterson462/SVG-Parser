package org.w3c.dom.svg;

public interface SVGAnimatedPreserveAspectRatio extends Animated<SVGPreserveAspectRatio> {

	public static class Implementation implements SVGAnimatedPreserveAspectRatio {

		private SVGPreserveAspectRatio baseValue, animatedValue;
		
		public Implementation(SVGPreserveAspectRatio baseValue, SVGPreserveAspectRatio animatedValue) {
			this.baseValue = baseValue;
			this.animatedValue = animatedValue;
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
