package com.digiturtle.svg.datatypes;

public interface SVGAnimatedBoolean extends Animated<Boolean> {

	public static class Implementation implements SVGAnimatedBoolean {

		private boolean baseValue, animatedValue;
		
		public Implementation(boolean baseValue, boolean animatedValue) {
			this.baseValue = baseValue;
			this.animatedValue = animatedValue;
		}
		
		@Override
		public Boolean getBaseValue() {
			return baseValue;
		}

		@Override
		public void setAnimatedValue(Boolean value) {
			this.animatedValue = value;
		}

		@Override
		public Boolean getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
