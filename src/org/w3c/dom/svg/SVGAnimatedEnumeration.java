package org.w3c.dom.svg;

public interface SVGAnimatedEnumeration extends Animated<Short> {

	public static class Implementation implements SVGAnimatedEnumeration {

		private short baseValue, animatedValue;
		
		public Implementation(short baseValue, short animatedValue) {
			this.baseValue = baseValue;
			this.animatedValue = animatedValue;
		}
		
		@Override
		public Short getBaseValue() {
			return baseValue;
		}

		@Override
		public void setBaseValue(Short value) {
			this.baseValue = value;
		}

		@Override
		public Short getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
