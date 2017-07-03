package org.w3c.dom.svg;

public interface SVGAnimatedNumber extends Animated<Float> {

	public static class Implementation implements SVGAnimatedNumber {

		private float baseValue, animatedValue;
		
		public Implementation(float baseValue, float animatedValue) {
			this.baseValue = baseValue;
			this.animatedValue = animatedValue;
		}
		
		@Override
		public Float getBaseValue() {
			return baseValue;
		}

		@Override
		public void setBaseValue(Float value) {
			this.animatedValue = value;
		}

		@Override
		public Float getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
