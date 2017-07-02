package com.digiturtle.svg.datatypes;

public interface SVGAnimatedString extends Animated<String> {

	public static class Implementation implements SVGAnimatedString {

		private String baseValue, animatedValue;
		
		public Implementation(String baseValue, String animatedValue) {
			this.baseValue = baseValue;
			this.animatedValue = animatedValue;
		}
		
		@Override
		public String getBaseValue() {
			return baseValue;
		}

		@Override
		public void setAnimatedValue(String value) {
			this.animatedValue = value;
		}

		@Override
		public String getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
