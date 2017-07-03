package org.w3c.dom.svg;

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
		public void setBaseValue(Long value) {
			this.baseValue = value;
		}

		@Override
		public Long getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
