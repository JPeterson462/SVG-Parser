package org.w3c.dom.svg;

public interface SVGAnimatedString extends Animated<String> {

	public static class Implementation implements SVGAnimatedString {

		private String baseValue, animatedValue;
		
		public Implementation(String baseValue, String animatedValue) {
			this.baseValue = baseValue;
			if (baseValue == animatedValue) {
				this.animatedValue = new String(baseValue);
			} else {
				this.animatedValue = animatedValue;
			}
		}
		
		@Override
		public String getBaseValue() {
			return baseValue;
		}

		@Override
		public void setBaseValue(String value) {
			this.baseValue = value;
		}

		@Override
		public String getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
