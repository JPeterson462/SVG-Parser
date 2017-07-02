package com.digiturtle.svg.datatypes;

public interface SVGAnimatedInteger extends Animated<Long> {

	public static class Implementation implements SVGAnimatedInteger {

		private long baseValue, animatedValue;
		
		public Implementation(long baseValue, long animatedValue) {
			this.baseValue = baseValue;
			this.animatedValue = animatedValue;
		}
		
		@Override
		public Long getBaseValue() {
			return baseValue;
		}

		@Override
		public void setAnimatedValue(Long value) {
			this.animatedValue = value;
		}

		@Override
		public Long getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
