package org.w3c.dom.svg;

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
		public void setBaseValue(Boolean value) {
			this.baseValue = value;
		}

		@Override
		public Boolean getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
