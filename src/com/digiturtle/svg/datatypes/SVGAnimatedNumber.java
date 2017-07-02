package com.digiturtle.svg.datatypes;

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
		public void setAnimatedValue(Float value) {
			this.animatedValue = value;
		}

		@Override
		public Float getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
